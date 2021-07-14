package chapter08;

public class MyClass {
	RemoteControl rc = new Television();
	
	public MyClass() {}

	public MyClass(RemoteControl rc) {
		        // 매개변수 안에 들어오는 건 같거나 하위타입만 들어올 수 있음
		this.rc = rc;
		rc.turnOn();
		rc.setVolume(5);
	}
	
	void methodA() {
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
	}

	void methodB(RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(5);
	}
}
