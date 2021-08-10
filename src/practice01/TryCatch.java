package practice01.p10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dividend = 0;
		int divisor = 0;
		int result = 0;
		
		while (true) {
			try {
				System.out.print("어떤 수를 나누시겠습니까?>> ");
				dividend = scanner.nextInt();
				System.out.print("어떤 수로 나누시겠습니까?>> ");
				divisor = scanner.nextInt();
				result = dividend / divisor;
				break;
			} catch (InputMismatchException e) {
				System.err.println("잘못된 입력입니다. 다시 입력해주세요.");
				scanner.next(); // nextInt에 있는 enter를 없애줘서 에러 사라지게 함
			} catch (ArithmeticException e) {
				System.err.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
			} 
		}
		System.out.println(String.format("%d / %d = %d", dividend, divisor, result));		
		
		scanner.close();
	}
}
