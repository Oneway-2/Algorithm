package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA 1208 Flatten
 * Difficulty: D3
 * 실행시간: 129ms
 * 메모리: 21,564kb
 * 2021.08.03 화 WS
 */
public class Solution_SWEA_1208_Flatten_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int dump;
		int[] boxes = new int[100];
		int diff = 0;
		
		for (int i = 1; i <= 10; i++) {
			dump = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < boxes.length; j++) {  // 배열에 box들 삽입
				boxes[j] = Integer.parseInt(stk.nextToken());
			}			
			Arrays.sort(boxes); // 최초정렬
			
			for (int j = dump; j >= 0; j--) { // dump 횟수를 전부 소모할 때 까지
				 // boxes 정렬. 0에 최소값, 99에 최대값 있음.
				diff = boxes[99] - boxes[0];
				if (diff <= 1) { // 차이가 1보다 작게 나면 평탄화가 이미 끝난거
					break;
				}	
				boxes[99]--;
				boxes[0]++;
				Arrays.sort(boxes);
			}
			sb.append("#").append(i).append(" ").append(diff).append("\n");
			
		}
		System.out.print(sb);
	}
}


// output

//#1 13
//#2 32
//#3 54
//#4 25
//#5 87
//#6 14
//#7 39
//#8 26
//#9 13
//#10 29
