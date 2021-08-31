package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_1629_곱셈_실버1_92ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		long A = Integer.parseInt(stk.nextToken());
		long B = Integer.parseInt(stk.nextToken());
		long C = Integer.parseInt(stk.nextToken());
		long extra = 1;
		
		A = A%C;
		while(B > 1) {
		//B가 2로 안나눠진다?
		if (B%2 != 0) {
			extra *= A;
			A = A*A;
			B = B/2;
		}
		//B가 2로 나눠진다?
		else {
			A = A*A;
			B = B/2;
		}
		A = A%C;
		if (extra >= C) extra = extra%C;
		
		} // while 끝
		long result = ((long)Math.pow(A, B) * extra) % C;
		System.out.println(result);
	} // 메인 끝
}
