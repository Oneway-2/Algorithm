package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 2001 파리 퇴치
 * Difficulty: D2
 * 실행시간: 102ms / 30초
 * 메모리: 18,620kb
 * 코드길이: 1,264
 * 2021.08.04 수 HW
 */
public class Solution_SWEA_2001_파리퇴치_D2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			int[][] map = new int[N][N];
			int max = 0;
			int movement = N-M;
			for (int i = 0; i < map.length; i++) {
				StringTokenizer stk2 = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(stk2.nextToken());
				}
			}
			
			for (int i = 0; i <= movement; i++) {
				for (int j = 0; j <= movement; j++) {
					int sum = 0;
					for (int ii = i; ii < M+i; ii++) {
						for (int jj = j; jj < M+j; jj++) {
							sum+=map[ii][jj];
						}
					}
					if (sum > max) {
						max = sum;
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}
}

/*

#1 49
#2 159
#3 428
#4 620
#5 479
#6 941
#7 171
#8 968
#9 209
#10 1242


*/