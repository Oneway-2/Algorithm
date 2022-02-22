package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_7510_고급수학_브론즈3_204ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[3];
		for (int i = 1; i <= n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[j] = Integer.parseInt(stk.nextToken());
			}
			Arrays.sort(arr);
			System.out.printf("Scenario #%d:\n", i);
			if (arr[2]*arr[2] == (arr[0]*arr[0])+(arr[1]*arr[1])) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
			System.out.println();
		}
	} // 메인 끝
}
