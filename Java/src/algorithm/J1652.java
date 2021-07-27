package algorithm;
//누울 자리를 찾아라

import java.io.*;

public class J1652 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for (int i = 0; i < map.length; i++) {
			map[i] = br.readLine().replaceAll(" ", "").toCharArray();
		}
		
		int rAble = 0, cAble = 0;
		boolean overWall;
		
		for (int i = 0; i < map.length; i++) {
			overWall = true;
			for (int j = 0; j < map.length-1; j++) {
				if(map[i][j]=='X') {
//					System.out.printf("%d%d 에서 true로 바꿨음\n",i,j);
					overWall = true;
				}
				if(overWall && ((map[i][j]=='.') && (map[i][j+1]=='.'))) {
//					System.out.printf("%b %b %b   ", overWall, map[i][j]=='.', map[i][j+1]=='.');
//					System.out.printf("가로검사중%d%d %d%d는 연속..\n",i,j,i,j+1);
					cAble++;
					overWall = false;
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			overWall = true;
			for (int j = 0; j < map.length-1; j++) {
				if(map[j][i]=='X') {
//					System.out.printf("%d%d 에서 true로 바꿨음\n",i,j);
					overWall = true;
				}
				if(overWall && ((map[j][i]=='.') && (map[j+1][i]=='.'))) {
//					System.out.printf("%b %b %b   ", overWall, map[j][i]=='.', map[j+1][i]=='.');
//					System.out.printf("세로검사중%d%d %d%d는 연속..\n",j,i,j+1,i);
					rAble++;
					overWall = false;
				}
			}
		}
		System.out.printf("%d %d",cAble, rAble);	
	}
}
