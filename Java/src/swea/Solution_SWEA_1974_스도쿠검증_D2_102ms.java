package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 제한시간: 30초
 * 실행시간: 102ms
 * 2021.08.13 금 WS
 */
public class Solution_SWEA_1974_스도쿠검증_D2_102ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		
		int TC = Integer.parseInt(br.readLine());
		int sum = 0;
		int valid;
		int[][] sudoku = new int[9][9];
ex:		for (int testCase = 1; testCase <= TC; testCase++) {
			valid = 1;
			
			// 입력
			for (int i = 0; i < sudoku.length; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < sudoku.length; j++) {
					sudoku[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			// 가로체크
			for (int i = 0; i < sudoku.length; i++) {
				sum = 0;
				for (int j = 0; j < sudoku.length; j++) {
					sum += sudoku[i][j];
				}
				if (sum != 45) {
					valid = 0;
					sb.append("#").append(testCase).append(" ").append(valid).append("\n");
					continue ex;
				}
			}

			// 세로체크
			for (int i = 0; i < sudoku.length; i++) {
				sum = 0;
				for (int j = 0; j < sudoku.length; j++) {
					sum += sudoku[j][i];
				}
				if (sum != 45) {
					valid = 0;
					sb.append("#").append(testCase).append(" ").append(valid).append("\n");
					continue ex;
				}
			}
			
			// 3x3 체크
			for (int i = 0; i < sudoku.length; i+=3) { // 세로
				for (int j = 0; j < sudoku.length; j+=3) { // 가로
					sum = 0;					
					for (int ii = i; ii < i+3; ii++) {
						for (int jj = j; jj < j+3; jj++) {
							sum += sudoku[ii][jj];
						}
					}					
					if (sum != 45) {
						valid = 0;
						sb.append("#").append(testCase).append(" ").append(valid).append("\n");
						continue ex;
					}					
				}
			}		
			
			// 전체가 5 로 된 판은 valid 하지 않음. 
			// 한줄에 5가 2번 나오는 경우를 가로 또는 세로 둘 중 하나만 판별해도 됨.
			int count = 0;
			for (int i = 0; i < sudoku.length; i++) {
				count = 0;
				for (int j = 0; j < sudoku.length; j++) {
					if (sudoku[i][j] == 5) {
						count++;
					}
					if (count >= 2) {
						valid = 0;
						sb.append("#").append(testCase).append(" ").append(valid).append("\n");
						continue ex;
					}
				}
			}						
						
			sb.append("#").append(testCase).append(" ").append(valid).append("\n");
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
} 

/*
#1 1
#2 0
#3 1
#4 0
#5 0
#6 1
#7 0
#8 1
#9 1
#10 0
*/