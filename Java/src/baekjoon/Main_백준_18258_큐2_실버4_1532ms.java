package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_백준_18258_큐2_실버4_1532ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if ("pop".equals(input)) {
				if (q.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(q.pollFirst()).append("\n");
				}
			} else if ("size".equals(input)) {
				sb.append(q.size()).append("\n");
			} else if ("empty".equals(input)) {
				if (q.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else if ("front".equals(input)) {
				if (q.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(q.getFirst()).append("\n");
				}
			} else if ("back".equals(input)) {
				if (q.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(q.getLast()).append("\n");
				}
			} else { // push
				int num = Integer.parseInt(input.split(" ")[1]);
				q.offer(num);
			}
		}
		System.out.println(sb);
	} // 메인 끝
}
