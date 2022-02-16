package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2010_플러그_브론즈3_272ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int total = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			total += (n - 1);
		}
		System.out.println(total + 1);
	} // 메인 끝
}	
