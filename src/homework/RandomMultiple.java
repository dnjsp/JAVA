package z_homework;

import java.util.Arrays;
import java.util.Random;

public class RandomMultiple {
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] array = new int[100];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100) + 1;
		}
		
		int[] temp = new int[100];
		int n = random.nextInt(4) +2;
		int count = 0;
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] % n == 0) {
				temp[count] = array[i];
				count++;
			}
		}
		array = new int[count];
		for (int i = 0; i < array.length; i++) {
			array[i] = temp[i];
		}
		
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			int tmp = array[i];
			array[i] = array[min];
			array[min] = tmp;
		}
		System.out.println("n : " + n);
		System.out.println(Arrays.toString(array));
	}
}
