package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16234_인구이동_골드5_668ms {
	public static void main(String[] args) throws IOException {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int L = Integer.parseInt(stk.nextToken());
		int R = Integer.parseInt(stk.nextToken());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		ArrayList<int[]> arr = new ArrayList<int[]>();
		Queue<int[]> q = new LinkedList<int[]>();
		int day = 0;
		while(true) {
			boolean moved = false;
			cleanVisited(visited);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j]) continue;
					arr.clear();
					q.offer(new int[] {i, j});
					arr.add(new int[] {i, j});
					visited[i][j] = true;
					int unionMember = 0;
					while(q.size() > 0) {
						int r = q.peek()[0];
						int c = q.poll()[1];
						unionMember += map[r][c];
						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if (0>nr || nr>=N || 0>nc || nc>=N) continue;
							int dif = Math.abs(map[r][c] - map[nr][nc]);
							if (L>dif || dif>R || visited[nr][nc]) continue;
							moved = true; // 연합이 생겨서 한번이라도 이동했음.
							q.offer(new int[] {nr, nc});
							arr.add(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
					} // while 끝
					unionMember = unionMember / arr.size();
					for (int k = 0; k < arr.size(); k++) {
						int r = arr.get(k)[0];
						int c = arr.get(k)[1];
						map[r][c] = unionMember;
					}
				}
			}
			if(!moved) {
				break;
			}
			day++;
		} // 가장 큰 while 끝
		System.out.println(day);
	} // 메인 끝

	private static void cleanVisited(boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], false);
		}
	}
}
