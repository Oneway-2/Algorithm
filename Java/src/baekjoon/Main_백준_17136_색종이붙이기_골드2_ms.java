package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17136_색종이붙이기_골드2_ms {
	private static int[] size = new int[6];
	private static int ans, total;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		dfs(0, 0, 0);
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
		
	} // 메인 끝

	private static void dfs(int c, int r, int cnt) {
		while(map[c][r] == 0) {
			if (++r >= 10) {
				if (++c >= 10) {
					ans = Math.min(ans, cnt);
					return;
				}
				r = 0;
			}
		}
		
		if (ans <= cnt) {
			return;
		}
		
		for (int i = 5; i > 0; i--) {
			if (c + i > 10 || r + i > 10 || size[i] == 5) {
				continue;
			}
			
			if (can_attach(c, r, i)) {
				update_paper(c, r, i, 0);
				++size[i];
				dfs(c, r, cnt+1);
				
				update_paper(c, r, i, 1);
				--size[i];
			}
		}
		
	}

	private static void update_paper(int c, int r, int size, int attached) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[c+i][r+j] = attached;
			}
		}
	}

	private static boolean can_attach(int c, int r, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[c+i][r+j] == 1) {
					return false;
				}
			}
		}
		return false;
	}
}
