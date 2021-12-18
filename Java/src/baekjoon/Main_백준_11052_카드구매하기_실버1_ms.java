package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11052_카드구매하기_실버1_ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] dp = new int[1001];
		int[] p = new int[N+1];
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(stk.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + p[j]);
			}
		}
		System.out.println(dp[N]);
	} // 메인 끝
}
