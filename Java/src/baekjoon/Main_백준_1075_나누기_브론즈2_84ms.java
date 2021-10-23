package baekjoon;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_백준_1075_나누기_브론즈2_84ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int f = Integer.parseInt(br.readLine());
		int a = n % 100;
		int startn = n-a;
		for (int i = 0; i < 100; i++) {
			n = startn + i;
			if (n%f == 0) {
				break;
			}
		}
		String result = String.valueOf(n);
		result = result.substring(result.length()-2, result.length());
		System.out.println(result);
	}
}
