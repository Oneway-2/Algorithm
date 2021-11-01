package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1697_숨바꼭질_실버1_120ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		boolean[] visited = new boolean[100001];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {N, 0}); // x, time
		visited[N] = true;
		while(q.size() > 0) {
			int x = q.peek()[0];
			int time = q.poll()[1];
			if (x == M) {
				System.out.println(time);
				break;
			}
			int nx = x*2;
			if(0<=nx && nx<100001 && !visited[nx]) {
				q.offer(new int[] {nx, time+1});
				visited[nx] = true;
			}
			nx = x-1;
			if(0<=nx && nx<100001 && !visited[nx]) {
				q.offer(new int[] {nx, time+1});
				visited[nx] = true;
			}
			nx = x+1;
			if(0<=nx && nx<100001 && !visited[nx]) {
				q.offer(new int[] {nx, time+1});
				visited[nx] = true;
			}
		}
	} // 메인 끝
}

