package practice01.p05;

import java.util.Random;

public class ArrayDiceRandom10000 {
	public static void main(String[] args) {
		Random random = new Random();
		
		System.out.println("------------");
		System.out.println("면\t빈도");
		System.out.println("------------");
		
		int[] dice = new int[6];
		
		for (int i = 0; i < dice.length; i++) {	
			dice[i] = i +1;
			}
		
		int[] count = new int[6];

		for (int i = 0; i < 10000; i++) {
			count[random.nextInt(6)]++;	
		}
		for (int i = 0; i < dice.length; i++) {
			System.out.println(dice[i] + "\t" + count[i]);
		}
	}
}
