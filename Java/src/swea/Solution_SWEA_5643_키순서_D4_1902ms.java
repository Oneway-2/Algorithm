package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5643_키순서_D4_1902ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int TC = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine().trim()); // 학생 수 2 <= N <= 500
			int M = Integer.parseInt(br.readLine().trim()); // 비교한 수 0 <= M <= N*(N-1)/2
			int[][] map = new int[N+1][N+1];
			for (int i = 0; i < M; i++) {
				stk = new StringTokenizer(br.readLine()," ");
				int s = Integer.parseInt(stk.nextToken());
				int t = Integer.parseInt(stk.nextToken());
				map[s][t] = 1;
				map[t][s] = -1;
			}
			// i가 k보다 크고, k가 j보다 크다면, i는 j보다 크다.
			// i가 k보다 작고, k가 j보다 작다면, i는 j보다 작다.
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (map[i][j] == 0) {
							if (map[i][k] == 1 && map[k][j] == 1) {
								map[i][j] = 1;
							}
							else if(map[i][k] == -1 && map[k][j] == -1) {
								map[i][j] = -1;
							}
						}
					}
				}
			}
			
			int result = 0;
			for (int i = 1; i <= N; i++) {
				int cnt = 0;
				for (int j = 1; j <= N; j++) {
					if(map[i][j] == 0) cnt++;
				}
				if (cnt == 1) {
					result++;
				}
			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
}
