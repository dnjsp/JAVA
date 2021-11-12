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

public class MemberServiceImpl1 implements IMemberService {
	private IMemberDao dao; // DAO객체가 저장될 변수 선언
	private String key = "a1b2c3d4e5f6g7h8i9";

	// 1.
	private static MemberServiceImpl1 service;

	// 2. 생성자
	private MemberServiceImpl1() {
//      dao = new MemberDaoImpl();      // DAO객체 생성
		dao = MemberDaoImpl.getInstance();
	}

	// 3.
	public static MemberServiceImpl1 getInstance() {
		if (service == null)
			service = new MemberServiceImpl1();
		return service;
	}

	@Override
	public int insertMember(MemberVO memvo) {

		try {
			memvo.setMem_id(CryptoUtil.encryptAES256(memvo.getMem_id(), key));
			memvo.setMem_pass(CryptoUtil.sha512(memvo.getMem_pass()));
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}

		return dao.insertMember(memvo);
	}

	@Override
	public int deleteMember(String memId) {
		try {
			memId = CryptoUtil.encryptAES256(memId, key);
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memvo) {
		try {
			memvo.setMem_id(CryptoUtil.encryptAES256(memvo.getMem_id(), key));
			memvo.setMem_pass(CryptoUtil.sha512(memvo.getMem_pass()));
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return dao.updateMember(memvo);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> list = dao.getAllMemberList();

		try {
			for (MemberVO mvo : list) {
				mvo.setMem_id(CryptoUtil.decryptAES256(mvo.getMem_id(), key));
			}
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return list;
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
	public int updateMember2(Map<String, String> map) {
		try {
			map.put("memId", CryptoUtil.encryptAES256(map.get("memId"), key));
			if (map.get("field").equals("mem_pass")) {
				map.put("data", CryptoUtil.sha512(map.get("data")));
			}

		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}

		return dao.updateMember2(map);
	}

}