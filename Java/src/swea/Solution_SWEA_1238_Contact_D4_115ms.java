package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact_D4_115ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		
		int n, start, biggest;
		int[] numInput;
		boolean[][] con;
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			stk = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(stk.nextToken());
			start = Integer.parseInt(stk.nextToken());
			numInput = new int[n];
			biggest = 0;
			
			stk = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < numInput.length; i++) {
				numInput[i] = Integer.parseInt(stk.nextToken());
				if(numInput[i] > biggest) biggest = numInput[i];
			}
			
			con = new boolean[biggest+1][biggest+1];
			
			for (int i = 0; i < n; i+=2) {
				con[numInput[i]][numInput[i+1]] = true;
				
			}
			
			Queue<Integer> qList = new LinkedList<Integer>();
			int[] visited = new int[biggest];
			
			qList.offer(start);
			visited[start] = 1;
			int lastBig = 0, ans = 0;
			
			while(!qList.isEmpty()) {
				int current = qList.poll();
				
				// visited 에 내가 해당 인덱스를 몇 번에 걸쳐서 간건지 적는다.
				for (int i = 1; i < biggest; i++) {
					if(visited[i] == 0 && con[current][i]) {
						qList.offer(i);
						visited[i] = visited[current] + 1;
					} else continue;
				} 
				lastBig = visited[current];
			}
			
			for (int i = 1; i < biggest; i++) {
				if(lastBig != visited[i]) continue;
				ans = ans > i ? ans : i;
			}
		
			sb.append("#").append(testCase).append(" ").append(ans).append("\n");
		
		} // 테케 끝
		System.out.println(sb);
	} // main 끝
	
} // class 끝

/*

#1 17 
#2 96
#3 49 
#4 39 
#5 49 
#6 1 
#7 28 
#8 45 
#9 59
#10 64 

*/