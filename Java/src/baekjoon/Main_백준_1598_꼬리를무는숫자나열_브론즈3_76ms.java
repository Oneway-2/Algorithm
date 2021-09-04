package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1598_꼬리를무는숫자나열_브론즈3_76ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(stk.nextToken());
		int B = Integer.parseInt(stk.nextToken());
		int dA, dB, rA, rB;
		if (A%4 == 0) {
			dA = A/4 - 1;
			rA = 4;
		} else {
			dA = A/4;
			rA = A%4;
		}
		if (B%4 == 0) {
			dB = B/4 - 1;
			rB = 4;
		} else {
			dB = B/4;
			rB = B%4;
		}
		int result = Math.abs(dA-dB) + Math.abs(rA-rB);
		System.out.println(result);
	}
}
