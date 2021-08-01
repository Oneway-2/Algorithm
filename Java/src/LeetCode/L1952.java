package LeetCode;
/** 1952. Three Divisors */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L1952 {
	public static void main(String[] args) throws IOException{
		Solution s = new Solution();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		boolean result = s.isThree(n);
		System.out.println(result);
	}
}

class Solution
{
	public boolean isThree(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if(n % i == 0) {
				count++;
				if(count >= 4) {
					return false;
				}
			}
		}
		if(count <= 2) {
			return false;
		}
		else if(count == 3) {
			return true;
		}
		
		return false;
	}
}
