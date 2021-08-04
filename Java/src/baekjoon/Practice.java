package baekjoon;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		long n = 0;
		long acc = 2*n*(n+1)*(2*n + 1);
		double awer = Math.pow(10, 15);
		System.out.println(awer);
		while(acc < Math.pow(10, 15)) {
			n++;
			acc = 2*n*(n+1)*(2*n + 1);
			System.out.printf("n = %d, acc = %d\n", n , acc);
		}
		
		//10의 15승까지 가기위한 단계는 62996번
	}
}
