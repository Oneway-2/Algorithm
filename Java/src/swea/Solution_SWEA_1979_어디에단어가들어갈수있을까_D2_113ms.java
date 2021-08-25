package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1979_어디에단어가들어갈수있을까_D2_113ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int TC = Integer.parseInt(br.readLine());
		int[][] map;
		for (int testCase = 1; testCase <= TC; testCase++) {
			int possibleCnt = 0;
			stk = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(stk.nextToken()); // 5 <= N <= 15
			int K = Integer.parseInt(stk.nextToken()); // 2 <= K <= N
			map = new int[N+2][N+2];
			// 입력받자
			for (int i = 1; i <= N; i++) {
				stk = new StringTokenizer(br.readLine()," ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			int til = N - K + 1;
			int ins = K + 2;
			// 가로탐색
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j <= til; j++) {
					if(map[i][j] == 1) continue; // 시작부터 뚫린경우 안됨. 아늑하게 막혀있어야함
					int cnt = 0;
					for (int h = j+1; h < ins + j + 1; h++) {
						if(cnt == K && map[i][h] == 0) {
							possibleCnt++; // 안착할 공간 + 끝이 막힌경우 okay
						}
						if(map[i][h] == 0) break; // 중간에 벽으로 막힌경우
						cnt++;
					}
				}
			}
			// 세로탐색
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j <= til; j++) {
					if(map[j][i] == 1) continue; // 시작부터 뚫린경우 안됨. 아늑하게 막혀있어야함
					int cnt = 0;
					for (int h = j+1; h < ins + j + 1; h++) {
						if(cnt == K && map[h][i] == 0) {
							possibleCnt++; // 안착할 공간 + 끝이 막힌경우 okay
						}
						if(map[h][i] == 0) break; // 중간에 벽으로 막힌경우
						cnt++;
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(possibleCnt).append("\n");
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
}

/*
#1 2
#2 6
#3 6
#4 0
#5 14
#6 2
#7 45
#8 0
#9 98
#10 7
*/