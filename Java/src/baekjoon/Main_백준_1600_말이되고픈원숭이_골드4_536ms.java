package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Solution이었음. 직접 풀어보자.
 */
public class Main_백준_1600_말이되고픈원숭이_골드4_536ms {
	// 					말처럼뛰기 8개, 상하좌우
	static int[] dr = {-1,-2,-2,-1,1,2,2,1,-1,1,0,0};
	static int[] dc = {-2,-1,1,2,2,1,-1,-2,0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int K = Integer.parseInt(br.readLine()); // 0 <= K <= 30;
		stk = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(stk.nextToken()); // 1 <= W <= 200
		int H = Integer.parseInt(stk.nextToken()); // 1 <= H <= 200
		int[][] m = new int[H][W];
		
		// Stringtokenizer 로 쪼개는거보다 charAt 쓰는게 더 빠르다.
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < W; j++, index += 2) {
				m[i][j] = s.charAt(index); // '0'이면 평지, '1'이면 장애물
			}
		}
		
		int minMoveCnt = -1; // 이동 회수의 최소값
		boolean[][][] visited = new boolean[H][W][K+1]; // 행, 열, 말처럼 이동할 수 있는 남은 횟수
		Queue<int[]> q = new LinkedList<int[]>(); // r, c, k, moveCnt 저장하기
		q.offer(new int[] {0,0,K,0}); // 시작 전 큐에 초기값 넣기.
		visited[0][0][K] = true;
		
		while(q.size() > 0) { // 큐가 빌때까지 반복.
			int[] arr = q.poll(); // 큐에서 꺼낸정보는 r,c,K,moveCnt;
			int r = arr[0];
			int c = arr[1];
			int kk = arr[2];
			int moveCnt = arr[3];
			
			// 우측 하단 좌표에 도착하면 종료.
			if (r == H-1 && c == W-1) {
				minMoveCnt = moveCnt;
				break;
			}
			
			// 우측하단이 아니면, 현 정점에서 이동 가능한 좌표를 큐에 넣기.
			for (int i = 8; i < dr.length; i++) { // 상화좌우는 dr의 8~11 번째 인덱스에 있다.
				int nr = r + dr[i];
				int nc = c + dc[i];
				// 정점에 인접한, 방문하지 않은 정점, 평지일 경우만 진입(큐에 넣기)
				if(0<=nr && nr<H && 0<=nc && nc<W && !visited[nr][nc][kk] && m[nr][nc]=='0') {
					q.offer(new int[] {nr, nc, kk, moveCnt+1});
					visited[nr][nc][kk] = true;
				}
			}
			
			// 말처럼 뛸 수 있다면 진행, 없다면 continue로 분기하여 뛰는 행동은 고려하지 않음.
			if (kk == 0) continue; 
			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(0<=nr && nr<H && 0<=nc && nc<W && !visited[nr][nc][kk-1] && m[nr][nc]=='0') {
					q.offer(new int[] {nr, nc, kk-1, moveCnt+1});
					visited[nr][nc][kk-1] = true;
				}
			}
		}
		System.out.println(minMoveCnt);
		
		//DFS : 가지치기가 많이 안된다. 왜냐면 끝까지 가보고 가지치기 하기때문에.
		//BFS : 끝까지 가기전에 계속 가지치며 나아가기 때문에 훨씬 빠르다.
	} // 메인 끝
}
