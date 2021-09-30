package swea;

/**
 * 2021.09.30 목
 * BFS + PriorityQueue 사용
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_SWEA_1249_보급로_D4_130ms {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N, map[][];
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			String s;
			for (int i = 0; i < N; i++) {
				s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			int result = dijkstra(0, 0);
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
	
	private static int dijkstra(int startR, int startC) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];
		
		// 최소값이 갱신되도록 큰 값으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
				
			}
		}
		
		PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(new Comparator<int[]>() { 
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];  // 나는 비용을 3번째에 넣을거라, 2번 인덱스를 가져온거고 작은값을 앞으로 꺼내오기 위해 o1-o2 한거임.
			}
		});
		
		minTime[startR][startC] = 0;
		pQueue.offer(new int[] {startR, startC, minTime[startR][startC]});
		
		int r = 0, c = 0, minCost = 0, nr, nc;
		while(true) {
			
			// step1 
			int[] cur = pQueue.poll();
			r = cur[0];
			c = cur[1];
			minCost = cur[2];
			
			if(visited[r][c]) continue; 
			
			visited[r][c] = true;
			if(r == N-1 && c == N-1) {
				return minCost;
			}
			
			for (int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && minTime[nr][nc] > minCost + map[nr][nc]) {
					minTime[nr][nc] = minCost + map[nr][nc];
					pQueue.offer(new int[] {nr,nc,minTime[nr][nc]});
				}
			}
		} // while 끝
	} // dijkstra 끝
}
