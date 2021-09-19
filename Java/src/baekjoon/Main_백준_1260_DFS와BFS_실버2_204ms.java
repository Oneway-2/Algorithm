package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1260_DFS와BFS_실버2_204ms {
	private static int N, M, V;
	private static boolean[] visited = new boolean[1001];
	private static int[][] map = new int[1001][1001];
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(stk.nextToken()); // 1 <= N <= 1000
		M = Integer.parseInt(stk.nextToken()); // 1 <= M <= 10000
		V = Integer.parseInt(stk.nextToken()); // 시작할 정점
		
		int a, b;
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(stk.nextToken());
			b = Integer.parseInt(stk.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		
		dfs(V);
		Arrays.fill(visited, false);
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
	} // 메인 끝
	
	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");
		for (int i = 1; i <= N; i++) {
			if (map[v][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	} // dfs 끝
	
	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		visited[v] = true;
		sb.append(v).append(" ");
		
		while(q.size() > 0) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if (map[cur][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					sb.append(i).append(" ");
				}
			}
		}
	} // bfs 끝
}
