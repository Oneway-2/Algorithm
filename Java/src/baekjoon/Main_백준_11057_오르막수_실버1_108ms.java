package baekjoon;

import java.util.Scanner;

public class Main_백준_11057_오르막수_실버1_108ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][10];
		// 1자리수는 0~9를 1로 초기화
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9 ; j++) {
				for (int k = j; k <= 9; k++) {
					// 10007 안나눠서 틀렸었네. 더할때마다 나눠줘야 오버플로우 안남.
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007;
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i <= 9; i++) {
			result += dp[n][i];
		}
		// 각 수를 다 더한 값은 10007보다 커질수도 있으니 나눠줘야한다.
		System.out.println(result % 10007);
	} // 메인 끝
}
