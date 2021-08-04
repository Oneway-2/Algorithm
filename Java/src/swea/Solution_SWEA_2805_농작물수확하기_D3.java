package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * SWEA 2805 농작물 수확하기
 * Difficulty: D3
 * 실행시간: 111ms / 2초
 * 메모리: 19,768kb
 * 2021.08.04 수 WS
 */
public class Solution_SWEA_2805_농작물수확하기_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for (int j = 0; j < map.length; j++) { 
				String str = br.readLine();
				for (int k = 0; k < map.length; k++) {
					map[j][k] = str.charAt(k) - '0';
				}
			}
			
			int mid = N/2;
			int sum = 0;
			int exp = 0;
			for (int h = 0; h < N; h++) {
				sum += map[h][mid];
				if(h != 0 && h <= mid) {
					exp = h;
					for (int j = 1; j <= exp; j++) {
						sum += map[h][mid+j];
						sum += map[h][mid-j];
					}
				}
				else if (h > mid) {
					exp = -h+(N-1);
					for (int k = 1; k <= exp; k++) {
						sum += map[h][mid+k];
						sum += map[h][mid-k];
					}
				}
			}
			sb.append("#").append(i).append(" ").append(sum).append("\n");
		} // end of testCase
		System.out.print(sb);
	} // end of main
} // end of class



/*

#1 23
#2 1190
#3 946
#4 112
#5 1886
#6 3000
#7 1032
#8 1330
#9 939
#10 2960
#11 547
#12 3016
#13 1712
#14 2049
#15 1294
#16 354
#17 1634
#18 1901
#19 2518
#20 1750
#21 2144
#22 940
#23 0
#24 1712
#25 1685
#26 559
#27 874
#28 75
#29 139
#30 3
#31 13
#32 331
#33 2646
#34 1531
#35 156
#36 1663
#37 934
#38 1725
#39 107
#40 2291
#41 84
#42 590
#43 31
#44 1351
#45 1364
#46 1187
#47 1059
#48 1771
#49 1228
#50 2065


*/