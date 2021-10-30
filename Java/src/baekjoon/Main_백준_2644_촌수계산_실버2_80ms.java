package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2644_촌수계산_실버2_80ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 
		boolean[][] map = new boolean[n+1][n+1];
		boolean[] visited = new boolean[n+1];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(stk.nextToken());
		int y = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			map[a][b] = map[b][a] = true;
		}
		
		int result = -1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x, 0});
		visited[x] = true;
		while(q.size() > 0) {
			int asdf = q.peek()[0];
			int step = q.poll()[1];
//			System.out.printf("%d와 %d의 촌수는 %d\n",x,asdf,step);
			if (asdf == y) {
				result = step;
				break;
			}
			for (int i = 1; i <= n; i++) {
				if (map[asdf][i] && !visited[i]) {
					q.offer(new int[] {i, step+1});
					visited[i] = true;
				}
			}
		} // while 끝
		System.out.println(result);
	} // 메인 끝
}
