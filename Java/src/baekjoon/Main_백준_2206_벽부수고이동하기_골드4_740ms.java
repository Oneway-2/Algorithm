package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2206_벽부수고이동하기_골드4_740ms {
	public static void main(String[] args) throws IOException {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		
		if (R-1 == 0 && C-1 == 0) {
			System.out.println(1);
			System.exit(0);
		}
		
		char[][] map = new char[R][C];
		int[][] dist = new int[R][C];
		boolean[][][] visited = new boolean[2][R][C];
		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		// 시작x, 시작y, 벽뿌신여부(0, 1)
		q.offer(new int[] {0, 0, 0});
		
		while(q.size() > 0) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int crashed = cur[2];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (0>nr || nr>=R || 0>nc || nc>=C) continue; 
				
				// 다음이 벽이면
				if (map[nr][nc] == '1') {
					// 부수기 이용권 썼는지? && 방문했던 벽인지?
					if (crashed == 0 && !visited[1][nr][nc]) {
						visited[crashed][nr][nc] = true;
						dist[nr][nc] = dist[r][c] + 1;
						q.offer(new int[] {nr,nc,1});
					}
				}
				// 다음이 벽이 아니면
				else {
					// 벽을 부순 여부에 따라 방문을 했는지 체크
					if (!visited[crashed][nr][nc]) {
						visited[crashed][nr][nc] = true;
						dist[nr][nc] = dist[r][c] + 1;
						q.offer(new int[] {nr,nc,crashed});
					}
				}
				
				// 도착지점에 도착했다면 end
				if (nr == R-1 && nc == C-1) {
					System.out.println(dist[nr][nc] + 1);
					System.exit(0);
				}
			}
		}
		System.out.println(-1);
	} // 메인 끝
}
