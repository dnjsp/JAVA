package kr.or.ddit.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.CryptoUtil;

/*
	데이터를 추가할 때 회원 ID는 양방향 암호화 방식으로 암호화하고,
	비밀번호는 단방향 암호화 방식으로 암호화해서 저장한다.

	전체 자료를 출력할 때는 회원ID는 복호화해서 출력한다. 
*/

public class MemberController {
	private IMemberService service; // service객체 변수 선언
	private Scanner scan;
	private String encryptId;
	private String decryptId;
	private String encryptPass;
	String key = "a1b2c3d4e5f6g7h8";

	// 생성자
	public MemberController() {
		service = MemberServiceImpl.getInstance(); // Service객체 생성
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		new MemberController().startMember();
	}

	public void startMember() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: // 자료 추가
				insert();
				break;
			case 2: // 자료 삭제
				delete();
				break;
			case 3: // 자료 수정
				update();
				break;
			case 4: // 자료 수정2
				update2();
				break;
			case 5: // 전체 자료 출력
				displayMember();
				break;
			case 0:
				System.out.println("작업을 마칩니다.");
				return;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
			}
		}

	}

	@SuppressWarnings("unused")
	private void update2() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("회원ID>>");
		String memId = scan.next();

		int count = service.getMemberCount(memId);
		if (count == 0) {
			System.out.println(memId + "는 없는 회원ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}

		int num;
		String updateField = null;
		String updateTitle = null;

		do {
			System.out.println();
			System.out.println("수정할 항목 선택.");
			System.out.println("1.비밀번호 2.회원이름 3.전화번호 4.주소");
			System.out.println("-----------------------------------");
			System.out.print("수정할 항목 선택>>");
			num = scan.nextInt();
			switch (num) {
			case 1:
				updateField = "mem_pass";
				updateTitle = "비밀번호";
				break;
			case 2:
				updateField = "mem_name";
				updateTitle = "이름";
				break;
			case 3:
				updateField = "mem_tel";
				updateTitle = "전화번호";
				
				break;
			case 4:
				updateField = "mem_addr";
				updateTitle = "주소";
				break;
			default:

				break;
			}
		} while (num < 1 || num > 4);

		System.out.println();
		scan.nextLine(); // 버퍼 비우기
		System.out.print("새로운 " + updateTitle + ">>");
		String updateData = scan.nextLine();

		// 수정 작업에 필요한 데이터들을 Map에 저장한다.
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("memId", CryptoUtil.encryptAES256(paramMap.get("memId"), key)); // 회원ID 추가
		if (paramMap.get("field").equals("mem_pass")) {
			paramMap.put("data", CryptoUtil.sha512(paramMap.get("data")));
		}

		int cnt = service.updateMember2(paramMap);

		if (cnt > 0) {
			System.out.println("수정 작업 성공");
		} else {
			System.out.println("수정 작업 실패");
		}

	}

// 회원 정보를 수정하는 메소드 ==> 전체 항목 수정
	private void update() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("수정할 회원ID : ");
		String memId = scan.next();

		int count = service.getMemberCount(memId);
		if (count == 0) { // 없는 회원이면...
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}

		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 비밀번호 : ");
		String newPass = scan.next();
		
		System.out.print("새로운 회원이름 : ");
		String newName = scan.next();

		System.out.print("새로운 전화번호 : ");
		String newTel = scan.next();

		scan.nextLine();
		System.out.print("새로운 회원주소 : ");
		String newAddr = scan.nextLine();

		// 입력한 데이터들을 MemberVO객체에 저장하기
		MemberVO memvo = new MemberVO();
		encryptId =  CryptoUtil.encryptAES256(memId, key);
		encryptPass = CryptoUtil.sha512(newPass);
		
		memvo.setMem_id(encryptId);
		memvo.setMem_pass(encryptPass);
		memvo.setMem_name(newName);
		memvo.setMem_tel(newTel);
		memvo.setMem_addr(newAddr);

		int cnt = service.updateMember(memvo);

		if (cnt > 0) {
			System.out.println("수정 작업 성공");
		} else {
			System.out.println("수정 작업 실패");
		}

	}

// 자료를 삭제하는 메소드
	private void delete() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("삭제할 회원ID : ");
		String memId = scan.next();

		encryptId =  CryptoUtil.encryptAES256(memId, key);
		int cnt = service.deleteMember(encryptId);

		if (cnt > 0) {
			System.out.println("삭제 작업 성공");
		} else {
			System.out.println("삭제 작업 실패");
		}

	}

// 자료를 추가하는 메소드
	private void insert() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");

		int count = 0;
		String memId;
		
		do {
			System.out.print("회원 ID : ");
			memId = scan.next();
			count = service.getMemberCount(memId);
			if (count > 0) {
				System.out.println(memId + "는(은) 이미 등록된 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요.");
			}
		} while (count > 0);
		
		encryptId =  CryptoUtil.encryptAES256(memId, key);

		System.out.print("비밀번호 : ");
		String memPass = scan.next();
		encryptPass = CryptoUtil.sha512(memPass);

		System.out.print("회원이름 : ");
		String memName = scan.next();
		System.out.print("전화번호 : ");
		String memTel = scan.next();

		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("회원주소 : ");
		String memAddr = scan.nextLine();

		// 입력한 데이터들을 MemberVO객체에 담는다.
		MemberVO memvo = new MemberVO();
		memvo.setMem_id(encryptId);
		memvo.setMem_pass(encryptPass);
		memvo.setMem_name(memName);
		memvo.setMem_tel(memTel);
		memvo.setMem_addr(memAddr);

		int cnt = service.insertMember(memvo);

		if (cnt > 0) {
			System.out.println("추가 작업 성공");
		} else {
			System.out.println("추가 작업 실패");
		}
	}

// 메뉴를 출력하는 메소드
	private int displayMenu() {
		System.out.println();
		System.out.println("=======================================");
		System.out.println("          == 작 업 선 택 ==");
		System.out.println("          1. 자 료 추 가 ");
		System.out.println("          2. 자 료 삭 제 ");
		System.out.println("          3. 자 료 수 정 ");
		System.out.println("          4. 자 료 세 부 수 정 ");
		System.out.println("          5. 전 체 자 료 출 력 ");
		System.out.println("          0. 작 업 끝 ");
		System.out.println("=======================================");
		System.out.print("원하는 작업 선택 >> ");
		int num = scan.nextInt();
		return num;
	}

// 전체 회원 정보를 출력하는 메소드
	private void displayMember() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		List<MemberVO> list = service.getAllMemberList();
		
		System.out.println("————————————————————————");
		System.out.println(" ID    비밀번호   이름     전화번호      주소  ");
		System.out.println("————————————————————————");

		if (list == null || list.size() == 0) {
			System.out.println("회원 자료가 하나도 없습니다.");
		} else {
			for (MemberVO memvo : list) {
				decryptId = CryptoUtil.decryptAES256(memvo.getMem_id(), key);

				System.out.println(decryptId + "   " + memvo.getMem_pass() + "   " + memvo.getMem_name() + "   "
						+ memvo.getMem_tel() + "   " + memvo.getMem_addr());
			}
		}

		System.out.println("—————————————————————————");
		System.out.println("출력 끝..");

	}


}
