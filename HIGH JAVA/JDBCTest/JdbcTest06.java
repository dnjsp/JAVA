package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.or.ddit.util.DBUtil;

/*
 * 	회원을 관리하는 프로그램을 작성하시오.
 * 	(maria DB mymember 테이블 이용)
 * 	아래 메뉴의 기능을 모두 구현하시오. (CRUD 기능 구현하기)
 * 
 *	메뉴예시)
 *	=========================
 *		-- 작업 선택 --
 *		1. 자료 추가
 *		2. 자료 삭제
 *		3. 자료 수정
 *		4. 전체 자료 출력
 *		0. 작업 끝.
 *	=========================₩
 *
 *	처리 조건) 
 *	1) 자료 추가에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력받는다.)
 *	2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
 *	3) 자료 수정에서 '회원ID는 변경되지 않는다.
 *
 */

public class JdbcTest06 {
	MemberVO vo = new MemberVO();
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		
		JdbcTest06 jt = new JdbcTest06();
		jt.start();
	}
	
	private void start() {
		
		while (true) {
			System.out.println("1. 자료추가 2. 자료삭제 3. 자료 수정 4. 전체 자료 출력 5. 자료수정2 0. 작업 끝");
			try {
				switch (Integer.parseInt(br.readLine())) {
				case 1:
					insert();
					break;
				case 2:
					delete();
					break;
				case 3:
					update();
					break;
				case 4:
					selectAll();
					break;
				case 5:
					update2();
				case 0:
					return;
				default:
					System.out.println("다시 입력해 주세요!");
					break;
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
	}


	private void update2() {
		conn = DBUtil.getConnection();
		StringBuilder sqlUp2 = new StringBuilder();
		sqlUp2.append("UPDATE ");
		sqlUp2.append("");
		sqlUp2.append("");
		sqlUp2.append("");
	}

	private int check() {

		int count = -1;
		try {
			conn = DBUtil.getConnection();
			String sqlCheck = "SELECT COUNT(*) cnt FROM MYMEMBER WHERE MEM_ID = ?";
			pstmt = conn.prepareStatement(sqlCheck);
			
			stmt = conn.createStatement();
			
			
				System.out.println("아이디 입력받기");

				vo.setMemId(br.readLine());
				
				pstmt.setString(1, vo.getMemId());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}

	private void insert() {
		if(check()==0) {
			try {
				conn = DBUtil.getConnection();
				
				System.out.println("패스 입력받기");
				vo.setMemPass(br.readLine());
				
				System.out.println("주소 입력받기");
				vo.setMemAddr(br.readLine());

				System.out.println("이름 입력받기");
				vo.setMemName(br.readLine());
				
				System.out.println("번호 입력받기");
				vo.setMemTel(br.readLine());

				String sqlIn = "INSERT INTO MYMEMBER(MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR)"
						+ " VALUES(?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sqlIn);
				
				pstmt.setString(1, vo.getMemId());
				pstmt.setString(2, vo.getMemPass());
				pstmt.setString(3, vo.getMemName());
				pstmt.setString(4, vo.getMemTel());
				pstmt.setString(5, vo.getMemAddr());
				
				int cnt = pstmt.executeUpdate();
				
				if(cnt>0) {
					System.out.println("등록성공");
				} else {
					System.out.println("실패");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("이미 걔는 있어");
		}

	}
	private void delete() {
		try {
			conn = DBUtil.getConnection();
			
			System.out.println("아이디 입력받기");
			vo.setMemId(br.readLine());
			
			String sqlD = "DELETE FROM mymember"
					+ " WHERE mem_id = ?";
			pstmt = conn.prepareStatement(sqlD);
			
			pstmt.setString(1, vo.getMemId());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("아이디가 있냐?");
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}
	private void update() {
		try {
			conn = DBUtil.getConnection();
			
			System.out.println("수정할 아이디 입력");
			vo.setMemId(br.readLine());
			
			System.out.println("패스 입력받기");
			vo.setMemPass(br.readLine());
			
			System.out.println("주소 입력받기");
			vo.setMemAddr(br.readLine());

			System.out.println("이름 입력받기");
			vo.setMemName(br.readLine());
			
			System.out.println("번호 입력받기");
			vo.setMemTel(br.readLine());
			
			
			String sqlUp = "UPDATE MYMEMBER"
					+ " SET	MEM_PASS = ?, MEM_NAME = ?,	MEM_TEL = ?, MEM_ADDR = ?"
					+ " WHERE MEM_ID = ?";
			pstmt = conn.prepareStatement(sqlUp);
			
			pstmt.setString(1, vo.getMemPass());
			pstmt.setString(2, vo.getMemName());
			pstmt.setString(3, vo.getMemTel());
			pstmt.setString(4, vo.getMemAddr());
			pstmt.setString(5, vo.getMemId());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
			
		} catch (SQLException | IOException e) {	
			e.printStackTrace();
		}
	}
	private void selectAll() {
		conn = DBUtil.getConnection();
		
		try {
			String sqlAll = "SELECT * FROM mymember";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlAll);
			
			while (rs.next()) {
				System.out.print("MEM_ID : " +rs.getString("mem_id") + "\t");
				System.out.print("MEM_ADDR : " +rs.getString("mem_addr") + "\t");
				System.out.print("MEM_TEL : " +rs.getString("mem_tel") + "\t");
				System.out.print("MEM_NAME : " +rs.getString("mem_name") + "\t");
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}