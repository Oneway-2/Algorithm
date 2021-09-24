package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17144_미세먼지안녕_골드4_680ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(stk.nextToken()); // 6 <= R <= 50
		int C = Integer.parseInt(stk.nextToken()); // 6 <= C <= 50
		int T = Integer.parseInt(stk.nextToken()); // 1 <= T <= 1000
		int APr=0, APc=0; // 공기청정기의 윗 좌표 Air Purifier
		boolean findAP = false;
		int[][] map = new int[R][C];
		for (int i = 0; i < R; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if (!findAP && map[i][j] == -1) {
					APr = i;
					APc = j;
					findAP = true;
				}
			}
		}
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		int toLeft = APc - 0;
		int toTop = APr - 0;
		int toRight = C - APc - 1;
		int toBottom = R - APr - 2; // 아랫좌표는 바닥과 1 더 가까워서 -2함
		
		ArrayList<int[]> arr = new ArrayList<int[]>(); // {r, c, cost}
		for (int time = 0; time < T; time++) {
			arr.clear();
			
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] > 0) { // 미세먼지 발견하면 확산할 값과 위치를 arr에 저장
						int availableDir = 0;
						int cost = map[r][c] / 5;
						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if(0<=nr && nr<R && 0<=nc && nc<C && map[nr][nc] != -1) { // 바라보는 방향이 방 안이면서 공기청정기가 아니면
								availableDir++;
								arr.add(new int[] {nr,nc,cost});
							}
						}
						int centerCost = map[r][c] - cost*availableDir;
						map[r][c] = centerCost;
					}
				}
			}
			
			// 저장한 cost들 추가로 더해준다. (확산시키기)
			for (int i = 0; i < arr.size(); i++) {
				int r = arr.get(i)[0];
				int c = arr.get(i)[1];
				int cost = arr.get(i)[2];
				map[r][c] += cost;
			}
			
			// 공기청정기 작동
			int r = APr, c = APc, r2 = APr+1;
			int nr = r, nc = c, nr2 = r2;
			// ← 쪽에서 당겨오기 (위, 아래 둘다)
			for (int i = 0; i < toLeft; i++) {
				nc -= 1;
				map[r][c] = map[nr][nc];
				map[r2][c] = map[nr2][nc];
				c = nc;
			}
			// ↑ 쪽에서 당겨오기 (위)
			for (int i = 0; i < toTop; i++) {
				nr -= 1;
				map[r][c] = map[nr][nc];
				r = nr;
			}
			// ↓ 쪽에서 당겨오기(아래)
			for (int i = 0; i < toBottom; i++) {
				nr2 += 1;
				map[r2][c] = map[nr2][nc];
				r2 = nr2;
			}
			// → 쪽에서 당겨오기 (위, 아래 둘다)
			for (int i = 0; i < C-1; i++) {
				nc += 1;
				map[r][c] = map[nr][nc];
				map[r2][c] = map[nr2][nc];
				c = nc;
			}
			// ↓ 쪽에서 당겨오기 (위)
			for (int i = 0; i < toTop; i++) {
				nr += 1;
				map[r][c] = map[nr][nc];
				r = nr;
			}
			// ↑ 쪽에서 당겨오기 (아래)
			for (int i = 0; i < toBottom; i++) {
				nr2 -= 1;
				map[r2][c] = map[nr2][nc];
				r2 = nr2;
			}
			// ← 쪽에서 당겨오기 (위, 아래 둘다)
			for (int i = 0; i < toRight; i++) {
				nc -= 1;
				map[r][c] = map[nr][nc];
				map[r2][c] = map[nr2][nc];
				c = nc;
			}
			
			map[APr][APc] = -1; // 빙글 돌아서 지워진 -1 다시 넣기
			map[APr+1][APc] = -1;
			map[APr][APc+1] = 0; // 항상 깨끗한 바람만 나가게끔
			map[APr+1][APc+1] = 0;
			
		} // time out
		int cnt = 2;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				cnt += map[i][j];
			}
		}
		System.out.println(cnt);
	} // 메인 끝
}
