package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_9095_123더하기_실버3_76ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			int N = Integer.parseInt(br.readLine());
			for (int j = 4; j <= N; j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3]; 
			}
			System.out.println(dp[N]);
		}
	} // 메인 끝
}
