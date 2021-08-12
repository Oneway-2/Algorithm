package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_10974_모든순열_실버3_176ms {
	static int N;
	static int[] numbers;
	static int[] input;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		input = new int[N];
		
		for (int i = 1; i <= N; i++) {
			input[i-1] = i;
		}
		
		Permutation(0, 0);
		System.out.println(sb);
	}
	
	private static void Permutation(int cnt, int flag) {
		if(cnt == N) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			
			numbers[cnt] = input[i];
			
			Permutation(cnt + 1, flag | 1 << i);
		}
	}
}
