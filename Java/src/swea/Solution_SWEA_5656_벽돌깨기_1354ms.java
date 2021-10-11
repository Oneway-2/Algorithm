package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2021.10.05 화 WS
 */
public class Solution_SWEA_5656_벽돌깨기_1354ms {
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1}; // 상하좌우
	private static int[] ball;
	private static int[][] map, mapCopy;
	private static int N, W, H, min;
	public static void main(String[] args) throws IOException {
		// 완탐
		// 중복순열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			min = Integer.MAX_VALUE;
			StringTokenizer stk = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(stk.nextToken());
			W = Integer.parseInt(stk.nextToken());
			H = Integer.parseInt(stk.nextToken());
			map = new int[H][W];
			mapCopy = new int[H][W];
			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < W; j++, index+=2) {
					map[i][j] = s.charAt(index) - '0';
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					mapCopy[i][j] = map[i][j];
				}
			}
			
			ball = new int[N];
			comb(0);
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
			
		} // 테케 끝
		System.out.println(sb);
		
	} // 메인 끝

	private static void comb(int cnt) {
		if (cnt == N) {
			drop(ball);
			// count
			int c = 0; 
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != 0) {
						c++;
					}
				}
			}
			// min renewal
			if (min > c) min = c;
			// map reconstruct
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = mapCopy[i][j];
				}
			}
			return;
		}
		 
		for (int i = 0; i <= W-1; i++) {
			ball[cnt] = i;
			comb(cnt+1);
		}
	}

	private static void drop(int[] ball) {
		for (int i = 0; i < ball.length; i++) {
			int c = ball[i];
			for (int r = 0; r < H; r++) {
				if(map[r][c] != 0) { // 공이 떨어지다 벽을 만났다.
					boom(r, c);
					break;
				}
			}
		}
	}

	private static void boom(int rr, int cc) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[H][W];
		ArrayList<int[]> arr = new ArrayList<int[]>();
		q.offer(new int[] {rr, cc});
		visited[rr][cc] = true;
		arr.add(new int[] {rr,cc});
		
		while(q.size() > 0) {
			int r = q.peek()[0];
			int c = q.poll()[1];
			int range = map[r][c];
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < range; j++) {
					int nr = r + dr[i]*j;
					int nc = c + dc[i]*j;
					if (0<=nr && nr<H && 0<=nc && nc<W && !visited[nr][nc] && map[nr][nc]!=0) {
						q.offer(new int[] {nr,nc});
						arr.add(new int[] {nr,nc});
						visited[nr][nc] = true;
					}
				}
			}
		} // while 끝
		
		// 0으로 변환
		for (int i = 0; i < arr.size(); i++) {
			int r = arr.get(i)[0];
			int c = arr.get(i)[1];
			map[r][c] = 0;
		}
		// 남은 블록 아래로 당기기
		for (int i = 0; i < W; i++) {
			for (int j = H-1; j >= 0; j--) {
				if(map[j][i] == 0) {
					int idx = j;
					for (int k = j-1; k >= 0; k--) {
						if (map[k][i] != 0) {
							map[idx][i] = map[k][i];
							map[k][i] = 0;
							break;
						}
					}
				}
			}
		}
	} // boom 끝
}

