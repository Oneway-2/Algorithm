package programmers.sorting;
/** 프로그래머스 코테유형 - 정렬 - K번째수 */

import java.util.Arrays;

public class k번째수 {
	public static void main(String[] args) {
		Solution_k번째수 sol = new Solution_k번째수();
		int[] array = new int[] {1,5,2,6,3,7,4};
		int[][] commands = new int[][] {{2,5,3}, {4,4,1}, {1,7,3}};
		int[] answer = new int[commands.length];
		answer = sol.solution(array, commands);
		System.out.println(Arrays.toString(answer));
	}
}

class Solution_k번째수 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer= new int[commands.length]; // 명령의 갯수만큼 답이 나올테니 answer 공간 확보
		for (int i = 0; i < commands.length; i++) {
			int[] temp = new int[commands[i][1] - commands[i][0] + 1];
			temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); // Arrays.copyOfRange 사용
			Arrays.sort(temp);  // 정렬
			answer[i] = temp[commands[i][2]-1];  // 원하는 번째의 요소 저장
		}
		return answer;
	}
}