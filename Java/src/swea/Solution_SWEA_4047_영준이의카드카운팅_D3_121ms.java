package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_SWEA_4047_영준이의카드카운팅_D3_121ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		ArrayList<Integer> S = new ArrayList<Integer>(); // 스페이드
		ArrayList<Integer> D = new ArrayList<Integer>(); // 다이아
		ArrayList<Integer> H = new ArrayList<Integer>(); // 하트
		ArrayList<Integer> C = new ArrayList<Integer>(); // 클로버
		String inputStr;
		char shape;
		int num;
		boolean flag = false;
		for (int testCase = 1; testCase <= TC; testCase++) {
			flag = false;
			S.clear();
			D.clear();
			H.clear();
			C.clear();
			inputStr = br.readLine();
			for (int i = 0; i < inputStr.length(); i+=3) {
				shape = inputStr.substring(i, i+1).charAt(0);
				num = Integer.parseInt(inputStr.substring(i+1, i+3));
				switch (shape) {
				case 'S':
					if(S.contains(num)) flag = true;
					S.add(num);
					break;
				case 'D':
					if(D.contains(num)) flag = true;
					D.add(num);
					break;
				case 'H':
					if(H.contains(num)) flag = true;
					H.add(num);
					break;
				case 'C':
					if(C.contains(num)) flag = true;
					C.add(num);
					break;
				}
			}
			if (flag) {
				sb.append("#").append(testCase).append(" ").append("ERROR").append("\n");
			}
			else {
				sb.append("#").append(testCase).append(" ").append(13-S.size()).append(" ").append(13-D.size()).append(" ").append(13-H.size()).append(" ").append(13-C.size()).append("\n");
			}
		}// 테케 끝
		System.out.println(sb);
	}
}
