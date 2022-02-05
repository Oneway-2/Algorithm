package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2583_영역구하기_실버1_144ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		int[][] map = new int[R][C];
		for (int i = 0; i < K; i++) {
			stk = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(stk.nextToken());
			int y1 = Integer.parseInt(stk.nextToken()); // 왼쪽위
			int x2 = Integer.parseInt(stk.nextToken());
			int y2 = Integer.parseInt(stk.nextToken()); // 오른아래

			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					map[j][k] = 1;
				}
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		boolean[][] visited = new boolean[R][C];
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Queue<int[]> q = new LinkedList<int[]>();
		int pieces = 0, getArea = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					pieces++;
					getArea = 1;
					q.offer(new int[] { i, j });
					visited[i][j] = true;
					while (q.size() > 0) {
						int r = q.peek()[0];
						int c = q.poll()[1];
						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if (0 > nr || nr >= R || 0 > nc || nc >= C || visited[nr][nc] || map[nr][nc] == 1) {
								continue;
							}
							getArea++;
							q.offer(new int[] { nr, nc });
							visited[nr][nc] = true;
						}
					}
					arr.add(getArea);
				}
			}
		}
		System.out.println(pieces);
		Collections.sort(arr);
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
	} // 메인 끝
}
