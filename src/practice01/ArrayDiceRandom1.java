package practice01.p05;

import java.util.Random;

public class ArrayDiceRandom1 {
	public static void main(String[] args) {
		
		// 값이 이상하게 나옴...		
		Random random = new Random();
		
		int[] dice = new int[6];
		
		for (int i = 0; i < 10_000; i++) {
			dice[random.nextInt(6)]++;
		}
		switch (random.nextInt(6) + 1) {
		case 1:
			dice[0]++;
			break;
		case 2:
			dice[1]++;
			break;
		case 3:
			dice[2]++;
			break;
		case 4:
			dice[3]++;
			break;
		case 5:
			dice[4]++;
			break;
		case 6:
			dice[5]++;
			break;
			}
		System.out.println("------------");
		System.out.println("면\t빈도");
		System.out.println("------------");
		for(int i = 0; i < dice.length; i++) {
			System.out.println((i +1) + "  \t " + dice[i]);
		}
	}
}
