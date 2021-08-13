package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoTest { 
	ArrayList<Integer> lottoList;
	ArrayList<Integer> userList;
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	
	public static void main(String[] args) {
		new LottoTest().startLotto();
	}
	
	public void startLotto() {		
		while (true) {
			System.out.println("==========================");
			System.out.println("Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴선택 : ");
			int input = scanner.nextInt();
			if (input == 1) {
				buyLotto();
			} else if (input == 2) {
				System.out.println("감사합니다.");
				System.exit(0);
			} 
		}
	}
	
	public void buyLotto() {
		System.out.println("\nLotto 구입 시작");
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액 입력 : ");
		int money = scanner.nextInt();
		int trynum = money / 1000;
		
		if (trynum < 1) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
		} else if (trynum > 100) {
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
		} else {
			System.out.println("\n행운의 로또번호는 아래와 같습니다.");
			for (int i = 0; i < trynum; i++) {
				System.out.print("로또번호" + (i + 1) + " : ");
				getNum();
			}
			
			System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + money % 1000 + "원입니다.");
		}
	}
	
	public void getNum() {
		Set<Integer> numSet = new HashSet<Integer>();
		
		while (numSet.size() < 6) {
			numSet.add(random.nextInt(45) + 1);
		}
		
		lottoList = new ArrayList<Integer>(numSet);
		System.out.println(numSet);
	}
}
