package baekjoon;

import java.util.Scanner;

public class Main_백준_2448_별찍기_골드4_564ms {
	
	static char[][] map; 
	
	public static void main(String[] args) {
		// n 은 3,6,12,24,48,96,192,384,768,1536,3072
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new char[n][2*n-1]; 
		
		// 일단 전부 공백1칸으로 초기화
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = ' ';
			}
		}
		
		PrintStar(n, 0, n-1);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2*n - 1; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void PrintStar(int len, int row, int col) {
		
		if (len == 3) {
			Draw(row, col);
			return;
		}
		
		int nextLen = len/2;
		PrintStar(nextLen, row, col);
		PrintStar(nextLen, row + nextLen, col - nextLen);
		PrintStar(nextLen, row + nextLen, col + nextLen);
	}
	
	
	private static void Draw(int row, int col) {
		// 첫번째 줄 꼭지점
		map[row][col] = '*';
		
		// 두번째 줄 두 개
		map[row + 1][col - 1] = '*';
		map[row + 1][col + 1] = '*';
		
		// 세번째 줄 밑변
		for (int i = 0; i < 5; i++) {
			map[row+2][col-2+i] = '*';
		}
	}
}
