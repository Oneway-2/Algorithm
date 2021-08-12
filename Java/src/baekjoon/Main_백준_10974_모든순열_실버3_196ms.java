package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

// NextPermutation
public class Main_백준_10974_모든순열_실버3_196ms {
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		
		Arrays.sort(input);
		
		do {
			for (int i = 0; i < input.length; i++) {
				sb.append(input[i]).append(" ");
			}
			sb.append("\n");
		} while (np(input));
		
		System.out.println(sb);
	}
	
	private static boolean np(int[] numbers) {
		
		int N = numbers.length;
		
		int i = N-1;
		while(i>0 && numbers[i-1] >= numbers[i]) --i;
		
		if(i==0) return false;
		
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) --j;
		
		swap(numbers, i-1, j);
		
		int k = N-1;
		while (i < k) swap(numbers, i++, k--);
		
		return true;
	}
	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
