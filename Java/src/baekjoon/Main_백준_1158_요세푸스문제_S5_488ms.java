package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1158 요세푸스 문제 
 * Difficulty: 실버 5 
 * 실행시간: 488ms / 2초 
 * 메모리: 12,600 kb 
 * 코드길이: 2099
 * 2021.08.10 화 WS
 */
public class Main_백준_1158_요세푸스문제_S5_488ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		
		boolean[] isChecked = new boolean[N]; // 해당 index의 녀석이 제거됐는지 기록
		int[] members = new int[N];      // 1,2,3...N 까지 저장
		int[] josephus = new int[N];     // 제거되는 순서가 저장될 놈
		int index = 0;                    // 0 ~ N-1 를 계속 순환할 놈
		int cnt = 0;                      // 얘가 N만큼 도달하면 반복문 탈출
		int trigger = 1;                  // 얘가 N가 될 때마다 그 때의 members[index]를 josephus에 저장
		boolean goInside = true;
		
		for (int i = 1; i <= members.length; i++) {
			members[i-1] = i;
		}
		
		if (K == 1) {
			for (int i = 0; i < josephus.length; i++) {
				josephus[i] = members[i];
			}
			goInside = false;
		}
		
		while(goInside) {
			
			// 이미 제거된 놈이면 조회할 필요 없다
			// && 트리거가 K와 같아졌을 때
			if (!isChecked[index] && trigger == K) {
				isChecked[index] = true;

				josephus[cnt++] = members[index];
				trigger = 1;
			}
			// 순회하되 이미 제거된 놈일 땐 trigger가 증가하지 않음
			else { 
				if (isChecked[index]) {
					index++;
				} else {
					index++;
					trigger++;
				}
			}
			
			// 재미 다 봤으니 탈출
			if (cnt >= N) {
				break;
			}
			
			// 순회하기위해 index가 N을 넘어서면 다시 0으로 초기화		
			if (index >= N) {
				index = 0;
			}
		}
		
		sb.append("<");
		for (int i = 0; i < josephus.length-1; i++) {
			sb.append(josephus[i]).append(",").append(" ");
		}
		sb.append(josephus[josephus.length-1]).append(">");
		
		System.out.println(sb);
	}
}
