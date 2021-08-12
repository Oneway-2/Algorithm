package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 제한시간: 1초
 * 실행시간: 80ms
 * 2021.08.12 목 HW
 */
public class Main_백준_3040_백설공주와일곱난쟁이_브론즈2_80ms {
	static int[] num = new int[9];
	static int[] ans = new int[7];
	static int N=9, R=7;
	static boolean exit = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		getHundred(0, 0);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
	}
	private static void getHundred(int cnt, int start) {
		if (cnt == R) {
			int sum = 0;
			for (int i = 0; i < ans.length; i++) {
				sum += ans[i];
			}
			
			if (sum == 100) {
				exit = true;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			ans[cnt] = num[i];
			getHundred(cnt+1, i+1);
			if (exit) {
				break;
			}
		}
	}
}
