package programmers.graph;

import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
	public static void main(String[] args) {
		Solution_가장먼노드 sol = new Solution_가장먼노드();
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int result = sol.solution(n, vertex);
		System.out.println(result);
		
	} // 메인
	
	// 가장 깊은애를 찾아야 하니까 dfs를 썼는데 시간초과, 메모리초과 뜨고 심지어 몇개는 걍 틀려버림.
	// bfs를 써보자. -> 인접행렬로 했더니 마지막 2문제가 메모리초과 떠버림. 
	// bfs를 쓰면서 인접리스트 써보자..
}	

class Solution_가장먼노드 {
	
	static class Node {
		int vertex;
		Node link;
		public Node() {	}
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	public int solution(int n, int[][] edge) {
		int maxDepth = 0, cnt = 0, size = edge.length;
    	boolean[] visited = new boolean[n+1];
    	Node[] adjList = new Node[n+1];
		
    	for (int i = 0; i < size; i++) {
			int from = edge[i][0];
			int to = edge[i][1];
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		visited[1] = true;
		q.offer(new int[] {1, 0});
		
		while(q.size() > 0) {
			int i = q.peek()[0];
			int depth = q.poll()[1];
			if(depth > maxDepth) {
				maxDepth = depth;
				cnt = 0;
			}
			if(depth == maxDepth) cnt++;
			
			for(Node temp = adjList[i]; temp != null ; temp = temp.link) {
				if(!visited[temp.vertex]) {
					q.offer(new int[] {temp.vertex, depth+1});
					visited[temp.vertex] = true;
				}
			}
		} // while 끝
        return cnt;
    }
}