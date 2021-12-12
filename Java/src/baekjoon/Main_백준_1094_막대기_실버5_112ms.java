package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_백준_1094_막대기_실버5_112ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); // 1 <= x <= 64
		int sum = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(64);
		while(true) {
			sum = 0;
			for (int i = 0; i < arr.size(); i++) {
				sum += arr.get(i);
			}
			// 가지고있는 막대의 길이를 다 더했더니 x보다 크다.
			if (sum > x) {
				// 1. 가장 짧은애를 절반으로 자른다.
				int temp = arr.get(arr.size()-1); 
				temp /= 2;
				// 2. 절반 중 하나를 버리고 남아있는 막대의 합이 몇인지?
				arr.remove(arr.size()-1);
				arr.add(temp);
				int tempsum = 0;
				for (int i = 0; i < arr.size(); i++) {
					tempsum += arr.get(i);
				}
				// 그것이 X보다 크거나 같다면 위에서 자른 막대 중 하나를 버린다.
				// 반대로 말하면 그것이 X보다 작다면 버리지 않고 챙기는거
				if (tempsum < x) {
					arr.add(temp);
				}
			}
			// 가지고있는 막대의 길이를 다 더했더니 x보다 작아졌다.
			else {
				break;
			}
		} // while 끝
		System.out.println(arr.size());	
	} // 메인 긑
}
