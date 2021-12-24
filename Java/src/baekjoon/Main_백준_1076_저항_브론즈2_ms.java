package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1076_저항_브론즈2_ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = new String[3];
		long[] n = new long[3];
		s[0] = br.readLine();
		s[1] = br.readLine();
		s[2] = br.readLine();
		long result;
		for (int i = 0; i < 3; i++) {
			if (s[i].equals("black") ) {
				if (i == 2) n[i] = 1;
				else n[i] = 0;
			}
			else if (s[i].equals("brown")) {
				if (i == 2) n[i] = 10;
				else n[i] = 1;
			}
			else if (s[i].equals("red")) {
				if (i == 2) n[i] = 100;
				else n[i] = 2;
			}
			else if (s[i].equals("orange")) {
				if (i == 2) n[i] = 1_000;
				else n[i] = 3;
			}
			else if (s[i].equals("yellow")) {
				if (i == 2) n[i] = 10_000;
				else n[i] = 4;
			}
			else if (s[i].equals("green")) {
				if (i == 2) n[i] = 100_000;
				else n[i] = 5;
			}
			else if (s[i].equals("blue")) {
				if (i == 2) n[i] = 1_000_000;
				else n[i] = 6;
			}
			else if (s[i].equals("violet")) {
				if (i == 2) n[i] = 10_000_000;
				else n[i] = 7;
			}
			else if (s[i].equals("grey")) {
				if (i == 2) n[i] = 100_000_000;
				else n[i] = 8;
			}
			else if (s[i].equals("white")) {
				if (i == 2) n[i] = 1_000_000_000;
				else n[i] = 9;
			}
		}
		result = (n[0] * 10 + n[1]) * n[2];
		System.out.println(result);
	} // 메인 끝
}
