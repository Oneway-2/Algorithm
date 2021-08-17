package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 제한시간: 1초
 * 실행시간: 232ms
 * 2021.08.13 금 WS
 */

public class Main_백준_17135_캐슬디펜스_골드4_232ms {
	static int N , R = 3;  // N개의 숫자 중 R개를 뽑자~!!! 
	static int[] numbers = new int[3];
	static int[] input;
	private static int[][] map, originalMap;
	private static int Y, X, Range;
	private static int bestKillCount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(stk.nextToken()); // 3 <= Y <= 15
		X = Integer.parseInt(stk.nextToken()); // 3 <= X <= 15 
		Range = Integer.parseInt(stk.nextToken()); // 1 <= R <= 10
		
		map = new int[Y+1][X];
		originalMap = new int[Y+1][X];
		input = new int[X];
		
		for (int i = 0; i < input.length; i++) {
			input[i] = i+1;
		}
		N = X;
		
		for (int i = 0; i < map.length-1; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				originalMap[i][j] = map[i][j];
			}
		}
		
		// 궁수 배치해보자.
		setArchers(0, 0);
		System.out.println(bestKillCount);
	}
	
	private static void setArchers(int cnt, int start) {
		Arrays.fill(map[Y], 0);
		
		// 3마리 뽑아다가 성벽에 배치했다.
		if(cnt == R) {
			for (int i = 0; i < numbers.length; i++) {
				// 궁수가 있는 곳을 2로 표시
				map[Y][numbers[i]-1] = 2;
			}
			
			// 배치한애 가지고 사격해보자.
			calBestShot();
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			setArchers(cnt + 1, i + 1);
		}
	}
	
	private static void calBestShot() {
		// 궁수의 위치로부터 사거리안에 들어있는 적을 찾아야함.
		// 3명의 궁수, r, c좌표 
		int[][] aimingTarget = new int[][] {{Y,X-1},{Y,X-1},{Y,X-1}}; // 초기화로 허공을 바라보고 있게끔 한 것
		int killCount = 0;

		for (int targetDown = 0; targetDown < Y; targetDown++) {
			int idx = 0;
			
			for (int i = 0; i < map[Y].length; i++) {
				
				if (map[Y][i] == 2) {
					
					int cTime = 2*Range-1;
					int straight = 0;
					int distance = 0;
					int minDistance = Y+1; // 걍 최대로 길어봐야 Y+1보다 길 수 없으니까 
					// 사거리 1=1, 2=3, 3=5, 4=7 ... n = 2n-1 
					// 궁수의 사거리에 따라 탐색할 횟수가 달라짐.
					for (int n = 1; n <= cTime; n++) {
						if (n >= Range)	straight = -n + cTime + 1;
						else straight = n;
						
						// 탐색 가능한 범위를 왼쪽에서부터 세로로 확인.
						for (int j = 1; j <= straight; j++) {
							int r = Y-j;
							int c = i + n - Range;
							
							if (c >= 0 && c < X && r >= 0 &&  r < Y && map[r][c] == 1) {
								// 최소거리인지 체크하고 갱신해
								// 현재 내 위치 map[Y][i] , 적의 위치 map[r][c]
								distance = Math.abs(Y-r) + Math.abs(i-c);
								if (minDistance > distance) {
									minDistance = distance;
									aimingTarget[idx][0] = r;
									aimingTarget[idx][1] = c;
								}
							} 
						} // 세로 하나하나 살피는 중
						
					} // 세로 다 살피고 사수 한명이 조준 완료. 다음 사수가 조준할차례
					idx++;
				}
				
			} // 세명이 다 조준 완료됐고, 총 쏠 차례
			
			// 조준중인 녀석을 동시에 쏜다. 중복해서 쏜 애는 카운트 ㄴㄴ 
			for (int killTurn = 0; killTurn < 3; killTurn++) {
				int tr = aimingTarget[killTurn][0];
				int tc = aimingTarget[killTurn][1];
				if (map[tr][tc] == 1) {
					map[tr][tc] = 0;
					killCount++;
				}
			}
			
			// 총 쏴서 적 죽이고 killCount 증가했고 적이 한 칸 내려올 차례
			
			for (int oneLineDown = Y-2; oneLineDown >= 0; oneLineDown--) {
				map[oneLineDown+1] = Arrays.copyOf(map[oneLineDown], map[oneLineDown].length);
			}
			for (int topLineSet = 0; topLineSet < X; topLineSet++) {
				map[0][topLineSet] = 0;
			}
			
		} // 현재 궁수의 위치로 탐색은 끝
		
		bestKillCount = killCount > bestKillCount ? killCount : bestKillCount;
		
		// 다음 궁수 배치 턴을 위해 map 복구
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = originalMap[i][j];
			}
		}
	} 
}
