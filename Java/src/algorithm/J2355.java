package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J2355 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		long A = Long.parseLong(stk.nextToken());
		long B = Long.parseLong(stk.nextToken());
		long result = 0;
		if (A >= B){
			result = (A * (A+1) - B * (B-1)) / 2;
			System.out.println(result);
		} else if(B > A) {
			result = (B * (B+1) - A * (A-1)) / 2;
			System.out.println(result);
		}
	}
}

// 5 5 와 같은 입력일 경우 A,B를 둘다 포함시켜 더해야한다 생각해서 A==B 일 경우 A*2 와 같은 출력을 계속 해가지고 여러번 틀렸다. 멍청이