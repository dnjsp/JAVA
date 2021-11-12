package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	
	// 1번
	private static MemberServiceImpl service;
	
	// 생성자 ==> 2번
// 	public MemberServiceImpl() {
	private MemberServiceImpl() {
		// dao = new MemberDaoImpl();
		dao = MemberDaoImpl.getInstance();  // DAO객체 생성
	}
	
	// 3번
	public static MemberServiceImpl getInstance() {
		if (service == null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public int insertMember(MemberVO memvo) {
		return dao.insertMember(memvo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memvo) {
		return dao.updateMember(memvo);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return dao.getAllMemberList();
	}

	@Override
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}

	@Override
	public int updateMember2(Map<String, String> map) {
		return dao.updateMember2(map);
	}
	
}
