package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_3035_스캐너_브론즈1_88ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		String input;
		
		stk = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		int ZR = Integer.parseInt(stk.nextToken());
		int ZC = Integer.parseInt(stk.nextToken());
		char[][] map = new char[R][C];
		
		for (int i = 0; i < map.length; i++) {
			input = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for (int r = 0; r < map.length; r++) {
			
			for (int i = 0; i < ZR; i++) {
				
				for (int c = 0; c < map[r].length; c++) {
					
					for (int j = 0; j < ZC; j++) {
						sb.append(map[r][c]);
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	} // 메인 끝
}

