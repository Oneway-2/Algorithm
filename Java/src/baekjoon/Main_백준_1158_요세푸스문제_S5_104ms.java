package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1158 요세푸스 문제 
 * Difficulty: 실버 5 
 * 실행시간: 104ms / 2초 
 * 메모리: 12,316 kb 
 * 코드길이: 868
 * 2021.08.10 화 WS
 */
public class Main_백준_1158_요세푸스문제_S5_104ms {
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder("<");
		
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		
		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}
		
		int index = 0;
		
		while(!arr.isEmpty()) {
			index = (index + K - 1) % arr.size();
			sb.append(arr.remove(index)).append(", ");
		}
		sb.replace(sb.length() - 2, sb.length(), ">");
		System.out.println(sb);
	}
}
