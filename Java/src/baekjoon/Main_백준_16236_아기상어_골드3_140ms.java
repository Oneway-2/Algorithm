package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_16236_아기상어_골드3_140ms {
	private static int[] dr = { -1, 0, 0, 1 };
	private static int[] dc = { 0, -1, 1, 0 }; // 상,좌,우,하

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int N = Integer.parseInt(br.readLine());
		int size = 2, eatAmount = 0, time = 0;
		int[] position = new int[3];
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if (map[i][j] == 9) {
					position = new int[] {i, j};
					map[i][j] = 0;
				}
			}
		}

		while (true) {
			PriorityQueue<int[]> qq = new PriorityQueue<>((o1, o2) ->
            o1[2] != o2[2] ? Integer.compare(o1[2], o2[2])
            :(o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
        );
			
			boolean[][] visited = new boolean[N][N];
			
			qq.add(new int[] {position[0], position[1], 0});
			visited[position[0]][position[1]] = true;
			
			boolean check = false;
			while(qq.size() > 0) {
				position = qq.poll();
				int r = position[0];
				int c = position[1];
				int dist = position[2];
				
				if (map[r][c] != 0 && map[r][c] < size) {
					map[r][c] = 0;
					eatAmount++;
					time += dist;
					check = true;
					break;
				}
				
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if (nr >= N || nr < 0 || nc >= N || nc < 0 || visited[nr][nc] || map[nr][nc] > size) {
						continue;
					}
					qq.add(new int[] {nr, nc, dist+1});
					visited[nr][nc] = true;
				}
			}
			if (!check) {
				break;
			}
			if (size == eatAmount) {
				size++;
				eatAmount = 0;
			}
		}
		System.out.println(time);
	} // 메인 끝
}
