package swea;

/**
 * 2021.09.15 HW
 * MST, 크루스칼 알고리즘
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정점 개수 1 <= V <= 100,000
// 간선 개수 1 <= E <= 200,000
// 가중치 값 -1,000,000 <= weight <= 1,000,000
// 최고로 정점과 간선이 많을 때 가중치는 int값을 벗어날 수 있음을 주의

public class Solution_SWEA_3124_최소스패닝트리_D4_2004ms {
	
	static int[] parents;
	static int V, E; // 정점개수, 간선개수
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge> {
		int start, end, weight;
		
		public Edge() {
			// TODO Auto-generated constructor stub
		}
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}

	private static void make() {
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer stk = new StringTokenizer(br.readLine()," ");
			V = Integer.parseInt(stk.nextToken());
			E = Integer.parseInt(stk.nextToken());
			
			edgeList = new Edge[E];
			for (int i = 0; i < E; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(stk.nextToken());
				int end = Integer.parseInt(stk.nextToken());
				int weight = Integer.parseInt(stk.nextToken());
				edgeList[i] = new Edge(start-1, end-1, weight);
			}
			
			Arrays.sort(edgeList);
			make();
			long cnt = 0, result = 0;
			for (Edge edge : edgeList) {
				if(union(edge.start, edge.end)) {
					result += edge.weight;
					if(++cnt == V-1) break;
				}
			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
}
