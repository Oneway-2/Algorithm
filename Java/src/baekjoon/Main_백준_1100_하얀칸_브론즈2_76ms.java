package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1100_하얀칸_브론즈2_76ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			String s = br.readLine();
			if (i % 2 == 0) { // 홀수칸이 하양
				for (int j = 0; j < 8; j+=2) {
					if (s.charAt(j) == 'F') {
						cnt++;
					}
				}
			}
			else { // 짝수칸이 하양
				for (int j = 1; j < 8; j+=2) {
					if(s.charAt(j) == 'F') {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	} // 메인 끝
}
