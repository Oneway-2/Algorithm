package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15700_타일채우기4_브론즈4_128ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		Long a = Long.parseLong(stk.nextToken());
		Long b = Long.parseLong(stk.nextToken());
		Long result = a * b / 2;
		System.out.println(result);
	} // 메인 끝
}
