package chapter13;

public class IntegerBox {
	private int data;

	public IntegerBox(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Box [data=" + data + "]";
	}
	
}
