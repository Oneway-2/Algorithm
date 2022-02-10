package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_4949_균형잡힌세상_실버4_236ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			boolean YESorNO = true;
			String text = br.readLine();
			if (text.equals(".")) {
				break;
			}
			int textlen = text.length();
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < textlen; i++) {
				if (text.charAt(i) == '(') {
					stack.push('(');
				}
				else if (text.charAt(i) == '[') {
					stack.push('[');
				}
				else if (text.charAt(i) == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}
					else {
						YESorNO = false;
						break;
					}
				}
				else if (text.charAt(i) == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					}
					else {
						YESorNO = false;
						break;
					}
				}
			}
			if (stack.isEmpty() && YESorNO) {
				sb.append("yes\n");			
			}
			else {
				sb.append("no\n");
			}
		}
		System.out.println(sb);
	} // 메인 끝
}
