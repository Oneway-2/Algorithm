package programmers.kakao;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 순위검색 {
	public static void main(String[] args) {
		 String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		 String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		 Solution_순위검색 sol = new Solution_순위검색();
		 int[] result = sol.solution(info, query);
		 System.out.println(Arrays.toString(result));
		 
	} // 메인 끝
	
}

class Solution_순위검색 {
	public int[] solution(String[] info, String[] query) {
        int infolen = info.length;
        int querylen = query.length;
        String[][] sinfo = new String[infolen][5];
        String[][] squery = new String[querylen][5];
        
        // DB처럼 저장
        for (int i = 0; i < infolen; i++) {
        	sinfo[i] = info[i].split(" ");
		}
        String[] temp;
        for (int i = 0; i < querylen; i++) {
        	temp = query[i].split(" and ");
        	squery[i][0] = temp[0];
        	squery[i][1] = temp[1];
        	squery[i][2] = temp[2];
        	temp = temp[3].split(" ");
        	squery[i][3] = temp[0];
        	squery[i][4] = temp[1];
		}
        
        boolean[] survivor = new boolean[infolen];
        int[] answer = new int[querylen];
        for (int i = 0; i < querylen; i++) {
        	Arrays.fill(survivor, true);
        	// String check
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < infolen; k++) {
					// - 인 경우 전부 pass
					if (squery[i][j].equals("-")) {
						continue;
					}
					else if (!squery[i][j].equals(sinfo[k][j])) {
						survivor[k] = false;
					}
				}
			}
			// Integer check
			for (int k = 0; k < infolen; k++) {
				int sinfonum = Integer.parseInt(sinfo[k][4]);
				int squerynum = Integer.parseInt(squery[i][4]);
				if (squerynum > sinfonum) {
					survivor[k] = false;
				}
			}
			// count true from survivor
			int count = 0;
			for (int j = 0; j < survivor.length; j++) {
				if (survivor[j]) count++;
			}
			answer[i] = count;
		}
        return answer;
    }
}