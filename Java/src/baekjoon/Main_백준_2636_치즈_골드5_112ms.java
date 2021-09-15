package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2636_치즈_골드5_112ms {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1 ,0}; // 우하좌상
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		int H = Integer.parseInt(stk.nextToken());
		int W = Integer.parseInt(stk.nextToken()); // 가로세로는 최대 100씩. 최대 크기 10000
		char[][] map = new char[H][W];
		String s;
		for (int i = 0; i < H; i++) {
			s = br.readLine();
			for (int j = 0, index = 0; j < W; j++, index += 2) {
				map[i][j] = s.charAt(index);
			}
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[H][W];
		q.offer(new int[] {0,0});
		visited[0][0] = true;
		int cnt = 0, exitFlag = 0, term = 0;
		
		while(true) {
			cnt = 0;
			while(q.size() > 0) {
				int[] arr = q.poll();
				int r = arr[0];
				int c = arr[1];
				
				// 우하좌상 큐에 넣음.
				// 대신 가장 처음 1을 만나면 걘 2로 바꿔줌. 공기에 접촉하고있는 치즈임. 그리고 거기론 진행 ㄴㄴ
				// 탐색하다 2를 만나면 진행 ㄴㄴ
				for (int i = 0; i < dr.length; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					// 바깥이 아닌경우 && 가본적 없는곳인경우
					if (0<=nr && nr<H && 0<=nc && nc<W && !visited[nr][nc]) {
						// 가려는곳이 치즈인경우
						if (map[nr][nc] == '1') {
							map[nr][nc] = '2'; // 공기중에 노출된 치즈로 바꿔준다. 
							cnt++;
						}
						// 가려는곳이 치즈가 아닌경우 진행.
						else if(map[nr][nc] == '0'){
							q.offer(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
					}
				}
			} // q.size() > 0 while 끝
			
			term++; // 1시간 지남. 2인 치즈는 녹이자.
			exitFlag = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] == '2') map[i][j] = '0';
					if(map[i][j] != '0') exitFlag++;
				}
			}
			
			if(exitFlag == 0) break;
			
			// 전부 녹지 않았다면 다음 term을 위해 준비
			q.offer(new int[] {0, 0});
			for (int i = 0; i < visited.length; i++) {
				Arrays.fill(visited[i], false);
			}
		} // while 끝
		System.out.println(term+"\n"+cnt);
	} // 메인 끝
}
