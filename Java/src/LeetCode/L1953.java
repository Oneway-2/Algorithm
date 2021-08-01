package LeetCode;
/** 1953. Maximum Number of Weeks for Which You Can Work */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class L1953 {
	public static void main(String[] args) throws IOException{
		
		int[] inputArr = new int[] {1,2,4,7};
		long count = 0;
		count = numberOfWeeks(inputArr);
//		System.out.println();
		System.out.println(count);
	}
	
	public static long numberOfWeeks(int[] milestones) {
//		if (milestones.length <= 0) {
//			return 0;
//		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		long count = 0;
		int maxTemp = 0, temp = 0;
		
		for (int i = 0; i < milestones.length; i++) { // ArrayList 로 대입
			arr.add(milestones[i]);
		}

		Collections.sort(arr); // 정렬
		
//		for (Integer i : arr) {  // 한번 프린트해보자
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		// 최초 1회 실행
		arr.set(arr.size()-1, arr.get(arr.size()-1)-1);  // 가장큰거 1감소
		maxTemp = arr.remove(arr.size()-1);  // 가장큰거 임시보관
//		if (maxTemp < 0) {
//			return 0;
//		}
		count++;
		
//		for (Integer i : arr) {  // 한번 프린트해보자
//			System.out.print(i + " ");
//		}
//		System.out.printf("maxTemp = %d  count = %d", maxTemp, count);		
//		System.out.println();
		
		while(arr.get(arr.size()-1) != 0) {
			arr.set(arr.size()-1, arr.get(arr.size()-1)-1);
			
//			for (Integer i : arr) {  // 한번 프린트해보자
//				System.out.print(i + " ");
//			}
//			System.out.println();
			
			Collections.sort(arr);
			temp = arr.remove(arr.size()-1);
			arr.add(maxTemp);
			maxTemp = temp;
			Collections.sort(arr);
			count++;
			
//			for (Integer i : arr) {  // 한번 프린트해보자
//				System.out.print(i + " ");
//			}
//			System.out.printf("maxTemp = %d  count = %d", maxTemp, count);		
//			System.out.println();
		}
		
		return count;
	}
	
}

