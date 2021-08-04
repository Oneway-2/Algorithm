package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스위치 켜고 끄기
 * 백준 1244번
 * 실버4
 * 84ms
 */
public class J1244_S4 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] switches = new int[N];
		for (int i = 0; i < N; i++) {
			switches[i] = Integer.parseInt(stk.nextToken());
		}
		int S = Integer.parseInt(br.readLine());
		int[][] ctrl = new int[S][2];
		for (int i = 0; i < S; i++) {
			StringTokenizer stk2 = new StringTokenizer(br.readLine());
			ctrl[i][0] = Integer.parseInt(stk2.nextToken());
			ctrl[i][1] = Integer.parseInt(stk2.nextToken());
		}
		
//		System.out.println(Arrays.toString(switches));
		
		for (int i = 0; i < S; i++) {
			if(ctrl[i][0] == 1) { // 남자
				for (int j = ctrl[i][1]; j <= N; j += ctrl[i][1]) { // 1 <= j <= N
					switches[j-1] = onoff(switches[j-1]);
				}
			}
			
			else { // 여자
				for (int k = 0; k < N; k++) { // 어차피 N까지 가기전에 break됨
					if (k == 0) { // 최초 1개는 무조건 onoff됨
						switches[ctrl[i][1] - 1] = onoff(switches[ctrl[i][1] - 1]);
					}
					else if (ctrl[i][1]-1+k > N-1 || ctrl[i][1]-1-k < 0) {
//						System.out.println("범위를 넘어버림.");
						break;
					}
					else {
						if (switches[ctrl[i][1]-1+k] == switches[ctrl[i][1]-1-k]) {
							switches[ctrl[i][1]-1+k] = onoff(switches[ctrl[i][1]-1+k]);
							switches[ctrl[i][1]-1-k] = onoff(switches[ctrl[i][1]-1-k]);
						}
						else {
							break;
						}
					}
				}
			}
//			System.out.println(Arrays.toString(switches));
		}
		int over20 = 0;
		for (int i = 0; i < N; i++) {
			System.out.print(switches[i]+" ");
			over20++;
			if (over20 >= 20) {
				System.out.println();
				over20 = 0;
			}
		}
			
	} //end of main
	
	private static int onoff(int a) {
		if (a == 0) a++;
		else a--;
		return a;
	}
} //end of class

// 아 마지막에 20개마다 한 줄 내려쓰는거 잊어먹고 틀려버렸네 후
