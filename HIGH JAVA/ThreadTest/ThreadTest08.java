package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest08 {
	public static void main(String[] args) {
		DataInput th1 = new DataInput();
		CountDown th2 = new CountDown();
		
		th1.start();
		th2.start();
		
	}
}

// 데이터를 입력하는 쓰레드
class DataInput extends Thread {
	// 입력 여부를 확인하기 위한 변수 선언
	// 쓰레드에 공통으로 사용할 변수 (입력이 완료되면 true값이 저장된다.)
	public static boolean inputCheck;
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		
		inputCheck = true;	// 입력이 완료되어 값을 true로 변경한다.
		
		System.out.println("입력한 값 : " + str);
	}
}

// 카운트 다운을 담당하는 쓰레드
class CountDown extends Thread {
	@Override
	public void run() {
		for (int i = 10; i >= 1; i--) {
			 
			// 입력이 완료되었는지 여부 검사해서 입력이 완료되었으면 쓰레드를 종료시킨다.
			if (DataInput.inputCheck == true) {
				return;	 // run()메서드가 종료되면 쓰레드도 종료된다.
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);
		
	}
}
