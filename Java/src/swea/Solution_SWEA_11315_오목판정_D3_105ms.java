package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_11315_오목판정_D3_105ms {
	static int[] dr = {0, 1, 1, 1};
	static int[] dc = {1, 1, 0,-1};
	//                   → ↘ ↓ ↙
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		char[][] map;
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			String input;
			for (int i = 0; i < N; i++) {
				input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			// 탐색 시작
			boolean found = false;
ex:			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					// o 을 찾으면 → ↘ ↓ ↙ 탐색 ㄱㄱ
					// 다 탐색하기 전에 5개를 찾으면 바로 나가면 댐.
					if (map[i][j] == 'o') {
						for (int k = 0; k < 4; k++) { // → ↘ ↓ ↙
							int count = 1;
							for (int h = 1; h <= 5; h++) {
								int r = i+dr[k]*h;
								int c = j+dc[k]*h;
								if (r>=N || c>=N || r<0 || c<0 || map[r][c] == '.') { // 5개 채우기 전에 벽을 만나거나 . 을 만나면 땡
									break;
								} else {
									count++;
								}
							}
							if (count == 5) {
								found = true;
								break ex;
							}
						}
					}
				}
			}
			if (found) sb.append("#").append(testCase).append(" ").append("YES").append("\n");
			else sb.append("#").append(testCase).append(" ").append("NO").append("\n");
		} // 테케 끝
		System.out.println(sb);
	}
}

/*

#1 YES
#2 YES
#3 YES
#4 NO
*/