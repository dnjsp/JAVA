package chapter11;

public class test {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		
		boolean result = obj1.equals(obj2);
		
		boolean result2 = (obj1 == obj2);
		
		String a = "사과";
		String b = new String("사과");
		//equals() : 데이터 비교 * 문자열 비교
		boolean result3 = a.equals(b);	//true
		//== 은 두개의 자료형이 동일한 객체인지를 판별할 때 사용하는 연산자
		boolean result5 = (a == b);	//false
		//결론 : a와 b는 값(데이터)은 같지만 서로 다른 객체이다.
		
		Member mem1 = new Member("김철수");
		Member mem2 = new Member("개똥이");
		//equals : 데이터 비교
		System.out.println("처음 : " + mem1.equals(mem2)); //false
		
		//mem1객체와 mem2객체가 같다면?
		mem1.setName("개똥이");
		System.out.println("나중 : " + mem1.equals(mem2)); //true
//		System.out.println("결과 : " + mem2.getName());
		
		System.out.println(mem1 == mem2); //false => 다른 객체이다.
		
		System.out.println("result : " + result);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
		System.out.println("result5 : " + result5);
	}

}
