package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1004_어린왕자_실버3_168ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			int in = 0;
			int out = 0;
			stk = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(stk.nextToken());
			int y1 = Integer.parseInt(stk.nextToken());
			int x2 = Integer.parseInt(stk.nextToken());
			int y2 = Integer.parseInt(stk.nextToken());
			int N = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; j++) {
				stk = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				int r = Integer.parseInt(stk.nextToken());
				if ((x-x1)*(x-x1) + (y-y1)*(y-y1) < r*r) {
					if (((x-x2)*(x-x2) + (y-y2)*(y-y2)) > r*r) {
						out++;
					}
				}
				if ((x-x1)*(x-x1) + (y-y1)*(y-y1) > r*r) {
					if (((x-x2)*(x-x2) + (y-y2)*(y-y2)) < r*r) {
						in++;
					}
				}
			}
			System.out.println(out+in);
		}
	} // 메인 끝
}
