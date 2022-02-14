package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1037_약수_실버5_ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(stk.nextToken());
			max = Math.max(val, max);
			min = Math.min(val, min);
		}
		System.out.println(max * min);
	}
}
