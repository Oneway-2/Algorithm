package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2606_바이러스_실버3_80ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[n+1][n+1];
		boolean[] visited = new boolean[n+1];
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			map[a][b] = map[b][a] = true;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		visited[1] = true;
		int cnt = 0;
		while(q.size() > 0) {
			int s = q.poll();
			for (int i = 0; i < map[s].length; i++) {
				if (map[s][i] && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
	System.out.println(cnt);
	} // 메인 끝
}
