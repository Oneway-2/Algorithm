package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2775_부녀회장이될테야_브론즈2_76ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[15][14];
		for (int i = 0; i < map[i].length; i++) {
			map[0][i] = i+1;
		}
		for (int i = 0; i < map.length; i++) {
			map[i][0] = 1;
		}
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				map[i][j] = map[i-1][j] + map[i][j-1];
			}
		}
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int r = Integer.parseInt(br.readLine()); //층 
			int c = Integer.parseInt(br.readLine()); //호
			System.out.println(map[r][c-1]);
		}
	} // 메인 끝
}
