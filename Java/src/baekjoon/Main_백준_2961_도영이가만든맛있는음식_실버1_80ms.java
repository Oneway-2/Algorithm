package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 제한시간 1초
 * 실행시간 80ms
 */
public class Main_백준_2961_도영이가만든맛있는음식_실버1_80ms {
	static int N, R;
	static int[] sour, bitter;
	static int[] cSour, cBitter;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(stk.nextToken());
			bitter[i] = Integer.parseInt(stk.nextToken());
		}
		
		for (int R = 1; R <= N; R++) {
			cSour = new int[R];
			cBitter = new int[R];
			cal(0, 0, R);
		}
		
		System.out.println(min);
	}
	
	private static void cal(int cnt, int start, int R){
		if(cnt == R) {
			
			int cSourMul = 1;
			int cBitterSum = 0;
			int diff = 0;
			
			for (int i = 0; i < R; i++) {
				cSourMul *= cSour[i];
				cBitterSum += cBitter[i];
			}
			
			diff = Math.abs(cSourMul - cBitterSum);
			min = Math.min(diff,  min);
//			System.out.println("cSour = " + Arrays.toString(cSour) + " cBitter = " + Arrays.toString(cBitter) + " cSourMul = " + cSourMul + " cBitterSum = " + cBitterSum + " min = " + min);
			return;
		}
		
		for (int i = start; i < N; i++) {
			cSour[cnt] = sour[i];
			cBitter[cnt] = bitter[i];
			
			cal(cnt+1, i+1, R);
		}
	}
}
