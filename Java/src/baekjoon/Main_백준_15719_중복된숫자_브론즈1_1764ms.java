package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15719_중복된숫자_브론즈1_1764ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		boolean[] arr = new boolean[N];
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(stk.nextToken());
			if(arr[a]) {
				System.out.println(a);
				break;
			}
			else {
				arr[a] = true;
			}
		}
	} // 메인 끝
}
