package practice01.p04;

import java.util.Scanner;

public class RockScissorsPaper {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("가위 바위 보 게임");
		System.out.print("철수: ");
		String cheolsu = scanner.nextLine();
		System.out.print("영희: ");
		String yeonghui = scanner.nextLine();
		String result = "";
		
		if (cheolsu.equals(yeonghui)) {
			result = "무승부 입니다.";
		} else if (cheolsu.equals("가위") && yeonghui.equals("바위") 
				|| cheolsu.equals("바위") && yeonghui.equals("보") 
				|| cheolsu.equals("보") && yeonghui.equals("가위")) {
			result = "영희 승리!";
		} else if (cheolsu.equals("가위") && yeonghui.equals("보") 
				|| cheolsu.equals("바위") && yeonghui.equals("가위") 
				|| cheolsu.equals("보") && yeonghui.equals("바위")) {
			result = "철수 승리!"; 
		} else {
			result = "승부를 낼 수 없습니다.";
		}
		System.out.println("결과 " + result);
		scanner.close();
	}
}
