package practice01.p04;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberCount {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int num = random.nextInt(100) + 1;
		int count = 0;
		
		while (true) {
			System.out.print("1부터 100 사이의 정수 중 하나를 선택하세요: ");
			int input = scanner.nextInt(); 
			count ++;
			
			if (input < num) {
				System.out.println("정답은 더 큰 수 입니다.");
			} else if (input > num) {
				System.out.println("정답은 더 작은 수 입니다.");
			} else {
				System.out.println("\n정답입니다.");
				System.out.println(count + "번 만에 맞추셨습니다!");
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
		
		scanner.close();
	}
}
