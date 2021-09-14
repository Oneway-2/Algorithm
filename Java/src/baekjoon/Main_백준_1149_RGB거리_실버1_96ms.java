package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1149_RGB거리_실버1_96ms {
	static int R = 0;
	static int G = 1;
	static int B = 2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine()," ");
			cost[i][R] = Integer.parseInt(stk.nextToken());
			cost[i][G] = Integer.parseInt(stk.nextToken());
			cost[i][B] = Integer.parseInt(stk.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			cost[i][R] += Math.min(cost[i-1][G], cost[i-1][B]);
			cost[i][G] += Math.min(cost[i-1][R], cost[i-1][B]);
			cost[i][B] += Math.min(cost[i-1][R], cost[i-1][G]);
		}
		
		System.out.println(Math.min(Math.min(cost[N-1][R], cost[N-1][G]), cost[N-1][B]));
	} // 메인 끝
}
