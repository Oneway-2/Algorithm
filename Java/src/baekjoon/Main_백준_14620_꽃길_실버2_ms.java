package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14620_꽃길_실버2_ms {
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static int N, minCost;
	private static boolean[][] board;
	private static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		board = new boolean[N][N];
		minCost = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		plant(0, 1, 1); // cnt, r, c
		System.out.println(minCost);
		
		
	} // 메인 끝
	private static void plant(int cnt, int r, int c) {
		if (cnt == 3) {
			int cost = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j]) {
						cost += map[i][j];
					}
				}
			}
			minCost = Math.min(cost, minCost);
			System.out.printf("정산중 cost = %d, minCost = %d\n", cost, minCost);
			return;
		}
		
		if (c >= N-1) {
			if (r >= N-1) {
				// 끝까지 다해봤으니 종료
				System.out.println("종료");
				return;
			}
			else {
				plant(cnt, r+1, 1);
			}
		}
		System.out.printf("cnt = %d, r = %d, c = %d\n", cnt, r, c);
		
		boolean ok = true;
		// 밖으로 나가거나, 어느 하나라도 이미 차있으면 그냥 패스
		if (0>r || r>=N || 0>c || c>=N || board[r][c] || board[r+1][c] || board[r-1][c] || board[r][c+1] || board[r][c-1]) { 
			System.out.println("패스함");
			plant(cnt, r, c+1);
		}
		// 모두 비어있으면 거기에 심고 다음으로 ㄱ
		else {
			System.out.println("심었음");
			board[r][c] = true;
			board[r+1][c] = true;
			board[r-1][c] = true;
			board[r][c+1] = true;
			board[r][c-1] = true;
			plant(cnt+1, r, c+1);
			board[r][c] = false;
			board[r+1][c] = false;
			board[r-1][c] = false;
			board[r][c+1] = false;
			board[r][c-1] = false;
		}
	}
}	
