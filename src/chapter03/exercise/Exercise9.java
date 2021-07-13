package chapter03.exercise;

import java.util.Scanner;

public class Exercise9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫 번째 수: ");
		double num1 = scanner.nextDouble(); // = Double.parseDouble(scanner.next());
		System.out.print("두 번째 수: ");
		double num2 = scanner.nextDouble();
		System.out.println("-------------------");
		double result = num1 / num2;
		
		if(num2 == 0 || num2 == 0.0) {
			System.out.println("결과: 무한대");
		} else {
			System.out.println("결과: " + result);
		}
		
		scanner.close();
	}

}
