package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10163_색종이_브론즈1_256ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int N = Integer.parseInt(br.readLine());  // 색종이 수 1<=n<=100
		int x, y, a, b;
		int[][] paper = new int[1001][1001];
		int[] paperCnt = new int[N+1];
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(stk.nextToken());
			y = Integer.parseInt(stk.nextToken());
			a = Integer.parseInt(stk.nextToken());
			b = Integer.parseInt(stk.nextToken());
			for (int R = x; R <= x+a-1; R++) {
				for (int C = y; C <= y+b-1; C++) {
						paper[R][C] = i;
					}
				}
			}
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				paperCnt[paper[i][j]]++;
			}
		}
		for (int i = 1; i < paperCnt.length; i++) {
			sb.append(paperCnt[i]).append("\n");
		}
		System.out.println(sb);
	} // 메인 끝
}
