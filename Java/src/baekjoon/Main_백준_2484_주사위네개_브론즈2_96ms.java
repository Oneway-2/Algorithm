package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2484_주사위네개_브론즈2_96ms {
	static int max1, max2, max22, max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int N = Integer.parseInt(br.readLine()); // 1<=N<=1000
		int reward = 0, maximum = 0;
		int[] n = new int[7];
		int select = 0;
		for (int i = 0; i < N; i++) {
			Arrays.fill(n, 0);
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				n[Integer.parseInt(stk.nextToken())]++;
			}
			select = Select(n);
			if (select == 1) {
				reward = 50000 + max*5000;
			}
			else if(select == 2) {
				reward = 10000 + max*1000;
			}
			else if(select == 3) {
				reward = 2000 + max2*500 + max22*500;
			}
			else if(select == 4) {
				reward = 1000 + max*100;
			}
			else if(select == 5) {
				reward = max1*100;
			}
//			System.out.println(reward);
			maximum = reward > maximum ? reward : maximum;
		}
		System.out.println(maximum);
	} // 메인 끝

	private static int Select(int[] n) {
		int cnt1 = 0, cnt2 = 0, maxIdx = 0;
		max = 0;
		max1 = 0;
		max2 = 0;
		max22 = 0;
		for (int i = 0; i < n.length; i++) {
			if(n[i] > maxIdx) {
				maxIdx = n[i];
				max = i;
			}
			if(n[i] == 1) {
				cnt1++;
				max1 = i;
			}
			if(n[i] == 2) {
				if(cnt2 == 0) max2 = i;
				else if(cnt2 == 1) max22 = i;
				cnt2++;
			}
		}
//		System.out.printf("maxIdx = %d, cnt1 = %d, cnt2 = %d, max = %d, max1 = %d, max2 = %d, max22 = %d\n", maxIdx, cnt1, cnt2, max, max1, max2, max22);
		if(maxIdx == 4) return 1;
		else if(maxIdx == 3) return 2;
		else if(maxIdx == 2 && cnt2 == 2) return 3;
		else if(maxIdx == 2 && cnt2 == 1) return 4;
		else if(maxIdx == 1 && cnt1 == 4) return 5;
		return 0;
	}
}
