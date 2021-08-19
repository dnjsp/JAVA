package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/* 
 *  문제) Lprod_id값을 2개를 입력받아서 두 값 중 작은 값부터 큰 값 사이의 자료들을 출력하시오. 
 */
public class JdbcTest03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Connection conn = null;
//      Statement stmt = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int putnum1, putnum2;
		int temp;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jwh97", "java");
			System.out.print("첫번쩨 id값을 입력하세요 : ");
			putnum1 = sc.nextInt();
			System.out.print("두번째 id값을 입력하세요 : ");
			putnum2 = sc.nextInt(); // 큰값

			if (putnum1 > putnum2) {
				temp = putnum1;
				putnum1 = putnum2;
				putnum2 = temp;
			}

			String sql = "select lprod_id, lprod_gu, lprod_nm from LPROD WHERE LPROD_ID > ? and lprod_id < ?";
//          stmt = conn.createStatement();
//          rs = stmt.executeQuery(sql) ;

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, putnum1);
			pstmt.setInt(2, putnum2);

			rs = pstmt.executeQuery();

			System.out.println("=== 쿼리문 처리 결과 ===");
			while (rs.next()) {
				System.out.println("Lprod_id :" + rs.getInt("lprod_id"));
				System.out.println("lprod_gu :" + rs.getString(2));
				System.out.println("lprod_nm :" + rs.getString(3));
				System.out.println("------------------------------------");
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) { }
			if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { }
			if (conn != null) try { conn.close(); } catch (SQLException e) { }
		}

		sc.close();
	}

}