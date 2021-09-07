package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_20299_3대측정_브론즈2_936ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken()); // 1 <= N <= 500000 가입 팀 수
		int K = Integer.parseInt(stk.nextToken()); // 0 <= K <= 12000 레이팅 합 조건
		int L = Integer.parseInt(stk.nextToken()); // 0 <= L <= 4000 개인 가입 조건
		
		int[] a = new int[3];
		int sum = 0, cnt = 0;
		boolean pass;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			sum = 0;
			pass = true;
			for (int k = 0; k < 3; k++) {
				a[k] = Integer.parseInt(stk.nextToken());
				if (a[k] < L) pass = false;
				sum += a[k];
			}
			if (sum < K) pass = false;
			if (pass) {
				cnt++;
				for (int k = 0; k < 3; k++) {
					sb.append(a[k]).append(" ");
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	} // 메인 끝
}
