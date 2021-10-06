package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2580_스도쿠_골드4_360ms {
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < 9; j++, index+=2) {
				map[i][j] = s.charAt(index) - '0';
			}
		}
		setSudoku(0, 0); // 0, 0 지점부터 조사 시작
	} // 메인 끝

	private static void setSudoku(int r, int c) {
		if (c == 9) {
			setSudoku(r+1, 0);
			return;
		}
		if (r == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}

		if (map[r][c] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isAvailable(r, c, i)) { // 가로, 세로, 3x3 내 전부 충족하면 다음걸 알아보자.
					map[r][c] = i;
					setSudoku(r, c+1);
				}
			}
			map[r][c] = 0; // 하나라도 충족못하면 0으로 돌려놓고 과거를 되살핀다
			return;
		}
		setSudoku(r, c+1);
	}

	private static boolean isAvailable(int r, int c, int val) {
		// 가로체크
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == val) {
				return false;
			}
		}
		// 세로체크
		for (int i = 0; i < 9; i++) {
			if (map[i][c] == val) {
				return false;
			}
		}
		// 해당 지점이 속한 3x3 체크
		int row = (r / 3)*3;
		int col = (c / 3)*3;
		for (int i = row; i < row+3; i++) {
			for (int j = col; j < col+3; j++) {
				if (map[i][j] == val) {
					return false;
				}
			}
		}
		return true;
	}
}
