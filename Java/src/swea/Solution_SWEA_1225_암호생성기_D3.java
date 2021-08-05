package swea;
/**
 * SWEA 1225 암호생성기
 * Difficulty: D3 
 * 실행시간: 100ms / 20초 
 * 메모리: 18,624kb 
 * 코드길이: 1,593
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
			
			// 큐에 넣기전에 배열에 잠깐 넣어서 값 축약해주자.
			int[] arr = new int[8];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
				if (min > arr[i]) {
					min = arr[i];
				}
			}
			
			int v = (min-1) / 15 * 15; // 전체적으로 한방에 빼버릴 값을 넣자. 그런데 몫을 1 뺀 담에 넣어줘야 나눠서 0이 되버리지 않는다.
			for (int i = 0; i < arr.length; i++) {
				arr[i] -= v;
			}
			
			for (int i = 0; i < 8; i++) {
				qnums.offer(arr[i]);
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
//				System.out.printf("%d ", qnums.poll());
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

/*
1
2147483647 2147483640 2147483644 2147483647 2147483647 2147483646 2147483645 2147483644
을 넣고 돌리면 엄청나게 오래걸린다. 코드 개선이 필요함..
 */

