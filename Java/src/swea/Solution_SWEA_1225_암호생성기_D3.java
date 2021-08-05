package swea;
/**
 * SWEA 1225 암호생성기
 * Difficulty: D3 
 * 실행시간: 144ms / 20초 
 * 메모리: 25,492kb 
 * 코드길이: 1,159
 * 2021.08.05 목 WS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3 {
	
	public static void main(String[] args) throws IOException {
		Queue<Integer> qnums = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= 10; testCase++) {
			
			int TC = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 8; i++) {
				qnums.offer(Integer.parseInt(stk.nextToken()));
			}
			
			int temp = 0;
			int inc = 1;
			while(true) {
				temp = qnums.poll();
				temp -= inc;
				if (temp <= 0) {
					temp = 0;
					qnums.offer(temp);
					break;
				}else {
					qnums.offer(temp);
				}
				inc++;
				if (inc > 5) inc = 1;			
			}
			
			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(qnums.poll()).append(" ");
			}
			sb.append("\n");
			
		} // end of testCase
		System.out.print(sb);
	}
}

/*

#1 6 2 2 9 4 1 3 0 
#2 9 7 9 5 4 3 8 0 
#3 8 7 1 6 4 3 5 0 
#4 7 5 8 4 8 1 3 0 
#5 3 8 7 4 4 7 4 0 
#6 6 7 5 9 6 8 5 0 
#7 7 6 8 3 2 5 6 0 
#8 9 2 1 7 3 6 3 0 
#9 4 7 8 1 2 8 4 0 
#10 6 8 9 5 8 5 2 0 


*/

