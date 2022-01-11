package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1920_수찾기_실버4_496ms {
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
			int key = find[i];
			int start = 0;
			int end = N - 1;
			int mid;
			boolean flag = false;
			while (end - start >= 0) {
				mid = (start + end) / 2;
				if (arr[mid] == key) {
					sb.append(1).append("\n");
					flag = true;
					break;
				} else if (arr[mid] > key) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			if (!flag) {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	} // 메인 끝
}
