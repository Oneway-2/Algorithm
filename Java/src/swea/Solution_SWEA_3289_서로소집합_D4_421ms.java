package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_D4_421ms {
	
	static int[] parents; // 부모 원소들 관리(트리처럼 사용)

	private static void make(int N) { // make-set
		// 모든 원소를 자신을 대표자로 만듬.
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) { // find-set
		// a가 속한 집합의 대표자 찾기
		if (a == parents[a]) { // 자신이 대표자인 경우
			return a;
		}
		return parents[a] = find(parents[a]); // 자신이 속한 집합이ㅡ 대표자를 자신의 부모로 : path - compression
	}
	
	private static int union(int a, int b) {  // union
		// 두 원소를 하나의 집합으로 합치기 (대표자를 이용해서 합친다.)
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return 1; // 이미 같은 집합이니 합치지 않는다.
		
		parents[bRoot] = aRoot;
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			stk = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(stk.nextToken()); // 1<= n <=1,000,000
			int m = Integer.parseInt(stk.nextToken()); // 1<= m <= 100,000
			
			parents = new int[n+1];
			make(n);
			
			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				int h = Integer.parseInt(stk.nextToken()); // 0 이면 합치기, 1이면 포함되었냐 물어보는거
				int a = Integer.parseInt(stk.nextToken()); 
				int b = Integer.parseInt(stk.nextToken()); 
				if(h == 0) union(a, b);
				else if(h == 1) {
					if(find(a) == find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		} // 테케 끝
		System.out.println(sb);
	} // 메인 끝
} // 클래스 끝

