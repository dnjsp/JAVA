package chapter07;

public class DmbCellPhone extends CellPhone { // class 자식클래스 extends 부모클래스
	// 필드
	int channel;
	
	// 생성자
	DmbCellPhone(String model, String color, int channel) {
		this.model = model;
	  //super.~ 이렇게 사용해도 됨 (부모클래스에서 가져오는 거기 때문에)
		this.color = color;
		this.channel = channel;
	}
	
	//메소드
	void turnOnDmb() {
		System.out.println("채널 " + channel + "번 DMB 방송 수신을 시작합니다.");
	}
	
	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널 " + channel + "번으로 바꿉니다.");
	}
	
	void turnOffDmb() {
		System.out.println("DMB 반송 수신을 멈춥니다.");
	}
}
