package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_16926_배열돌리기1_실버3_652ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		stk = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(stk.nextToken()); // 세로
		int M = Integer.parseInt(stk.nextToken()); // 가로
		int R = Integer.parseInt(stk.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		int loop = Math.min(N, M) / 2;
		
		for (int times = 0; times < R; times++) {
			
			for (int i = 0; i < loop; i++) {
				
				for (int j = i; j < -i+M-1; j++) {
					swap(i, j, i , j+1, map);
				}
				
				for (int j = i; j < -i+N-1; j++) {
					swap(j, M-1-i, j+1 , M-1-i, map);
				}
				
				for (int j = i; j < -i+M-1; j++) {
					swap(N-1-i, -j+M-1, N-1-i , -j+M-2, map);
				}
				
				for (int j = i; j < -i+N-2; j++) {
					swap(-j+N-1, i, -j+N-2 , i, map);
				}
				
			}
		}
		
//		System.out.println();
		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void swap(int fc, int fr, int tc, int tr, int[][] map) {
		int temp;
		temp = map[fc][fr];
		map[fc][fr] = map[tc][tr];
		map[tc][tr] = temp;
	}
}
