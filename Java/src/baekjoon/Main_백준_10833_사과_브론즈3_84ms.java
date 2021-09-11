package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10833_사과_브론즈3_84ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int N = Integer.parseInt(br.readLine());
		int sum = 0, a, b;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(stk.nextToken());
			b = Integer.parseInt(stk.nextToken());
			sum += b % a;
		}
		System.out.println(sum);
	} // 메인 긑
}
