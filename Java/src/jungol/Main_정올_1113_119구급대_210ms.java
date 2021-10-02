package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_1113_119구급대_210ms {
	public static void main(String[] args) throws IOException {
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
		int[][] map = new int[M][N];
		boolean[][] visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
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
			visited[r][c] = true;
			
			if(r == desM && c == desN) {
				if(minCnt > cnt) minCnt = cnt;
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(0<=nr && nr<M && 0<=nc && nc<N && map[nr][nc] != 0 && !visited[nr][nc]) {
					map[r][c] = cnt;
					if (dir == i) {
						q.offer(new int[] {nr, nc, i, cnt});
					}
					else if(cnt + 1 < minCnt) {
						q.offer(new int[] {nr, nc, i, cnt + 1});
					}
				}
			}
		} // while 긑
		System.out.println(minCnt);
	} // 메인 끝
}

