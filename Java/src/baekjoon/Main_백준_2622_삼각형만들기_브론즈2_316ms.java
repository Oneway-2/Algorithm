package baekjoon;

import java.util.Scanner;

public class Main_백준_2622_삼각형만들기_브론즈2_316ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1 <= N <= 50000
		int m, c, cnt = 0;
		m = N / 3;
		c = N; // 임시 initialize
		for (int a = 1; a <= m; a++) {
			for (int b = a; b < c; b++) {
			c = N - a - b;
				if (a+b > c) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	} // 메인 끝
}
