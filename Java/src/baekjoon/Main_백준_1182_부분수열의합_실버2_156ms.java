package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1182_부분수열의합_실버2_156ms {
	private static int N;
	private static int S;
	private static int[] input;
	private static int[] numbers;
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
		
		for (int R = 1; R <= N; R++) {
			numbers = new int[R];
			Check(0, 0, R);
		}
		System.out.println(count);
	}
	
	private static void Check(int cnt, int start, int R) {
		if (cnt==R) {
			int sum = 0;
			for (int i = 0; i < numbers.length; i++) {
				sum += numbers[i];
			}
			if (sum == S) {
				count++;
			}
			return;
		} 
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			Check(cnt + 1, i + 1, R); 
		}
	}
}
