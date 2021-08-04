package baekjoon;
import java.io.*;
import java.util.StringTokenizer;
public class J20361 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int X = Integer.parseInt(stk.nextToken()); // ball is in X
		int K = Integer.parseInt(stk.nextToken()); 
		
		int a, b;
		for (int i = 0; i < K; i++) {
			StringTokenizer steps = new StringTokenizer(br.readLine());
			a = Integer.parseInt(steps.nextToken());
			b = Integer.parseInt(steps.nextToken());
			if (X != a && X != b) {
				continue;
			}else if (X == a) {
				X = b;
			}else if (X == b) {
				X = a;
			}
		}
		System.out.println(X);
	}
}
