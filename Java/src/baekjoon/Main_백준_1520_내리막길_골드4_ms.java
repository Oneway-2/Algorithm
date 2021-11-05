package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1520_내리막길_골드4_ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		int[][] map = new int[R+2][C+2];
		for (int i = 1; i <= R; i++) {
			Arrays.fill(map[i], 99999);
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		Arrays.fill(map[0], 99999);
		Arrays.fill(map[R+1], 99999);
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.printf("%6d", map[i][j]);
			}
			System.out.println();
		}
		
		
		
		
	} // 메인 끝
}
