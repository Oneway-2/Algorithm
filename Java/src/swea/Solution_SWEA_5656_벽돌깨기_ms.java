package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2021.10.05 화 WS
 */
public class Solution_SWEA_5656_벽돌깨기_ms {
	
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1}; // 상하좌우
	private static int[] ball;
	private static int[][] map;
	private static int N, W, H;
	public static void main(String[] args) throws IOException {
		// 완탐
		// 중복순열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer stk = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(stk.nextToken());
			W = Integer.parseInt(stk.nextToken());
			H = Integer.parseInt(stk.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < W; j++, index+=2) {
					map[i][j] = s.charAt(index) - '0';
				}
			}
			
			ball = new int[N];
			comb(0, 0);
			
			
			
			
			
		} // 테케 끝
		System.out.println(sb);
		
	} // 메인 끝

	private static void comb(int cnt, int start) {
		if (cnt == N) {
			System.out.println(Arrays.toString(ball));
			for (int i = 0; i < ball.length; i++) {
				drop(ball[i]);
			}
			return;
		}
		 
		for (int i = start; i <= W-1; i++) {
			ball[cnt] = i;
			comb(cnt+1, i);
		}
	}

	private static void drop(int c) {
		for (int r = 0; r < H; r++) {
			if(map[r][c] != 0) { // 공이 떨어지다 벽을 만났다.
				boom(r, c);
				return;
			}
		}
	}

	private static void boom(int r, int c) {
		
		
	}
}

