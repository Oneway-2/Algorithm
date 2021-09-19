package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_1767_프로세서연결하기_767ms {
	// 					상하좌우
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	private static ArrayList<int[]> arr;
	private static int N, min, max;
	private static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine().trim());
		String s;
		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine().trim()); // 7 <= N <= 12;
			map = new char[N][N];
			arr = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				s = br.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					map[i][j] = s.charAt(index);
					if (i > 0 && j > 0 && i < N-1 && j < N-1 && map[i][j] == '1') {
						arr.add(new int[] {i, j});
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			dfs(0, 0, 0);
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		} // 테케 끝
		System.out.println(sb);
	} //메인 끝

	private static void dfs(int index, int coreCnt, int len) {
		
		if(index == arr.size()) {
			if(max < coreCnt) { // 코어 개수가 더 많아서 갱신해야할 때
				max = coreCnt;
				min = len;
			}
			else if(max == coreCnt) { //코어 개수가 같아서 길이 비교
				if(min > len) min = len;
			}
			return;
		}
		
		int r = arr.get(index)[0];
		int c = arr.get(index)[1];
		
		for (int dir = 0; dir < 4; dir++) { // 상하좌우
			int count = 0;
			int or = r;
			int oc = c;
			int nr = r;
			int nc = c;
			
			while(true) {
				nr += dr[dir];
				nc += dc[dir];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) { // 벽을 만나면 
					break;
				}
				
				if (map[nr][nc] == '1') { //전선을 만남
					count = 0;
					break;
				}
				count++;
			} // 벽을 만날 경우에만 count 센걸 가져가고, 전선을 만나면 count는 안가져간다.
			
			// 전선세우기
			for (int i = 0; i < count; i++) {
				or += dr[dir];
				oc += dc[dir];
				map[or][oc] = '1';
			}
			
			if (count == 0) { // 중간에 전선을 만난 코어임. 바로 이 코어에서 다른방향으로 탐색
				dfs(index+1, coreCnt, len);				
			}
			else {
				dfs(index+1, coreCnt+1, len+count);
				
				// 전선 철거하는 과정
				or = r;
				oc = c;
				for (int i = 0; i < count; i++) {
					or += dr[dir];
					oc += dc[dir];
					map[or][oc] = '0';
				}
			}
		}
		
	} // dfs 끝
}
