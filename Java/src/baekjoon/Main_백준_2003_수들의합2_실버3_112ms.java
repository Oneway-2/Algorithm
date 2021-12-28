package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2003_수들의합2_실버3_112ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int[] arr = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		int sum = 0, a = 0, b = 0, cnt = 0;
		while(true) {
			if (sum >= M) {
				sum -= arr[a++];
			}
			else if (b == N) {
				break;
			}
			else sum += arr[b++];
			if (sum == M){
				cnt++;
			}
		}
		System.out.println(cnt);
	} // 메인 끝
}
