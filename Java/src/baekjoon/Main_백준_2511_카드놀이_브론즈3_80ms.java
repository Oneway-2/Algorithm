package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2511_카드놀이_브론즈3_80ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A = new int[10];
		int[] B = new int[10];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(stk.nextToken());
		}
		stk = new StringTokenizer(br.readLine(), " " );
		for (int i = 0; i < B.length; i++) {
			B[i] = Integer.parseInt(stk.nextToken());
		}
		int aScore = 0;
		int bScore = 0;
		char lastWinner = 'D';
		for (int i = 0; i < B.length; i++) {
			if (A[i] == B[i]) { // 비겼을경우
				aScore++;
				bScore++;
			}
			else if(A[i] > B[i]) { // A가 이겼을경우
				aScore += 3;
				lastWinner = 'A';
			}
			else if(A[i] < B[i]) { // B가 이겼을경우
				bScore += 3;
				lastWinner = 'B';
			}
		}
		System.out.println(aScore + " " + bScore);
		if (aScore == bScore) {
			System.out.println(lastWinner);
		}
		else if (aScore > bScore) {
			System.out.println("A");
		}
		else {
			System.out.println("B");
		}
	} // 메인 끝
}
