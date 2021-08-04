package programmers.bruteforce;

import java.util.Arrays;

public class 카펫 {
	public static void main(String[] args) {
		Solution_카펫 sol = new Solution_카펫();

		int brown = 304;
		int yellow = 56;
		int[] answer = new int[2];
		answer = sol.solution(brown, yellow);
		System.out.println(Arrays.toString(answer));
	}
}

class Solution_카펫 {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		// brown 과 yellow 를 더하면 총 카펫의 개수가 나온다.
		// 총 카펫의 개수를 세로=3,4,5,6.... 이렇게 나눠보고 나눠지는 애는 가로가 구해지므로, 둘을 저장해놓는다.
		// 가로, 세로에 따른 가장자리수 공식에 맞춰 계산한 뒤 그 가장자리의 수가 brown의 갯수와 맞는지 확인한다.
		// 가장자리수 공식 결과가 brown과 맞으면 총 카펫의 개수에서 brown 개수 빼면 yellow 나온다.
		// 둘이 들어맞는다? 구했던 가로,세로를 배열에 담아 return

		int totalCarpets = brown + yellow;
		for (int sero = 3; sero < totalCarpets; sero++) { // 어차피 totalCarpets 까지 가기전에 break될거다.
			if (totalCarpets % sero == 0) { // 나누어지는 애는 탐구해볼 가치가 있다.
				int garo = totalCarpets / sero;
//				System.out.printf("세로가%d, 가로가%d 탐구중\n",sero, garo);
				int seroTurn, garoTurn;
				
				if (sero % 2 != 0) { // 세로가 홀수면 반복할 수는 sero/2, 짝수면 sero/2 - 1
					seroTurn = sero / 2;
				} else {
					seroTurn = sero / 2 - 1;
				}
				if (garo % 2 != 0) { // 가로가 홀수면 반복할 수는 garo/2, 짝수면 garo/2 - 1
					garoTurn = garo / 2;
				} else {
					garoTurn = garo / 2 - 1;
				}
				
				int edge = 0;
				for (int i = 1; i <= seroTurn; i++) {
					for (int j = 1; j <= garoTurn; j++) {
						edge = garo * (i * 2) + (sero - i * 2) * j * 2;
//						System.out.printf("현재 %dx%d인 판을 보는중, %d * %d + %d * %d 해서 edge == %d, brown == %d\n",garo, sero, garo, i*2, sero-i*2, j*2, edge, brown);
						if (edge == brown) { // edge수가 brown수와 맞으면 찾았다 요놈
							answer[0] = garo;
							answer[1] = sero;
							return answer;
						}
					}
				}
			}
		}
		return null;
	}
}