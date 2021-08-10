package practice01.p08;

public class ScienceFiction extends Book{
	public ScienceFiction(String title, String author) {
		super(title, author);
	}
	
	public int getLateFee(int lateDays) {
		return lateDays * 600;
	}
}
