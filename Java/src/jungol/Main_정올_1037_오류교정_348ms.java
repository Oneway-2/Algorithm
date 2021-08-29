package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1037_오류교정_348ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 최대 행렬크기 100x100 이면 10000 밖에 안되니까 그냥 완탐 조지겠습니다.
		// int형 10000 이면 40000, 40kb 카와이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		// 0 이 날아오면 OK
		// 1 이 날아오면 Corrupt
		// 2 이 날아오면 1군데만 바꾸면 된다. 찾자.
		int result = 0;
		int errorX = 0, errorY = 0;

		// 가로탐색
		int sum = 0, errorCntG = 0, errorCntS = 0;
		for (int i = 0; i < map.length; i++) {
			sum = 0;
			for (int j = 0; j < map.length; j++) {
				sum += map[i][j];
			}
			if (sum % 2 != 0) { // 홀수이면
				errorCntG++;
				if (errorCntG >= 2) { // 에러 2곳 이상이면 구제불능
					result = 1;
					break;
				}
				errorX = i+1;
			}
		}

		// 세로탐색
		for (int i = 0; i < map.length; i++) {
			sum = 0;
			for (int j = 0; j < map.length; j++) {
				sum += map[j][i];
			}
			if (sum % 2 != 0) { // 홀수이면
				errorCntS++;
				if (errorCntS >= 2) { // 에러 2곳 이상이면 구제불능
					result = 1;
					break;
				}
				errorY = i+1;
			}
		}

		if (errorCntG == 0 && errorCntS == 0) {
			result = 0;
		} else if (errorCntG == 1 || errorCntS == 1){
			result = 2;
		}

		if (result == 0) {
			System.out.println("OK");
		} else if (result == 1) {
			System.out.println("Corrupt");
		} else {
			System.out.printf("Change bit (%d,%d)", errorX, errorY);
		}
	}
}
