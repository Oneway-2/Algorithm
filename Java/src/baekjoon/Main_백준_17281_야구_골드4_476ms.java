package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17281_야구_골드4_476ms {
	
	private static int[][] round;
	private static int[] lineup = new int[10];
	private static boolean[] selected = new boolean[10];
	private static int order = 1; // 선수순서
	private static int N, answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		N = Integer.parseInt(br.readLine());
		round = new int[N][9];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				round[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		selected[4] = true;
		lineup[4] = 1;
		perm(2);
		System.out.println(answer);
		
	} // 메인 끝

	private static void perm(int cnt) {
		
		if (cnt == 10) {
//			System.out.println(Arrays.toString(lineup));
			play();
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			if (selected[i]) {
				continue;
			}
			selected[i] = true;
			lineup[i] = cnt;
			perm(cnt + 1);
			selected[i] = false;
		}
	}

	private static void play() {
		int out = 0; // 3이 되면 행동 끝
		int score = 0; // 해당 play에서 얻은 점수를 저장할거
		int player = 0; // 몇번째 선수가 나와서 칠건지
		int action = 0; // 선수가 할 행동 (안타,2루타,3루타,홈런,아웃)
		int ining = 0; // 3 out이 되면 1 증가함
		order = 1;
		boolean base[] = new boolean[3];
		
		while(ining < N) {
			// 3아웃 당했으면 모든 루는 초기화, out도 0부터 다시.
			Arrays.fill(base, false);
			out = 0;
			while(out < 3) {
				player = lineup[order];
//				System.out.printf("ining = %d, order = %d, player = %d, out = %d, score = %d\n",ining, order, player, out, score);
				action = round[ining][player-1];
				
				// 아웃함
				if (action == 0) { 
					out++;
				}
				// 안타침. 1씩 앞으로
				else if (action == 1) { 
					if (base[2] == true) {
						score++;
						base[2] = false;
					}
					if (base[1] == true) {
						base[1] = false;
						base[2] = true;
					}
					if (base[0] == true) {
						base[0] = false;
						base[1] = true;
					}
					base[0] = true;
				}
				// 2루타 침. 2씩 앞으로
				else if (action == 2) {
					if (base[2] == true) {
						score++;
						base[2] = false;
					}
					if (base[1] == true) {
						score++;
						base[1] = false;
					}
					if (base[0] == true) {
						base[0] = false;
						base[2] = true;
					}
					base[1] = true;
				}
				// 3루타 침. 3씩 앞으로
				else if (action == 3) {
					if (base[2] == true) {
						score++;
						base[2] = false;
					}
					if (base[1] == true) {
						score++;
						base[1] = false;
					}
					if (base[0] == true) {
						score++;
						base[0] = false;
					}
					base[2] = true;
				}
				// 홈런 침.
				else if (action == 4) {
					if (base[2] == true) {
						score++;
						base[2] = false;
					}
					if (base[1] == true) {
						score++;
						base[1] = false;
					}
					if (base[0] == true) {
						score++;
						base[0] = false;
					}
					score++;
				}
				order++;
				if (order > 9) {
					order = 1;
				}
			} // out while 끝
//			System.out.println("3아웃");
			ining++;
		} // ining while 끝
		answer = Math.max(score, answer);
	} // play() 끝
}
