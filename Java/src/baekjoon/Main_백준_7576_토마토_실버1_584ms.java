package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7576_토마토_실버1_584ms {
	
	// 맵 크기 최소 2x2 최대 1000x1000
	// 1초내로 다 익을 수 있으면 시간을, 다 못익으면 -1을
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		Queue<int[]> q = new LinkedList<int[]>();
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		int M = Integer.parseInt(stk.nextToken()); // 가로
		int N = Integer.parseInt(stk.nextToken()); // 세로
		int time = 0;
		int[][] map = new int[N+2][M+2];
		// 처음엔 걍 2로 다 초기화해놓자. 안그러면 나중에 0 인식해서 오류남
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], 2);
		}
		
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// 시작도 하기전에 이미 다 익어있는 경우는 그냥 0 출력하고 끝내자.
		int alreadyDone = 0;
		int thisTurnCnt = 0;
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				if (map[i][j] == 0) alreadyDone++;
				else if(map[i][j] == 1) {
					q.offer(new int[] {i,j}); // 세는김에 1 있는곳 좌표좀 알아놓자.
					thisTurnCnt++;
				}
			}
		}
		if (alreadyDone == 0) {
			System.out.println(0);
			return;
		}
		
		int tempTurn = thisTurnCnt;
		thisTurnCnt = 0;
		while(q.size() > 0) {
			
			// 시간이 지나는거 time에 기록
			if(tempTurn == 0) {
				time++;
				tempTurn = thisTurnCnt;
				thisTurnCnt = 0;
			}
			int r = q.peek()[0];
			int c = q.poll()[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (map[nr][nc] == 0) { // 주변이 안익어있다면 익게 만들기
					map[nr][nc] = 1;
					q.offer(new int[] {nr, nc}); // 그리고 다음 차례에 넣자
					thisTurnCnt++;
				}
			}
			tempTurn--;
		} // while 끝
		
		// 다 익게 만들었는데, 혹시 안익은 곳이 있나 체크. 있으면 -1 출력.
ex:		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					time = -1;
					break ex;
				}
			}
		}
		System.out.println(time);
	} // 메인 끝
}
