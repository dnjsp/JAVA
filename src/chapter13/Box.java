package chapter13;
	
public class Box<T> { // 어떤 타입이 들어가는지 나중에 알려주는 것
					  // 보통 한글자로만 입력
	private T data;
	
	public Box(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public static <T> String getStreamData(int a) {
		return "";
	}
	
	@Override
	public String toString() {
		return "Box [data=" + data + "]";
	} 
	
}
