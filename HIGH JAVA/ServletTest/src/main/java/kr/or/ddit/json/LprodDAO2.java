package kr.or.ddit.json;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;

public class LprodDAO2 {
	private SqlMapClient smc;
	
	public LprodDAO2() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public List<LprodVO> getLprodList() {
		List<LprodVO> list = null;
		try {
			list = smc.queryForList("Lprod.getAllLprod");
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}
}
