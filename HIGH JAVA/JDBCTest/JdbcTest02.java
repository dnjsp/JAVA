package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/* 
 * 문제 ) 사용자로부터 Lprod_id값을 입력받아 입력한 값보다 Lprod_id가 큰 자료들을 출력하시오. 
 */
public class JdbcTest02 {
   
   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      Connection conn= null;
      //Statement stmt = null; 
      ResultSet rs = null; 
      PreparedStatement pstmt = null; 
      String condition; 
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jwh97","java");
         System.out.print("조건을 입력하세요 : ");
         condition = sc.next();
         String sql = "select lprod_id, lprod_gu, lprod_nm from LPROD WHERE LPROD_ID > ?";
         //stmt = conn.createStatement();
         //rs = stmt.executeQuery(sql) ;
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, condition);
         
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
          if(rs!=null) try { rs.close(); }catch(SQLException e) {}
            if(pstmt!=null) try {pstmt.close(); }catch(SQLException e) {}
            if(conn!=null) try { conn.close(); }catch(SQLException e) {}
      }
    
      sc.close();
   }
 
}