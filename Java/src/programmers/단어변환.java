package programmers.dfs_bfs;


public class 단어변환 {
	public static void main(String[] args) {
		Solution_단어변환 sol = new Solution_단어변환();
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		int result;
		result = sol.solution(begin, target, words);
		System.out.println(result);
	}
}


class Solution_단어변환 {
    private boolean[] visited;
	private int answer;
	private String target;

	public int solution(String begin, String tar, String[] words) {
		int size = words.length;
    	answer = 987654321;
    	visited = new boolean[size];
    	target = tar;
    	
    	for (int i = 0; i < size; i++) {
			if (checkOneSame(begin, words[i])) {
				visited[i] = true;
				dfs(i, words, 1);
			}
		}
    	if(answer == 987654321) return 0;
        return answer;
    }

	private void dfs(int i, String[] words, int step) {
		if (words[i].equals(target)) {  // 와 이부분 == 쓰고있다가 계속틀렸네 하....
			if(answer > step) answer = step;
		}
		
		for (int j = 0; j < visited.length; j++) {
			if (!visited[j] && checkOneSame(words[i], words[j])) {
				visited[j] = true;
				dfs(j, words, step+1);
				visited[j] = false;
			}
		}
	}

	private boolean checkOneSame(String begin, String target) {
		int cnt = 0;
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) == target.charAt(i)) {
				cnt++;
			}
		}
		int dif = begin.length() - cnt;
		if (dif == 1) return true;
		else return false;
	}
} // solution 끝