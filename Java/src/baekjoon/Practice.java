package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Practice {
	public static void main(String[] args) {
		int[][][] map = new int[3][2][5];
		
		System.out.println(map.length);
		System.out.println(map[0].length);
		System.out.println(map[0][0].length);
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				for (int k= 0; k < map[i][j].length; k++) {
					System.out.print(map[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
	}
	

		
}

