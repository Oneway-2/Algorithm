package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3307_최장증가부분수열_D3_129ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		int[] arr, LIS;
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			LIS = new int[N];
			stk = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			int size = 0;
			for (int i = 0; i < N; i++) {
				int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i])) - 1;
				LIS[temp] = arr[i];
				
				if(temp == size) ++size;
			}
			sb.append("#").append(testCase).append(" ").append(size).append("\n");
		}
		System.out.println(sb);
	} // 메인 끝
}
