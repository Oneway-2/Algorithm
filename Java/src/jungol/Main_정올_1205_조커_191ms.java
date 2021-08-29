package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1205_조커_191ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int jokerCnt = 0;
		int N = Integer.parseInt(br.readLine()); // 1000 보다 작음, 최대 스트레이트 길이는 1000
		int[] cards = new int[N]; // 카드들은 0 이상 1000000 이하
		stk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < cards.length; i++) {
			cards[i] = Integer.parseInt(stk.nextToken());
			if(cards[i] == 0) jokerCnt++;
		}
		Arrays.sort(cards);
		int[] tmpCards = new int[N];
		int howLong = 1, longest = -jokerCnt;
		int jokerUse, idx;
		for (int i = jokerCnt; i < cards.length; i++) {
			howLong = 1;
			tmpCards = Arrays.copyOf(cards, N);
			jokerUse = jokerCnt;
			idx = i;
			while(true) {
				if (idx+1 >= N) { // 남은 카드는 끝났고 남은 joker을 써야할 때
					if (jokerUse == 0) { // 조커가 바닥났다.
						longest = howLong > longest ? howLong : longest;
						break;
					} else { // 아직 남은 조커가 있다.
						jokerUse--;
						howLong++;
					}
				}
				else if (tmpCards[idx+1] == tmpCards[idx]) { // 다음 카드랑 같아버리면?
					idx++;
				}
				else if (tmpCards[idx+1] == tmpCards[idx]+1) { // 다음 카드가 이어진 카드면
					howLong++;
					idx++;
				} else { // 다음 카드가 이어지지 않았다면
					if (jokerUse == 0) { // 조커카드를 써야하는데, 조커가 바닥났다면
						longest = howLong > longest ? howLong : longest;
						break;
					} else { // 아직 남은 조커가 남았다면
						jokerUse--;
						howLong++;
						tmpCards[idx]++;
					}
				}
			} // while 끝
		} // for문 끝
		if(longest < 0) System.out.println(-longest);
		else System.out.println(longest);
	} // 메인 끝
}
