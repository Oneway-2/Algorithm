package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(3);
		q.offer(5);
		q.offer(7);
		q.offer(9);
		
		System.out.println(q.contains(9));
		System.out.println(q.contains(8));
		System.out.println(q.contains(7));
		System.out.println(q.contains(6));
		
	}
	

		
}

