package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_7568_덩치_실버5_156ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][2];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			int rank = 1;
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (map[i][0] < map[j][0] && map[i][1] < map[j][1]) {
					rank++;
				}
			}
			System.out.print(rank + " ");
		}
	} // 메인 끝
}
