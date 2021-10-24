package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_3048_개미_실버4_ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(stk.nextToken());
		int n2 = Integer.parseInt(stk.nextToken());
		String g1 = br.readLine();
		String g2 = br.readLine();
		int sec = Integer.parseInt(br.readLine());
		char[] arr = new char[n1+n2];
		for (int i = 0, j = n1-1; i < n1; i++, j--) {
			arr[i] = g1.charAt(j);
		}
		for (int i = n1, j = 0; i < n1+n2; i++, j++) {
			arr[i] = g2.charAt(j);
		}
		
		System.out.println(Arrays.toString(arr));
		
		for (int i = n1-1; i >= 0; i--) {
			System.out.println(i);
			swap(i, arr);
		}
		
	} // 메인 끝

	private static void swap(int i, char[] arr) {
		
	}
}
