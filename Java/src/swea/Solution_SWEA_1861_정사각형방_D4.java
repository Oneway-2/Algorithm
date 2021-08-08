package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA 1861 정사각형 방
 * Difficulty: D4 
 * 실행시간: 141ms / 2초 
 * 메모리: 28,852kb 
 * 코드길이: 2,531
 * 2021.08.06 금 WS
 */
public class Solution_SWEA_1861_정사각형방_D4 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1}; // 상하좌우
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N+2][N+2];
			int[][] memo = new int[N+2][N+2];
			for (int i = 1; i <= N; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine()," ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			int moveMax = 0;
			int minRoomNum = N*N;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) { // 맵하나씩 다 뒤져보자.
					
					if (memo[i][j] == 1) { // memo가 이미 1로 되어있다는건 이미 지나갔었다는 곳이라는거다. 이미 지나간 곳은 살필 필요 없다.
						continue;
					}
					else {
						memo[i][j] = 1; // memo는 원래 다 0인데 가는데마다 1로 바꿔놓는다.
					}
					
					int ii = i, jj = j;  // 돌아댕길 방 좌표
					boolean checkedAll = false;
					int move = 1;
					
					while(!checkedAll) { // 한 방에서 상하좌우 탐색했을 때 아무데도 갈 데가 없으면 checkedAll = true
						for (int k = 0; k < 4; k++) { // 상하좌우를 살펴보자
							if (map[ii+dr[k]][jj+dc[k]] == map[ii][jj]+1) { // 상하좌우 뒤지다가 갈데가 생겼다?
								move++;
								ii = ii + dr[k];
								jj = jj + dc[k];
								memo[ii][jj] = 1;
								break;
							}
							
							if (k == 3) { // 상하좌우 다뒤졌는데 갈데가 없다?
								checkedAll = true;
							}
						}
						
					} // end of while
					// 탐색 후 얻은 move 수 비교해보자
					
					if (move > moveMax) { // 가장 최고로 많이 이동했으면 roomNum에 그 자리의 인덱스 넣어준다.
						moveMax = move;
						minRoomNum = map[i][j];
					}
					else if (move == moveMax) { // 현재 이동한 거리가 moveMax랑 똑같으면 이전 등록된 roomNum 과 현재 방번호 중 어느놈이 더 작은지 정해서 넣는다.
						if (minRoomNum > map[i][j]) {
							minRoomNum = map[i][j];
						}
					}
				}
			} // 맵 다뒤짐
			sb.append("#").append(testCase).append(" ").append(minRoomNum).append(" ").append(moveMax).append("\n");
			
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class


/*

#1 6 8
#2 3 2
#3 149 2
#4 2 45
#5 2 23
#6 1 2
#7 1 4
#8 5 17
#9 4 2
#10 1 35
#11 2 2
#12 7 2
#13 45 2
#14 113 2
#15 12 32
#16 6 9
#17 1 4
#18 36 42
#19 204 2
#20 7 14
#21 4 2
#22 8225 2200
#23 35 3
#24 2 2
#25 613 2
#26 33 2
#27 5 5


*/