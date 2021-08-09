package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA 9229 한빈이와 Spot Mart
 * Difficulty: D3
 * 실행시간: 153ms / 2초
 * 메모리: 23,520kb
 * 코드 길이: 1,908
 * 2021.08.09 월 HW
 */

public class Solution_SWEA_9229_한빈이와SpotMart_D3 {
	static int[] numbers = new int[2];
	static int sum, closestSum, limit;
	static int min;
	static boolean exitFlag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			sum = 0;
			closestSum = -1;
			min = Integer.MAX_VALUE;
			exitFlag = false;
			stk = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(stk.nextToken()); // 과자 개수
			int M = Integer.parseInt(stk.nextToken()); // 들고갈 수 있는 최대 무게
			int[] weight = new int[N];  // 과자들의 무게
			stk = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < weight.length; i++) {
				weight[i] = Integer.parseInt(stk.nextToken());
			}
			
			limit = M;			
			Combination(0, 0, weight);
			sb.append("#").append(testCase).append(" ").append(closestSum).append("\n");
			
		} // end of testCase
		System.out.println(sb);
	} // end of main
	
	private static void Combination(int cnt, int start, int[] input) {
		if(cnt == 2) { // 2개만 뽑을거다
			sum = numbers[0] + numbers[1];
			int diff = limit - sum;

			if (diff == 0) { // 즉시 탈출임.
				closestSum = sum;
				exitFlag = true;
				return;				
			}
			else if (diff > 0) { // 차이가 1보다 더 난다면 가장 차이가 적은녀석을 가려낸다.
				if (min > diff) {
					min = diff;
					closestSum = sum;
				}
			} 
			return; 
		}
		
		for (int i = start; i < input.length; i++) {
			if (exitFlag) {
				return;
			}
			numbers[cnt] = input[i];
			Combination(cnt + 1, i + 1, input);
		}
		
	}
	
} // end of class
