package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> aliasList = new ArrayList<String>();
		
		System.out.println("5개의 별명을 입력하세요.");

		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + "번째 별명 : ");
			String alias = scanner.next();
			aliasList.add(alias);
		}
		
		System.out.println("\n< 가장 긴 별명 > ");
		
		// 제일 긴 별명의 길이가 저장될 변수를 선언하고 이 변수에 첫 번째 데이터의 길이를 저장한다.
		
		int maxLen = aliasList.get(0).length();
		
		for (int i = 1; i < aliasList.size(); i++) {
			if (maxLen < aliasList.get(i).length()) {
				maxLen = aliasList.get(i).length();
			}
		}
		
		for (String alias : aliasList) {
			if (maxLen == alias.length()) {
				System.out.println(alias);
			}
		}
		
		scanner.close();
	}
}
