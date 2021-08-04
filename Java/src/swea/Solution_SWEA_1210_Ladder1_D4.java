package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA 1210 Ladder1
 * Difficulty: D4
 * 실행시간: 149ms / 20초
 * 메모리: 30,396kb
 * 2021.08.04 수 WS
 */
public class Solution_SWEA_1210_Ladder1_D4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			
//			어차피 항상 총 10개의 테스트케이스가 주어질거면 왜 입력받지 아무튼 입력받자
			int TC = Integer.parseInt(br.readLine());

//			int형 2차원배열을 만들자. 크기는 100x100 
			int[][] map = new int[100][100];

//			2차원배열에 맵을 넣자
			for (int i = 0; i < 100; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			for (int OC = 0; OC < 100; OC++) {
				int R = 0;
				int C = OC;
				boolean foundGoal = false;
				// 시작부분이 1이면 탐색 시작.
				if (map[R][OC] == 1) {
//					System.out.printf("%d %d부터 타기 시작합니다\n", R,C);
					while(!foundGoal) {		
//						System.out.printf("도는중 현재 %d %d\n", R, C);
						if (map[R][C] == 1) {
							// 타기
							
							// 어라랏 왼쪽에 1이 있다 - 근데 왼쪽이 문자열 바깥일 수도 있다.
							if (C-1 >= 0 && map[R][C-1] == 1) { 
//								System.out.printf("%d %d의 왼쪽에 1이 있어서 왼쪽으로 이동합니다.\n",R,C);
								while(true) {
									// 이동하다가, 자신의 왼쪽이 0이거나 문자열 바깥이면 break 							
									if (C-1 < 0 || map[R][C-1] == 0) {
//										System.out.printf("왼쪽으로 이동하다 %d %d에서 막혔습니다\n", R, C);
										break;
									}
									// C를 계속 감소시키면서 왼쪽으로 이동한다.								
									C--;
//									System.out.printf("왼쪽으로 이동중. 현재 %d %d\n", R, C);

								}
							}  
							// 어라랏 오른쪽에 1이 있다 - 근데 오른쪽이 문자열 바깥일 수도 있다.
							else if (C+1 <= 99 && map[R][C+1] == 1) {
//								System.out.printf("%d %d의 오른쪽에 1이 있어서 오른쪽으로 이동합니다.\n",R,C);
								while(true) {
									// 이동하다가, 자신의 오른쪽이 0이거나 문자열 바깥이면 break 
									if ( C+1 > 99 || map[R][C+1] == 0) {
//										System.out.printf("오른쪽으로 이동하다 %d %d에서 막혔습니다\n", R, C);
										break;
									}
									// C를 계속 증가시키면서 오른쪽으로 이동한다.
									C++;
//									System.out.printf("오른쪽으로 이동중. 현재 %d %d\n", R, C);
									
								}
							} // if~else 끝
							
							// not골인 - 다음턴에 문자열 바깥으로 나가버린다. 다음라인 탐색한다.
							if (R >= 99) {
//								System.out.println("골이 아니네요.\n");
								break;
							}
							
							// R 을 1씩 증가시키면서 내려간다.
							R++;
						}
						
						// 골인
						else if (map[R][C] == 2) {
							sb.append("#").append(testCase).append(" ").append(OC).append("\n");
							foundGoal = true;
						}
					}					
				}

				// 시작부분이 1이 아니니까 바로 패스
				else {
					continue;
				}
			} // 한 라인 탐색 끝 
		} // testCase for문 끝
		
		System.out.print(sb);
		
	} // end of main
} // end of class


//output
//#1 67
//#2 45
//#3 39
//#4 24
//#5 91
//#6 93
//#7 90
//#8 4
//#9 99
//#10 35

 