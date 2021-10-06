package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_9663_nQueen_골드5_5616ms {
	static int N, cnt;
	static int col[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N+1];
		cnt = 0;
		setQueens(1); // 1행부터 놓는 시도.
		System.out.println(cnt);
	}
    
	private static void setQueens(int rowNo) {
		if (!isAvailable(rowNo-1)) {
			return;
		}
		
		if(rowNo > N) { // 마지막행까지 다 둔경우
			cnt++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;
			setQueens(rowNo+1);
		}
	}
	
	private static boolean isAvailable(int rowNo) {
		for (int k = 1; k < rowNo; k++) { // k는 이전 퀸
			if (col[rowNo] == col[k] || Math.abs(col[rowNo] - col[k]) == (rowNo-k)) {
				return false;
			}
		}
		return true;
	}
}
