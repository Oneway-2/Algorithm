package programmers.graph;

public class 순위 {
	public static void main(String[] args) {
		Solution_순위 sol = new Solution_순위();
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int n = 5;
		System.out.println(sol.solution(n, results));
	}
}

class Solution_순위 {
	public int solution(int n, int[][] results) {
		int[][] arr = new int[n+1][n+1];
		int mat = results.length;
		// 지면 -1, 이기면 1
		for (int i = 0; i < mat; i++) {
			int win = results[i][0];
			int lose = results[i][1];
			arr[win][lose] = 1;
			arr[lose][win] = -1;
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				System.out.printf("%3d",arr[i][j]);
			}
			System.out.println();
		}
		
		// 플로이드 워샬
		// i가 k를 이기고, k가 j를 이겼다면 i는 j를 무조건 이긴다.
		// i가 k한테 지고, k가 j한테 진다면 i는 j한테 무조건 진다.
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					// 
					if (arr[i][j] == 0) {
						if (arr[i][k] == 1 && arr[k][j] == 1) {
							arr[i][j] = 1;
						}
						else if(arr[i][k] == -1 && arr[k][j] == -1) {
							arr[i][j] = -1;
						}
					}
				}
			}
		}
		
		System.out.println();
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				System.out.printf("%3d",arr[i][j]);
			}
			System.out.println();
		}
		
		// 각 선수의 매칭결과를 보고 나를 제외한 다른 선수와 한 번씩 싸워본적이 있다면 순위를 알 수 있는 것.
        int answer = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
        	cnt = 0;
        	for (int j = 1; j <= n; j++) {
        		if (arr[i][j] == 0) {
					cnt++;
				}
			}
        	if (cnt == 1) {
				answer++;
			}
		}
        return answer;
    }
}
