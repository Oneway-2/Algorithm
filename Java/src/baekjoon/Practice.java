package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice {
	static int N;
	static int R;
	static int[] numbers;
	static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());
		input = new int[N];
		numbers = new int[R];

		stk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}

		Permu(0, 0);
		System.out.println();
		Combi(0, 0);
		System.out.println();

		dPermu(0);
	}

	private static void Combi(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			Combi(cnt + 1, i);
		}
	}

	private static void Permu(int cnt, int flag) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			numbers[cnt] = input[i];
			Permu(cnt + 1, flag | 1 << i);
		}

	}

	private static void dPermu(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			numbers[cnt] = input[i];
			dPermu(cnt + 1);

		}

	}
}