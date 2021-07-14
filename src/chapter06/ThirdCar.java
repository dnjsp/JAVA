            package chapter06;

public class ThirdCar {
	// 필드
	int gas;
	
	// 생성자 : 없으면 default 생성자를 컴파일러가 만들어줌
	
	// 메소드
	void setGas(int gas) {
		this.gas = gas;
	}
	
	boolean isLeftGas() { // 에러를 먼저 없앤 다음에 if문 작성하기
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;
		} // return이 있으면 바로 끝나기 때문에 else를 사용하지 않아도 됨
		System.out.println("gas가 있습니다.");
		return true;
	}
	
	void run() {
		while (true) {
			if (gas > 0) {
				System.out.println("달립니다.(gas잔량:" + gas + ")");
				gas -= 1;
			} else {
				System.out.println("멈춥니다.(gas잔량:" + gas + ")");
				return;
			}
		}
	}
}
