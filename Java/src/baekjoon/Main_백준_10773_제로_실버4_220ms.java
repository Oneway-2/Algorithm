package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_10773_제로_실버4_220ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				s.pop();
			} else {
				s.add(num);
			}
		}
		int result = 0;
		while(!s.isEmpty()) {
			result += s.pop();
		}
		System.out.println(result);
	} // 메인 끝
}
