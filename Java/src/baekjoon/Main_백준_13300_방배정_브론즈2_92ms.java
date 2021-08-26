package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_13300_방배정_브론즈2_92ms {
	public static void main(String[] args) throws IOException {
		// 일단 남자인지 여자인지를 가르고 학년별로 나눠진 배열을 만들어다가
		// 0이면 0, 배정할 수 있는 최대 인원수로 나눴을때 나눠떨어지면 그거로, 안떨어지면 +1 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(stk.nextToken()); // 1~1000
		int K = Integer.parseInt(stk.nextToken()); // 1~1000
		int[][] st = new int[6][2];
		int sex, grade;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			sex = Integer.parseInt(stk.nextToken());
			grade = Integer.parseInt(stk.nextToken());
			st[grade-1][sex]++;
		}
		
		int totalRoom = 0;
		for (int i = 0; i < st.length; i++) {
			for (int j = 0; j < st[i].length; j++) {
				if(st[i][j] != 0) {
					if (st[i][j] % K != 0) totalRoom += st[i][j] / K + 1;
					else totalRoom += st[i][j] / K;
				}
			}
		}
		System.out.println(totalRoom);		
	} // 메인 끝
}
