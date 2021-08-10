package z_homework;

import java.util.Random;

public class Student {
	public String name;
	public int age, java, oracle, sql;
	public Random rnd = new Random();
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		this.java = rnd.nextInt(51) + 50;
		this.oracle = rnd.nextInt(51) + 50;
		this.sql = rnd.nextInt(51) + 50;		
	}
	
	public void showInfo() {
		System.out.printf("[%3s%4s세%4s점%4s점%4s점%6s점]\n",
				this.name, this.age, this.java, this.oracle, this.sql, getAverage());
	}
	
	public double getAverage() {
		return Math.round(((java + oracle + sql) / 3.0) * 10) / 10.0;
	}
	
}
