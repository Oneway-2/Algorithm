package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_9465_스티커_실버1_772ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] a = new int[2][n + 1];
			int[][] dp = new int[2][100001];
			for (int j = 0; j < 2; j++) {
				stk = new StringTokenizer(br.readLine());
				for (int k = 1; k <= n; k++) {
					a[j][k] = Integer.parseInt(stk.nextToken());
				}
			}
			dp[0][0] = dp[1][0] = 0;
			dp[0][1] = a[0][1];
			dp[1][1] = a[1][1];
			if (n > 1) {
				dp[0][2] = a[1][1] + a[0][2];
				dp[1][2] = a[0][1] + a[1][2];
			}
			if (n > 2) {
				dp[0][3] = Math.max(a[1][1] + a[0][3], a[0][1] + a[1][2] + a[0][3]);
				dp[1][3] = Math.max(a[0][1] + a[1][3], a[1][1] + a[0][2] + a[1][3]);
			}
			if (n > 3) {
				dp[0][4] = Math.max(dp[0][1]+a[1][2]+a[0][4], Math.max(dp[0][1]+a[1][3]+a[0][4], dp[1][1]+a[0][2]+a[1][3]+a[0][4]));
				dp[1][4] = Math.max(dp[1][1]+a[0][2]+a[1][4], Math.max(dp[1][1]+a[0][3]+a[1][4], dp[0][1]+a[1][2]+a[0][3]+a[1][4]));
			}
			for (int k = 5; k <= n; k++) {
				dp[0][k] = Math.max(a[0][k]+dp[1][k-2], a[0][k]+dp[1][k-1]);
				dp[1][k] = Math.max(a[1][k]+dp[0][k-2], a[1][k]+dp[0][k-1]);
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	} // 메인 끝
}
