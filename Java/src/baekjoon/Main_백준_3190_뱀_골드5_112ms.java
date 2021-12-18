package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_3190_뱀_골드5_112ms {
	public static void main(String[] args) throws IOException {
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] cMap = new int[N][N];
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			stk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			map[r-1][c-1] = 2; // 2는 사과
		}
		
		int L = Integer.parseInt(br.readLine());
		int[][] cBag = new int[L][2];
		for (int i = 0; i < L; i++) {
			stk = new StringTokenizer(br.readLine());
			cBag[i][0] = Integer.parseInt(stk.nextToken()); // ~초 후
			cBag[i][1] = stk.nextToken().charAt(0); // 방향지시
		}
		
		int time = 0;
		int step = 0;
		ArrayList<Tail> arr = new ArrayList<Tail>();
		arr.add(new Tail(0, 0, 1));
		map[0][0] = 1;
		
ex:		while(true) {
			
			// 현재 위치 r, c
			int r = arr.get(0).r;
			int c = arr.get(0).c;
			int dir = arr.get(0).dir;
			
			// 만약 이번 time에 방향지시등을 놔야할 타이밍이면 현재 위치에 방향지시등 놓기
			if (cBag[step][0] == time) {
				cMap[r][c] = cBag[step][1];
				if (step < cBag.length-1) step++;
			}
			
			boolean ateApple = false;
			// 움직이기 전에 가장 꼬리의 위치 기억해두기
			int lr = arr.get(arr.size()-1).r;
			int lc = arr.get(arr.size()-1).c;
			
			time++;
			
			for (int i = 0; i < arr.size(); i++) {
				// 변경 전
				int cr = arr.get(i).r;
				int cc = arr.get(i).c;
				map[cr][cc] = 0;
				
				if (cMap[cr][cc] == 'L') { 
					if (arr.get(i).dir == 0) arr.get(i).dir += 3;
					else arr.get(i).dir -= 1;
				}
				else if (cMap[cr][cc] == 'D') {
					if (arr.get(i).dir == 3) arr.get(i).dir -= 3;
					else arr.get(i).dir += 1;
				}
				
				arr.get(i).r += dr[arr.get(i).dir];
				arr.get(i).c += dc[arr.get(i).dir];
				
				// 꼬리가 지나갈때는 방향지시등 제거하고 지나가자.
				if (i == arr.size()-1) {
					cMap[cr][cc] = 0;
				}
				
				// 변경 후
				int nnr = arr.get(i).r;
				int nnc = arr.get(i).c;
				
				// 밖으로 나가거나 꼬리밟아서 끝
				if (0>nnr || nnr>=N || 0>nnc || nnc>=N || map[nnr][nnc] == 1) { 
					break ex;
				}
				
				// 사과를 먹음
				if (i == 0) {
					if (map[nnr][nnc] == 2) { 
						ateApple = true;
						map[nnr][nnc] = 0;
					}
				}
				
				map[nnr][nnc] = 1;
			}
			
			// 사과를 먹었다면, 턴이 끝나기 전에 처음 꼬리가 있었던 자리에 하나 더 추가
			int ldir = arr.get(arr.size()-1).dir;
			if (ateApple) {
				arr.add(new Tail(lr, lc, ldir));
			}
		}
		System.out.println(time);
	} // 메인 끝

public static class Tail {
	int r;
	int c;
	int dir;

	public Tail(int r, int c, int dir) {
		this.r = r;
		this.c = c;
		this.dir = dir;
	}

}}
