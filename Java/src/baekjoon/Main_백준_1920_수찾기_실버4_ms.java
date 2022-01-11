package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1920_수찾기_실버4_ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] find = new int[M];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(stk.nextToken());
		}
		
		// arr 정렬
		Arrays.sort(arr);
		for (int i = 0; i < M; i++) {
			int t = find[i];
			int idx = (N-1)/2;
			int pm = idx/2;
			boolean flag = false;
			while(true) {
				if (t > arr[idx]) {
					idx += pm;
				}
				else {
					idx -= pm;
				}
				if (t == arr[idx]) {
					sb.append(1).append("\n");
					break;
				}
				else {
					pm /= 2;
					if (pm < 2 && !flag) {
						pm = 1;
						flag = true;
					}
					else if (pm < 2 && flag){
						sb.append(0).append("\n");
						break;
					}
				}
			}
		} // for 끝
		System.out.println(sb);
	} // 메인 끝
}
