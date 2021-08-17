package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제한시간: 0.5초
 * 실행시간: 84ms
 * 2021.08.17 화 WS
 */
public class Main_백준_1074_Z_실버1_84ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(stk.nextToken()); // 1 <= N <= 15
		int R = Integer.parseInt(stk.nextToken()); // 0 <= R <= 32,768
		int C = Integer.parseInt(stk.nextToken()); // 0 <= C <= 32,768
		int total = 0;
		// 최대 맵 10억까지 올라감. 이러면 1초 그냥지남. 절대 완탐 금지
		
		goInto(N, R, C, total);
	}
	
	private static void goInto(int n, int r, int c, int total) {
		if(n <= 0) {
			System.out.println(total);
			return;
		}
		
		if (r >= Math.pow(2, n-1) && c >= Math.pow(2, n-1)) {
//			System.out.printf("n == %d 일때 3\n", n);
			total += Math.pow(4, n-1) * 3;
			r -= Math.pow(2, n-1);
			c -= Math.pow(2, n-1);
		}
		else if (r >= Math.pow(2, n-1) && c < Math.pow(2, n-1)) {
//			System.out.printf("n == %d 일때 2\n", n);
			total += Math.pow(4, n-1) * 2;
			r -= Math.pow(2, n-1);
		}
		else if (r < Math.pow(2, n-1) && c >= Math.pow(2, n-1)) {
//			System.out.printf("n == %d 일때 1\n", n);
			total += Math.pow(4, n-1) * 1;
			c -= Math.pow(2, n-1);
		}
		else if (r < Math.pow(2, n-1) && c < Math.pow(2, n-1)) {
//			System.out.printf("n == %d 일때 0\n", n);
		}
		
		goInto(n - 1, r, c, total);
	}
}
