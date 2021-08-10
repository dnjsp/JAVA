package practice02.p05;

import java.util.Random;

public class Exercise055 {
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] ball3 = new int[3];
		
		for (int i = 0; i < 9; i++) {
			int j= random.nextInt(ballArr.length) ;
			int tmp = 0;
			
			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;
			
			System.arraycopy(ballArr,0,ball3,0,3);
			
		}
		
		for (int i = 0; i < ball3.length; i++) {
			System.out.print(ball3[i] + " ");
		}
	}
}
