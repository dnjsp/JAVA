package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LprodIbatisTest {
	// iBatis를 이용하여 DB자료를 처리하는 순서 및 방법 연습하기
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 1. iBatis의 환경설정 파일(sqlMapConfig.xml)을 읽어와 실행한다.
		try {
			// 1-1. 문자 인코딩 캐릭터셋 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			// 1-2. 환경설정 파일(sqlMapConfig.xml)을 읽어온다.
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			
			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경설정을 완성한 후 SQL문을 호출해서 실행할 객체를 생성한다.
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();  // Reader객체 닫기
			
			// 2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
			
			/*
			// 2-1. insert연습
			System.out.println("insert연습 시작...");
			System.out.print("Lprod_id 입력 : ");
			int lprodId = scan.nextInt();
			
			System.out.print("Lprod_gu 입력 : ");
			String lprodGu = scan.next();
			
			System.out.print("Lprod_nm 입력 : ");
			String lprodNm = scan.next();
			
			// 입력한 데이터를 VO에 저장한다.
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(lprodId);
			lvo.setLprod_gu(lprodGu);
			lvo.setLprod_nm(lprodNm);
			
			// SqlMapClient객체변수를 이용하여 처리할 쿼리문을 호출하여 실행한다.
			// 형식) smc.insert("namespace값.id값", 파라미터클래스)
			// 		 반환값 : insert성공 : null, insert실패: 오류 객체
			Object obj = smc.insert("Lprod.insertLprod", lvo);
			if (obj == null) {
				System.out.println("insert 작업 성공!!!");
			} else {
				System.out.println("insert 작업 실패~~~");
			}
			
			// 2-2. update연습
			System.out.println("update 시작...");
			System.out.print("수정할 Lprod_gu 입력 : ");
			String gu = scan.next();
			
			System.out.print("새로운 Lprod_id 입력 : ");
			int id = scan.nextInt();
			System.out.print("새로운 Lprod_nm 입력 : ");
			String nm = scan.next();
			
			// 입력받은 데이터 VO에 저장하기
			LprodVO lvo2 = new LprodVO();
			lvo2.setLprod_gu(gu);
			lvo2.setLprod_id(id);
			lvo2.setLprod_nm(nm);
			
			// 형식) smc.update("namespace값.id값", 파라미터클래스);
			//		 반환값 : 성공한 레코드 수
			int cnt = smc.update("Lprod.updateLprod", lvo2);
			if (cnt > 0) {
				System.out.println("update 성공!!!");
			} else {
				System.out.println("update 실패~~~");
			}

			// 2-3. delete연습
			System.out.println("delete 연습 시작...");
			System.out.print("삭제할 Lprod_gu 입력 :");
			String lgu = scan.next();
			
			// 형식) smc.delete("namespace값.id값", 파라미터클래스)
			//		 반환값 : 작업에 성공한 레코드 수
			int cnt2 = smc.delete("Lprod.deleteLprod", lgu);
			if (cnt2 > 0) {
				System.out.println("delete 작업 성공!");
			} else {
				System.out.println("delete 작업 실패~");
			}
			
			// 2-4. select 연습
			// 1) 응답 결과가 여러개인 경우
			System.out.println("select 연습 시작(결과가 여러개인 경우)...");
			
			// 응답 결과가 여러개인 경우에는 queryForList()메서드를 사용하는데 이 메서드는 여러개의 레코드 각각을 VO에 담은 후
			// 이 VO데이터를 List에 추가해 주는 작업을 자동으로 수행한다.
			// 형식) smc.queryForList("namespace값.id값", 파라미터클래서)
			List<LprodVO> lprodList = smc.queryForList("Lprod.getAllLprod");
			
			for (LprodVO lprodVO : lprodList) {
				System.out.println("ID : " + lprodVO.getLprod_id());
				System.out.println("GU : " + lprodVO.getLprod_gu());
				System.out.println("NM : " + lprodVO.getLprod_nm());
				System.out.println("-----------------------------------");
			}
			System.out.println("출력 끝...");
			*/
			
			// 응답 결과가 1개인 경우
			System.out.println("select 연습 시작(결과가 1개인 경우)...");
			System.out.print("검색할 Lprod_gu 입력 : ");
			String lprodGu = scan.next();
			
			// 응답 결과가 1개가 확실한 경우에는 queryForObject()메서드를 사용한다.
			// 형식) smc.queryForObject("namespace값.id값", 파라미터클래스)
			//		 반환값 : 1. 처리결과가 여러개인 경우 ==> exception 객체 반환
			//				  2. 처리결과가 1개인 경우	  ==> 해당 객체 반환
			//				  3. 처리결과가 없을 경우 	  ==> null 반환
			LprodVO reLvo = (LprodVO) smc.queryForObject("Lprod.getLprod", lprodGu);
			
			if (reLvo == null) {
				System.out.println("검색한 데이터가 하나도 없습니다.");
				return;
			}
			
			System.out.println("ID : " + reLvo.getLprod_id());
			System.out.println("GU : " + reLvo.getLprod_gu());
			System.out.println("NM : " + reLvo.getLprod_nm());
			System.out.println("---------------------------------");
			System.out.println("출력 끝...");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		scan.close();
	}
}
