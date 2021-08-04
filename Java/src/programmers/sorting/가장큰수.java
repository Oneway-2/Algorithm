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
		for (int i = 0; i < digit.length; i++) {
			if (numbers[i] >= 100000) digit[i] = 100000;
			else if (numbers[i] >= 10000) digit[i] = 10000;
			else if (numbers[i] >= 1000) digit[i] = 1000;
			else if (numbers[i] >= 100) digit[i] = 100;
			else if (numbers[i] >= 10) digit[i] = 10;
			else if (numbers[i] < 10) digit[i] = 1;
		}
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = numbers[i] / digit[i];
		}
		
		System.out.println(Arrays.toString(numbers));
		
		
		
		
		
		
		return answer;
	}
}

// 