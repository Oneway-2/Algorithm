package programmers.dfs_bfs;

import java.util.Arrays;

public class 네트워크 {
	public static void main(String[] args) {
		Solution_네트워크 sol = new Solution_네트워크();
//		int[][] computers = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//		int[][] computers = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int[][] computers = new int[][] {{1,1,0,0,0},{1,1,1,0,0},{0,1,1,0,0,},{0,0,0,1,1},{0,0,0,1,1}};
//		int n = 3;
		int n = 5;
		int result = sol.solution(n, computers);
		System.out.println(result);
	}
}

class Solution_네트워크 {
	private boolean[] visited;
	private int[][] arr;
	private int cnt;
	public int solution(int n, int[][] computers) {
		
//		방문체크 해줄 visited
		visited = new boolean[n];
		
//		배열의 대각선을 0으로 바꿔주기 위한 과정
		arr = computers; 
		for (int i = 0; i < arr.length; i++) {
			arr[i][i] = 0;
		}
		
//		처음 출발은 0번 인덱스부터 출발한다. (1번컴퓨터)		
//		dfs는 꼬리를 물고 나아가서 네트워크가 끊어진 컴퓨터가 나타날때까지 탐색할거다.
//		탐색을 완료한 컴퓨터는 visited에서 true로 바뀐다.
//		visited가 false인 녀석(아직 방문하지 않은녀석)이 발견되면 dfs에 들어간다.
//		dfs에 들어갈때마다 cnt를 해준다.
//		dfs에 한 번 들어갔다 나온다는건, 그게 하나의 네트워크라는 의미기 때문
		cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			} 
		}
		return cnt;
	}

	private void dfs(int i) {
		visited[i] = true;
		for (int j = 1; j < arr.length; j++) {
			if (arr[i][j] == 1 && !visited[j]) {
				dfs(j);
			}
		}
	}
}