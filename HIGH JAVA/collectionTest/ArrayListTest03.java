package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 문제1) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 별명 중에 별명의 길이가 제일 긴 별명을 출력하시오.
       (단, 각 별명의 길이는 모두 다르게 입력한다.)
 
 문제2) 문제1에서 별명의 길이가 같은 것을 입력할 수 있을 경우에 대해 처리하시오.
 */

public class ArrayListTest03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> aliasList = new ArrayList<String>();
		
		System.out.println("서로 다른 길이의 별명 5개를 입력하세요.");
		
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 별명 : ");
			String alias = scanner.next();
			aliasList.add(alias);
		}
		
		System.out.println("\n< 가장 긴 별명 > ");

		// 제일 긴 별명이 저장될 변수 선언하고 이 변수에는 List의 첫 번째 데이터로 초기화 한다.
		
		String maxAlias = aliasList.get(0);
		
		for (int i = 0; i < aliasList.size(); i++) {
			if (maxAlias.length() < aliasList.get(i).length()) {
				maxAlias = aliasList.get(i);
			}
		}
		
		System.out.println(maxAlias);
		
		scanner.close();
	}
}
