package chapter13;

public class BoxExample {
	public static void main(String[] args) {
		
		IntegerBox box = new IntegerBox(10);
		System.out.println(box.getData());
		
		StringBox stringBox = new StringBox("10");
		System.out.println(stringBox.getData());
	
		DoubleBox doubleBox = new DoubleBox(10.1);
		System.out.println(doubleBox.getData());
	
		Box<String> box2 = new Box<String>("ac");
		System.out.println(box2.getData());
		Box<Integer> box3 = new Box<Integer>(10);
		System.out.println(box3.getData());
	}
}
