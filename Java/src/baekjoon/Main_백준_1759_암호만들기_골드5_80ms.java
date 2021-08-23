package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1759_암호만들기_골드5_80ms {
	
	private static String[] alpa;
	private static String[] possible;
	private static int L; // 뽑아야 할 개수
	private static int C; // 총 문자 개수
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		L = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		alpa = new String[C];
		possible = new String[L];
		stk = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < alpa.length; i++) {
			alpa[i] = stk.nextToken();
		}
		
		Arrays.sort(alpa);
		getKey(0 ,0);
		System.out.println(sb);
	}
	
	private static void getKey(int cnt, int start) {
		if(cnt == L) {
			
			StringBuilder tempSb = new StringBuilder();
			int countMoum = 0; // 1개 이상
			int countJaum = 0; // 2개 이상
			
			// 일단 tempSb를 통해 str로 만들어보자.
			// 모음이 들어있나 검사. 모음이 들어있으면 sb에 담는다.
			// 자음이 최소 2개 이상 들어있나도 검사.
			for (int i = 0; i < possible.length; i++) {
				if (possible[i].contains("a") || possible[i].contains("e") || possible[i].contains("i") || possible[i].contains("o") || possible[i].contains("u")) {
					countMoum++;
				} else {
					countJaum++;
				}
				
				tempSb.append(possible[i]);
			}
			
			if (countMoum >= 1 && countJaum >= 2) {
				sb.append(tempSb.toString()).append("\n");
			}

			return;
		}
		
		for (int i = start; i < C; i++) {
			possible[cnt] = alpa[i];
			getKey(cnt + 1, i + 1);
		}
	}
}	
