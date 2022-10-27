package programmers.dfs_bfs;

public class 타겟넘버 {
	public static void main(String[] args) {
		Solution_타겟넘버 sol = new Solution_타겟넘버();
		int[] arr = new int[] {1,2,3,4,-5};
		int target = 3;
		int result;
		result = sol.solution(arr, target);
		System.out.println(result);
	}
}

class Solution_타겟넘버 {
	static int size, target, answer;
	public int solution(int[] arr , int t) {
		size = arr.length;
		target = t;
		dfs(0, 0, arr); // 깊이 depth, 들고다닐 sum
		return answer;
	}

	private void dfs(int depth, int sum, int[] arr) {
		if(depth == size) {
			if(sum == target) {
				answer++;
			}
			return;
		}
		dfs(depth+1 , sum + arr[depth], arr);
		dfs(depth+1 , sum - arr[depth], arr);
	}
}