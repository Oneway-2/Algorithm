package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로_225ms {
	private static int[][] map;
	private static boolean[] visited;
	private static int N, ans = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		N = Integer.parseInt(br.readLine().trim()); // 1 <= N <= 12
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		visited[1] = true;
		dfs(1, 1, 0);
		System.out.println(ans);
	}
	private static void dfs(int depth, int v, int cost) {
		if (depth >= N) {
			if (map[v][1] != 0 && ans > cost + map[v][1]) {
				ans = cost + map[v][1];
			}
			return;
		}
		
		for (int i = 2; i <= N; i++) {
			if (visited[i] || map[v][i] == 0) continue;
			if (cost + map[v][i] > ans) continue;
			visited[i] = true;
			dfs(depth + 1, i, cost + map[v][i]);
			visited[i] = false;
		}
	}
}
