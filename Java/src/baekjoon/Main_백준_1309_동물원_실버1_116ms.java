package baekjoon;

import java.util.Scanner;

public class Main_백준_1309_동물원_실버1_116ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// N , result
		// 1 , 3
		// 2 , 7
		// 3 , 17
		// 4 , 41
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 3;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901;
		}
		System.out.println(dp[N]);
	} // 메인 끝
}
