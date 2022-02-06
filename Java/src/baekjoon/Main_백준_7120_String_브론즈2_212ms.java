package baekjoon;

import java.util.Scanner;

public class Main_백준_7120_String_브론즈2_212ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = sc.next();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			if (i == 0) {
				sb.append(a);
			}
			else if (a == s.charAt(i-1)) {
				continue;
			}
			else if (a != s.charAt(i-1)) {
				sb.append(a);
			}
		}
		System.out.println(sb);
	} // 메인 끝
}
