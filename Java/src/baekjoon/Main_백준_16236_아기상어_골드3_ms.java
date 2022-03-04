package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16236_아기상어_골드3_ms {
	private static int[] dr = {-1,0,0,1};
	private static int[] dc = {0,-1,1,0}; // 상,좌,우,하
//	private static int[] dr = {-1,1,0,0};
//	private static int[] dc = {0,0,-1,1}; // 상,좌,우,하
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int N = Integer.parseInt(br.readLine());
		int startr = 0, startc = 0;
		int size = 2, eatAmount = 0, time = 0;
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if (map[i][j] == 9) {
					startr = i;
					startc = j;
					map[i][j] = 0;
				}
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) ->
			o1[2] != o2[2] ? Integer.compare(o1[2], o2[2])
				:(o1[0] != o2[0] ? Integer.compare(o1[0],  o2[0]) : Integer.compare(o1[1], o2[1])));
		boolean[][] visited = new boolean[N][N];
		
		
		q.add(new int[] {startr, startc, 1}); // r, c, distance
		visited[startr][startc] = true;
		
		while(q.size() > 0) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			int dist = q.poll()[2];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0>nr || nr>=N || 0>nc || nc>=N || visited[nr][nc] || map[nr][nc]>size) {
					continue;
				}
				System.out.printf("현재 %d, %d, 걸음수: %d, 사이즈: %d 먹은양: %d\n",nr, nc, dist, size, eatAmount);
				// 가장 가까운거리, 먹을 수 있는 물고기가 있으면.
				if (map[nr][nc] != 0 && map[nr][nc] < size) {
					time += dist;
					System.out.printf("%d 거리인 %d, %d 에서 %d 사이즈를 잡아먹었다. 토탈거리 %d, 현재사이즈 %d\n", dist, nr, nc, map[nr][nc], time, size);
					eatAmount++;
					// 먹은 양이 사이즈만큼이면 사이즈 +1
					if (eatAmount >= size) {
						size++;
						eatAmount = 0;
						System.out.printf("%d로 사이즈업\n", size);
					}
					map[nr][nc] = 0;
					q.clear();
					for (int j = 0; j < N; j++) {
						Arrays.fill(visited[j], false);
					}
					q.add(new int[] {nr, nc, 1});
					visited[nr][nc] = true;
					break;
				}
				else if (map[nr][nc] == size || map[nr][nc] == 0){
					q.add(new int[] {nr, nc, dist+1});
					visited[nr][nc] = true;
				}
			}
		}
		System.out.println(time);
		
		
	} // 메인 끝
}
