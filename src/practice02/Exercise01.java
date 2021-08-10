package practice02.p04;

public class Exercise01 {
	public static void main(String[] args) {
		
		// 183쪽부터
		
		// 1.
		int x = 0;
		if (x > 10 && x < 20) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		// 2.
		char ch = '가';
		if (ch != ' ' && ch != '\t') {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		// 3.
		if (ch == 'x' || ch == 'X') {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		// 4.
		if (ch >= 0 && ch <= 9) {
			System.out.println("ture");
		} else {
			System.out.println("false");
		}
		
		// 5.
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		// 6.
		int year = 2021;
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		// 7.
		boolean powerOn = false;
		if (powerOn == false) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		// 8.
		String str = "no";
		if (str.equals("yes")) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
