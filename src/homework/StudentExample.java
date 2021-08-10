package z_homework;

public class StudentExample {
	public static void main(String[] args) {
		Student[] ddit406 = new Student[25];
		ddit406[0] =  new Student("강주희", 32);
		ddit406[1] =  new Student("구현수", 29);
		ddit406[2] =  new Student("권영채", 31);
		ddit406[3] =  new Student("김다윤", 27);
		ddit406[4] =  new Student("김주현", 25);
		ddit406[5] =  new Student("박수정", 27);
		ddit406[6] =  new Student("박해성", 28);
		ddit406[7] =  new Student("봉현민", 33);
		ddit406[8] =  new Student("서유리", 28);
		ddit406[9] =  new Student("서혜란", 28);
		ddit406[10] = new Student("안대근", 27);
		ddit406[11] = new Student("유영진", 27);
		ddit406[12] = new Student("유재면", 34);
		ddit406[13] = new Student("유제이", 26);
		ddit406[14] = new Student("윤주원", 29);
		ddit406[15] = new Student("윤효주", 32);
		ddit406[16] = new Student("이나영", 27);
		ddit406[17] = new Student("이인환", 27);
		ddit406[18] = new Student("이준석", 27);
		ddit406[19] = new Student("이희열", 27);
		ddit406[20] = new Student("임창균", 26);
		ddit406[21] = new Student("임태희", 31);
		ddit406[22] = new Student("조원혜", 25);
		ddit406[23] = new Student("최가현", 21);
		ddit406[24] = new Student("한주연", 24);
		
		System.out.printf("[%3s%5s%4s%4s%5s%5s ]\n", "이름", "나이", "자바", "오라클", "SQL", "평균");
		for(int i = 0; i < ddit406.length; i++) {
			ddit406[i].showInfo();
		}
	}
}
