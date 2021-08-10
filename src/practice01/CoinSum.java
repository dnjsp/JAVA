package practice01.p02;

import java.util.Scanner;

public class CoinSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("500원짜리 동전의 갯수: ");
		int num500 = scanner.nextInt();
		System.out.print("100원짜리 동전의 갯수: ");
		int num100 = scanner.nextInt();
		System.out.print("50원짜리 동전의 갯수: ");
		int num50 = scanner.nextInt();
		System.out.print("10원짜리 동전의 갯수: ");
		
		int num10 = scanner.nextInt();
		int sum = (num500 * 500) + (num100 * 100) + (num50 * 50) + (num10 * 10);
		System.out.println("저금통 안의 동전의 총 액수: " + sum);
		
		scanner.close();
	}

}
