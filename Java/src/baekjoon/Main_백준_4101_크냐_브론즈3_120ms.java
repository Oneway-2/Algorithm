package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_4101_크냐_브론즈3_120ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		while(true) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			if (a==0 && b==0) {
				break;
			}
			if (a > b) {
				sb.append("Yes\n");
			}
			else {
				sb.append("No\n");
			}
		}
		System.out.println(sb);
	} // 메인 끝
}	
