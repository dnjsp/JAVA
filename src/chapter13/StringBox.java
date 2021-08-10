package chapter13;

public class StringBox {
	private String data;

	public StringBox(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "StringBox [data=" + data + "]";
	}

}
