package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_9012_괄호_실버4_84ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < N; i++) {
			boolean good = true;
			st.clear();
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(') {
					st.add(s.charAt(j));
				} else if (s.charAt(j) == ')') {
					if (st.isEmpty()) {
						good = false;
						break;
					} else {
						st.pop();
					}
				}
			}
			if (st.isEmpty() && good) {
				sb.append("YES\n");
			} else { 
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	} // 메인 끝
}
