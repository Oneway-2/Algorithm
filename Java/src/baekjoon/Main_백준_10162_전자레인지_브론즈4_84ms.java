package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_10162_전자레인지_브론즈4_84ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		if(T % 10 != 0) {
			System.out.println(-1);
		}
		else {
			int a = T / 300;
			int b = T % 300 / 60;
			int c = T % 60 / 10;
			System.out.println(a + " " + b + " " + c);
		} 
	} // 메인 끝
}

// 5분은 600초가 아니라 300초란다 ^^ 하..