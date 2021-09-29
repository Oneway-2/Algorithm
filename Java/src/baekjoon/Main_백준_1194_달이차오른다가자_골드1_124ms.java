package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1194_달이차오른다가자_골드1_124ms {
	public static void main(String[] args) throws IOException {
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		char[][] map = new char[R][C];
		int r = 0, c = 0;
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '0') { // 시작포인트 저장
					r = i;
					c = j;
					map[i][j] = '.';
				}
			}
		}
		// 대문자에서 +32 하면 소문자나옴.
		
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][][] visited = new boolean[R][C][1<<6];
		boolean escaped = false;
		int minStep = 0;
		
		q.offer(new int[] {r,c,0,0});
		while(q.size() > 0) {
			int rr = q.peek()[0];
			int cc = q.peek()[1];
			int ss = q.peek()[2];
			int keys = q.poll()[3];

			if (map[rr][cc] == '1') {
				escaped = true;
				minStep = ss;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = rr + dr[i];
				int nc = cc + dc[i];

				// 다음 갈 곳이 가본적 없고, 미로 내부이고 벽이 아닌경우 다음으로이동
				if (0<=nr && nr<R && 0<=nc && nc<C && !visited[nr][nc][keys] && map[nr][nc] != '#') {
					// 다음 가려는 곳이 문이면 열쇠가 있는지 확인
					if ('A' <= map[nr][nc] && map[nr][nc] <= 'Z') { 
						if ((keys & (1 << map[nr][nc] - 'A')) != 0) {
							visited[nr][nc][keys] = true;
							q.add(new int[] {nr,nc,ss+1,keys});
						}
					}
					// 다음 가려는 곳이 열쇠면 획득한다.
					else if('a' <= map[nr][nc] && map[nr][nc] <= 'z') {
						visited[nr][nc][keys | 1 << map[nr][nc] - 'a'] = true;
						q.offer(new int[] {nr, nc, ss+1, keys | 1 << map[nr][nc] - 'a'});
					}
					else if(map[nr][nc] == '.' || map[nr][nc] == '1') {
						visited[nr][nc][keys] = true;
						q.offer(new int[] {nr, nc, ss+1, keys});
					}
				}
			}
		} // while 끝
		if (escaped)
			System.out.println(minStep);
		else
			System.out.println(-1);
	} // 메인 끝
}
