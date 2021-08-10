package practice01.p02;

import java.util.Scanner;

public class Scannernumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 수를 입력하세요: ");
		int num1 = scanner.nextInt();
		System.out.print("두번째 수를 입력하세요: ");
		int num2 = scanner.nextInt();
		System.out.print("첫번째 수가 두번째 수보다 큰가? ");
		System.out.println(num1 > num2);
		
		scanner.close();
	}

}
