package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_12100_2084Easy_골드2_788ms {
	private static int N, maxVal = 0;
	private static int[] dr = {0,0,1,-1};
	private static int[] dc = {1,-1,0,0};
	private static int[] dirOrder = new int[5]; // 최대 5번 이동 가능
	private static int[][] map, tmap;
	private static boolean[][] merged;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		tmap = new int[N][N];
		merged = new boolean[N][N];
		for (int i = 0; i < map.length; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		per(0);
		System.out.println(maxVal);
		
	} // 메인 끝
	private static void per(int cnt) {
		if (cnt == 5) {
			play();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			dirOrder[cnt] = i;
			per(cnt+1);
		}
	}
	
	private static void play() {
		for (int i = 0; i < tmap.length; i++) {
			tmap[i] = Arrays.copyOf(map[i], map.length);
		}
		
		for (int i = 0; i < dirOrder.length; i++) {
			for (int a = 0; a < merged.length; a++) {
				Arrays.fill(merged[a], false);
			}
			int order = dirOrder[i];
			// 방향으로 밀착
			if (order == 0) { // -> 방향
				for (int r = 0; r < N; r++) {
					for (int c = N-1; c >= 0; c--) {
						// 공백이거나 옆이 벽이면 pass
						if (tmap[r][c] == 0 || c == N-1) continue;
						// 벽까지 보내는 와중
						boolean touchedWall = false;
						for (int cc = c+1; cc < N; cc++) {
							// 나랑 똑같은 숫자를 발견했다
							if (tmap[r][c] == tmap[r][cc]) {
								// 합쳐진 적 없다 - 합친다.
								if (!merged[r][cc]) {
									tmap[r][cc] += tmap[r][c];
									tmap[r][c] = 0;
									merged[r][cc] = true;
									break;
								}
								// 합쳐진 적 있다 - 밀착한다.
								else {
									tmap[r][cc-1] = tmap[r][c];
									tmap[r][c] = 0;
									break;
								}
							}
							// 나랑 다른 숫자를 발견했다 - 밀착한다.
							else if (tmap[r][cc] != 0 && tmap[r][c] != tmap[r][cc]) {
								int t = tmap[r][c];
								tmap[r][c] = 0;
								tmap[r][cc-1] = t;
								break;
							}
							// 아무것도 발견하지 못하고 벽에 닿았다. - 벽에 밀착한다.
							else if (cc == N-1 && tmap[r][cc] == 0) touchedWall = true; 
						}
						if (touchedWall) {
							tmap[r][N-1] = tmap[r][c];
							tmap[r][c] = 0;
						}
					}
				}
			}
			else if (order == 1) { // <- 방향
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						// 공백이거나 옆이 벽이면 pass
						if (tmap[r][c] == 0 || c == 0) continue;
						// 벽까지 보내는 와중
						boolean touchedWall = false;
						for (int cc = c-1; cc >= 0; cc--) {
							// 나랑 똑같은 숫자를 발견했다
							if (tmap[r][c] == tmap[r][cc]) {
								// 합쳐진 적 없다 - 합친다.
								if (!merged[r][cc]) {
									tmap[r][cc] += tmap[r][c];
									tmap[r][c] = 0;
									merged[r][cc] = true;
									break;
								}
								// 합쳐진 적 있다 - 밀착한다.
								else {
									tmap[r][cc+1] = tmap[r][c];
									tmap[r][c] = 0;
									break;
								}
							}
							// 나랑 다른 숫자를 발견했다 - 밀착한다.
							else if (tmap[r][cc] != 0 && tmap[r][c] != tmap[r][cc]) {
								int t = tmap[r][c];
								tmap[r][c] = 0;
								tmap[r][cc+1] = t;
								break;
							}
							// 아무것도 발견하지 못하고 벽에 닿았다. - 벽에 밀착한다.
							else if (cc == 0 && tmap[r][cc] == 0) touchedWall = true; 
						}
						if (touchedWall) {
							tmap[r][0] = tmap[r][c];
							tmap[r][c] = 0;
						}
					}
				}
			}
			else if (order == 2) { // 아래 방향
				for (int c = 0; c < N; c++) {
					for (int r = N-1; r >= 0 ; r--) {
						// 공백이거나 아래가 벽이면 pass
						if (tmap[r][c] == 0 || r == N-1) continue;
						// 벽까지 보내는 와중
						boolean touchedWall = false;
						for (int rr = r+1; rr < N; rr++) {
							// 나랑 똑같은 숫자를 발견했다
							if (tmap[r][c] == tmap[rr][c]) {
								// 합쳐진 적 없다 - 합친다.
								if (!merged[rr][c]) {
									tmap[rr][c] += tmap[r][c];
									tmap[r][c] = 0;
									merged[rr][c] = true;
									break;
								}
								// 합쳐진 적 있다 - 밀착한다.
								else {
									tmap[rr-1][c] = tmap[r][c];
									tmap[r][c] = 0;
									break;
								}
							}
							// 나랑 다른 숫자를 발견했다 - 밀착한다.
							else if (tmap[rr][c] != 0 && tmap[r][c] != tmap[rr][c]) {
								int t = tmap[r][c];
								tmap[r][c] = 0;
								tmap[rr-1][c] = t;
								break;
							}
							// 아무것도 발견하지 못하고 벽에 닿았다. - 벽에 밀착한다.
							else if (rr == N-1 && tmap[rr][c] == 0) touchedWall = true; 
						}
						if (touchedWall) {
							tmap[N-1][c] = tmap[r][c];
							tmap[r][c] = 0;
						}
					}
				}
			}
			else { // 위 방향
				for (int c = 0; c < N; c++) {
					for (int r = 0; r < N ; r++) {
						// 공백이거나 아래가 벽이면 pass
						if (tmap[r][c] == 0 || r == 0) continue;
						// 벽까지 보내는 와중
						boolean touchedWall = false;
						for (int rr = r-1; rr >= 0; rr--) {
							// 나랑 똑같은 숫자를 발견했다
							if (tmap[r][c] == tmap[rr][c]) {
								// 합쳐진 적 없다 - 합친다.
								if (!merged[rr][c]) {
									tmap[rr][c] += tmap[r][c];
									tmap[r][c] = 0;
									merged[rr][c] = true;
									break;
								}
								// 합쳐진 적 있다 - 밀착한다.
								else {
									tmap[rr+1][c] = tmap[r][c];
									tmap[r][c] = 0;
									break;
								}
							}
							// 나랑 다른 숫자를 발견했다 - 밀착한다.
							else if (tmap[rr][c] != 0 && tmap[r][c] != tmap[rr][c]) {
								int t = tmap[r][c];
								tmap[r][c] = 0;
								tmap[rr+1][c] = t;
								break;
							}
							// 아무것도 발견하지 못하고 벽에 닿았다. - 벽에 밀착한다.
							else if (rr == 0 && tmap[rr][c] == 0) touchedWall = true; 
						}
						if (touchedWall) {
							tmap[0][c] = tmap[r][c];
							tmap[r][c] = 0;
						}
					}
				}
			}
		}
		
		for (int j = 0; j < tmap.length; j++) {
			for (int j2 = 0; j2 < tmap[j].length; j2++) {
				maxVal = Math.max(tmap[j][j2], maxVal);
			}
		}
	}
}
