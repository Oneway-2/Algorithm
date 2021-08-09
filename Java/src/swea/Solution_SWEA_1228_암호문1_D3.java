package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA 1228 암호문1
 * Difficulty: D3
 * 실행시간: 106ms / 20초
 * 메모리: 19,476kb
 * 코드 길이: 1,614
 * 2021.08.09 월 HW
 */
public class Solution_SWEA_1228_암호문1_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk, stk2;
		StringBuilder sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			// 첫 번째 줄 : 원본 암호문의 길이 N ( 10 ≤ N ≤ 20 의 정수)
			int originLength = Integer.parseInt(br.readLine());
			
			// 두 번째 줄 : 원본 암호문
			stk = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < originLength; i++) {
				list.add(Integer.parseInt(stk.nextToken()));
			}		
			
			// 세 번째 줄 : 명령어의 개수 ( 5 ≤ N ≤ 10 의 정수)
			int commandLength = Integer.parseInt(br.readLine());
			
			// 네 번째 줄 : 명령어
			stk = new StringTokenizer(br.readLine(), "I");
			for (int i = 0; i < commandLength; i++) {
				
				String commands = stk.nextToken().trim();
				stk2 = new StringTokenizer(commands, " ");
				int x = Integer.parseInt(stk2.nextToken());
				int y = Integer.parseInt(stk2.nextToken());
				for (int j = x; j < y + x; j++) {
					list.add(j, Integer.parseInt(stk2.nextToken()));
				}
			}
			
			sb.append("#").append(testCase);
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(list.get(i));
			}
			sb.append("\n");
			list.clear();
			
		} // end of testCase
		System.out.println(sb);
		
	} // end of main
} // end of class

// LinkedList로 푸는것이 더 효율적이다.

/*

#1 449047 400905 139831 408347 512816 992679 693002 835918 768525 949227 
#2 150706 600576 565945 486128 594841 566753 244528 233616 556294 697547 
#3 973313 271510 434200 132826 186343 308937 115088 438559 139738 948108 
#4 505428 811504 426664 713940 855599 655028 878767 259061 870009 141255 
#5 267162 670435 488135 605710 353909 276272 171102 871819 129966 404856 
#6 192530 407162 275094 303667 851080 385930 909225 863939 286381 776616 
#7 136752 320395 397751 875871 683248 246614 942192 856739 914031 556177 
#8 482032 518037 513679 145989 422525 497171 841413 364367 572438 104109 
#9 438278 128145 818986 814573 692305 541108 569934 812165 774081 789114 
#10 596308 376463 344210 520543 173961 644251 888643 787798 136503 153477 


*/