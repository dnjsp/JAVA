package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class BoardDAOImpl implements IBoardDAO {
	
	private static BoardDAOImpl instance;
	
	private SqlMapClient smc;
	
	private BoardDAOImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
//		try {
//			Charset charset = Charset.forName("UTF-8");
//			Resources.setCharset(charset);
//			
//			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
//			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
//			rd.close();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	public static BoardDAOImpl getInstance() {
		if(instance == null) {
			instance = new BoardDAOImpl();
			return instance;
		}
		return instance;
	}

	@SuppressWarnings("unused")
	@Override
	public int insertPost(BoardVO boardVO) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("board.insertPost", boardVO);
			
			if (instance == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		
		return cnt;
	}

	@Override
	public int deletePost(int boardNo) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("board.deletePost", boardNo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		
		return cnt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> getAllPostList() {
		  List<BoardVO> list = null;
		  
		  try {
			list = smc.queryForList("board.getAllPost");
			
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		  
		return list;
	}

	@Override
	public int updatePost(BoardVO boardVO) {
		int cnt = 0;
		
		try {
			cnt = smc.update("board.updatePost", boardVO);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int getPostCount(int boardNo) {
		int cnt = 0;
		
		try {
			cnt = (int) smc.queryForObject("board.getPostCount", boardNo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		
		return cnt;
	}

	@Override
	public BoardVO getBoard(BoardVO boardVO) {
		BoardVO vo = null;
		
		try {
			vo = (BoardVO) smc.queryForObject("board.getBoard", boardVO);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	@Override
	public int updateBoardCnt(int boardNo) {
		int cnt = 0;

		try {
			cnt = smc.update("board.updateBoardCnt", boardNo);
			
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		}
		return cnt;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> searchBoard(String changeContent) {
		List<BoardVO> list = null;
		
		try {
			list = smc.queryForList("board.searchBoard", changeContent);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
