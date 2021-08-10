package practice01.p06;

public class Plane {
	private String manufacture;
	private String model;
	private int maxNumberOfPassengers;
	private static int numberOfPlanes;
	
	public Plane() {
		numberOfPlanes++; //객체가 생성될 때마다 하나씩 증가시켜줌 
	}
	
	public Plane(String manufacture, String model, int maxNumberOfPassengers) {
		this.manufacture = manufacture;
		this.model = model;
		this.maxNumberOfPassengers = maxNumberOfPassengers;
		numberOfPlanes++; 
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMaxNumberOfPassengers() {
		return maxNumberOfPassengers;
	}

	public void setMaxNumberOfPassengers(int maxNumberOfPassengers) {
		if (maxNumberOfPassengers > 0) {
			this.maxNumberOfPassengers = maxNumberOfPassengers;			
		}
	}
	
	public static int getNumberOfPlanes() {
		return numberOfPlanes;
	}
	
	public String toString() {
		return "";
	}
}
