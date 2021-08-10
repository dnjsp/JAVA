package practice01.p02;

public class UnitOfYear {

	public static void main(String[] args) {
		
		double distance = 40e12;
		double speed = 300_000; //_는 ,라는 뜻
		double unitOfYear = 60 * 60 * 24 * 365;
		double time = distance / speed / unitOfYear; 
		System.out.println("빛의 속도로 프록시마 센타우리 별까지 가는데 걸리는 시간은 " + time + "광년이다.");
		
	}

}
