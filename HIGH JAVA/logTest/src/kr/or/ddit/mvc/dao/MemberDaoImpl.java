package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {
	static Logger logger = Logger.getLogger(MemberDaoImpl.class);
	static ResourceBundle bundle;
	
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {	}
	
	public static MemberDaoImpl getInstance() {
		if (dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO memvo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성...");
			
			String sql = "insert into mymember (mem_id, mem_pass, mem_name, mem_tel, mem_addr)"
					+ " values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memvo.getMem_id());
			pstmt.setString(2, memvo.getMem_pass());
			pstmt.setString(3, memvo.getMem_name());
			pstmt.setString(4, memvo.getMem_tel());
			pstmt.setString(5, memvo.getMem_addr());

			logger.info("PreparedStatement객체 생성...");
			logger.info("실행한 SQL : " + sql);
			logger.info("사용 데이터 : [" + memvo.getMem_id() + ", " + memvo.getMem_pass() + ", " + memvo.getMem_name() + ", " + memvo.getMem_tel() + ", " + memvo.getMem_addr() + "]");
			
			cnt = pstmt.executeUpdate();
			logger.info("작업 성공~~");
			
		} catch (SQLException e) {
			logger.error("작업 실패 : " + e);
			cnt = 0;
//			e.printStackTrace();
			
		} finally {
			
			if (pstmt != null)
				try { 
					pstmt.close(); 
					logger.info("PreparedStatement객체 반납...");
					
				} catch (SQLException e) {}
			
			if (conn != null) 
				try { 
					conn.close();
					logger.info("Connection객체 반납...");
					
				} catch (SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성...");

			String sql = "delete from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			logger.info("PreparedStatement객체 생성...");
			logger.info("실행한 SQL : " + sql);
			logger.info("사용 데이터 : [" + memId + "]");
			
			cnt = pstmt.executeUpdate();
			logger.info("작업 성공~~");

		} catch (SQLException e) {
			logger.error("작업 실패 : " + e);
//			e.printStackTrace();
			
		} finally {
			
			if (pstmt != null)
				try { 
					pstmt.close(); 
					logger.info("PreparedStatement객체 반납...");
					
				} catch (SQLException e) {}
			
			if (conn != null) 
				try { 
					conn.close();
					logger.info("Connection객체 반납...");
					
				} catch (SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memvo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성...");
			
			String sql = "update mymember set mem_pass = ?, mem_name = ?, mem_tel = ?, "
					+ " mem_addr = ? where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memvo.getMem_pass());
			pstmt.setString(2, memvo.getMem_name());
			pstmt.setString(3, memvo.getMem_tel());
			pstmt.setString(4, memvo.getMem_addr());
			pstmt.setString(5, memvo.getMem_id());

			logger.info("PreparedStatement객체 생성...");
			logger.info("실행한 SQL : " + sql);
			logger.info("사용 데이터 : [" + memvo.getMem_pass() + ", " + memvo.getMem_name() + ", " + memvo.getMem_tel() + ", " + memvo.getMem_addr() + ", " + memvo.getMem_id() + "]");
			
			cnt = pstmt.executeUpdate();
			logger.info("작업 성공~~");
			
		} catch (SQLException e) {
			logger.error("작업 실패 : " + e);
//			e.printStackTrace();
			
		} finally {
			
			if (pstmt != null)
				try { 
					pstmt.close(); 
					logger.info("PreparedStatement객체 반납...");
					
				} catch (SQLException e) {}
			
			if (conn != null) 
				try { 
					conn.close();
					logger.info("Connection객체 반납...");
					
				} catch (SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> list =new ArrayList<MemberVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성...");
			
			String sql = "select * from mymember";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MemberVO memvo = new MemberVO();	
				memvo.setMem_id(rs.getString("mem_id"));
				memvo.setMem_pass(rs.getString("mem_pass"));
				memvo.setMem_name(rs.getString("mem_name"));
				memvo.setMem_tel(rs.getString("mem_tel"));
				memvo.setMem_addr(rs.getString("mem_addr"));
				
				logger.info("ResultSet객체 생성...");
				logger.info("실행한 SQL : " + sql);
				logger.info("사용 데이터 : ["  + memvo.getMem_id() + ", " + memvo.getMem_pass() + ", " + memvo.getMem_name() + ", " + memvo.getMem_tel() + ", " + memvo.getMem_addr() + "]");
				
				list.add(memvo);
				logger.info("작업 성공~~");
			}

		} catch (SQLException e) {
			logger.error("작업 실패 : " + e);
			list = null;
//			e.printStackTrace();
			
		} finally {
			
			if (rs != null)
				try { 
					rs.close(); 
					logger.info("PreparedStatement객체 반납...");
					
				} catch (SQLException e) {}
			
			if (stmt != null) 
				try { 
					stmt.close();
					logger.info("Connection객체 반납...");
					
				} catch (SQLException e) {}
			
			if (conn != null) 
				try { 
					conn.close();
					logger.info("Connection객체 반납...");
					
				} catch (SQLException e) {}
		}
		
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성...");
			
			String sql = "select count(*) cnt from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			logger.info("PreparedStatement객체 생성...");
			logger.info("실행한 SQL : " + sql);
			logger.info("사용 데이터 : [" + memId + "]");
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("cnt");
			}

			logger.info("작업 성공~~");

		} catch (SQLException e) {
			logger.error("작업 실패 : " + e);
			count = 0;
//			e.printStackTrace();
			
		} finally {
			
			if (rs != null)
				try { 
					rs.close(); 
					logger.info("PreparedStatement객체 반납...");
					
				} catch (SQLException e) {}
			
			if (pstmt != null) 
				try { 
					pstmt.close();
					logger.info("Connection객체 반납...");
					
				} catch (SQLException e) {}
			
			if (conn != null) 
				try { 
					conn.close();
					logger.info("Connection객체 반납...");
					
				} catch (SQLException e) {}
		}
		
		return count;
	}
	
	public int updateMember2(Map<String, String> paramMap) {
		// kye값 정보 ==> 회원ID(memId), 수정할 컬럼명(field), 수정할 데이터(data)
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성...");
			
			String sql = "update mymember set "
					+ paramMap.get("field") + " = ? "
					+ "where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramMap.get("data"));
			pstmt.setString(2, paramMap.get("memId"));
			
			logger.info("PreparedStatement객체 생성...");
			logger.info("실행한 SQL : " + sql);
			logger.info("사용 데이터 : [" + paramMap.get("data") + ", " + paramMap.get("memId") + "]");
			
			cnt = pstmt.executeUpdate();
			
			logger.info("작업 성공~~");
			
		} catch (SQLException e) {
			logger.error("작업 실패 : " + e);
//			e.printStackTrace();
			
		} finally {
			
			if (pstmt != null)
				try { 
					pstmt.close(); 
					logger.info("PreparedStatement객체 반납...");
					
				} catch (SQLException e) {}
			
			if (conn != null) 
				try { 
					conn.close();
					logger.info("Connection객체 반납...");
					
				} catch (SQLException e) {}
		}
		
		return cnt;
	}
	
}
