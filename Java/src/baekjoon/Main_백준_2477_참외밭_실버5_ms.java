package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2477_참외밭_실버5_ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int K = Integer.parseInt(br.readLine()); // 1<=K<=20
		Queue<Integer> direct = new LinkedList<Integer>();
		Queue<Integer> len = new LinkedList<Integer>();
		int inputDirect, inputLen, idx = 0; 
		int[] whoisdup = new int[5]; // 방향 1,2,3,4 체크하려고 5개
		int[] youaredup = new int[2];
		for (int i = 0; i < 6; i++) {
			stk = new StringTokenizer(br.readLine()," ");
			inputDirect = Integer.parseInt(stk.nextToken());
			inputLen = Integer.parseInt(stk.nextToken());
			if (whoisdup[inputDirect] == 1) youaredup[idx++] = inputDirect; // 이미 추가됐다면 youaredup 에 저장
			else whoisdup[inputDirect]++; // 추가된 적 없으면 체크
			direct.offer(inputDirect);
			len.offer(inputLen);
		}
//		System.out.println("whoisdup check = " + Arrays.toString(whoisdup));
//		System.out.println("youaredup check = " + Arrays.toString(youaredup));
		int tmp, longX, longY, subX, subY;
		while(true) {
//			System.out.println("현재 direct peek = " + direct.peek());
//			System.out.println("현재 len peek = \n" + len.peek());
			// 중복이 아닌 애라면, 즉 가장 긴 변이 드디어 젤 앞으로 왔다면?
			if (direct.peek() != youaredup[0] && direct.peek() != youaredup[1]) { 
//				System.out.println("중복 아닌애가 젤앞에 나왔다.");
				longX = len.poll();
				longY = len.poll();
				len.poll();
				subX = len.poll();
				subY = len.poll();
//				System.out.printf("longX = %d, longY = %d, subX = %d, subY = %d\n", longX , longY, subX, subY);
				break;
			}
			// 가장 긴 변이 큐의 젤 앞까지 올때까지 반복
			tmp = direct.poll();
			direct.offer(tmp);
			tmp = len.poll();
			len.offer(tmp);
		}
//		System.out.println(longX*longY + " " + subX*subY);
		int cnt = (longX*longY - subX*subY) * K;
		System.out.println(cnt);
	}
}
