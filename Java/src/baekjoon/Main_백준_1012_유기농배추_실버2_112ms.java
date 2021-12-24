package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1012_유기농배추_실버2_112ms {
	public static void main(String[] args) throws IOException {
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			stk = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(stk.nextToken()); // 가로
			int N = Integer.parseInt(stk.nextToken()); // 세로
			int K = Integer.parseInt(stk.nextToken());
			boolean[][] map = new boolean[N][M];
			boolean[][] visited = new boolean[N][M];
			for (int j = 0; j < K; j++) {
				stk = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(stk.nextToken());
				int r = Integer.parseInt(stk.nextToken());
				map[r][c] = true;
			}
			
			int cnt = 0;
			Queue<int[]> q = new LinkedList<int[]>();
			for (int ii = 0; ii < N; ii++) {
				for (int jj = 0; jj < M; jj++) {
					// 배추가 있거나, 이미 방문하지 않은곳이라면 BFS시작
					if (map[ii][jj] && !visited[ii][jj]) {
						cnt++;
						q.offer(new int[] {ii,jj});
						while(q.size() > 0) {
							int r = q.peek()[0];
							int c = q.poll()[1];
							for (int j = 0; j < 4; j++) {
								int nr = r + dr[j];
								int nc = c + dc[j];
								if (0>nr || nr>=N || 0>nc || nc>=M || !map[nr][nc] || visited[nr][nc]) {
									continue;
								}
								q.offer(new int[] {nr,nc});
								visited[nr][nc] = true;
							}
						} // while 끝
					}
				}
			} // for 끝
			System.out.println(cnt);
		}
	} // 메인 끝
}
