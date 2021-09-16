package swea;

/**
 * 2021.09.16 목 WS
 * 플로이드 와샬
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_SWEA_1263_사람네트워크2_D6_1457ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		int[][] d;
		int N, result;
		for (int testCase = 1; testCase <= TC; testCase++) {
			result = Integer.MAX_VALUE;
			stk = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(stk.nextToken());
			d = new int[N][N];
			
			// Floyd Warshall 사용
			// 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					d[i][j] = Integer.parseInt(stk.nextToken());
					if (d[i][j]==0 && i!=j) {
						d[i][j] = 100000000;
					}
				}
			}
			
			// k = 거쳐가는 노드
			for (int k = 0; k < d.length; k++) {
				// i = 출발 노드
				for (int i = 0; i < d.length; i++) {
					// j = 도착 노드
					for (int j = 0; j < d.length; j++) {
						d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
						// if문으로 비교했을때보다 Math.min을 쓰는게 2배 빠름. ㄷㄷ
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				int temp = 0;
				for (int j = 0; j < N; j++) {
					temp += d[i][j];
				}
				result = Math.min(temp, result);
			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
}

/*
#1 2
#2 3
#3 25
#4 37
#5 16
#6 11
#7 21
#8 20
#9 715
#10 1449
*/