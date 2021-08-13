package kr.or.ddit.basic;

// yield()메서드 연습하기
public class ThreadTest11 {
	public static void main(String[] args) {
		YieldThread th1 = new YieldThread("1번 쓰레드");
		YieldThread th2 = new YieldThread("2번 쓰레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(5);
		} catch (Exception e) { }
		System.out.println("------------------------ 11111111");
		
		th1.work = false;
		try {
			Thread.sleep(5);
		} catch (Exception e) { }
		System.out.println("------------------------ 22222222");

		th1.work = true;
		try {
			Thread.sleep(5);
		} catch (Exception e) { }
		System.out.println("------------------------ 33333333");
		
		th1.stop = true;
		th2.stop = true;		
		
	}
}


// yield()메서드 연습용 쓰레드
class YieldThread extends Thread {
	public boolean stop = false;
	public boolean work = true;
	
	public YieldThread(String name) {
		super(name);		// 쓰레드의 name속성값 설정
	}
	
	@Override
	public void run() {
		while(!stop) {
			if (work) {
				System.out.println(getName() + " 작업중...");
			} else {
				System.out.println(getName() + " 양보...");
				Thread.yield();
			}
		}
		System.out.println(getName() + " 쓰레드 종료..."); 
	}
}