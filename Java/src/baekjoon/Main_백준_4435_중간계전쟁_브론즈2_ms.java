package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_4435_중간계전쟁_브론즈2_ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int[] gandalph = new int[6];
		int[] sauron = new int[7];
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < gandalph.length; j++) {
				gandalph[j] = Integer.parseInt(stk.nextToken());
			}
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < sauron.length; j++) {
				sauron[j] = Integer.parseInt(stk.nextToken());
			}
			int gScore = 0;
			int sScore = 0;
			gScore += gandalph[0]*1;
			gScore += gandalph[1]*2;
			gScore += gandalph[2]*3;
			gScore += gandalph[3]*3;
			gScore += gandalph[4]*4;
			gScore += gandalph[5]*10;
			sScore += sauron[0]*1;
			sScore += sauron[1]*2;
			sScore += sauron[2]*2;
			sScore += sauron[3]*2;
			sScore += sauron[4]*3;
			sScore += sauron[5]*5;
			sScore += sauron[6]*10;
			if (gScore > sScore) sb.append("Battle ").append(testCase).append(": Good triumphs over Evil\n");
			else if (gScore < sScore) sb.append("Battle ").append(testCase).append(": Evil eradicates all trace of Good\n");
			else sb.append("Battle ").append(testCase).append(": No victor on this battle field\n");
		}
		System.out.println(sb);
	} // 메인 끝
}
