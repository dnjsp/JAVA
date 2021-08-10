package z_homework;

import java.util.Scanner;

public class Practice0609 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("세 숫자를 입력받아 낮은 순서대로 출력하세요.");
		System.out.print("첫 번째 숫자 >> ");
		int a = scanner.nextInt();
		System.out.print("두 번째 숫자 >> ");
		int b = scanner.nextInt();
		System.out.print("세 번째 숫자 >> ");
		int c = scanner.nextInt();
		
		int tmp = 0;
		if(a > b) {
			tmp = a;
			a = b;
			b = tmp;	
		}
		if(b > c) {
			tmp = b;
			b = c;
			c = tmp;
		}
		if (a > b) {
			tmp = b;
			b = a;
			a = tmp;
		}
		
		System.out.println(a + " < " + b  + " < " + c);
		
		scanner.close();
	}

}
