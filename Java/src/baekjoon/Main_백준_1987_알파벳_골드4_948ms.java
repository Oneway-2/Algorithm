package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳_골드4_948ms {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int R, C;
	static int[][] map;
	//                    우하좌상
	static boolean[] alpaCheck = new boolean[26];
	static int max;
	// a b c d e / f g h i j / k l m n o / p q r s t / u v w x y / z
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		map = new int[R][C];
		String tmpstr;
		for (int i = 0; i < R; i++) {
			tmpstr = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmpstr.charAt(j) - 'A';
			}
		}
		
		Ahead(0, 0, 1);
		System.out.println(max);
		
	}
	
	private static void Ahead(int r, int c, int step) {
		alpaCheck[map[r][c]] = true;
		max = step > max ? step : max;
		// 우하좌상 전부 체크해라. 다 체크했는데 갈 데 없으면 return
		for (int i = 0; i < 4; i++) {
			
			// 다음꺼 들여다봤는데, 갈 수 있냐?
			if(canGo(r+dr[i], c+dc[i])) { 
				Ahead(r+dr[i], c+dc[i], step + 1);
			}
		}
		
		// 나갈땐 퇴실체크 해라
		alpaCheck[map[r][c]] = false;
		return;
	}
	
	private static boolean canGo(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C || alpaCheck[map[r][c]] == true) {
			return false;
		} 
		return true;
	}
}
