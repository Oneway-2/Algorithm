package baekjoon;

import java.io.*;
//import java.math.BigInteger;

/** 나머지와 몫이 같은 수 */
public class J1834 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		long N = Integer.parseInt(br.readLine());
//		long first = (N * (N + 1)) / 2;
//		BigInteger second = new BigInteger(Long.toString(first));
//		BigInteger third = new BigInteger(Long.toString(N-1));
//		System.out.println(second.multiply(third));
		
		long N = Long.parseLong(br.readLine());
		long sum = ((N + 1) * (N - 1) * N) / 2;
		System.out.println(sum);
	}
}

// 처음에 int*int 한걸 long에 박아서 오류난걸, long 범위안에 못넣는 줄 알고 BigInteger 같은거 찾아보고 자빠졌었네..