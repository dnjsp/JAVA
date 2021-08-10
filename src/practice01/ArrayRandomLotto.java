package practice01.p05;

import java.util.Random;

public class ArrayRandomLotto {
	public static void main(String[] args) {
		
		// 1. 6개의 로또 숫자를 저장할 배열 생성
		//    int[] lotto = new int[6];
		// 2. 랜덤 생성(1 ~ 45) 후 배열에 저장
		// 3. 기존 배열의 값과 비교 후 같으면 다시 2번 실행 (현재값 삭제)
		// 4. 출력
		// 2 ~ 3번 6번 반복
				
		Random random = new Random();
		
		int[] lotto = new int[6];
		int[] allLotto = new int[45];
		for (int i = 0; i < 45; i++) {
			allLotto[i] = i + 1;
		}
		// allLotto[0] <--> allLotto[random]
		int temp = 0;
		for (int i = 0; i < allLotto.length; i++) {
			int ranNum = random.nextInt(45);
			temp = allLotto[i];
			allLotto[0] = allLotto[ranNum];
			allLotto[ranNum] = temp;
		}
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(allLotto[i] + " ");
		}
	}
}
