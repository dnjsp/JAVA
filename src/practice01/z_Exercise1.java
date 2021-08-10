package practice01.p04;

import java.util.Scanner;

public class z_Exercise1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		long num1 = 1;
		long num2 = 1;
		long num3 = 0;
		String result = "1 1 ";
		
		while (true) {
			System.out.print("몇 번째 항까지 출력하시겠습니까?(3 이상 입력): ");
			int inputNum = scanner.nextInt();
			if (inputNum >= 3) {
				for (int i = 2; i < inputNum; i++) {
					num3 = num1 + num2;
					result += num3 + " ";
					num1 = num2;
					num2 = num3;
				}
				System.out.println(result);
				break;
			}
			System.out.println("3 이상의 숫자를 입력하세요.");
		}
		scanner.close();
	}
}
