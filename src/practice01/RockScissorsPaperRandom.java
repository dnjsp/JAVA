package practice01.p05;

import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaperRandom {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		String[] array = {"가위", "바위", "보"};
		
		System.out.print("가위 바위 보를 입력하세요: ");
		String input = scanner.nextLine();
		System.out.println("게이머: " + input);
		String computer = array[random.nextInt(3)];
		System.out.println("인공지능 컴퓨터: " + computer);
		
		String result;
		
		if (input.equals(computer)) {
			result = "무승부 입니다.";
		} else if (input.equals("가위") && computer.equals("바위") 
				|| input.equals("바위") && computer.equals("보") 
				|| input.equals("보") && computer.equals("가위")) {
			result = " 인공지능 컴퓨터 승리!";
		} else if (input.equals("가위") && computer.equals("보") 
				|| input.equals("바위") && computer.equals("가위") 
				|| input.equals("보") && computer.equals("바위")) {
			result = "게이머 승리!"; 
		} else {
			result = "승부를 낼 수 없습니다.";
		}
		
		System.out.println("결과: " + result);
		scanner.close();
	}
}
