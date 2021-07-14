package chapter07;

public class Tiger extends Animal {
	public Tiger() {
		this.kind = "포유류";
	}
	
	@Override
	public void sound() {
		System.out.println("어흥");
		
	}
}
