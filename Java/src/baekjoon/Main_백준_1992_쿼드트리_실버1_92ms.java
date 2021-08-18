package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 제한시간: 2초
 * 실행시간: 92ms
 */
public class Main_백준_1992_쿼드트리_실버1_92ms {
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int[] dr = new int[] {0, 0, 1, 1};
	static int[] dc = new int[] {0, 1, 0 ,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());  // 1,2,4,8,16,32,64 중 하나임.
		
		map = new int[N][N];
		
		String s;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int sr = 0;
		int sc = 0;
		Checking(sr, sc, N);
		System.out.println(sb);
	}
	
	private static void Checking(int r, int c, int n) {
		if (canZip(r, c, n)) {
			sb.append(map[r][c]);
			return;
		}
		
		sb.append("(");
		
		Checking(r, c, n/2);
		Checking(r, c + n/2, n/2);
		Checking(r + n/2, c, n/2);
		Checking(r + n/2, c + n/2, n/2);
		
		sb.append(")");
	}
	
	private static boolean canZip(int r, int c, int n) {
		int val = map[r][c];
		
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(val != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
