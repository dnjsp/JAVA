package chapter07;

public class Student extends People{
	private int studentNo;
	private String ssn;
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn);
		this.studentNo = studentNo;
	}
}
