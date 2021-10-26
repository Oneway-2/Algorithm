package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2178_미로탐색_실버1_100ms {
	public static void main(String[] args) throws IOException {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		char[][] map = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0,0,1});
		visited[0][0] = true;
		while(q.size() > 0) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			int step = q.poll()[2];
			if (r == N-1 && c == M-1) {
				System.out.println(step);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0>nr || nr>=N || 0>nc || nc>=M || visited[nr][nc] || map[nr][nc] == '0') {
					continue;
				}
				q.offer(new int[] {nr,nc,step+1});
				visited[nr][nc] = true;
			}
		} // while 끝
	} // 메인 끝
}

