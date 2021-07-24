package algorithm;
import java.io.*;
import java.util.Arrays;

public class P5212 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = { 0, 0,-1, 1};
//				         상 하 좌 우
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] nums = str.split(" ");
		int r = Integer.parseInt(nums[0]);
		int c = Integer.parseInt(nums[1]);
		
		char[][] map = new char[r+2][c+2]; // 초기화
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = '.';
			}
		}
		
		int islands = 0;
		String mark; // 마킹 ㄱㄱ
		for (int i = 1; i <= r; i++) {
			mark = br.readLine();
			for (int j = 1; j <= c; j++) {
				map[i][j] = mark.charAt(j-1);
				if(mark.charAt(j-1) == 'X') {
					islands++; // 섬 갯수 세자
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		int sCount = 0;		
		int xMin = c+2, xMax = 0, yMin = r+2, yMax = 0;
ex:		for (int i = 1; i <= r; i++) {			
			for (int j = 1; j <= c; j++) {
				if(islands <= 1) { // 육지가 1개가 남거나, 그 이하면 볼것도없이 반복문 탈출.
					break ex;
				}
				if(map[i][j] == 'X') { // X인 곳만 검사하자.
					for (int k = 0; k < 4; k++) { // 인접 4개의 면 검사해보자.
						if(map[i+dr[k]][j+dc[k]] == '.') {
							sCount++;
						}
						if(sCount >= 3) { // 인접면에 바다가 3개이상이다 더 체크할 필요도 없다.
							map[i][j] = '.';
							islands--;
							System.out.printf("%d %d는 곧 묻힌다\n", i, j);
							break;
						}			
						// 살아남은 섬은 여기로 옴
						if(j >= yMax) yMax = j;
						if(j <= yMin) yMin = j;
						if(i >= xMax) xMax = i;
						if(i <= xMin) xMin = i;
						System.out.printf("%d, %d는 xmin:%d xmax:%d ymin:%d ymax:%d\n",i, j, xMin, xMax, yMin, yMax);
					}		
				}else { // . 인 곳은 검사할 필요 없으니 다음칸 검사
					System.out.printf("%d %d는 검사할 필요 ㄴ\n", i, j);
					continue;
				}
			}
			
		}
		
		
		
		char copyMap[][] = new char[yMax - yMin + 1][xMax - xMin + 1];
		for (int i = 0; i < copyMap.length; i++) {
			copyMap[i] = Arrays.copyOfRange(map[i + yMin], xMin, xMax+1);			
		}
		
		
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(copyMap[i][j]);
			}
			System.out.println();
		}
	} // end of main
}
