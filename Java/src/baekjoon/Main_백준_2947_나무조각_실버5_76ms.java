package baekjoon;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_백준_2947_나무조각_실버5_76ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] map = new int[5];
		for (int i = 0; i < 5; i++) {
			map[i] = Integer.parseInt(stk.nextToken());
		}
		
		while(!check(map)) {
			for (int i = 0; i < 4; i++) {
				boolean flag = false;
				if (map[i] > map[i+1]) {
					flag = true;
					int temp = map[i];
					map[i] = map[i+1];
					map[i+1] = temp;
				}
				if (flag) {
					for (int j = 0; j < map.length; j++) {
						System.out.print(map[j] + " ");
					}
					System.out.println();					
				}
			}
		}
	} // 메인 끝

	private static boolean check(int[] map) {
		for (int i = 0; i < 5; i++) {
			if(map[i] != i+1) {
				return false;
			}
		}
		return true;
	}
}
