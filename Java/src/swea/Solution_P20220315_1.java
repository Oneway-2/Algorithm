package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_P20220315_1 {
	private static int[] order;
	private static boolean[] selected;
	private static int[][] map;
	private static int N, minDist;

	public static void main(String[] args) throws IOException {
		// 낚시터 자리잡기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[3][2];
			for (int j = 0; j < 3; j++) {
				stk = new StringTokenizer(br.readLine());
				for (int k = 0; k < 2; k++) {
					map[j][k] = Integer.parseInt(stk.nextToken());
				}
						
			}
			order = new int[3];
			selected = new boolean[3];
			minDist = Integer.MAX_VALUE;
			perm(0);
			System.out.printf("#%d %d\n", i, minDist);
//			#1 18
//
//			#2 25
//
//			#3 57
//
//			#4 86
//
//			#5 339

			
			
		} // TC 끝
		
		
	} // 메인 끝

	private static void perm(int cnt) {
		if (cnt == 3) {
			boolean[] seat = new boolean[N+1];
			int dist = 0;
			cal(0, seat, dist);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (selected[i]) {
				continue;
			}
			order[cnt] = i;
			selected[i] = true;
			perm(cnt+1);
			selected[i] = false;
		}
	}

	private static void cal(int i, boolean[] seat, int dist) {
		if (i == 3) {
//			System.out.printf("무야호 dist = %d, minDist = %d\n", dist, minDist);
			minDist = Math.min(dist, minDist);
			return;
		}
		
//		System.out.println("접속");
		
		int idx = order[i];
		int gate = map[idx][0];
		int member = map[idx][1];
		
		
		int godist = 0;
//		while(member > 0) {
//			System.out.printf("i = %d, idx = %d, gate = %d, member = %d, godist = %d, dist = %d, minDist = %d\n", i,idx,gate,member,godist,dist,minDist);
//			if (godist == 0) { // 첫 시도
//				System.out.println("접속접속");
//				if (!seat[gate] || gate!=0) { // 자리가 안찼다면
//					seat[gate] = true;
//					dist += godist+1;
//					member--;
//					godist++;
//				}
//			}
//			else { // 첫 손님 아님
//				if (member == 1) { // 마지막손님
//					if (gate-godist >= 1 ) { // 왼쪽 안전
//						if (gate+godist <= N) { // 오른쪽 안전
//							if (!seat[gate-godist] && !seat[gate+godist]) { // 양쪽 다 가능
//								dist += godist+1;
//								seat[gate-godist] = true;
//								cal(i+1, seat, dist);
//								seat[gate-godist] = false;
//								seat[gate+godist] = true;
//								cal(i+1, seat, dist);
//								member--;
//							}
//						}
//						else { // 오른쪽은 막혔으니 왼쪽으로 찾으면 됨
//							while(member == 0) {
//								if(!seat[gate-godist]) {
//									seat[gate-godist] = true;
//									dist += godist+1;
//									member--;
//								}
//								else {
//									godist++;
//								}
//							}
//						}
//					}
//					else { // 왼쪽은 막혔으니 오른쪽으로 찾으면 됨
//						while(member == 0) {
//							if (!seat[gate+godist]) {
//								seat[gate+godist] = true;
//								dist += godist+1;
//								member--;
//							} else {
//								godist++;
//							}
//						}
//					}
//				}
//				else { // 첫 손님 아니고 마지막 손님 아님
//					if(gate-godist >= 1) { // 왼쪽으로 가도 범위 안넘음
//						if (!seat[gate-godist]) { // 자리도 있음
//							seat[gate-godist] = true;
//							dist += godist+1;
//							member--;
//						}
//					}
//					if (gate+godist <= N) { // 오른쪽으로 가도 범위 안넘음
//						if(!seat[gate-godist]) {
//							seat[gate-godist] = true;
//							dist += godist+1;
//							member--;
//						}
//					}
//					godist++;
//				}
//			}
//		} // whhil 끝
//		cal(i+1, seat, dist);
	}
}
