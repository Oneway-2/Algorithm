package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_11586_지영공주님의마법거울_브론즈1_92ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);	
			}
		}
		int K = Integer.parseInt(br.readLine());
		if (K == 1) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			} 
		}
		else if (K == 2) {
			for (int i = 0; i < map.length; i++) {
				for (int j = map.length - 1; j >= 0 ; j--) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		} 
		else if (K == 3) {
			for (int i = map.length - 1; i >= 0 ; i--) {
				for (int j = 0; j < map.length; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	} // 메인 끝
}
