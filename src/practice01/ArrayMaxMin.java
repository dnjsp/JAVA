package practice01.p05;

public class ArrayMaxMin {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE; // 최솟값으로 시작
		int[] scores = {38, 94, 16, 3, 76, 94, 82, 47, 59, 8};
		int min = Integer.MAX_VALUE; // 최댓값으로 시작
		
		for (int i = 0; i < scores.length; i++) {
			if (max < scores[i]) {
				max = scores[i];
			} 
			if (min > scores[i]) {
				min = scores[i];
			}
		}
		System.out.println("최댓값: " + max);
		System.out.println("최솟값: " + min);
	}
}
