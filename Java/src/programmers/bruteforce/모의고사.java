package programmers.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
	public static void main(String[] args) {
		Solution_모의고사 sol = new Solution_모의고사();
//		int[] answers = {1,2,3,4,5}; // 1
//		int[] answers = {1,3,2,4,2}; // 1 2 3
//		int[] answers = {1, 2, 3, 4, 5, 4, 2, 2}; // 1
		int[] answers = {2,3,2,1,5};
		answers = sol.solution(answers);
		
		System.out.println(Arrays.toString(answers));
	}
}

class Solution_모의고사 {
	public int[] solution(int[] answers) {
		int[][] sp = { {1,2,3,4,5},
						{2,1,2,3,2,4,2,5},
						{3,3,1,1,2,2,4,4,5,5} };
		
		int[] corrects = new int[3];
		int li = 0;
		
		// corrects 배열에 각각 맞은 갯수 넣는중
		for (int i = 0; i < 3; i++) {
			li = 0;
			for (int j = 0; j < answers.length; j++) {
				if (sp[i][li] == answers[j]) {
					corrects[i]++;
				}

				li++;
				if (li >= sp[i].length) {
					li = 0;
				}
			}
		}
		
		// 가장 많이 맞춘 횟수 찾는 중
		int max = 0;
		for (int i = 0; i < corrects.length; i++) {
			if (corrects[i] > max) {
				max = corrects[i];
			}
		}
		
		// 동시에 가장 많이 맞춘 사람이 몇명인지 세어서 size에 저장. 
		// 이 size는 toTurn 이라는 배열 사이즈를 결정합니다.
		int size = 0;
		int[] temp = new int[3];
		for (int i = 0; i < corrects.length; i++) {
			if (corrects[i] == max) {
				size++;
				temp[i] = i+1;
			}
		}
		
		// size가 결정된 toTurn의 앞쪽부터 차례로 가장 많이 맞춘 사람의 번호를 넣습니다.
		int[] toTurn = new int[size];
		int index = 0;
		for (int i = 0; i < corrects.length; i++) {
			if (temp[i] != 0) {
				toTurn[index] = temp[i];
				index++;
			}
		}
		
		return toTurn;
	}	
}

// 엉망진창이라고 생각한다.