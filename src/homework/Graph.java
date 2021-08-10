package z_homework;

import java.util.Arrays;
import java.util.Random;

public class Graph {
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] array = new int[20];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(5) + 1;
		}
		System.out.println(Arrays.toString(array));
		
		int[] count = new int[5];
		
		for (int i = 0; i < array.length; i++) {
			count[array[i] - 1]++;
		}
		for (int i = 0; i < count.length; i++) {
			System.out.print(i  + 1 + " : ");
			for (int j = 0; j < count[i]; j++) {
				System.out.print("*");
			}
			System.out.println(" " + count[i]);
		}		
	}
}
