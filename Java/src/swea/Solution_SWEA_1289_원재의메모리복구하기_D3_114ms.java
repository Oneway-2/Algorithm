package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1289_원재의메모리복구하기_D3_114ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {
			String str = br.readLine();

			int count = 0;
			if (str.charAt(0) == '1') {
				count += 1;
			}
			for (int i = 0; i < str.length() - 1; i++) {
				if (str.charAt(i) != str.charAt(i + 1)) {
					count += 1;
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(count).append("\n");
		} // 테케 끝
		System.out.println(sb);
	} // end of main
} 
