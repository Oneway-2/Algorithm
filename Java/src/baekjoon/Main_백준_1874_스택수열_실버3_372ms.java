package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_1874_스택수열_실버3_372ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int max = 1;
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			int target = Integer.parseInt(br.readLine());
			while(max <= target) {
				sb.append("+\n");
				stack.push(max++);
				flag = true;
			}
			while(!stack.isEmpty() && stack.peek() >= target) {
				sb.append("-\n");
				stack.pop();
				flag = true;
			}
			if (!flag) {
				sb = new StringBuilder("NO");
				break;
			}
		}
		System.out.println(sb);
	} // 메인 끝
}
