package practice01.p08;

public abstract class Book {
	private int number;
	private String title;
	private String author;
	private static int countOfBooks;
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		number = ++countOfBooks; // 관리번호를 1부터 시작하고 싶으면 먼저 +를 해주면 됨
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public abstract int getLateFee(int lateDays);
	
//	@Override
//	public boolean equals(Object obj) {
//		if (getTitle().equals(title) && getAuthor().equals(author)) {
//			return true;
//		}
//		return false;
//	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book book = (Book) obj;
			return title.equals(book.getTitle()) && author.equals(book.getAuthor());
		}
		return false;
	}
	
//	public int hashCode() {
//		return number;
//		
//	}
	
	@Override
	public int hashCode() {
		return (title.hashCode () * 31 + author.hashCode()) * 31;
		// 숫자에는 소수가 들어가면 됨 (이왕이면 큰 숫자로)
	}
	
	// equals랑	hashCode는 Shift + Alt + S 눌러서 자동완성되게 해도 됨
	
	public String toString() {
		return String.format("관리번호 %d번, 제목: %s, 작가: %s(일주일 연체료: %,d원)",
							 number, title, author, getLateFee(7));
	}
	
	
//	public String toString() {
//		return "관리번호 " + (number + 1) + "번, 제목: " + title + ", 작가: " + author +
//			   "(일주일 연체료: " + getLateFee(7) + "원)";
//	}
	
}
