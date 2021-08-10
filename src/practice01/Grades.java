package practice01.p04;

import java.util.Scanner;

public class Grades {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요.");
		System.out.print("프로그래밍 기초: ");
		int a = scanner.nextInt();
		System.out.print("데이터베이스: ");
		int b = scanner.nextInt();
		System.out.print("화면 구현: ");
		int c = scanner.nextInt();
		System.out.print("애플리케이션 구현: ");
		int d = scanner.nextInt();
		System.out.print("머신러닝: ");
		int e = scanner.nextInt();
		
		int sum = a + b + c + d + e;
		double average = (double)sum / 5;
		
		System.out.println("총점: " + sum);
		System.out.printf("평균: %-10.2f", average);
		System.out.println();
		
		if (average >= 90) {
			System.out.println("학점: A");
		} else if (average >= 80 && average < 90) {
			System.out.println("학점: B");
		} else if (average >= 70 && average < 80) {
			System.out.println("학점: C");
		} else if (average >= 60 && average < 70) {
			System.out.println("학점: D");
		} else {
			System.out.println("학점: E");
		}
		
		scanner.close();
	}
}
