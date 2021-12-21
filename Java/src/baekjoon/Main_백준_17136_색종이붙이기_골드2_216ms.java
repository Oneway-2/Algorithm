package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17136_색종이붙이기_골드2_216ms {
	private static int[] size = {0,5,5,5,5,5};
	private static int[][] map;
	private static int ans = Integer.MAX_VALUE;

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
		
		dfs(0, 0, 0);
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
		
	} // 메인 끝

	private static void dfs(int x, int y, int cnt) {
		if (x >= 9 && y > 9) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		// ans보다 cnt가 커지면 더이상 최소가 아닌값임.
		if (ans <= cnt) {
			return;
		}
		
		if (y > 9) {
			dfs(x+1, 0, cnt);
			return;
		}
		
		if (map[x][y] == 1) {
			for (int i = 5; i >= 1; i--) {
				if (size[i] > 0 && isAttach(x, y, i)) {
					attach(x, y, i, 0);
					size[i]--;
					dfs(x, y+1, cnt+1);
					
					// 다시 떼는과정
					attach(x, y, i, 1);
					size[i]++;
				}
			}
		}
		else {
			dfs(x, y+1, cnt);
		}
		
	}

	private static void attach(int x, int y, int size, int attach) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = attach;
			}
		}
	}

	private static boolean isAttach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}
				
				if (map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
}
