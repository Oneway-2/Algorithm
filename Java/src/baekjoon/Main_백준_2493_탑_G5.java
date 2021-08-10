package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 백준 2493 탑 
 * Difficulty: 골드5 
 * 실행시간: 736ms / 1.5초 
 * 메모리: 120,620kb 
 * 코드길이: 1,267B
 * 2021.08.05 목 HW
 */

public class Main_백준_2493_탑_G5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] top = new int[N];
		int[] dest = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			top[i] = Integer.parseInt(stk.nextToken());
		}

		// height는 탑의 키가, index에는 탑의 번호를 넣어준다.
		// 크고작음의 비교는 height로 하고, 답(타워번호)는 index를 이용해 넣는다.
		Stack<Integer> height = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			if (!height.isEmpty()) { // 안비었으면 (최초 검사용)

				// 이미 들어가있는 녀석이 내가 지금 넣을 녀석보다 작을때까지 전부 들어낸다.
				// 그러다가 스택안에 바닥이 드러날 수도 있는데, 그럴땐 멈춘다.
				while (!height.isEmpty() && height.peek() < top[i]) {
					height.pop();
					index.pop();
				}
				if (!index.isEmpty()) { // 텅 빈건 손 안대도 dest[i]는 0이다.
					dest[i] = index.peek(); // 다 들어낸 뒤 내 발아래 있는애가 벽에 걸리는 지점
				}

				// 내 발아래를 다 들여다봤으면 이제 쌓아준다.
				height.add(top[i]);
				index.add(i + 1);
			} else { // 텅 비어있으면 (최초 검사용)
				height.add(top[i]);
				index.add(i + 1);
			}
		}
		for (int i = 0; i < dest.length; i++) {
			sb.append(dest[i]).append(" ");
		}
		System.out.println(sb);
	}
}


// 완전탐색으로 했다가 시간초과남
//public class Main_백준_2493_탑_골5_김한길 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		int[] tops = new int[N];
//		int[] dest = new int[N];
//		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
//		for (int i = 0; i < tops.length; i++) {
//			tops[i] = Integer.parseInt(stk.nextToken());
//		}
//
//		for (int i = tops.length - 1; i >= 0; i--) {
//			for (int j = i - 1; j >= 0; j--) {
//				if (tops[i] < tops[j]) {
//				 	dest[i] = j + 1;
//					break;
//				}
//			}
//		}
//		
//		for (int i = 0; i < dest.length; i++) {
//			sb.append(dest[i]).append(" ");
//		}
//		System.out.println(sb);
//	}
//}
