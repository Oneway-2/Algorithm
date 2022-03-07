package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_21736_헌내기는친구가필요해_실버2_476ms {
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int startr = 0, startc = 0;
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'I') {
					startr = i;
					startc = j;
				}
			}
		}
		
		int cnt = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		q.offer(new int[] {startr, startc});
		visited[startr][startc] = true;
		
		while(q.size() > 0) {
			int r = q.peek()[0];
			int c = q.poll()[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0>nr || nr>=N || 0>nc || nc>=M || visited[nr][nc] || map[nr][nc] == 'X') {
					continue;
				}
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				if (map[nr][nc] == 'P') {
					cnt++;
				}
			}
		}
		
		if (cnt == 0) {
			System.out.println("TT");
		}
		else {
			System.out.println(cnt);
		}
	} // 메인 끝
}
