package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간제한 8초
 * 2021.08.11 수 WS
 *
 */
public class Solution_SWEA_5215_햄버거다이어트_D3_168ms {
	private static int[] cal;
	private static int[] score;
	private static int cal_limit;
	private static int N;
	private static int bestScore;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			
			stk = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(stk.nextToken());
			cal_limit = Integer.parseInt(stk.nextToken());
			
			score = new int[N];
			cal = new int[N];
			
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				score[i] = Integer.parseInt(stk.nextToken());
				cal[i] = Integer.parseInt(stk.nextToken());
			}
			bestScore = 0;
			Combination(0, 0, 0);
			
			sb.append("#").append(testCase).append(" ").append(bestScore).append("\n");
		} // end of testCase
		
		System.out.println(sb);
	} // end of Main
	
	private static void Combination(int cnt, int calSum, int scoreSum) {
		
		if(calSum > cal_limit) {
			return;
		}
		if (cnt == N) {
			bestScore = Math.max(bestScore, scoreSum);
			return;
		}
		
		Combination(cnt + 1, calSum + cal[cnt], scoreSum + score[cnt]);
		Combination(cnt + 1, calSum, scoreSum);
	} // end of Combination
} // end of class
