package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_6721_BackwardNumbers_브론즈2_136ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String[] text = s.split(" ");
			String a = text[0];
			String b = text[1];
			String a1 = "";
			String b1 = "";
			for (int j = a.length()-1; j >= 0; j--) {
				a1 = a1.concat(Character.toString(a.charAt(j)));
			}
			for (int j = b.length()-1; j >= 0; j--) {
				b1 = b1.concat(Character.toString(b.charAt(j)));
			}
			int a2 = Integer.parseInt(a1);
			int b2 = Integer.parseInt(b1);
			int c = a2 + b2;
			String c1 = String.valueOf(c);
			String c2 = "";
			for (int j = c1.length()-1; j >= 0; j--) {
				c2 = c2.concat(Character.toString(c1.charAt(j)));
			}
			int c3 = Integer.parseInt(c2);
			sb.append(c3).append("\n");
		}
		System.out.println(sb);
	} //메인 끝
}
