package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7569_토마토_실버1_712ms {
	public static void main(String[] args) throws IOException {
		int[] dr = {-1,1,0,0,0,0}; // 상하좌우 위 아래
		int[] dc = {0,0,-1,1,0,0};
		int[] dh = {0,0,0,0,1,-1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(stk.nextToken()); // 가로
		int R = Integer.parseInt(stk.nextToken()); // 세로
		int H = Integer.parseInt(stk.nextToken()); // 높이
		int maxDay = Integer.MIN_VALUE;
		int[][][] map = new int[H][R][C];
		boolean[][][] visited = new boolean[H][R][C];
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < R; j++) {
				stk = new StringTokenizer(br.readLine());
				for (int k = 0; k < C; k++) {
					map[i][j][k] = Integer.parseInt(stk.nextToken());
					if(map[i][j][k] == 1) {
						q.offer(new int[] {i, j, k, 0}); // h, r, c, day
						visited[i][j][k] = true;
					}
				}
			}
		}
		
		while(q.size() > 0) {
			int h = q.peek()[0];
			int r = q.peek()[1];
			int c = q.peek()[2];
			int day = q.poll()[3];
			maxDay = Math.max(day, maxDay);
			
			for (int i = 0; i < 6; i++) {
				int nh = h + dh[i];
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0>nh || nh>=H || 0>nr || nr>=R || 0>nc || nc>=C || visited[nh][nr][nc] || map[nh][nr][nc] != 0) {
					continue;
				}
				q.offer(new int[] {nh, nr, nc, day+1});
				visited[nh][nr][nc] = true;
				map[nh][nr][nc] = 1;
			}
		}
		
		boolean allDone = true;
ex:		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				for (int k = 0; k < map[i][j].length; k++) {
					if (map[i][j][k] == 0) {
						allDone = false;
						break ex;
					}
				}
			}
		}
		
		if(allDone) System.out.println(maxDay);
		else System.out.println(-1);
	} // 메인 끝
}

