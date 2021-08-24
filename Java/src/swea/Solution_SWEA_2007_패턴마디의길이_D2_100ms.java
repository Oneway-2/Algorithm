package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_2007_패턴마디의길이_D2_100ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			String str = br.readLine(); // 무조건 30글자가 입력됨
			
			// 1글자부터 10글자까지 문자를 자른다. 자른 문자가 가장 마지막까지 반복된다면 그게 패턴이고, 반복문 다 탈출 
			boolean exit = false;
			for (int i = 1; i <= 10; i++) { // 최대 패턴 문자열은 10글자임.
				if(exit) break;
				String testStr = str.substring(0, i); // 비교할 문자열
				for (int j = 1; j < 30/i; j++) { // 몇 글자를 비교하냐에 따라 반복문 횟수 달라짐
					if(!testStr.equals(str.substring(i*j, i*j+i))) break;
					sb.append("#").append(testCase).append(" ").append(i).append("\n");
					exit = true;
					break;
				}
			}
		} // 테케 끝
		System.out.println(sb);
	}
}
