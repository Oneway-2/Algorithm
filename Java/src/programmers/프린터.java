package programmers.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
	public static void main(String[] args) {
		Solution_프린터 sol = new Solution_프린터();
		
//		int[] prioritites = {1,1,9,1,1,1};
//		int location = 0;
		
//		int[] prioritites = {2,1,3,2};
//		int location = 2;
		
		int[] prioritites = {2,5,4,7,3,3,7,7,8};
		int location = 7;
	
		System.out.println(sol.solution(prioritites, location));
	}
}

class Solution_프린터 {
	public int solution(int[] prioritites, int location) {
		Queue<Integer> priQu = new LinkedList<Integer>();
		Queue<Integer> locaQu = new LinkedList<Integer>();
				
		for (int i = 0; i < prioritites.length; i++) {
			priQu.offer(prioritites[i]);
			locaQu.offer(i);
		}

		// 정렬해서 최대값을 알아낼 tempP와 다음 최대값을 지목해줄 trigger
		int[] tempP = new int[prioritites.length];
		tempP = Arrays.copyOf(prioritites, prioritites.length);
		Arrays.sort(tempP);
		int trigger = tempP.length - 1;
		int printed = 0;
		
		while(true) {
//			System.out.printf("priQu.peek == %d, locaQu.peek == %d, trigger == %d, tempP[trigger] == %d, printed == %d\n",priQu.peek(), locaQu.peek(), trigger, tempP[trigger], printed);
			if (priQu.peek() == tempP[trigger]) {
//				System.out.println("뽑아갔다");
				// 우선순위가 가장 높은녀석이 이제 출력될 차례면 printed 횟수 1 증가.
				printed++;

				if (location == locaQu.peek()) {  
					// 우선순위가 젤 높은애를 뽑았더니, 걔가 내가 지정한 녀석이다? 탈출.
					break;
				}
				priQu.poll();
				locaQu.poll();
				trigger--;
			}
			else {
				// 아직 우선순위가 가장 높은애가 젤 앞으로 오지 않았다.
				int tmp = priQu.poll();
				priQu.offer(tmp);
				tmp = locaQu.poll();
				locaQu.offer(tmp);
			}
		} // while의 끝
		
		return printed;
	}
}
