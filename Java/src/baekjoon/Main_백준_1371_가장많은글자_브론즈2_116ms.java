package baekjoon;

import java.util.Scanner;

public class Main_백준_1371_가장많은글자_브론즈2_116ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int[26]; // a~z, 공백, 엔터 아 공백,엔터는 안세나본데
		String s = " ";
		while(sc.hasNextLine()) {
			s = sc.nextLine();
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == ' ') continue;
				else cnt[((int)s.charAt(i) - 'a')]++;
			}
		}
		int max = 0;
		for (int i = 0; i < cnt.length; i++) {
			max = cnt[i] > max ? cnt[i] : max;
		}
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] == max) {
				System.out.print((char)(i + 'a'));
			}
		}
	} // 메인 끝
}	
