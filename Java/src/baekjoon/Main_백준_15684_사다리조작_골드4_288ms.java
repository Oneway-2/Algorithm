package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15684_사다리조작_골드4_288ms {
	private static int N, M, H, result;
	private static int[][] map;
	private static boolean END;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken()); // 세로 선의 수
		M = Integer.parseInt(stk.nextToken()); // 그어진 가로선의 수
		H = Integer.parseInt(stk.nextToken()); // 가로 선의 수
		map = new int[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			map[r][c] = 1;
			map[r][c + 1] = 2;
		}

		// 3이 넘으면 어차피 -1니까 4까지만.
		for (int set = 0; set < 4; set++) {
			result = set;
			dfs(1, 0, set); // x, cnt
			if(END) break;
		}
		
		if (END) System.out.println(result);
		else System.out.println(-1);

	} // 메인 끝

	private static void dfs(int x, int cnt, int set) {
		if (END) return;
		if (cnt == set) {
			boolean isEnd = play();
			if (isEnd) END = true;
			return;
		}
		
		for (int i = x; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 0 && map[i][j+1] == 0) {
					map[i][j] = 1;
					map[i][j+1] = 2;
					dfs(i, cnt+1, set);
					map[i][j] = map[i][j+1] = 0;
				}
			}
		}
	}

	private static boolean play() {
		for (int j = 1; j <= N; j++) {
			int jj = j;
			for (int i = 1; i <= H; i++) {
				if (map[i][jj] == 1) { // 오른쪽으로 가는 길
					jj++;
				}
				else if (map[i][jj] == 2) { // 왼쪽으로 가는 길
					jj--;
				}
			}
			
			if (j != jj) { // 하나라도 일치하지 않으면 out
				return false;
			}
		}
		
		// 전부 일치했을 때 여기까지 옴. 적은 수에서 부터 올라가니까 한 번이라도 여기에 도달하면 프로그램 종료임.
		return true;
	}
}
