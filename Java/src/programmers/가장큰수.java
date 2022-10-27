package programmers.sorting;

import java.util.Arrays;

public class 가장큰수 {
	public static void main(String[] args) {
		Solution_가장큰수 sol = new Solution_가장큰수();
		int[] numbers = new int[] {10, 2, 6, 1902, 23, 462, 132, 8, 469, 84};
		String answer;
		answer = sol.solution(numbers);
		System.out.println(answer);
	}
}

class Solution_가장큰수 {
	public String solution(int[] numbers) {
		int[] digit = new int[numbers.length];
		StringBuilder sb = new StringBuilder();
		String answer = "";
		
		String num1 = Integer.toString(numbers[0]);
		String num2 = Integer.toString(numbers[1]);
		System.out.println(num1);
		System.out.println(num2);
		
		int compare = num2.compareTo(num1);
		System.out.println(compare);
		
		
		
		
		return answer;
	}
}

// 