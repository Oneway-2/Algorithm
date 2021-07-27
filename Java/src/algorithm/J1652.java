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
					overWall = true;
				}
				if(overWall && ((map[i][j]=='.') && (map[i][j+1]=='.'))) {
					cAble++;
					overWall = false;
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			overWall = true;
			for (int j = 0; j < map.length-1; j++) {
				if(map[j][i]=='X') {
					overWall = true;
				}
				if(overWall && ((map[j][i]=='.') && (map[j+1][i]=='.'))) {
					rAble++;
					overWall = false;
				}
			}
		}
		System.out.printf("%d %d",cAble, rAble);	
	}
}
