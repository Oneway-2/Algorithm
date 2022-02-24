package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2638_치즈_골드4_ms {
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static int[][] map;
	private static int N, M, time, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		time = 0;
		cnt = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(map[i][j] == 1) cnt++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		
		fillAir();
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		while(cnt <= 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
				}
			}
		}
		
		
		
		
		
		
	} // 메인 끝
	private static void fillAir() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		q.offer(new int[] {0,0});
		while(q.size() > 0) {
			int r = q.peek()[0];
			int c = q.poll()[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0>nr || nr>=N || 0>nc || nc>=M || map[nr][nc] != 0) {
					continue;
				}
				map[nr][nc] = 2;
				q.offer(new int[] {nr,nc});
			}
			
		}
		
	}
}
