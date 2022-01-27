package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_23290_마법사상어와복제_골드1_2796ms {
	private static int[] dr = {0,-1,-1,-1,0,1,1,1};
	private static int[] dc = {-1,-1,0,1,1,1,0,-1};
	private static int[] sdr = {0,-1,0,1,0};
	private static int[] sdc = {0,0,-1,0,1};
	private static int[] route = new int[3];
	private static int[][] bestRoute = new int[3][2];
	private static ArrayList<fish>[][] map = new ArrayList[5][5];
	private static int[][] smell = new int[5][5];
	private static int sharkr, sharkc, countFish=0, priority = 445;
	public static void main(String[] args) throws IOException {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				map[i][j] = new ArrayList<fish>();
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(stk.nextToken()); // 물고기수 1~10
		int S = Integer.parseInt(stk.nextToken()); // 마법횟수 1~100
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int fx = Integer.parseInt(stk.nextToken()); // 물고기 r
			int fy = Integer.parseInt(stk.nextToken()); // 물고기 c
			int d = Integer.parseInt(stk.nextToken()) - 1; // 물고기 방향 (1빼준다.)
			map[fx][fy].add(new fish(fx, fy, d));
		}
		stk = new StringTokenizer(br.readLine());
		sharkr = Integer.parseInt(stk.nextToken());
		sharkc = Integer.parseInt(stk.nextToken());
		
		for (int spell = 0; spell < S; spell++) {
			moveFish();
		}
		
		// 최종적으로 남아있는 물고기 수 세자.
		int result = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 0; k < map[i][j].size(); k++) {
					result++;
				}
			}
		}
		System.out.println(result);
	} // 메인 끝

	private static void moveFish() {
		// 잠시 저장할 tmap 생성, 현재 물고기 상태 저장
		ArrayList<fish>[][] tmap = new ArrayList[5][5];
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				tmap[i][j] = new ArrayList<fish>();
				for (int k = 0; k < map[i][j].size(); k++) {
					tmap[i][j].add(new fish(map[i][j].get(k).getR(), map[i][j].get(k).getC(), map[i][j].get(k).getDir()));
				}
			}
		}
		
		// 현재 물고기들 1칸씩 전진, saveMove에 움직인 좌표랑 dir 저장했다가 한번에 map에 적용
		ArrayList<fish> saveMove = new ArrayList<fish>();
		// 각 칸 돌면서 물고기 이동시키자.
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				// map 에 있는 애들 초기화.
				map[i][j].clear();
				// tmap 에 있는거 꺼내쓰자.
				for (int k = 0; k < tmap[i][j].size(); k++) {
					int tr = tmap[i][j].get(k).getR();
					int tc = tmap[i][j].get(k).getC();
					int tdir = tmap[i][j].get(k).getDir();
					// 회전 실시
					for (int l = 0, ddir = 8; l < 8; l++, ddir--) {
						// 반시계 방향으로 회전
						int ndir = (tdir + ddir) % 8;
						int nr = tr + dr[ndir];
						int nc = tc + dc[ndir];
						// 창밖으로 나가냐? 봤더니 냄새가 있는곳이냐? 봤더니 상어가 있는 곳이냐? 그러면 안됨.
						if (nr<1 || nr>=5 || nc<1 || nc>=5 || smell[nr][nc] != 0 || (nr==sharkr && nc==sharkc)) {
							// 8방 다 뒤져봐도 갈 데가 없다면
							if (l == 7) {
								saveMove.add(new fish(tr, tc, tdir));
								break;
							} 
							else continue;
						}
						// 아니라면 한 칸 이동한 좌표 saveMove에 저장.
						saveMove.add(new fish(nr, nc, ndir));
						// 한 번 이동한 애는 더 회전하지 않음.
						break;
					}
				}
			}
		}
		
		// 이동한거 map에 적용시킨다.
		for (int i = 0; i < saveMove.size(); i++) {
			int r = saveMove.get(i).getR();
			int c = saveMove.get(i).getC();
			int dir = saveMove.get(i).getDir();
			map[r][c].add(new fish(r, c, dir));
		}
		
		// 상어의 최적의 이동 경로 계산
		priority = 445;
		countFish = 0;
		findRoute(0);
		
		// 최적의 루트를 걸어간 길에 물고기 수거하고 냄새 남겨놓기.
		for (int i = 0; i < bestRoute.length; i++) {
			int r = bestRoute[i][0];
			int c = bestRoute[i][1];
			if (!map[r][c].isEmpty()) smell[r][c] = 3;
			map[r][c].clear();
		}
		
		// 상어를 옮겨준다.
		sharkr = bestRoute[2][0];
		sharkc = bestRoute[2][1];
		
		// 냄새를 1씩 줄인다.
		for (int i = 0; i < smell.length; i++) {
			for (int j = 0; j < smell[i].length; j++) {
				if (smell[i][j] == 0) continue;
				smell[i][j]--;
			}
		}
		
		// 복제가 완료된다.
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 0; k < tmap[i][j].size(); k++) {
					map[i][j].add(new fish(tmap[i][j].get(k).getR(), tmap[i][j].get(k).getC(), tmap[i][j].get(k).getDir()));
				}
			}
		}
	}

	private static void findRoute(int cnt) {
		// 444, 443, 442 ..... 113, 112, 111 순으로 탐색.
		// 왜냐면 사전순으로 앞선 것으로 갈아치우기 위해서.
		if (cnt == 3) {
			findBestRoute();
			return;
		}
		for (int i = 4; i >= 1; i--) {
			route[cnt] = i;
			findRoute(cnt + 1);
		}
	}

	private static void findBestRoute() {
		// 임시로 쓸 ttmap 또 만들자..
		ArrayList<fish>[][] ttmap = new ArrayList[5][5];
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				ttmap[i][j] = new ArrayList<fish>();
				for (int k = 0; k < map[i][j].size(); k++) {
					ttmap[i][j].add(new fish(map[i][j].get(k).getR(), map[i][j].get(k).getC(), map[i][j].get(k).getDir()));
				}
			}
		}
		int[][] memorizeRoute = new int[3][2];
		int sr = sharkr;
		int sc = sharkc;
		int cnt = 0;
		String p = "";
		for (int i = 0; i < route.length; i++) {
			int dir = route[i];
			// 4우 3하 2좌 1상
			sr += sdr[dir];
			sc += sdc[dir];
			// 밖으로 나가면 땡
			if (sr<1 || sr>=5 || sc<1 || sc>=5) return;
			// 안나갔으면 이어서, 
			// 그 자리에 물고기 수 센다.
			cnt += ttmap[sr][sc].size();
			// 그리고 그 자리는 비워버린다.
			ttmap[sr][sc].clear();
			memorizeRoute[i][0] = sr;
			memorizeRoute[i][1] = sc;
			p = p.concat(Integer.toString(dir));
		}
		// 역대급으로 cnt가 높고, 우선으로 앞서면 bestRoute를 갱신한다.
		int pNum = Integer.parseInt(p);
		if (cnt >= countFish && pNum < priority) {
			bestRoute[0][0] = memorizeRoute[0][0];
			bestRoute[0][1] = memorizeRoute[0][1];
			bestRoute[1][0] = memorizeRoute[1][0];
			bestRoute[1][1] = memorizeRoute[1][1];
			bestRoute[2][0] = memorizeRoute[2][0];
			bestRoute[2][1] = memorizeRoute[2][1]; // 상우좌 142 // 상좌우 124 // 상상하 113
			countFish = cnt;
			priority = pNum;
		}
	}

	static class fish {
		int r;
		int c;
		int dir;
		
		public int getR() {
			return r;
		}
		public int getC() {
			return c;
		}
		public int getDir() {
			return dir;
		}
		public fish(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}
