package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_10971_외판원순회2_실버2_ms {
	private static int result, N;
	private static boolean[] visited;
	private static int[] order;
	private static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		order = new int[N];
		result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());					
			}
		}
		perm(0);
		System.out.println(result);
	} // 메인 끝
	
	private static void perm(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(order));
			play();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (visited[i]) {
				continue;
			}
			order[cnt] = i;
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}
	
	private static void play() {
		int from, to, sum = 0;
		for (int i = 0; i < N-1; i++) {
			from = order[i];
			to = order[i+1];
			if (map[from][to] == 0) {
				return;
			}
			sum += map[from][to];
		}
		from = order[order.length-1];
		to = order[0];
		sum += map[from][to];
		result = Math.min(sum, result);
		System.out.printf("sum = %d, result = %d\n", sum, result);
	}
}
