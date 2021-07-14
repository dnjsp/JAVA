package chapter06.exercise;

public class BoardExample {
	public static void main(String[] args) {
		Board board1 = new Board("제목", "내용");
		Board board2 = new Board("제목", "내용", "김주현");
		Board board3 = new Board("제목", "내용", "김주현", "2021-06-23");
		Board board4 = new Board("제목", "내용", "김주현", "2021-06-23", 0);
		
		System.out.println(board1);
		System.out.println(board2);
		System.out.println(board3);
		System.out.println(board4);
	}
}
