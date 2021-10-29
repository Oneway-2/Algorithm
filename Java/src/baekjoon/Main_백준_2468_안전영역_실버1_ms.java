package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2468_안전영역_실버1_ms {
	public static void main(String[] args) throws IOException {
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
		
		for (int i = 1; i < highest; i++) {
			// 일단 가라앉히기
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (map[r][c] == i) {
						map[r][c] = 0;
					}
				}
			}
			// 섬 몇개인지 세기
			for (int r = 0; r < r; r++) {
				for (int c 	= 0; c < r; c++) {
					if (map[r][c] != 0) {
						Queue<int[]> q = new LinkedList<int[]>();
						q.offer(new int[] {r,c});
						visited[r][c] = true;
					}
				}
			}
			
		}
		
		
		
	} // 메인 끝
}
