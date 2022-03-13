package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1063_킹_실버4_128ms {
	public static void main(String[] args) throws IOException {
		int[] dr = {0,0,1,-1,-1,-1,1,1};
		int[] dc = {1,-1,0,0,1,-1,1,-1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		String a1 = stk.nextToken();
		String a2 = stk.nextToken();
		int N = Integer.parseInt(stk.nextToken());
		String k1 = a1.substring(0,1);
		int k2 = Integer.parseInt(a1.substring(1,2));
		String r1 = a2.substring(0,1);
		int r2 = Integer.parseInt(a2.substring(1,2));
		
		int k11=0, k22=8-k2, r11=0, r22=8-r2;
		if ("A".equals(k1)) k11=0;
		else if ("B".equals(k1)) k11=1;
		else if ("C".equals(k1)) k11=2;
		else if ("D".equals(k1)) k11=3;
		else if ("E".equals(k1)) k11=4;
		else if ("F".equals(k1)) k11=5;
		else if ("G".equals(k1)) k11=6;
		else if ("H".equals(k1)) k11=7;
		if ("A".equals(r1)) r11=0;
		else if ("B".equals(r1)) r11=1;
		else if ("C".equals(r1)) r11=2;
		else if ("D".equals(r1)) r11=3;
		else if ("E".equals(r1)) r11=4;
		else if ("F".equals(r1)) r11=5;
		else if ("G".equals(r1)) r11=6;
		else if ("H".equals(r1)) r11=7;
		
		int[][] map = new int[8][8];
		map[k22][k11] = 1;
		map[r22][r11] = 2;
		int kr = k22, kc = k11;
		int rr = r22, rc = r11;
		
		for (int i = 0; i < N; i++) {
			String d = br.readLine();
			int d1 = 0;
			boolean over = false;
			if ("R".equals(d)) d1 = 0;
			else if ("L".equals(d)) d1 = 1;
			else if ("B".equals(d)) d1 = 2;
			else if ("T".equals(d))d1 = 3;
			else if ("RT".equals(d))d1 = 4;
			else if ("LT".equals(d)) d1 = 5;
			else if ("RB".equals(d))d1 = 6;
			else if ("LB".equals(d))d1 = 7;
			int nr = kr + dr[d1];
			int nc = kc + dc[d1];
			int rnr=0, rnc=0;
			if (nr == rr && nc == rc) {
				over = true;
				rnr = rr + dr[d1];
				rnc = rc + dc[d1];
				if (0>rnr || rnr>=8 || 0>rnc || rnc>=8) {
					continue;
				}
			}
			if (0>nr || nr>=8 || 0>nc || nc>=8) {
				continue;
			}
			if (over) {
				map[rnr][rnc] = 2;
				map[rr][rc] = 0;
				rr = rnr;
				rc = rnc;
			}
			map[nr][nc] = 1;
			map[kr][kc] = 0;
			kr = nr;
			kc = nc;
		}
		String q1="", q2=Integer.toString(8-kr), w1="", w2=Integer.toString(8-rr);
		if (kc == 0) q1 = "A";
		else if (kc == 1) q1 = "B";
		else if (kc == 2) q1 = "C";
		else if (kc == 3) q1 = "D";
		else if (kc == 4) q1 = "E";
		else if (kc == 5) q1 = "F";
		else if (kc == 6) q1 = "G";
		else if (kc == 7) q1 = "H";
		if (rc == 0) w1 = "A";
		else if (rc == 1) w1 = "B";
		else if (rc == 2) w1 = "C";
		else if (rc == 3) w1 = "D";
		else if (rc == 4) w1 = "E";
		else if (rc == 5) w1 = "F";
		else if (rc == 6) w1 = "G";
		else if (rc == 7) w1 = "H";
		String q = q1.concat(q2);
		String w = w1.concat(w2);
		System.out.println(q);
		System.out.println(w);
	} // 메인 끝
}

