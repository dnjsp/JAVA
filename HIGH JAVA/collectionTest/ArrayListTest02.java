package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 문제) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에 이들 중 '김'씨 성의 이름을 모두 출력하시오.
 	   (입력은 Scanner를 이용한다.)	
 */

public class ArrayListTest02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		
		System.out.println("5명의 이름을 입력하세요. > ");
		
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 이름 : ");
			String name = scanner.next();
			list.add(name);
		}

		System.out.println("\n< 김씨 성을 가진 사람들 >");
		
		for (String str : list) {
			if(str.charAt(0) == '김') {
				System.out.print(str + " ");
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i);
			if (name.substring(0, 1).equals("김")) {
				System.out.print(name + " ");
			}
		}
		
		for (String str : list) {
			if (str.indexOf("김") == 0) {
				System.out.print(str + " ");
			}
		}
		
		for (String str : list) {
			if (str.startsWith("김")) {
				System.out.println(str + " ");
			}
		}
		
		scanner.close();
	}
}
