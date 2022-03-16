package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14620_꽃길_실버2_184ms {
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static int N, minCost;
	private static boolean[][] board;
	private static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		board = new boolean[N][N];
		minCost = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		plant(0, 0); // cnt, sum
		System.out.println(minCost);
	} // 메인 끝
	private static void plant(int cnt, int cost) {
		if (cnt == 3) {
			minCost = Math.min(cost, minCost);
			return;
		}
		else {
			for (int r = 1; r < N-1; r++) {
				for (int c = 1; c < N-1; c++) {
					if (!board[r][c] && check(r,c)) {
						int hap = map[r][c];
						board[r][c] = true;
						for (int i = 0; i < 4; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];
							board[nr][nc] = true;
							hap += map[nr][nc];
						}
						plant(cnt+1, cost + hap);
						board[r][c] = false;
						for (int i = 0; i < 4; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];
							board[nr][nc] = false;
						}
					}
					
				}
			}
		}
	}
	private static boolean check(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (board[nr][nc]) {
				return false;
			}
		}
		return true;
	}
}	
