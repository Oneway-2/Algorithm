package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_2667_단지번호붙이기_실버1_96ms {
	public static void main(String[] args) throws IOException {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1}; // 상하좌우
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int dangiCnt = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1' && !visited[i][j]) {
					dangiCnt++;
					int cnt = 0;
					Queue<int[]> q = new LinkedList<int[]>();
					q.offer(new int[] {i,j});
					visited[i][j] = true;
					while(q.size() > 0) {
						cnt++;
						int r = q.peek()[0];
						int c = q.poll()[1];
						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if (0>nr || nr>=N || 0>nc || nc>=N || visited[nr][nc] || map[nr][nc]=='0') {
								continue;
							}
							q.offer(new int[] {nr,nc});
							visited[nr][nc] = true;
						}
					} // while 끝
					arr.add(cnt);
				} // if 끝
			}
		}
		Collections.sort(arr);
		System.out.println(dangiCnt);
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	} // 메인 끝
}
