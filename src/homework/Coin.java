package z_homework;

import java.util.Random;

public class Coin {
	public static void main(String[] args) {
		Random random = new Random();
		
		int money = random.nextInt(500) * 10;
		int[] coin = {500, 100, 50, 10};
		
		System.out.println("거스름돈 : " + money);
		
		for (int i = 0; i < coin.length; i++) {
			System.out.println(coin[i] + "원 : " + money / coin[i] + "개");
			money = money % coin[i];
		}
		
	}
}
