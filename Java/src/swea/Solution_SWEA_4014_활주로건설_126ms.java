package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_4014_활주로건설_126ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			stk = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(stk.nextToken()); // 맵 크기 6~20
			int X = Integer.parseInt(stk.nextToken()); // 활주로 길이 2~4
			int[][] map = new int[N][N];
			boolean[][] cmap = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
						
			int cnt = 0;
			// 가로 검사
			for (int i = 0; i < N; i++) {
				boolean pass = true;
				for (int j = 0; j < N-1; j++) {
					if(map[i][j] < map[i][j+1]) { // 오르막길 발견
//						1. 지금 자리에서부터 뒤로 X-1 칸 확인. (활주로 길이가 2면 1칸만 확인.)
//						2. 지금 높이와 쭉 같으면 ok.
						if(map[i][j+1] - map[i][j] > 1) { // 높이차이가 1보다 많이남
							pass = false;
							break;
						}
						for (int h = 1; h <= X-1; h++) {
							if (j-h < 0) { // 밖으로 나간거
								pass = false;
								break;
							}
							else { 
								if (cmap[i][j-h] || map[i][j-h] != map[i][j]) { // X 길이만큼 놓을 자리가 없음
									pass = false;
									break;
								}
							}
						}
						if(!pass) break;
						for (int k = 0; k < X; k++) {
							cmap[i][j-k] = true;
						}
					}
					else if(map[i][j] > map[i][j+1]) { // 내리막길 발견
						if(map[i][j] - map[i][j+1] > 1) { // 높이차이가 1보다 많이남
							pass = false;
							break;
						}
//						1. 다음 X칸동안 평지인지 확인
						for (int h = 1; h <= X-1; h++) {
							if(j+h+1 > N-1) { // 밖으로 나간거 
								pass = false;
								break;
							}
							else {
								if (map[i][j+h+1] != map[i][j+1]) { // X 길이만큼 놓을 자리가 없음
									pass = false;
									break;
								}
							}
						}
						if(!pass) break;
						for (int k = 1; k <= X; k++) {
							cmap[i][j+k] = true;
						}
					}
				}
				if(pass) cnt++;
			}
			
			for (int k = 0; k < cmap.length; k++) {
				Arrays.fill(cmap[k], false);
			}
			
			// 세로 검사
			for (int i = 0; i < N; i++) {
				boolean pass = true;
				for (int j = 0; j < N-1; j++) {
					if(map[j][i] < map[j+1][i]) { // 오르막길 발견
						if(map[j+1][i] - map[j][i] > 1) {
							pass = false;
							break;
						}
						for (int h = 1; h <= X-1; h++) {
							if (j-h < 0) { // 밖으로 나간거
								pass = false;
								break;
							}
							else { 
								if (cmap[j-h][i] || map[j-h][i] != map[j][i]) { // X 길이만큼 놓을 자리가 없음
									pass = false;
									break;
								}
							}
						}
						if(!pass) break;

						for (int k = 0; k < X; k++) {
							cmap[j-k][i] = true;
						}
					} 
					else if(map[j][i] > map[j+1][i]) { // 내리막길 발견
//						1. 다음 X칸동안 평지인지 확인
						if(map[j][i] - map[j+1][i] > 1) {
							pass = false;
							break;
						}
						for (int h = 1; h <= X-1; h++) {
							if(j+h+1 > N-1) { // 밖으로 나간거 
								pass = false;
								break;
							}
							else {
								if (map[j+h+1][i] != map[j+1][i]) { // X 길이만큼 놓을 자리가 없음
									pass = false;
									break;
								}
							}
						}
						if(!pass) break;
						for (int k = 1; k <= X; k++) {
							cmap[j+k][i] = true;
						}
					}
				}
				if(pass) cnt++;
			}
			sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
}
