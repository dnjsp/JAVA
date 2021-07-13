package chapter03.exercise;

import java.util.Scanner;

public class Exercise11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("아이디: ");
		String name = scanner.nextLine();

		System.out.print("패스워드: ");
		String strpw = scanner.nextLine();
		int pw = Integer.parseInt(strpw);

		if ("java".equals(name)) { // 이 순서가 가장 좋은 코드
			if (pw == 12345) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패:패스워드가 틀림");
			}
		} else {
			System.out.println("로그인 실패:아이디 존재하지 않음");
		}
		scanner.close();
	}

}
