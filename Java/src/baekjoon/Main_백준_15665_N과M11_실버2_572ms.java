package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_백준_15665_N과M11_실버2_572ms {
	
	static class Pair {
		int[] x;
		public Pair() {}
		public Pair(int[] x) {
			super();
			this.x = x;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(x);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!Arrays.equals(x, other.x))
				return false;
			return true;
		}
	}
	
	private static int N, M;
	private static int[] numbers, arr;
	private static StringBuilder sb;
	private static HashSet<Pair> p = new HashSet<Pair>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		arr = new int[N];
		numbers = new int[M];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr);
		per(0);
		System.out.println(sb);
	} // 메인 끝
	private static void per(int cnt) {
		// 중복순열
		if (cnt == M) {
			if (!p.contains(new Pair(numbers))) {
				for (int i = 0; i < numbers.length; i++) {
					sb.append(numbers[i]).append(" ");
				}
				sb.append("\n");	
			}
			p.add(new Pair(numbers));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			numbers[cnt] = arr[i];
			per(cnt+1);
		}
	}
}
