package algorithm;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4,5,6};
		int[] b = new int[10];
		System.out.println(Arrays.toString(b));
		b = Arrays.copyOfRange(a, 2, 4);
		System.out.println(Arrays.toString(a));
	}
}
