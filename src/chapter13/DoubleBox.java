package chapter13;

public class DoubleBox {
	private double data;

	public DoubleBox(double data) {
		this.data = data;
	}

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DoubleBox [data=" + data + "]";
	}
}
