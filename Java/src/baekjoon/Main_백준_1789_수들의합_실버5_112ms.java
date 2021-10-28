package baekjoon;

import java.util.Scanner;

public class Main_백준_1789_수들의합_실버5_112ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();
		long n = 1;
		long sum;
		while(true) {
			sum = (n * (n+1)) / 2;
			if (sum > s) {
				break;
			}
			n++;
		}
		System.out.println(n-1);
	} // 메인 끝
}
