package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1405_미친로봇_골드5_140ms {
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int N;
	static double[] percent;
	static double ans = 0;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		percent = new double[4]; // 동서남북
		for (int i = 0; i < 4; i++) {
			percent[i] = Double.parseDouble(stk.nextToken()) * 0.01;
		}
		
		visited = new boolean[30][30];
		visited[15][15] = true;
		DFS(15, 15, 0, 1); // 좌표, 좌표, cnt, per
		System.out.println(ans);
		
	} //메인 끝
	private static void DFS(int r, int c, int cnt, double result) {
		if (cnt == N) {
			ans += result;
			System.out.printf("r = %d, c = %d, cnt = %d, ans = %f\n",r , c, cnt ,ans);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (!visited[nr][nc]) {
				visited[nr][nc] = true;
				DFS(nr, nc, cnt+1, result*percent[i]);
				visited[nr][nc] = false;
			}
		}
	}
}
