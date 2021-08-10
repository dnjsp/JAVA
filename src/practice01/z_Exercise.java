package practice01.p04;

import java.util.Scanner;

public class z_Exercise {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("허용 오차: ");
		double tolerance = scanner.nextDouble();
		
		double pi = 3;
		double sign = 1;
		long i = 2;
		long count = 0;
		
		while (true) {
			pi += 4.0 / (i * (i+1) * (i+2)) * sign;
			count++;
			sign *= -1;
			i+=2;
			if (tolerance > Math.abs(Math.PI - pi)) {
				break;
			}
		}
		System.out.println("Math.PI = " + Math.PI);
		System.out.println("계산된 파이값: " + pi);
		System.out.println("반복 횟수: " + count);
		scanner.close();
	}
}
