package leetCode;

import java.util.Scanner;

/** 1954. Minimum Garden Perimeter to Collect Enough Apples */
public class L1954 {
	public static void main(String[] args) {
		Solution1954 sol = new Solution1954();
		Scanner sc = new Scanner(System.in);
		long neededApples = sc.nextLong();
		long perimeter = sol.minimumPerimeter(neededApples);
		System.out.println(perimeter);
	}
}

class Solution1954 {
	public long minimumPerimeter(long neededApples) {
		long n = 0;
        long acc = 2*n*(n+1)*(2*n+1);
        long peri = 0;
        while(acc < neededApples) {
        	n++;
        	acc = 2*n*(n+1)*(2*n+1);
        }
		peri = 8 * n;
		return peri;
    }
}
