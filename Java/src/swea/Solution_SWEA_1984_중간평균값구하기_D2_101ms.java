package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1984_중간평균값구하기_D2_101ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int TC = Integer.parseInt(br.readLine());
		int min, max, input, result;
		double sum;
		for (int testCase = 1; testCase <= TC; testCase++) {
			sum = 0.;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			stk = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 10; i++) {
				input = Integer.parseInt(stk.nextToken()); 
				sum += input;
				min = input > min ? min : input;
				max = input < max ? max : input;
			}
			sum = sum - min - max;
			result = (int) Math.round(sum / 8);
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		} // 테케 끝
		System.out.println(sb);
	}
}
