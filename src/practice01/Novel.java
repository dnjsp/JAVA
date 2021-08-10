package practice01.p08;

public class Novel extends Book{
	public Novel(String title, String author) {
		super(title, author);
	}
	
	public int getLateFee(int lateDays) {
		return lateDays * 300;
	}
}
