package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2468_안전영역_실버1_352ms {
	public static void main(String[] args) throws IOException {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1}; // 상하좌우
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		int highest = 0;
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				highest = Math.max(map[i][j], highest);
			}
		}
		
		int maxVal = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < highest; i++) { // 강수량 0일 경우를 고려안해줘서 1번틀렸네.
			// 일단 가라앉히기
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (map[r][c] == i) {
						map[r][c] = 0;
					}
				}
			}
			// 섬 세기
			int islandCnt = 0;
			q.clear();
			clearVisited(visited);
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (map[r][c] != 0 && !visited[r][c]) {
						q.offer(new int[] {r,c});
						visited[r][c] = true;
						islandCnt++;
						while(q.size() > 0) {
							int rr = q.peek()[0];
							int cc = q.poll()[1];
							for (int k = 0; k < 4; k++) {
								int nr = rr + dr[k];
								int nc = cc + dc[k];
								if (0>nr || nr>=n || 0>nc || nc>=n || visited[nr][nc] || map[nr][nc] == 0) {
									continue;
								}
								q.offer(new int[] {nr,nc});
								visited[nr][nc] = true;
							}
						} // while 끝
					} // if 끝
					maxVal = Math.max(islandCnt, maxVal);
				}
			}
		}
		System.out.println(maxVal);
	} // 메인 끝

	private static void clearVisited(boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], false);
		}
	}
}
