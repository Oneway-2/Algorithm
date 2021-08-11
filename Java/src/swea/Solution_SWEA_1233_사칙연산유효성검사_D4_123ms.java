package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA 1233 사칙연산 유효성 검사
 * Difficulty: D4
 * 실행시간: 123ms / 20초
 * 메모리: 20,980kb
 */
public class Solution_SWEA_1233_사칙연산유효성검사_D4_123ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int valid = 1;
			
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				int stkLen = stk.countTokens();
				String[] arr = new String[stkLen];
				for (int j = 0; j < stkLen; j++) {
					arr[j] = stk.nextToken();					
				}
				
				if (stkLen == 4) { // 길이가 4라는거는 가지를 쳤다는거임.
					if (arr[1].contains("-") || arr[1].contains("+") || arr[1].contains("/") || arr[1].contains("*")) {
						
					} else {
						valid = 0;
//						break;
					}
					
				}else { // 길이가 4가 아니라는건 가지를 치지 않은 녀석들.
					
					if (arr[1].contains("-") || arr[1].contains("+") || arr[1].contains("/") || arr[1].contains("*")) {
						valid = 0;
//						break;
					} else {
						
					}
				}
			}
			System.out.println("#"+testCase+" "+valid);
		}
	}
}


/*
 
#1 0
#2 0
#3 0
#4 1
#5 0
#6 1
#7 1
#8 0
#9 0
#10 0

*/
