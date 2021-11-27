package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1966_프린터큐_실버3_104ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int TC = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> qr = new LinkedList<Integer>();
		int[] bag = new int[10]; // 중요도 가방
		for (int i = 0; i < TC; i++) {
			Arrays.fill(bag, 0);
			q.clear();
			qr.clear();
			stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int el = Integer.parseInt(stk.nextToken());
				q.offer(el);
				bag[el]++;
				if (j == M) qr.offer(1);
				else qr.offer(0);
			}
			int idx = 9;
			int time = 0;
ex:			while(!q.isEmpty()) {
				if (bag[idx] == 0) {
					idx--;
					if (idx < 0) {
						break;
					}
					else {
						continue;
					}
				}
				else {
					while(true) {
						if (q.peek() == idx) {
							time++;
							bag[idx]--;
							q.poll();
							if (qr.poll() == 1) {
								break ex;
							}
							if(bag[idx] == 0) idx--;
							break;
						}
						int tmp = q.poll();
						q.offer(tmp);
						tmp = qr.poll();
						qr.offer(tmp);
					}
				}
			}
			System.out.println(time);
		}
	} // 메인 끝
}
