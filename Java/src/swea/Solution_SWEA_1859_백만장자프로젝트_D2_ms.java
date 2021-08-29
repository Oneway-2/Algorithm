package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1859_백만장자프로젝트_D2_ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		int[] price;
		int[] pCnt = new int[10001]; // 0 원부터 10000 원까지
		for (int testCase = 1; testCase <= TC; testCase++) {
			Arrays.fill(pCnt, 0); // 테케 돌때마다 초기화
			int N = Integer.parseInt(br.readLine()); // 2 <= N <= 1000000 전부 다 시세 알고있음
			price = new int[N];
			stk = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(stk.nextToken());
				pCnt[price[i]]++;
			}
			
			long sum = 0; // 10000 * 1000000 은 최대 백억임 ㄷ
			int day = 0;
			int lastSellDay = 0;
			boolean saleOver = false;
			for (int search = 10000; search >= 0; search--) {
				if (saleOver) break; // 탐색날 이상으로 탐색하려하면 break
				if (pCnt[search] != 0) { // 이만한 가치가 어느날 다가온단 소리니까 이 날이 올때까지 쭉 탐색,
					while(true) {
						if(price[day] == search) {
							for (int i = lastSellDay; i < day; i++) {
								sum += price[day] - price[i];
							}
							lastSellDay = day + 1;
						}
						pCnt[price[day]]--; // 이 가치를 가진 날은 지나갔다.
						day++;
						if (day >= N) {
							for (int i = lastSellDay; i < day-1; i++) {
								if (price[i] < price[day-1]) {
									sum += price[day-1] - price[i];
								}
							}
							saleOver = true;
							break;
						}
						if (pCnt[search] == 0) { 
							break;
						}
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
}	
