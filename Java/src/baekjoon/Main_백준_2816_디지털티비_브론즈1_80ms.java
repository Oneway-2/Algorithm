package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2816_디지털티비_브론즈1_80ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 채널의 수 2 <= N <= 100
		// 방법의 길이는 500보다 작아야함.
		// 무조건 무지성으로 KBS1 를 찾아나서서 0번 자리에 데려다 놓고,
		// 그다음 무지성으로 KBS2 를 찾아나서서 1번 자리에 데려다놔도 최악의 경우는 100 + 100
		
		int N = Integer.parseInt(br.readLine());
		String[] channel = new String[100];
		for (int i = 0; i < N; i++) {
			channel[i] = br.readLine();
		}
		String tmp;
		int idx = 0;
		boolean nocheck = true;
		while(true) {
			if (channel[idx].equals("KBS1")) {
				break;
			}
			idx++;
			sb.append(1);
		}
		if(channel[0].equals("KBS1")) nocheck = false;
		while(nocheck) {
			tmp = channel[idx];
			channel[idx] = channel[idx-1];
			channel[idx-1] = tmp;
			sb.append(4);
			idx--;
			if (idx <= 0) {
				break;
			}
		}
		nocheck = true;
		if(channel[1].equals("KBS2")) nocheck = false;
		while(nocheck) {
			if (channel[idx].equals("KBS2")) {
				break;
			}
			idx++;
			sb.append(1);
		}
		while(true) {
			sb.append(4);
			idx--;
			if (idx <= 1) break;
		}
		System.out.println(sb);
	} // 메인 끝
}

/*
조건중에
이미 KBS1이 첫 번째에, KBS2가 두 번째에 있는 입력은 주어지지 않는다.
라고 써있는데 이게 둘이 동시에 KBS1 KBS2 이렇게 있을 확률이 없다는건지 둘 중 하나는 있을 수 있다는건지 제대로 써주셔야지
뻘짓 존나하다가 계속틀렸잖아
*/