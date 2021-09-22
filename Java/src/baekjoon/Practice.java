package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = new String[100];
		for (int i = 0; i < 100; i++) {
			str[i] = String.valueOf(i);
		}

		str[98] = "KBS2";
		str[99] = "KBS1";
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		
		System.out.println(("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111144444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444411111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111144444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444".length()));
		
	}
}