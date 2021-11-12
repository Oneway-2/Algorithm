package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크_실버3_304ms {
	private static int N, hn, gap;
	private static boolean[] divideTeam;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		gap = Integer.MAX_VALUE;
		hn = N/2;
		divideTeam = new boolean[N+1];
		comb(0, 1);
		System.out.println(gap);
	} // 메인 긑

	private static void comb(int cnt, int start) {
		if(cnt == hn) {
			int sumTeam1 = 0, sumTeam2 = 0;
			for (int i = 1; i < N; i++) {
				for (int j = i+1; j <= N; j++) {
					if (divideTeam[i] && divideTeam[j]) {
						sumTeam1 += (map[i][j] + map[j][i]);
					} 
					else if (!divideTeam[i] && !divideTeam[j]) {
						sumTeam2 += (map[i][j] + map[j][i]);
					}
				}
			}
			int dif = Math.abs(sumTeam1 - sumTeam2); 
			if(dif == 0) {
				System.out.println(dif);
				System.exit(0);
			}
			gap = Math.min(dif, gap);
			return;
		}
		for (int i = start; i <= N; i++) {
			divideTeam[i] = true;
			comb(cnt+1, i+1);
			divideTeam[i] = false;
		}
	}
}
