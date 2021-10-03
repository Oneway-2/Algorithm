package hit1get4;
import java.util.Arrays;
import java.util.Scanner;

public class hit1get4_test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("x0, y0, x2, y2 입력 : ");
		String[] s = sc.nextLine().split(" ");
		double x0 = Integer.parseInt(s[0]);
		double y0 = Integer.parseInt(s[1]);
//		double x1 = Integer.parseInt(s[2]);
//		double y1 = Integer.parseInt(s[3]);
		double x2 = Integer.parseInt(s[2]);
		double y2 = Integer.parseInt(s[3]);
		System.out.printf("x0, y0, x2, y2 는 : %f, %f, %f, %f\n", x0, y0, x2, y2);
		
		double w = x2 - x0;
		double h = y2 - y0;
		System.out.printf("w, h = %f, %f\n", w, h);
		double ceta = Math.atan(h/w);
		System.out.printf("세타(라디안)는 = %f\n", ceta);
		System.out.printf("세타(각도)는 = %f\n", ceta * 180.0 / Math.PI );
		System.out.printf("");
		
		double m = (y2-y0) / (x2-x0);
	} // 메인 끝
}
