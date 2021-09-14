package baekjoon;
/**
 * 2021.09.14 WS
 */
import java.util.Scanner;

public class Main_백준_1463_1로만들기_실버3_136ms {
	static int[] D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N < 3) D = new int[4];
		else D = new int[N+1];
		D[0] = 0;
		D[1] = 0;
		D[2] = 1;
		D[3] = 1;
		for (int i = 4; i <= N; i++) {
			D[i] = D[i-1] + 1;
			if (i % 2 == 0) {
				D[i] = Math.min(D[i/2] + 1, D[i]);
			}
			if (i % 3 == 0) {
				D[i] = Math.min(D[i/3] + 1, D[i]);
			}
		}
		System.out.println(D[N]);
	} // 메인 끝
}
