package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2156_포도주시식_실버1_96ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int[] a = new int[N+1];
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		dp[1] = a[1];
		if (N == 1) {
			System.out.println(a[1]);
		}
		else {
			dp[2] = a[1]+a[2];
			for (int i = 3; i <= N; i++) {
				dp[i] = Math.max(Math.max(dp[i-3]+a[i-1]+a[i], dp[i-1]), dp[i-2]+a[i]);
			}
			System.out.println(dp[N]);
		}
		
	} // 메인 끝
}
