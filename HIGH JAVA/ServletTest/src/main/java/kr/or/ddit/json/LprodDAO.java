package kr.or.ddit.json;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.DBUtil;

public class LprodDAO {

	public List<LprodVO> getLprodList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<LprodVO> list = new ArrayList<LprodVO>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from lprod";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				LprodVO lpvo = new LprodVO();
				lpvo.setLprod_id(rs.getInt("lprod_id"));
				lpvo.setLprod_gu(rs.getString("lprod_gu"));
				lpvo.setLprod_nm(rs.getString("lprod_nm"));
				
				list.add(lpvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {}
			if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}	
		return list;
	}
}