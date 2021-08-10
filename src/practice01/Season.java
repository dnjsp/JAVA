package practice01.p04;

import java.util.Scanner;

public class Season {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("월을 입력하세요(1~12): ");
		int num = scanner.nextInt();
		
		switch(num) {
			case 3: case 4: case 5:
				System.out.println(num + "월은 봄입니다.");
				break;
			case 6: case 7: case 8:
				System.out.println(num + "월은 여름입니다.");
				break;
			case 9: case 10: case 11:
				System.out.println(num + "월은 가을입니다.");
				break;
			case 12: case 1: case 2:
				System.out.println(num + "월은 겨울입니다.");
				break;
			default:
				System.out.println(num + "월은 잘못된 입력입니다.");
		}
		
		scanner.close();
	}
}
