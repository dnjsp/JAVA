package z_homework;

import java.util.Random;
import java.util.Arrays;

public class Graph01 {
	public static void main(String[] args) {		
		Random random = new Random();
		
		int[] array = new int[20];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(5) + 1;
		}
		System.out.println(Arrays.toString(array));
		
		int count;
		
		for (int i = 0; i < 5; i++) {
			count = 0;
			System.out.print(i + 1 + " : ");
			for (int j = 0; j < array.length; j++) {
				if (array[j] == i + 1) {
					count++;
					System.out.print("*");
				}
			}
			System.out.println(" " + count);
		}
	}
}
