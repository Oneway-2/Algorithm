package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_2005_파스칼의삼각형_D2_101ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 1<=N<=10
			int[][] map = new int[N][N];
			
			// 왼쪽 가장자리는 무조건 1
			for (int i = 0; i < map.length; i++) {
				map[i][0] = 1;
			}
			
			sb.append("#").append(testCase).append("\n").append(map[0][0]).append("\n");
			for (int i = 1; i < map.length; i++) {
				sb.append(1).append(" ");
				for (int j = 1; j <= i; j++) {
					map[i][j] = map[i-1][j-1] + map[i-1][j];
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
}
