package programmers.greedy;

import java.util.Arrays;

public class 체육복 {
	public static void main(String[] args) {
		Solution_체육복 sol = new Solution_체육복();
		
		// 2 <= n <= 30
		// 1 <= lost <= n
		// 1 <= reserve <= n
		
//		int n = 5;
//		int[] lost = new int[] {2, 4};
//		int[] reserve = new int[] {1,3,5};
		
		int n = 5;
		int[] lost = new int[] {2, 4};
		int[] reserve = new int[] {3};
		
		System.out.println(sol.solution(n, lost, reserve));

	}
}

class Solution_체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		int[] has = new int[n+2];
		has[0] = -1;
		has[has.length-1] = -1;
		for (int i = 1; i <= n; i++) {
			has[i] = 1;
		}
		
		for (int i = 0; i < lost.length; i++) {
			has[lost[i]]--;
		}
		for (int i = 0; i < reserve.length; i++) {
			has[reserve[i]]++;
		}
		
		for (int i = 1; i < has.length-1; i++) {
			if (has[i] == 0) {
				if (has[i-1] == 2) {
					has[i-1]--;
					has[i]++;
				} else if(has[i+1] == 2) {
					has[i+1]--;
					has[i]++;
				}
			}
		}

		int answer=0;
		for (int i = 0; i < has.length; i++) {
			if (has[i] >= 1) {
				answer++;
			}
		}
		return answer;
	}
}
