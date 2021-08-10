package z_homework;

import java.util.Random;

public class LottoShop {
	static Random rnd = new Random();

	public static int[] getLotto() {
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rnd.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j])
					i--;
			}
		}

		return bubbleSort(lotto);
	}

	private static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean changed = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					changed = true;
				}
			}
			if (!changed) {
				break;
			}
		}
		return arr;
	}

	public static int getBonusNumber(int[] matchLotto) {
		int result = 0;
		boolean flag;
		do {
			flag = false;
			result = rnd.nextInt(45) + 1;
			for (int i = 0; i < matchLotto.length; i++) {
				if (matchLotto[i] == result)
					flag = true;
			}
		} while (flag);
		return result;
	}

}