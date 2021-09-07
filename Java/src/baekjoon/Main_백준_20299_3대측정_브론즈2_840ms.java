package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_20299_3대측정_브론즈2_840ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken()); // 1 <= N <= 500000 가입 팀 수
		int K = Integer.parseInt(stk.nextToken()); // 0 <= K <= 12000 레이팅 합 조건
		int L = Integer.parseInt(stk.nextToken()); // 0 <= L <= 4000 개인 가입 조건
		int[][] teams = new int[N][3];
		boolean[] pass = new boolean[N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				teams[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		int sum;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < 3; j++) {
				if (teams[i][j] < L) {
					pass[i] = true;
					break;
				}
				sum += teams[i][j];
			}
			if (!pass[i] && sum < K) {
				pass[i] = true;
			}
			if (!pass[i]) {
				cnt++;
				for (int m = 0; m < 3; m++) {
					sb.append(teams[i][m]).append(" ");
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	} // 메인 끝
}
