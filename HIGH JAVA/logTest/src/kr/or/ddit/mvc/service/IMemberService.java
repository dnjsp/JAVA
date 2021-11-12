package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * Service객체는 Dao에 설정된 메소드를 원하는 작업에 맞게 호출하여 결과를 받아오고, 
 * 받아온 결과를 Controller에게 보내주는 역할을 한다.
 * 
 * @author PC-19
 *
 */
public interface IMemberService {
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메소드
	 * 
	 * @param memvo DB에 insert할 데이터가 저장된 MemberVO객체
	 * @return 작업 성공 : 1, 실패 : 0
	 */
	public int insertMember(MemberVO memvo);

	/**
	 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메소드
	 * 
	 * @param memId 삭제할 회원ID
	 * @return 작업 성공 : 1, 실패 : 0
	 */
	public int deleteMember(String memId);

	/**
	 * MemberVO자료를 이용하여 DB의 회원 정보를 update하는 메소드
	 * 
	 * @param memvo update할 데이터가 저장된 MemberVO객체
	 * @return 작업 성공 : 1, 실패 : 2
	 */
	public int updateMember(MemberVO memvo);

	/**
	 * DB의 회원테이블의 전체 레코드를 가져와서 List에 담아 반환하는 메소드
	 * 
	 * @return MemberVO객체를 담고 있는 List객@Override
	체
	 */
	public List<MemberVO> getAllMemberList();
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원의 개수를 반환하는 메소드
	 * 
	 * @param memId 검색할 회원ID
	 * @return 검색된 회원ID 개수 
	 */
	public int getMemberCount(String memId);

	public int updateMember2(Map<String, String> map);
}
