package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_1259_팰린드롬수_브론즈1_80ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<Character>();
		int len;
		String str;
o:		while(true) {
			str = br.readLine();
			s.clear();
			len = str.length();
			if (str.equals("0")) {
				break; 
			}
			if (len == 1) {
				sb.append("yes\n");
			}
			else if (len % 2 != 0) { // 홀수면
				for (int i = 0; i < len/2; i++) { // 0 1 2 3 4
					s.add(str.charAt(i));
				}
				for (int i = len/2+1; i < len; i++) {
					if(str.charAt(i) != s.pop()) {
						sb.append("no\n");
						continue o;
					}
				}
				sb.append("yes\n");
			} 
			else { // 짝수면
				for (int i = 0; i < len/2; i++) {
					s.add(str.charAt(i));
				}
				for (int i = len/2; i < len; i++) {
					if(str.charAt(i) != s.pop()) {
						sb.append("no\n");
						continue o;
					}
				}
				sb.append("yes\n");
			}
		}
		System.out.println(sb);
	} // 메인 끝
}
