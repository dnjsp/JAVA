package chapter13.exercise;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {

	public List<Board> getBoardList() {
		// 다음에는 데이터베이스에 존재하는 board 테이블의 데이터를 가져와서 List에 담아서 리턴해줄 예정임
		List<Board> list = new ArrayList<Board>();
		list.add(new Board("제목1", "내용1"));
		list.add(new Board("제목2", "내용2"));
		list.add(new Board("제목3", "내용3"));
		return list;
	}
}
