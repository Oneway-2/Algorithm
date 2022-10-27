package programmers.graph;

import java.util.HashSet;

public class 방의개수 {
	public static void main(String[] args) {
		Solution_방의개수 sol = new Solution_방의개수();
		int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
//		int[] arrows = {6,6,4,2,2,4,6,6,4,2,2,7,0,0,2};
//		int[] arrows = {6,6,6,1,4,2,7,4};
//		int[] arrows = {6,6,6,1,4,7,2,3};
//		int[] arrows = {2,4,6,0,3,0,5};
		int result = sol.solution(arrows);
		System.out.println(result);
	}
}

class Solution_방의개수 {
	class Pair{
		int x;
		int y;
		public Pair() {	}
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
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
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		private Solution_방의개수 getOuterType() {
			return Solution_방의개수.this;
		}
	}
	
	class EdgePair {
		int x, y, nx, ny;
		public EdgePair() {}
		public EdgePair(int x, int y, int nx, int ny) {
			this.x = x;
			this.y = y;
			this.nx = nx;
			this.ny = ny;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + nx;
			result = prime * result + ny;
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
			EdgePair other = (EdgePair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (nx != other.nx)
				return false;
			if (ny != other.ny)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		private Solution_방의개수 getOuterType() {
			return Solution_방의개수.this;
		}
		
	}
	
    public int solution(int[] arrows) {
    	HashSet<Pair> p = new HashSet<Pair>();
    	HashSet<EdgePair> EdgeVisit = new HashSet<EdgePair>();
        int answer = 0;
    	int[] dx = {0, 1, 1, 1, 0,-1,-1,-1};
    	int[] dy = {1, 1, 0,-1,-1,-1, 0, 1};
    	int x = 0, y = 0;
    	p.add(new Pair(0, 0));
    	for (int i = 0; i < arrows.length; i++) {
			for (int j = 0; j < 2; j++) {
				int nx = x + dx[arrows[i]];
				int ny = y + dy[arrows[i]];
				if (p.contains(new Pair(nx, ny)) && !EdgeVisit.contains(new EdgePair(x, y, nx, ny))) {
					EdgeVisit.add(new EdgePair(x, y, nx, ny));
					EdgeVisit.add(new EdgePair(nx, ny, x, y));
					answer++;
					x = nx;
					y = ny;
					continue;
				}
				
				p.add(new Pair(nx, ny));
				EdgeVisit.add(new EdgePair(x, y, nx, ny));
				EdgeVisit.add(new EdgePair(nx, ny, x, y));
				x = nx;
				y = ny;
			}
		}
        return answer;
    }
}
