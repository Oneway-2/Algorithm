package programmers.dp;

import java.util.Arrays;

public class 정수삼각형 {
	public static void main(String[] args) {
		Solution_정수삼각형 sol = new Solution_정수삼각형();
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(sol.solution(triangle));
	} 
}

class Solution_정수삼각형 {
    public int solution(int[][] triangle) {
    	int size = triangle.length; 
    	int[] memo = new int[size];
    	// 처음 memo엔 triangle의 밑바닥에 있는 값을 그대로 가져온다.
    	memo = Arrays.copyOf(triangle[size-1], size); 
    	for (int i = size-1; i > 0 ; i--) {
    		for (int j = 0; j < i; j++) {
    			int a = memo[j] + triangle[i-1][j];
    			int b = memo[j+1] + triangle[i-1][j];
    			memo[j] = Math.max(a, b);
			}
		}
        int answer = Math.max(memo[0], memo[1]);
        return answer;
    }
}