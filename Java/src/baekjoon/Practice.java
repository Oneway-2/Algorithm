package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Practice {
	
	static class Pair {
		int[] x;
		public Pair() {
			// TODO Auto-generated constructor stub
		}
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
		@Override
		public String toString() {
			return "Pair [x=" + Arrays.toString(x) + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		HashSet<Pair> h = new HashSet<Pair>();
		int[] x = new int[] {0,0,0,0};
		h.add(new Pair(x));
//		h.add(new Pair(new int[] {0,0,0,0}));
		h.add(new Pair(new int[] {1,1,1,1}));
		System.out.println(h.size());
		System.out.println(h.toString());
		System.out.println(h.contains(new Pair(new int[] {1,0})));
		System.out.println(h.contains(new Pair(new int[] {1,1,1,1})));
	}
		
}

