package kr.or.ddit.mvc.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.CryptoUtil;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao; // DAO객체가 저장될 변수 선언
	private static MemberServiceImpl instance;
	String key = "a1b2c3d4e5f6g7h8";

	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(instance == null) {
			instance = new MemberServiceImpl();
			return instance;
		}
		return instance;
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
		try {
			memId = CryptoUtil.encryptAES256(memId, key);
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return dao.getMemberCount(memId);
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		return dao.updateMember2(paramMap);
	}

}
