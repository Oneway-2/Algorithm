package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2602_돌다리건너기_골드4_ms {
	private static int limit, len, total = 0;
	private static char srr[], arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		limit = s.length();
		srr = new char[limit];
		for (int i = 0; i < limit; i++) {
			srr[i] = s.charAt(i);
		}
		String a1 = br.readLine();
		String a2 = br.readLine();
		len = a1.length();
		arr = new char[2][len];
		for (int i = 0; i < len; i++) {
			arr[0][i] = a1.charAt(i);
		}
		for (int i = 0; i < len; i++) {
			arr[1][i] = a2.charAt(i);
		}
		
		count(1, 0, 0);
		
		
	
		
		
	} // 메인 끝

	private static void count(int asdf, int idx, int sidx) {
		// idx 가 len 을 넘어가면 return
		if (idx >= len) {
			return;
		}
		
		int rdx = (asdf == 0) ? 1 : 0;
		
		
		for (int i = idx; i < len; i++) {
			if (arr[rdx][idx] == srr[sidx]) {
				
			}
			
		}
			
		
		
		
	}
}
