package chapter07;

public class Driver {
	public void drive(Vehicle vehicle) { // Vehicle이랑 같거나 하위 타입만 가능
		vehicle.run();
	}
}
