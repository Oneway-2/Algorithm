package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_Main_7569_토마토_실버1_ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(stk.nextToken());
		int R = Integer.parseInt(stk.nextToken());
		int H = Integer.parseInt(stk.nextToken());
		int[][][] map = new int[H][R][C];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < H; j++) {
				stk = new StringTokenizer(br.readLine());
				for (int k = 0; k < C; k++) {
					map[i][j][k] = Integer.parseInt(stk.nextToken());
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				for (int k = 0; k < map[i][j].length; k++) {
					System.out.print(map[i][j][k] + " ");
				}
				System.out.println();
			}
		}
		
		
		
	} // 메인 끝
}

