package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_백준_1316_그룹단어체커_실버5_80ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = N;
		ArrayList<Character> arr = new ArrayList<Character>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			arr.clear();
			for (int j = 1; j <= s.length(); j++) {
				if (arr.contains(s.charAt(j-1))) {
					cnt--;
					break;
				}
				else {
					if (j == s.length()) {
						arr.add(s.charAt(j-1));
					}
					else {
						if (s.charAt(j-1) != s.charAt(j)) {
							arr.add(s.charAt(j-1));
						}
					}
				}
			}
		}
		System.out.println(cnt);
	} // 메인 끝
}
