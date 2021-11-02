package baekjoon;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_백준_5014_스타트링크_골드5_172ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(stk.nextToken()); // 꼭대기층
		int S = Integer.parseInt(stk.nextToken()); // 내가있는 층
		int G = Integer.parseInt(stk.nextToken()); // 가야할 층
		int U = Integer.parseInt(stk.nextToken()); 
		int D = Integer.parseInt(stk.nextToken());
		boolean[] visited = new boolean[F+1];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {S, 0}); // y, button pushed
		visited[S] = true;
		int btn = -1;
		while(q.size() > 0) {
			int y = q.peek()[0];
			int push = q.poll()[1];
			if(y == G) {
				btn = push;
				break;
			}
			int ny = y + U;
			if (1<=ny && ny<=F && !visited[ny]) {
				q.offer(new int[] {ny, push+1});
				visited[ny] = true;
			}
			ny = y - D;
			if (1<=ny && ny<=F && !visited[ny]) {
				q.offer(new int[] {ny, push+1});
				visited[ny] = true;
			}
		}
		if (btn == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(btn);
		}
	} // 메인 끝
}
