package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10709_기상캐스터_실버5_248ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		char[][] map = new char[R][C];
		int[][] result = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j); 
			}
		}
		for (int r = 0; r < R; r++) {
			int put = -1;
			for (int c = 0; c < C; c++) {
				if (map[r][c] == '.' && put == -1) {
					result[r][c] = put;
				}
				else if(map[r][c] == '.' && put != -1) {
					put++;
					result[r][c] = put;
				}
				else if(map[r][c] == 'c') {
					put = 0;
					result[r][c] = put;
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	} // 메인 끝
}
