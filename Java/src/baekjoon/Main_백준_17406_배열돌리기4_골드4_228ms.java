package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17406_배열돌리기4_골드4_228ms {
	private static int N,M,K, result;
	private static int[][] map, spinTurn;
	private static int[] order;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		map = new int[N][M];
		visited = new boolean[K];
		order = new int[K];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		spinTurn = new int[K][3];
		for (int i = 0; i < K; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				spinTurn[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		result = Integer.MAX_VALUE;
		perm(0);
		System.out.println(result);
	} // 메인 끝

	private static void perm(int cnt) {
		// 모든 순서를 다 뽑아보자.
		if (cnt == K) {
			play();
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (visited[i]) {
				continue;
			}
			order[cnt] = i;
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	private static void play() {
	 // 뽑힌 순서를 갖다가 회전 돌려보자.
		int[][] tmap = new int[N][M];
		for (int i = 0; i < N; i++) {
			tmap[i] = Arrays.copyOf(map[i], M);
		}
		
		for (int i = 0; i < K; i++) {
			int n = order[i];
			int r = spinTurn[n][0] - 1;
			int c = spinTurn[n][1] - 1;
			int s = spinTurn[n][2];
			for (int j = 1; j <= s; j++) {
				int save = tmap[r-j][c-j]; 
				// 왼변
				for (int k = r-j; k < r+j ; k++) {
					tmap[k][c-j] = tmap[k+1][c-j];
				}
				// 아랫변
				for (int k = c-j; k < c+j; k++) {
					tmap[r+j][k] = tmap[r+j][k+1];
				}
				// 오른변
				for (int k = r+j; k > r-j; k--) {
					tmap[k][c+j] = tmap[k-1][c+j];
				}
				// 윗변
				for (int k = c+j; k > c-j; k--) {
					tmap[r-j][k] = tmap[r-j][k-1];
				}
				tmap[r-j][c-j+1] = save;
			}
		}
		
		// 최솟값 갱신해보자.
		int sum;
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < M; j++) {
				sum += tmap[i][j];
			}
			result = Math.min(result, sum);
		}
	}
}
