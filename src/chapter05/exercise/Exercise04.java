package chapter05.exercise;

public class Exercise04 {
	public static void main(String[] args) {
		int max = 0;
		int[] array = {1, 5, 3, 8, 2};
		int min = array[0];
		
		for (int i : array) {
			max = max > i ? max : i;
			min = min < i ? min : i;
		}
		
		System.out.println(max);
		System.out.println(min);
	}
}
