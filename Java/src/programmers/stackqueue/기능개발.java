package programmers.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;

public class 기능개발 {
	public static void main(String[] args) {
		Solution_기능개발 sol = new Solution_기능개발();
		
		int[] progresses = new int[] {93, 30, 55};
		int[] speeds = new int[] {1, 30, 5};
//		
//		int[] progresses = new int[] {95,90,99,99,80,99};
//		int[] speeds = new int[] {1,1,1,1,1,1};
		
		System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
	}
}

class Solution_기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int trigger = 0;
		int done = 0;
		while(trigger <= progresses.length - 1) {
			
			for (int i = 0; i < progresses.length; i++) {
				if (progresses[i] >= 100) { // 만약 더하려했는데 이미 100이 넘어버린놈이 왔다?
					continue;              // 더하지말고 패스해.
				} 
				else {							// 만약 아직 100을 넘기지 못했다면
					progresses[i] += speeds[i]; // 계속해서 더해줘 영차영차
					if (progresses[i] > 100) {  // 근데 더했는데 100이 넘어버렸다?
						progresses[i] = 100;    // 100로 고정시킨다.
					}
				}
				
			} // for의 끝
			
//			System.out.println(Arrays.toString(progresses));
			
			while(trigger <= progresses.length - 1 && progresses[trigger] == 100) { // 100 되길 기다리고있는 녀석이 100이 되면, 그 이후거도 100인지 찾음. 계속 찾다가 100이 아니면 멈춤.
				trigger++;
				done++;
			}
			
			if (done != 0) {
				list.add(done);
			}
			
//			System.out.printf("%d개 배포합니다. trigger = %d, list는 현재 : ", done, trigger);
//			for (Integer integer : list) {
//				System.out.print(integer + " ");
//			}
//			System.out.println();
			
			done = 0;
			
		} // while의 끝
		
		int[] toTurn = new int[list.size()];
		for (int i = 0; i < toTurn.length; i++) {
			toTurn[i] = list.get(i);
		}
		
		return toTurn;
	}
}