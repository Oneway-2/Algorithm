package swea;

import java.io.BufferedReader;
/**
 * 제한시간: 2초
 * 2021.08.20 WS
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4_867ms {
	static int N, totalCnt;
	static int[] input, numbers;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			isSelected = new boolean[N];
			totalCnt = 0;

			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(stk.nextToken());
			}
			
			numbers = new int[N];
			
			permutation(0);
			sb.append("#").append(testCase).append(" ").append(totalCnt).append("\n");

		} // 테케 끝
		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if (cnt == N) {
			Subset(0, 0, 0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;

			numbers[cnt] = input[i]; 
			isSelected[i] = true; 
		
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
	
	private static void Subset(int cnt, int left, int right) {
		
		if(cnt == N) {
			totalCnt++;
			return;
		}
		
		Subset(cnt+1, left+numbers[cnt], right);
		
		if(left >= right + numbers[cnt]) {
			Subset(cnt+1, left, right+numbers[cnt]);
		}
	}
}

/*
#1 15
#2 17
#3 35583723
*/
