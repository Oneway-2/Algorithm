package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_18301_Rats_브론즈5_124ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		double n1 = Double.parseDouble(stk.nextToken());
		double n2 = Double.parseDouble(stk.nextToken());
		double n12 = Double.parseDouble(stk.nextToken());
		int result = (int)Math.floor(((n1+1)*(n2+1))/(n12+1) -1);
		System.out.println(result);
	} // 메인 끝
}
