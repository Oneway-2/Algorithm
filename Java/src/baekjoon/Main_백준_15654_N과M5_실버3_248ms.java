package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_15654_N과M5_실버3_248ms {
	private static int N, M;
	private static int[] numbers, arr;
	private static boolean[] visited;
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		arr = new int[N];
		numbers = new int[M];
		visited = new boolean[N+1];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr);
		per(0);
		System.out.println(sb);
	} // 메인 끝
	private static void per(int cnt) {
		// 순열
		if (cnt == M) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				continue;
			}
			numbers[cnt] = arr[i];
			visited[i] = true;
			per(cnt+1);
			visited[i] = false;
		}
	}
}
