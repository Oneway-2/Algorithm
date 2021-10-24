package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_3048_개미_실버4_72ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(stk.nextToken());
		int n2 = Integer.parseInt(stk.nextToken());
		String g1 = br.readLine();
		String g2 = br.readLine();
		int sec = Integer.parseInt(br.readLine());
		char[] arr = new char[n1+n2];
		for (int i = 0, j = n1-1; i < n1; i++, j--) {
			arr[i] = g1.charAt(j);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int a = 0; a < sec; a++) {
			for (int i = 1; i < arr.length; i++) {
				if ('A' > arr[i] || arr[i] > 'Z') {
					q.add(i++);
				}
			}
			while(q.size() > 0) {
				swap(q.poll(), arr);
			}
		}
		
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if ('A' > arr[i] || arr[i] > 'Z') {
				arr[i] = g2.charAt(idx++);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	} // 메인 끝
	private static void swap(int i, char[] arr) {
		char temp = arr[i-1];
		arr[i-1] = arr[i];
		arr[i] = temp;
	}
}
