package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14503_로봇청소기_골드5_88ms {
	private static int[] dr = {-1,0,1,0};
	private static int[] dc = {0,1,0,-1};
	private static int R, C, cnt;
	private static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		map = new int[R][C];
		stk = new StringTokenizer(br.readLine());
		int startr = Integer.parseInt(stk.nextToken());
		int startc = Integer.parseInt(stk.nextToken());
		int startd = Integer.parseInt(stk.nextToken());
		for (int i = 0; i < R; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		clean(startr, startc, startd);
		System.out.println(cnt);
	} // 메인 끝
	
	private static void clean(int r, int c, int dir) {
		if (map[r][c] == 0) {
			map[r][c] = 2;
			cnt++;
		}
		boolean flag = false;
		int odir = dir;
		for (int i = 0; i < 4; i++) {
			int ndir = (dir+3) % 4;
			int nr = r + dr[ndir];
			int nc = c + dc[ndir];
			// 청소가 이미 되어있거나 벽이면 더 회전.
			if (map[nr][nc] == 0) {
				clean(nr, nc, ndir);
				flag = true;
				break; // dfs 할 거 아니니까 이동했으면 break.
			}
			dir = (dir+3) % 4;
		}
		
		// flag가 flase 라는건 4방향 중 한 군데도 갈 수 있는 곳이 없었다는 얘기.
		if (!flag) {
			int backdir = (dir+2) % 4;
			int br = r + dr[backdir];
			int bc = c + dc[backdir];
			if (map[br][bc] != 1) {
				clean(br, bc, odir);
			}
			// 뒤로 갈랬더니 벽이면 동작을 멈춤.
			else {
				return;
			}
		}
	}
}
