package swea;

import java.util.Scanner;

/**
 * SWEA 1954 달팽이숫자
 * Difficulty: D2
 * 실행시간: 138ms
 * 메모리: 20,608kb
 * 2021.08.03 화 HW
 */
public class Solution_SWEA_1954_달팽이숫자_D2 {
	static int[][] d = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) {
		// 입력 N(달팽이의 크기)는 1 <= N <= 10;
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i = 1; i <= testCase; i++) {
			int size;
			size = sc.nextInt();
			int[][] map = new int[size][size];

			int to = 0; // 진행 방향
			int x = 0, y = 0;
			
			for (int j = 1; j <= size*size; j++) {
				map[x][y] = j;
//				System.out.printf("현재 %d %d에 %d를 넣었습니다. 방향은 %d 입니다.\n", x, y, j, to);
				if ( x+d[to][0] < 0 || x+d[to][0] > size-1 || y+d[to][1] < 0 || y+d[to][1] > size-1 || map[x+d[to][0]][y+d[to][1]] != 0) {
					to++;
//					System.out.println("방향전환 했습니다.");
					if (to > 3) to = 0;
				}
				x += d[to][0];
				y += d[to][1];
			}
			
			System.out.println("#"+i);
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					System.out.print(map[j][k]+" ");
				}
				System.out.println();
			}
		} // end of testCase
	} // end of main
} // end of class
