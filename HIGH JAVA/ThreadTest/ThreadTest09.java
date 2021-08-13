package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

/*
 	 컴퓨터와 가위 바위 보를 진행하는 프로그램 작성하기
 	 
 	 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
 	 사용자의 입력은 showInputDialog()메서드를 이용해서 입력 받는다.
 	 
 	 입력 시간은 5초로 제한하고 카운트 다운을 한다.
 	 5초 안에 입력이 없으면 게임에 진 것으로 처리한다.
 	 
 	 5초 안에 입력이 완료되면 승패를 구해서  출력한다.
 	 
 	 결과예시)
 	 	   -- 결 과 --
 	 	  컴퓨터 : 가위
 	 	  사용자 : 바위
 	 	  결  과 : 당신이 이겼습니다.
 	 	  
 	 < 5초안에 입력을 못했을 경우 >
 	 	   -- 결 과 --
 	 	   시간초과로 당신이 졌습니다.
 */

public class ThreadTest09 {
	Random random = new Random();
	String[] array = {"가위", "바위", "보"};
	public String computer = array[random.nextInt(3)];
	
	public static void main(String[] args) {
		DataInput1 th1 = new DataInput1();
		CountDown1 th2 = new CountDown1();

		th1.start();
		th2.start();
		
	}
	
	public void result() {	
		System.out.println("-- 결 과 --");
		System.out.println("컴퓨터 : " + computer);
		System.out.println("사용자 : " + DataInput1.input);
		
		if (DataInput1.input.equals(computer)) {
			System.out.println("결과 : 무승부 입니다.");
		} else if (DataInput1.input.equals("가위") && computer.equals("바위") 
				|| DataInput1.input.equals("바위") && computer.equals("보") 
				|| DataInput1.input.equals("보") && computer.equals("가위")) {
			System.out.println("결과 : 컴퓨터가 이겼습니다.");
		} else if (DataInput1.input.equals("가위") && computer.equals("보") 
				|| DataInput1.input.equals("바위") && computer.equals("가위") 
				|| DataInput1.input.equals("보") && computer.equals("바위")) {
			System.out.println("결과 : 당신이 이겼습니다.");
		} else {
			System.out.println("결과 : 승부를 낼 수 없습니다.");
		}
	}
}

class DataInput1 extends Thread {
	public static boolean inputCheck;
	public static String input;
	
	public void run() {
		input = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
		
		inputCheck = true;
	}
}

class CountDown1 extends Thread {
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			if (DataInput1.inputCheck == true) {
				new ThreadTest09().result();
				return;
			}
			
			System.out.println(i);
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("-- 결 과 --");
		System.out.println("시간초과로 당신이 졌습니다.");
		System.exit(0);
	}
}