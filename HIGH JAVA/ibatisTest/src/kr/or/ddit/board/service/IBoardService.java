package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {

		//게시글 저장
		public int insertPost(BoardVO boardVO);
		
		//게시글 삭제
		public int deletePost(int boardNo);
		
		//게시글 출력
		public List<BoardVO> getAllPostList();
		
		//게시글 수정
		public int updatePost(BoardVO boardVO);
		
		//게시글 존재 여부 확인
		public int getPostCount(int boardNo);
		
		//게시글 조회
		public BoardVO getBoard(BoardVO boardVO);
		
		//조회수 증가
		public int updateBoardCnt(int number);
		public List<BoardVO> searchBoard(String changeContent);
}
