package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7236_저수지의물의총깊이구하기_D3_112ms {
	static int[] dr = {-1, -1 ,-1 ,0, 1, 1, 1, 0};
	static int[] dc = {-1 ,0, 1, 1, 1, 0, -1 ,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		int deepest;
		char[][] map;
		for (int testCase = 1; testCase <= TC; testCase++) {
			deepest = 0;
			int N = Integer.parseInt(br.readLine()); 		// 저수지 구획의 크기 은 9<=N<=100
			map = new char[N+2][N+2];
			for (int i = 1; i <= N; i++) {
				stk = new StringTokenizer(br.readLine()," ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = stk.nextToken().charAt(0);
				}
			}
			
			int cntW = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					cntW = 0;
					for (int k = 0; k < dr.length; k++) {
						int r = i+dr[k];
						int c = j+dc[k];
						if (map[r][c] == 'W') {
							cntW++;
						}
					}
					deepest = cntW > deepest ? cntW : deepest;
				}
			}
			// 배열바깥은 G로 쳐도 되는건가??
			sb.append("#").append(testCase).append(" ").append(deepest).append("\n");
		} // 테케 끝
		System.out.println(sb);
	}
}
