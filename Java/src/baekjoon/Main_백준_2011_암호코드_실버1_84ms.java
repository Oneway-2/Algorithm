package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2011_암호코드_실버1_84ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		int mod = 1_000_000;
		int[] arr = new int[len];
		for (int i = 0; i < len ; i++) {
			arr[i] = s.charAt(i) - '0';
		}
		
		if (arr[0] == 0) {
			System.out.println(0);
			return;
		}
		int[] dp = new int[5001];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= len; i++) {
			// 0이 아니면
			if (arr[i-1] != 0) {
				dp[i] = (dp[i] + dp[i-1]) % mod;
			}
			int n = arr[i-2] * 10 + arr[i-1];
			if (10<=n && n<=26) {
				dp[i] = (dp[i] + dp[i-2]) % mod;
			}
		}
		System.out.println(dp[len]);
	} // 메인 끝
}
