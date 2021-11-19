package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1032_명령프롬프트_브론즈1_84ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = new String[N];
		for (int i = 0; i < N; i++) {
			s[i] = br.readLine();
		}
		char[] c = new char[s[0].length()];
		for (int i = 0; i < s[0].length(); i++) {
			char test = s[0].charAt(i);
			boolean flag = true;
			for (int j = 1; j < N; j++) {
				if(s[j].charAt(i) != test) {
					flag = false;
				}
			}
			if(flag) {
				c[i] = test;
			} else {
				c[i] = '?';
			}
		}
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
	} // 메인 끝
}
