package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1264_모음의개수_브론즈2_76ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		char a;
		int cnt;
		while(true) {
			cnt = 0;
			s = br.readLine();
			if(s.equals("#")) break;
			for (int i = 0; i < s.length(); i++) {
				a = s.charAt(i);
				if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u' || a=='A' || a=='E' || a=='I' || a=='O' || a=='U') cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	} // 메인 끝
}
