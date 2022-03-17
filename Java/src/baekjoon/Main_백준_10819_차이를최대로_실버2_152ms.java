package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10819_차이를최대로_실버2_152ms {
	private static int[] map, order;
	private static int N, maxSum;
	private static boolean[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	
		StringTokenizer stk = new StringTokenizer(br.readLine());
		map = new int[N];
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(stk.nextToken());
		}
		selected = new boolean[N];
		order = new int[N];
		maxSum = Integer.MIN_VALUE;
		perm(0); // cnt
		System.out.println(maxSum);
	} // 메인 끝

	private static void perm(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(order[i] - order[i+1]);
			}
			maxSum = Math.max(sum, maxSum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				continue;
			}
			order[cnt] = map[i];
			selected[i] = true;
			perm(cnt + 1);
			selected[i] = false;
		}
	}
}
