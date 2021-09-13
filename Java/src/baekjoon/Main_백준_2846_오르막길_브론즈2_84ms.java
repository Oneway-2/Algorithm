package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2846_오르막길_브론즈2_84ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000
		int[] hill = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < hill.length; i++) {
			hill[i] = Integer.parseInt(stk.nextToken());
		}
		boolean up = true;
		int lowPoint = hill[0], highPoint = 0, diff = 0;
		for (int i = 0; i < hill.length - 1; i++) {
			if (hill[i] < hill[i+1]) {
				highPoint = hill[i+1];
			} else { // 평지나 내리막 만남
				diff = (highPoint - lowPoint) > diff ? (highPoint - lowPoint) : diff;
				lowPoint = hill[i+1];
				highPoint = hill[i+1];
			}
		}
		diff = (highPoint - lowPoint) > diff ? (highPoint - lowPoint) : diff;
		System.out.println(diff);
	} // 메인 끝
}
