package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 모든 점들의 a+b 가 홀수거나 짝수여야한다.
// --> 왜냐면 모든 점들의 원점까지의 맨해튼 거리가 짝수가 되어야 하기때문임.
// --> 입력받으며 모든 수가 홀수 or 짝수로 통일되어있는지 확인.
// 2. 입력받으며 동시에 입력값중 최대값을 저장.
// 3. 매 초 이동량의 누적값을 구하여 그 값이 max보다 크면서 max와이 차이가 짝수일 때 종료.

public class Solution_SWEA_8458_원점으로집합_D4_211ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 점 개수
			boolean possible = false;
			int longest = 0, evenCnt = 0, oddCnt = 0;
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				if ((a+b)%2 != 0) oddCnt++;
				else evenCnt++;
				int len = Math.abs(a) + Math.abs(b);
				if(len > longest) longest = len; // 최대값 저장
			}
			// evenCnt 나 oddCnt 중 하나는 0이어야한다.
			if (evenCnt == 0 || oddCnt == 0) possible = true;
			
			int cnt = 0, sum = 0;
			while(possible) {
				sum += cnt;
				if (sum >= longest && (sum-longest)%2==0) {
					break;
				}
				cnt++;
			}
			
			if (!possible) {
				sb.append("#").append(testCase).append(" ").append("-1\n");
			}
			else {
				sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
			}
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
}
