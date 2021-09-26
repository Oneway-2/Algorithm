package programmers.graph;

import java.util.Arrays;

public class 가장먼노드 {
	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int result = solution(n, vertex);
		System.out.println(result);
		
	} // 메인
	
	
	public static int solution(int n, int[][] edge) {
		int[][] map = new int[n+1][n+1];
		for (int i = 0; i < edge.length; i++) {
			int r = edge[i][0];
			int c = edge[i][1];
			map[r][c] = map[c][r] = 1;
		}
		
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		int answer = 0;
		
		return answer;
		
	}
	
	
}	


