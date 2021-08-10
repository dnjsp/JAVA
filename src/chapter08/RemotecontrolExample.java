package chapter08;

public class RemotecontrolExample {
	public static void main(String[] args) {
		RemoteControl control = new Television();
	 // 생성한 객체랑 같거나 상위 타입으로 
		control = new Audio();
	// control에 Audio를 담아서 결과가 Audio 값이 나옴, 근데 이걸 주석처리하면 Television 값이 나옴
		control.turnOn();
		control.setVolume(8);
		control.turnOff();
	}
}
