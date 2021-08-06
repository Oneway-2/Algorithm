package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA 3499 퍼펙트셔플
 * Difficulty: D3 
 * 실행시간: 127ms / 2초 
 * 메모리: 22,628kb 
 * 코드길이: 1,483
 * 2021.08.06 금 WS
 */
public class Solution_SWEA_3499_퍼펙트셔플_D3 {
	private static String[] cA;
	private static String[] cB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int NHalf = N/2;
			stk = new StringTokenizer(br.readLine()," ");
			String[] cC = new String[N];
			
			if (N % 2 == 0) { // 짝수면
				cA = new String[NHalf];
				cB = new String[NHalf];
				for (int i = 0; i < NHalf; i++) {
					cA[i] = stk.nextToken();
				}
				for (int i = 0; i < NHalf; i++) {
					cB[i] = stk.nextToken();
				}
				
			}
			else if (N % 2 != 0) { // 홀수면 
				cA = new String[N/2 + 1];
				cB = new String[N/2];
				for (int i = 0; i < NHalf + 1; i++) {
					cA[i] = stk.nextToken();
				}
				for (int i = 0; i < NHalf; i++) {
					cB[i] = stk.nextToken();
				}
			}
			
			for (int i = 0; i < N; i++) {
				if(i % 2 == 0) cC[i] = cA[i/2];
				else cC[i] = cB[i/2];
			}
			sb.append("#").append(testCase);
			for (int i = 0; i < cC.length; i++) {
				sb.append(" ").append(cC[i]);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
