package chapter07;

public class ChildExample {
	public static void main(String[] args) {

		Parent child = new Child();			
		if (child instanceof Child) { 
		// instanceof : 실제로 이 타입이 맞는지 아닌지 확인해서 맞는 타입만 실행시켜주는 연산자 
			((Child) child).method3();
		}		
		
		Parent parent = new Parent();
		if (parent instanceof Child) {
			((Child) parent).method3();
		}
		
		// 컴파일 시점에서는 형식만 맞으면 되는데 run 타임에선 에러가 남
		// 캐스팅한다고 해서 Parent에 method3가 생기는 게 아니기 때문
	}
}
