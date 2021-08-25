package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_5356_의석이의세로로말해요_D3_116ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		Queue<Character>[] srr = new Queue[5];
		String inputStr;
		int longest = 0;
		for (int testCase = 1; testCase <= TC; testCase++) {
			for (int i = 0; i < 5; i++) {
				srr[i] = new LinkedList<Character>();
				inputStr = br.readLine();
				for (int j = 0; j < inputStr.length(); j++) {
					srr[i].add(inputStr.charAt(j));
				}
				longest = inputStr.length() > longest ? inputStr.length() : longest;
			}
			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < longest; i++) {
				for (int j = 0; j < 5; j++) {
					if (!srr[j].isEmpty()) {
						sb.append(srr[j].poll());
					}
				}
			}
			sb.append("\n");
		} // 테케 끝
		System.out.println(sb);
	}
}
