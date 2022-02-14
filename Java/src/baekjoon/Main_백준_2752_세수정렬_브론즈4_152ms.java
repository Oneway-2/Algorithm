package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2752_세수정렬_브론즈4_152ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] map = new int[3];
		for (int i = 0; i < 3; i++) {
			map[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(map);
		for (int i = 0; i < 3; i++) {
			System.out.print(map[i] + " ");
		}
	} // 메인 끝
}
