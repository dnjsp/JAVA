package chapter11;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegularExpressionExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("아이디를 입력하세요: ");
			String id = scanner.next();
			// 휴대전화번호 패턴 \\d{3}-[0-9]{4}-[0-9]{4}
			if (Pattern.matches("[a-z]\\w{7,}", id)) {
				System.out.println("올바른 아이디를 입력하셨습니다.");
				break;
			} else {
				System.out.println("아이디는 영문자로 시작하고 8글자 이상이어야 합니다.");
			}
		}
//		
//		while (true) {
//			System.out.print("비밀번호를 입력하세요: ");
//			String pw = scanner.next();
//
//			if (Pattern.matches("[A-Z]\\S{9,}", pw)) {
//				System.out.println("올바른 비밀번호를 입력하셨습니다.");
//				break;
//			} else {
//				System.out.println("비밀번호는 대문자로 시작하고 숫자, 특수문자 포함 10글자 이상이어야 합니다.");
//			}
//		}
		scanner.close();
	}
} 
