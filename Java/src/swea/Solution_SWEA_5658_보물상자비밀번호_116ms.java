package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_SWEA_5658_보물상자비밀번호_116ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int TC = Integer.parseInt(br.readLine());
		LinkedList<String> l = new LinkedList<String>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int testCase = 1; testCase <= TC; testCase++) {
			l.clear();
			a.clear();
			stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken()); // 4의 배수 8~28
			int K = Integer.parseInt(stk.nextToken()); 
			String pw = br.readLine();
			int turnTime = N / 4;
			
			for (int j = 0; j < turnTime; j++) {
				for (int i = 0; i < 4; i++) {
					String z = pw.substring(i*turnTime, (i+1)*turnTime);
					if (!l.contains(z)) l.add(z);
				}
				String t = pw.substring(0,1);
				pw = pw.concat(t).substring(1);
			}
			
			for (int i = 0; i < l.size(); i++) {
				int t = Integer.parseInt(l.get(i), 16);
				a.add(t);
			}
			
			Collections.sort(a, Collections.reverseOrder());
			System.out.printf("#%d %d\n", testCase, a.get(K-1));
			
		} // 테케 끝
	} // 메인 끝
}
