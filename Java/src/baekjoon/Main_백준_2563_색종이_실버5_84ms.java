package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2563 색종이
 * Difficulty: 실버5
 * 실행시간: 84ms / 1초
 * 메모리: 11,608kb
 * 2021.08.10 화 HW
 */

public class Main_백준_2563_색종이_실버5_84ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int[][] paper = new int[100][100];
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			
			
			for (int j = y; j < y + 10; j++) {
				for (int k = x; k < x + 10; k++) {
					if(paper[j][k] != 1) {
						paper[j][k] = 1;
						cnt++;
					}
				}
			}			
		}
		System.out.println(cnt);
	}
}
