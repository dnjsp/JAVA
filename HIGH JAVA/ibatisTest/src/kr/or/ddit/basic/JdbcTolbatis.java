package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

// jdbc공부할 때 사용했던 jdbcTest05.java 프로그램을 ibatis용으로 변환하시오.
// SQL문이 저장될 xml문서의 파일명은 'jdbc.xml'로 한다.)

public class JdbcTolbatis {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SqlMapClient smc = null;
		
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
			
//	        Lprod_id는 현재의 Lprod_id중 제일 큰 값보다 1만큼 크게해서 처리한다.
			int nextId = (int) smc.queryForObject("jdbc.getMaxId");
			
			// 입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
	         String gu;       // 상품 분류 코드(LPROD_GU)가 저장될 변수 선언
	         int count = 0;   // 입력한 상품 분류 코드의 개수가 저장될 변수
	         
	         do {
	            System.out.print("상품 분류 코드(LPROD_GU) 입력 : ");
	            gu = scan.next();
	            
	            count = (int) smc.queryForObject("jdbc.getCountGu", gu);
	        
	            if (count>0) {
	               System.out.println("입력한 상품 분류 코드" + gu + "는 이미 등록된 코드입니다.");
	               System.out.println("다시 입력하세요.");
	            }
	        
	         } while (count > 0);
			
	         System.out.print("상품 분류명(LPROD_NM) 입력 : ");
	         String nm = scan.next();
	         
	         // 만들어진 데이터들을 VO객체에 저장한다.
	         LprodVO lvo = new LprodVO();
	         lvo.setLprod_id(nextId);
	         lvo.setLprod_gu(gu);
	         lvo.setLprod_nm(nm);
	         
	         Object obj = smc.insert("jdbc.insertLprod", lvo);
	         
	         if (obj == null) {
				System.out.println("데이터 추가 성공!");
			} else {
				System.out.println("데이터 추가 실패~~~");
			}
	         
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		scan.close();
	}
}
 