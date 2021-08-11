package programmers.sorting;

//import java.util.Arrays;

public class H_Index {
	public static void main(String[] args) {
		Solution_HIndex sol = new Solution_HIndex();
		
//		int[] citations = new int[] {3,0,6,1,5};
//		int[] citations = new int[] {88,89};
//		int[] citations = new int[] {0,10,10,3,3,6,6,9,8,7,7};
//		int[] citations = new int[] {0,0,0,0,1};
//		int[] citations = new int[] {1,1,1,1,500,800};
//		int[] citations = new int[] {1,2,3,500,800};
//		int[] citations = new int[] {6,6,6,6,6,6};
//		int[] citations = new int[] {0,1,2,3,4,5,6,7,8,9};
//		int[] citations = new int[] {123,123,123,123,123,123,123,123,123};
		int[] citations = new int[] {10,10,10,10,10,10};
		
		System.out.println(sol.solution(citations));
	}
	
}

class Solution_HIndex {
	public int solution(int[] citations) {
//		Arrays.sort(citations);
		int answer = 0;
		
ex:		for (int i = citations.length; i >= 0; i--) {
			int more = 0;
			int less = 0;
			
			for (int j = 0; j < citations.length; j++) {
				if (citations[j] >= i) {
					more++;
				}
				else {
					less++;
				}
				
				if (more >= i && less <= i) {
					answer = i;
					break ex;
				}
			}
		}
		return answer;
	}
}
