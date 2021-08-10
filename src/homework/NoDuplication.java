package z_homework;

import java.util.Arrays;
import java.util.Random;

public class NoDuplication {
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] array = new int[10];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(5) + 1;
		}
		System.out.println(Arrays.toString(array)); // array를 보기 좋게 출력해줌
		
		int[] temp = new int[10]; // 임시 배열 생성 (5~10 사이로만 만들면 됨)
		int count = 0; // 최종적으로 출력될 배열의 크기를 알기 위해
		
		for (int i = 0; i < array.length; i++) {
			boolean dupl = false; // 중복확인하는 스위치
			for (int j = 0; j < temp.length; j++) {
				if(array[i] == temp[j]) {
					dupl = true;
				}
			}
			if (!dupl) {
				temp[count] = array[i];
				count++;
			}
		}
		int[] result = new int[count]; // temp를 출력하면 빈 공간이 0으로 출력돼서 새로운 배열을 생성
		for (int i = 0; i < result.length; i++) {
			result[i] = temp[i];
		}
		System.out.println(Arrays.toString(result));
	 }
}