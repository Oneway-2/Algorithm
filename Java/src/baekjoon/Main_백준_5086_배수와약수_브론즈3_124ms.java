package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_5086_배수와약수_브론즈3_124ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			if (N == 0 && M == 0) {
				break;
			}
			if (N > M) {
				int d = N % M;
				if (d == 0) {
					System.out.println("multiple");
				}
				else {
					System.out.println("neither");
				}
			}
			else {
				int d = M % N;
				if (d == 0) {
					System.out.println("factor");
				}
				else {
					System.out.println("neither");
				}
			}
		}
	} // 메인 끝
}
