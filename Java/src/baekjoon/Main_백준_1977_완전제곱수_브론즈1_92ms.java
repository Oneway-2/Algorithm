package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1977_완전제곱수_브론즈1_92ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// M과 N은 10000 이하이기 때문에 100x100 인 경우가 젤 큰거.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] save = new int[100]; // 1*1 ~ 100*100;
		for (int i = 1; i <= 100; i++) {
			save[i-1] = i*i; 
		}
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0, min = 100000;
		for (int i = 0; i < save.length; i++) {
			if(M <= save[i] && N >= save[i]) {
				sum += save[i];
				min = min < save[i] ? min : save[i];
			}
		}
		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	} // 메인 끝
}
