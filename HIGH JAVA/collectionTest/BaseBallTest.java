package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/*
 	  문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 	  		컴퓨터의 숫자는 난수를 이용하여 구한다.
 	  		(스트라이크 S, 볼은 B로 나타낸다.)
 	  		
 	  예시) 컴퓨터의 난수 ==> 9 5 7
 	  
 	  실행예시) 숫자입력 => 3 5 6
 	  			   3 5 6 => 1S 0B
 	  			숫자입력 => 7 8 9
 	  			   7 8 9 => 0S 2B
 	  			숫자입력 => 9 7 5
 	  			   9 7 5 => 1S 2B
 	  			숫자입력 => 9 5 7
 	  			   9 5 7 => 3S 0B
 	  			   
 	  			축하합니다.
 	  			당신은 4번째만에 맞췄습니다.
 */

public class BaseBallTest {
	ArrayList<Integer> numList; // 난수가 저장될 List
	ArrayList<Integer> userList; // 사용자가 입력한 값이 저장될 List
	Scanner scanner = new Scanner(System.in);
	
	int strike, ball;
	
	public static void main(String[] args) {
//		BaseBallTest test = new BaseBallTest();
//		test.startGame();

		new BaseBallTest().startGame();
	}
	
	// 게임이 시작되는 메서드
	public void startGame() {
		// 난수를 만드는 메서드 호출
		getNum();
		
		// 확인용 출력
		System.out.println("컴퓨터 난수 : " + numList);
		
		int count = 0;	// 몇 번만에 맞췄는지를 저장하는 변수
		
		do {
			count++;  // 카운트 증가
			
			// 사용자 입력 메서드 호출
			inputNum();
			
			// 볼카운트를 구하는 메서드 호출
			ballCount();
			
		} while (strike != 3);	// 3스트라이크가 될 때까지 반복한다.
		
		// 답을 모두 맞춘 후 결과 출력하기
		System.out.println();
		System.out.println("축하합니다.");
		System.out.println("당신은 " + count + "번째만에 맞췄습니다.");
	}
		
	// 1 ~ 9 사이의 서로 다른 난수 3개를 만들어서 List에 저장하는 메서드 
	// Set 이용
	public void getNum() {
		Set<Integer> numSet = new HashSet<Integer>();
		
		// 1 ~ 9 사이의 난수 3개 만들기
		Random random = new Random();
		while (numSet.size() < 3) {
			numSet.add(random.nextInt(9) + 1);
		}
		
		// 만들어진 난수를 List에 저장하기
		numList = new ArrayList<Integer>(numSet);
		
		// List의 데이터를 섞어준다.
		Collections.shuffle(numList);
	}
	
	// 사용자로부터 3개의 정수를 입력받아서 List에 저장하는 메서드
	// 입력한 정수는 중복되지 않는다.
	public void inputNum() {
		int n1, n2, n3;  // 입력한 정수가 저장될 변수 선언
		
		do {
			System.out.print("숫자입력 => ");
			n1 = scanner.nextInt();
			n2 = scanner.nextInt();
			n3 = scanner.nextInt();
			
			if (n1 == n2 || n1 == n3 || n2 == n3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다.");
				System.out.println("다시 입력하세요.");
			}
		} while (n1 == n2 || n1 == n3 || n2 == n3);
		
		// 입력받은 데이터를 List에 저장한다.
		userList = new ArrayList<Integer>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
	}
	
	// 스트라이크와 볼을 판정하고 그 결과를 출력하는 메서드
	public void ballCount() {
		strike = 0;
		ball = 0;	// 스트라이크와 볼의 개수가 저장될 변수 초기화
		
		for (int i = 0; i < numList.size(); i++) {
			for (int j = 0; j < userList.size(); j++) {
				
				// 값이 같은지 검사
				if (numList.get(i) == userList.get(j)) {
					if (i == j) {
						strike++;
					} else {
						ball++;
					}
				}
			}	// for문 j
		}	// for문 i
		
		// 볼카운트 결과를 출력한다.
		System.out.println(userList.get(0) + ", " + userList.get(1) + ", " + userList.get(2) + " => " + strike + "S " + ball + "B"); 
	}
}
