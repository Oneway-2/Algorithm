package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2638_치즈_골드4_312ms {
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int time = 0;
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		int[][] tMap = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		boolean exit = false;
		
		while(!exit) {
			exit = true;
			for (int i = 0; i < tMap.length; i++) {
				Arrays.fill(tMap[i], 0);
				Arrays.fill(visited[i], false);
			}
			
			Queue<int[]> q = new LinkedList<int[]>();
			visited[0][0] = true;
			q.offer(new int[] {0,0});
			while(q.size() > 0) {
				int r = q.peek()[0];
				int c = q.poll()[1];
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (0>nr || nr>=N || 0>nc || nc>=M || visited[nr][nc]) {
						continue;
					}
					if (map[nr][nc] == 0) {
						q.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
					}
					else if (map[nr][nc] == 1) {
						exit = false;
						tMap[nr][nc]++;
					}
					
				}
				
			}
			if (!exit) {
				time++;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (tMap[i][j] >= 2) {
							map[i][j] = 0;
						}
					}
				}
			}
		}
		System.out.println(time);
	} // 메인 끝
}
