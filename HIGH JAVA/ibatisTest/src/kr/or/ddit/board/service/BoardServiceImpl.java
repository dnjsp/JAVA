package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDAOImpl;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	private IBoardDAO dao;
	private static BoardServiceImpl instance;
	
	private BoardServiceImpl() {
		dao = BoardDAOImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(instance == null) {
			instance = new BoardServiceImpl();
			return instance;
		}
		return instance;
	}
	@Override
	public int insertPost(BoardVO boardVO) {
		return dao.insertPost(boardVO);
	}

	@Override
	public int deletePost(int boardNo) {
		return dao.deletePost(boardNo);
	}

	@Override
	public List<BoardVO> getAllPostList() {
		return dao.getAllPostList();
	}

	@Override
	public int updatePost(BoardVO boardVO) {
		return dao.updatePost(boardVO);
	}

	@Override
	public int getPostCount(int boardNo) {
		return dao.getPostCount(boardNo);
	}

	@Override
	public BoardVO getBoard(BoardVO boardVO) {
		return dao.getBoard(boardVO);
	}


	@Override
	public int updateBoardCnt(int number) {
		return dao.updateBoardCnt(number);
	}

	@Override
	public List<BoardVO> searchBoard(String changeContent) {
		return dao.searchBoard(changeContent);
	}

}
