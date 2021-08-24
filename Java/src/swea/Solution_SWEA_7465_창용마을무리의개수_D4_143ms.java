package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 2021.08.24 화 HW
 *
 */
public class Solution_SWEA_7465_창용마을무리의개수_D4_143ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		int[] vChecker;
		int[][] relationMatrix;
		int groupCnt;
		for (int testCase = 1; testCase <= TC; testCase++) {
			groupCnt = 0;
			stk = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(stk.nextToken());
			int E = Integer.parseInt(stk.nextToken());
			
			vChecker = new int[N+1]; // 1번부터 N번까지 빌리져들 체크
			relationMatrix = new int[N+1][N+1];
			for (int i = 0; i < E; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				relationMatrix[from][to] = relationMatrix[to][from] = 1;
			}
			
			for (int start = 1; start < vChecker.length; start++) {
				if(vChecker[start] == 0) {
					groupCnt++;
					// bfs START
					Queue<Integer> queue = new LinkedList<Integer>();
					
					queue.offer(start);
					vChecker[start] = start;
					
					while(!queue.isEmpty()) {
						int current = queue.poll();
						
						for (int i = 0; i <= N; i++) {
							if(vChecker[i] == 0 && relationMatrix[current][i] != 0) {
								queue.offer(i);
								vChecker[i] = start;
							}
						}
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(groupCnt).append("\n");
		} // 테케 끝
		System.out.println(sb);
	}
}


/* output
#1 2
#2 1	
*/
