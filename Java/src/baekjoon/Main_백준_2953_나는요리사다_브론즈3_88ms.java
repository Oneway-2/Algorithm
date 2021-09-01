package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2953_나는요리사다_브론즈3_88ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int[] score = new int[5];
		int bestScore = 0, bestCook = 0;
		for (int i = 0; i < score.length; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				score[i] += Integer.parseInt(stk.nextToken());
			}
			if(score[i] > bestScore) {
				bestScore = score[i];
				bestCook = i+1;
			}
		}
		System.out.println(bestCook+" "+bestScore);
	}
}
