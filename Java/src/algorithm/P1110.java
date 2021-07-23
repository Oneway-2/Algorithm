package algorithm;

import java.io.*;

public class P1110 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int length = 0;
		int ox = x;
		while(true) {
			int nx = (ox / 10) + ox % 10;
			nx %= 10;
			nx += (ox % 10) * 10;
			length++;
			if(nx == x) break;
			ox = nx;
		}
		System.out.println(length);
	}
}
