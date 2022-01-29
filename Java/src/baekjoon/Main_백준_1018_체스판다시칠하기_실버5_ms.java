package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1018_체스판다시칠하기_실버5_ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(stk.nextToken());
		int N = Integer.parseInt(stk.nextToken());
		char[][] map = new char[M][N];
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int m = M - 7;
		int n = N - 7;
		int minCnt = Integer.MAX_VALUE;
		int cntW = 0, cntB = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
//				System.out.println(i + " " + j);
				cntW = 0;
				cntB = 0;
				for (int ii = i, a = 0; ii < i + 8; ii++, a++) {
					for (int jj = j, b = 0; jj < j + 8; jj++, b++) {
						// W 로 시작
						if (map[i][j] == 'W') {
							if (a % 2 == 0 && b % 2 == 0 && map[ii][jj] == 'W')
								continue;
							else if (a % 2 == 0 && b % 2 != 0 && map[ii][jj] == 'B')
								continue;
							else if (a % 2 != 0 && b % 2 == 0 && map[ii][jj] == 'B')
								continue;
							else if (a % 2 != 0 && b % 2 != 0 && map[ii][jj] == 'W')
								continue;
							else
								cntW++;
							
							if (a % 2 == 0 && b % 2 == 0 && map[ii][jj] == 'B')
								continue;
							else if (a % 2 == 0 && b % 2 != 0 && map[ii][jj] == 'W')
								continue;
							else if (a % 2 != 0 && b % 2 == 0 && map[ii][jj] == 'W')
								continue;
							else if (a % 2 != 0 && b % 2 != 0 && map[ii][jj] == 'B')
								continue;
							else
								cntB++;
							
						}
						// B 로 시작
						if (map[i][j] == 'B') {
							if (a % 2 == 0 && b % 2 == 0 && map[ii][jj] == 'W')
								continue;
							else if (a % 2 == 0 && b % 2 != 0 && map[ii][jj] == 'B')
								continue;
							else if (a % 2 != 0 && b % 2 == 0 && map[ii][jj] == 'B')
								continue;
							else if (a % 2 != 0 && b % 2 != 0 && map[ii][jj] == 'W')
								continue;
							else
								cntW++;
							
							if (a % 2 == 0 && b % 2 == 0 && map[ii][jj] == 'B')
								continue;
							else if (a % 2 == 0 && b % 2 != 0 && map[ii][jj] == 'W')
								continue;
							else if (a % 2 != 0 && b % 2 == 0 && map[ii][jj] == 'W')
								continue;
							else if (a % 2 != 0 && b % 2 != 0 && map[ii][jj] == 'B')
								continue;
							else
								cntB++;
						}
					}
				}
				int cnt = Math.min(cntW, cntB);
				minCnt = Math.min(cnt, minCnt);
			}
		}
		System.out.println(minCnt);
	} // 메인 끝
}
