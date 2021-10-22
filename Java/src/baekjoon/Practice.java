package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Practice {
	
	static class Pair {
		int x;
		int y;
		public Pair() {
			// TODO Auto-generated constructor stub
		}
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		HashSet<Pair> h = new HashSet<Pair>();
		h.add(new Pair(0, 1));
		h.add(new Pair(0, 0));
		System.out.println(h.size());
		System.out.println(h.toString());
		System.out.println(h.contains(new Pair(0, 0)));
		System.out.println(h.contains(new Pair(1, 0)));
	}
		
}

