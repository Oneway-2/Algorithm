package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1953_탈주범검거_123ms {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	// 1 상하좌우
	// 2 상하
	// 3 좌우
	// 4 상우
	// 5 하우
	// 6 하좌
	// 7 상좌
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= TC; testCase++) {
			stk = new StringTokenizer(br.readLine().trim()," ");
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			int R = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			int L = Integer.parseInt(stk.nextToken());
			
			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			int cnt = 0;
			Queue<int[]> q = new LinkedList<int[]>();
			boolean[][] visited = new boolean[N][M];
			q.offer(new int[] {R,C,1});
			visited[R][C] = true;

			while(q.size() > 0) {
				cnt++;
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int step = cur[2];
				
				if(step >= L) {
					continue;
				}
				
				if(map[r][c] == 1) { // 1번 터널은 상하좌우
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc]) {
							int next = map[nr][nc];
							if(i == 0 && (next==1 || next==2 || next==5 || next==6)) { //상
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
							else if(i == 1 && (next==1 || next==2 || next==4 || next==7)) { //하
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
							else if(i == 2 && (next==1 || next==3 || next==4 || next==5)) { //좌
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
							else if(i == 3 && (next==1 || next==3 || next==6 || next==7)) { //우
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
						}
					}
				}
				else if(map[r][c] == 2) { // 2번 터널은 상하
					for (int i = 0; i < 2; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc]) {
							int next = map[nr][nc];
							if(i == 0 && (next==1 || next==2 || next==5 || next==6)) { //상
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
							else if(i == 1 && (next==1 || next==2 || next==4 || next==7)) { //하
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
						}
					}
				}
				else if(map[r][c] == 3) { // 3번 터널은 좌우
					for (int i = 2; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc]) {
							int next = map[nr][nc];
							if(i == 2 && (next==1 || next==3 || next==4 || next==5)) { //좌
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
							else if(i == 3 && (next==1 || next==3 || next==6 || next==7)) { //우
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
						}
					}
				}
				else if(map[r][c] == 4) { // 4번 터널은 상우
					for (int i = 0; i < 4; i+=3) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc]) {
							int next = map[nr][nc];
							if(i == 0 && (next==1 || next==2 || next==5 || next==6)) { //상
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
							else if(i == 3 && (next==1 || next==3 || next==6 || next==7)) { //우
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
						}
					}
				} 
				else if(map[r][c] == 5) { // 5번 터널은 하우
					for (int i = 1; i < 4; i+=2) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc]) {
							int next = map[nr][nc];
							if(i == 1 && (next==1 || next==2 || next==4 || next==7)) { //하
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
							else if(i == 3 && (next==1 || next==3 || next==6 || next==7)) { //우
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
						}
					}
				}
				else if(map[r][c] == 6) { // 6번 터널은 하좌
					for (int i = 1; i < 3; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc]) {
							int next = map[nr][nc];
							if(i == 1 && (next==1 || next==2 || next==4 || next==7)) { //하
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
							else if(i == 2 && (next==1 || next==3 || next==4 || next==5)) { //좌
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
						}
					}
				}
				else if(map[r][c] == 7) { // 7번 터널은 상좌
					for (int i = 0; i < 4; i+=2) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc]) {
							int next = map[nr][nc];
							if(i == 0 && (next==1 || next==2 || next==5 || next==6)) { //상
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
							else if(i == 2 && (next==1 || next==3 || next==4 || next==5)) { //좌
								q.offer(new int[] {nr, nc, step+1});
								visited[nr][nc] = true;
							}
						}
					}
				}
			} // while 끝
			sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
}

