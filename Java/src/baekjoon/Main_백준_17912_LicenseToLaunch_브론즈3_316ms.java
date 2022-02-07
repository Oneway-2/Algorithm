package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17912_LicenseToLaunch_브론즈3_316ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int day = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(stk.nextToken());
			if (n <= min && min != n) {
				day = i;
				min = n;
			}
		}
		System.out.println(day);
	} // 메인 끝
}
