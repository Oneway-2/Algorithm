package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_1864_문어숫자_브론즈3_72ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		char c;
		StringBuilder sb = new StringBuilder();
		int[] text = new int[8];
		while(true) {
			Arrays.fill(text, 0);
			s = br.readLine();
			if (s.equals("#")) break;
			for (int i = s.length()-1, j = 0 ; i >= 0; i--, j++) {
				c = s.charAt(i);
				if(c=='-') text[j]=0;
				else if(c=='-') text[j]=0;
				else if(c=='\\') text[j]=1;
				else if(c=='(') text[j]=2;
				else if(c=='@') text[j]=3;
				else if(c=='?') text[j]=4;
				else if(c=='>') text[j]=5;
				else if(c=='&') text[j]=6;
				else if(c=='%') text[j]=7;
				else if(c=='/') text[j]=-1;
			}
			int val = 0;
			for (int i = 0; i < text.length; i++) {
				val += text[i]*Math.pow(8, i);
			}
			sb.append(val).append("\n");
		}
		System.out.println(sb);
	} // 메인 끝
}
