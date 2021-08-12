package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1182_부분수열의합_실버2_88ms {
	private static int N;
	private static int S;
	private static int[] input;
	private static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stk.nextToken());
		S = Integer.parseInt(stk.nextToken());
		input = new int[N];
		stk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		
		Check(0, 0);
		if (S == 0) { // 목표 합 S가 0이면 시작할때 하나 추가되고 시작함. 그래서 하나뺴줌
			count--;
		}
		System.out.println(count);
	}
	
	private static void Check(int sum, int step) {
		if (step==N) {
			if (sum == S) {
				count++;
			}
			return;
		} 
		
		Check(sum + input[step], step + 1);
		Check(sum, step + 1);
	}
}
