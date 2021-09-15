package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1197_최소스패닝트리_골드4_564ms {
	
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
		int cnt = 0, result = 0;
		for (Edge edge : edgeList) {
			if(union(edge.start, edge.end)) {
				result += edge.weight;
				if(++cnt == V-1) break;
			}
		}
		System.out.println(result);
	} // 메인 끝
}
