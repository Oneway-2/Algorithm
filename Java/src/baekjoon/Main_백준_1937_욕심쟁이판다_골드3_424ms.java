package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1937_욕심쟁이판다_골드3_424ms {
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1}; // 상하좌우
	private static int map[][], memo[][], maxVal=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		map = new int[n+2][n+2];
		memo = new int[n+2][n+2];
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], -1);
		}
		for (int i = 1; i <= n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				maxVal = Math.max(maxVal, dfs(i, j)); // r, c, step
			}
		}
		System.out.println(maxVal);
	} // 메인 끝
	private static int dfs(int r, int c) {
		if (memo[r][c] != 0) {
			return memo[r][c];
		}
		memo[r][c] = 1;
		int nr, nc;
		for (int k = 0; k < 4; k++) {
			nr = r + dr[k];
			nc = c + dc[k];
			if (map[nr][nc] > map[r][c]) {
				memo[r][c] = Math.max(memo[r][c], dfs(nr,nc) + 1);
				dfs(nr,nc);
			}
		}
		return memo[r][c];
	}
}	
