package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수_실버2_188ms {
	private static int[] dr = {-1,-1,0,1,1,1,0,-1}; // 12시부터 시계방향
	private static int[] dc = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		while(true) {
			stk = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(stk.nextToken());
			int h = Integer.parseInt(stk.nextToken());
			if (w == 0 && h == 0) break;
			int[][] map = new int[h+2][w+2];
			boolean[][] visited = new boolean[h+2][w+2];
			for (int i = 1; i <= h; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= w; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			int cnt = 0;
			Queue<int[]> q = new LinkedList<int[]>(); 
			for (int r = 1; r <= h; r++) {
				for (int c = 1; c <= w; c++) {
					if (map[r][c] == 1 && !visited[r][c]) {
						cnt++;
						q.offer(new int[] {r, c});
						while(q.size() > 0) {
							int rr = q.peek()[0];
							int cc = q.poll()[1];
							for (int i = 0; i < 8; i++) {
								int nr = rr + dr[i];
								int nc = cc + dc[i];
								if (map[nr][nc] == 1 && !visited[nr][nc]) {
									q.offer(new int[] {nr, nc});
									visited[nr][nc] = true;
								}
							}
						} // while 끝
					}
				}
			}
			
			sb.append(cnt).append("\n");
		} // while 끝
		System.out.println(sb);
	} // 메인 끝
}
