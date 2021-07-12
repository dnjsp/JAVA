package chapter02;

import java.util.Scanner; //new Scanner 입력 후 Ctrl + space 하면 생김

public class ScannerExample {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// new Scanner(System.in) 이렇게 입력된 상태에서 Cntl + 1

		String inputData;

		while (true) {
			inputData = scanner.nextLine();
			System.out.println("입력된 문자열: \"" + inputData + "\"");
			if (inputData.equals("q")) {
				break;
			}
		}

		System.out.println("종료");

		scanner.close();

	}

}