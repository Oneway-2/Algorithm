package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2688_줄어들지않아_골드5_120ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[][] dp = new long[65][11];
		for (int i = 1; i < dp[1].length; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				for (int k = j; k < dp[i].length; k++) {
					dp[i][j] += dp[i-1][k]; 
				}
			}
		}
		
		// n 은 1 <= n <= 64 이다.
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			int n = Integer.parseInt(br.readLine());
			long result = 0;
			for (int j = 1; j < dp[n].length; j++) {
				result += dp[n][j];
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	} // 메인 끝
}
