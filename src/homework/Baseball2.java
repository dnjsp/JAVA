package z_homework;

import java.util.Random;
import java.util.Scanner;

public class Baseball2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int n1 = random.nextInt(9) + 1;
		int n2 = random.nextInt(10);
		int n3 = random.nextInt(10);
		
		if(n2 == n1) {
			n2 = random.nextInt(10);
		}
		if(n3 == n2 || n3 == n1) {
			n3 = random.nextInt(10);
		}
		
		System.out.print(n1);
		System.out.print(n2);
		System.out.println(n3);
		System.out.println();
		
		System.out.println("맞출 때까지 계속하는 숫자 야구게임을 만들어보자!");
		
		int count = 0;
		int i1, i2, i3;
		
		while(true) {
			System.out.print("3자리의 숫자 입력>> ");
			int input = scanner.nextInt();
			
			i3 = input % 10;
			input /= 10;
			i2 = input % 10;
			input /= 10;
			i1 = input % 10; // 어차피 input이 한자리수(10보다 작다는 뜻)이니 10으로 나누어도 나머지 값은 그대로
							 // 따라서 input % 10;이 아니라 input;으로 써도 됨 
			int s = 0, b = 0, o = 0;
			
			if(n1 == i1) s++;
			if(n2 == i2) s++;
			if(n3 == i3) s++;
			
			if(n1 == i2 || n1 == i3) b++;
			if(n2 == i1 || n2 == i3) b++;
			if(n3 == i1 || n3 == i2) b++;
			
			o = 3 - s - b;
			
			System.out.println(++count + "차 시도(" + i1 + i2 + i3 + ") : " + s + "S " + b + "B " + o + "O ");
			System.out.println("--------------------------------   ");
			
			if(s == 3) {
				System.out.println("정답입니다!!");
				break;
				
			}
		
		}
		
		scanner.close();
	}
}
