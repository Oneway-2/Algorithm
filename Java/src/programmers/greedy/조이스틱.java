package programmers.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 조이스틱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution_조이스틱 sol = new Solution_조이스틱();
		String str = br.readLine();
		System.out.println(sol.solution(str));
	}
}


class Solution_조이스틱 {
    public int solution(String name) {
    	int first = Judge(name.charAt(0));
    	int forwardCnt = first;
    	int backCnt = first;
    	// 다시 생각해
    	
    	
    	
    	
    	int answer = forwardCnt >= backCnt ? forwardCnt : backCnt;
    	
        return answer;
    }
    
    private int Judge(char a) {
    	if(a >= 'N') {
    		return 'Z' - a;
    	} 
    	else if(a < 'N') {
    		return a - 'A';
    	}
    	return 0;
    }
}