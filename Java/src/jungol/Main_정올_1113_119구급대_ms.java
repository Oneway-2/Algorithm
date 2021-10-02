package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2021.10.01 금 WS
 */

public class Main_정올_1113_119구급대_ms {
	public static void main(String[] args) throws IOException {
//		int[] dr = {-1,1,0,0};
//		int[] dc = {0,0,-1,1}; // 상하좌우
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1}; // 상우하좌
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(stk.nextToken());
		int N = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine(), " ");
		int desM = Integer.parseInt(stk.nextToken());
		int desN = Integer.parseInt(stk.nextToken());
		int minCnt = Integer.MAX_VALUE;
		boolean[][] map = new boolean[M][N];
		boolean[][] visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				if(Integer.parseInt(stk.nextToken()) == 1) map[i][j] = true;
			}
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
//		처음 시작이 0,0좌표에서 시작하는데 (상) 부터 탐색하므로 무조건 cnt이 1증가하고 시작됨. 그래서 -1로 시작.
		q.offer(new int[] {0,0,0,-1}); // r, c, dir, cnt 
		visited[0][0] = true;
		while(q.size() > 0) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			int dir = q.peek()[2];
			int cnt = q.poll()[3];
			if(r == desM && c == desN) {
				if(minCnt > cnt) minCnt = cnt;
				visited[r][c] = false;
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(0<=nr && nr<M && 0<=nc && nc<N && map[nr][nc] && !visited[nr][nc]) {
					if (dir != i) {
						q.offer(new int[] {nr, nc, i, cnt+1});
						visited[nr][nc] = true;
					}
					else {
						q.offer(new int[] {nr, nc, i, cnt});
						visited[nr][nc] = true;
					}
				}
			}
		} // while 긑
		System.out.println(minCnt);
		
	} // 메인 끝
}

