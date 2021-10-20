package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15652_N과M4_실버3_104ms {
	private static int[] numbers;
	private static int N, M;
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		numbers = new int[M];
		per(0, 1);
		System.out.println(sb);
	} // 메인 끝
	private static void per(int cnt, int start) {
		// 중복조합
		if(cnt == M) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			per(cnt+1, i);
		}
	}
}
