package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 제한시간: 1000ms
 * 실행시간: 202ms
 */
public class Main_정올_1828_냉장고_202ms {
	
	static class Chemical implements Comparable<Chemical>{
		int min;
		int max;
		
		public Chemical(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "Chemical [min=" + min + ", max=" + max + "]";
		}
		
		public int compareTo(Chemical o ) {
			int value = this.max - o.max;
			if(value != 0) return value;
			return this.min - o.min;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int N = Integer.parseInt(br.readLine()); // 1 <= N <= 100
		Chemical[] chem = new Chemical[N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			chem[i] = new Chemical(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
		}
		
		Arrays.sort(chem);
		
		int refCount = 1;
		int newMax = chem[0].max;
		for (int i = 1; i < chem.length; i++) {
			if (chem[i].min > newMax) {
				newMax = chem[i].max;
				refCount++;
			}
		}
		System.out.println(refCount);
	}
}
