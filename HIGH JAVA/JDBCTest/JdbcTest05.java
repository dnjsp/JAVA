package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

public class JdbcTest05 {
   public static void main(String[] args) {
      
      Scanner scan = new Scanner(System.in);
      
      Statement stmt = null;
      Connection conn = null;
      ResultSet rs = null;
      PreparedStatement pstmt1 = null;
      PreparedStatement pstmt2 = null;
      
      
      try {
//         Class.forName("oracle.jdbc.driver.OracleDriver");
//         
//         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","poi","java");
         
         conn = DBUtil.getConnection();
         
//         Lprod_id는 현재의 Lprod_id중 제일 큰 값보다 1만큼 크게해서 처리한다.
         String sql = "SELECT NVL(MAX(LPROD_ID),0) + 1 MAXNUM FROM LPROD";
         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
         int maxnum = 1;
         
         // select한 결과가 1개의 레코드일 경우에는 if문으로 처리가능
         if (rs.next()) {   
            maxnum = rs.getInt("MAXNUM");
         }

         
         // 입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
         String gu;       // 상품 분류 코드(LPROD_GU)가 저장될 변수 선언
         int count = 0;   // 입력한 상품 분류 코드의 개수가 저장될 변수
         
         String sql2 = "SELECT COUNT(*) CNT FROM LPROD WHERE LPROD_GU = ? ";
         pstmt1 = conn.prepareStatement(sql2);
         
         do {
            System.out.print("상품 분류 코드(LPROD_GU) 입력 : ");
            gu = scan.next();
            
            pstmt1.setString(1, gu);
            
            rs = pstmt1.executeQuery();
            
            if (rs.next()) {
               count = rs.getInt("CNT");
            }
            if (count>0) {
               System.out.println("입력한 상품 분류 코드" + gu + "는 이미 등록된 코드입니다.");
               System.out.println("다시 입력하세요.");
            }
         } while (count > 0);
      
         System.out.print("상품 분류명(LPROD_NM) 입력 : ");
         String nm = scan.next();
         
         String sql3 = "INSERT INTO LPROD (LPROD_ID, LPROD_GU, LPROD_NM) "
                   + "   VALUES (?,?,?)";
         
         pstmt2 = conn.prepareStatement(sql3);
         pstmt2.setInt(1, maxnum);
         pstmt2.setString(2, gu);
         pstmt2.setString(3, nm);
         
         int cnt = pstmt2.executeUpdate();
         
         if (cnt >0 ) {
            System.out.println("등록 성공");
         } else {
            System.out.println("등록 실패!!");
         }
         
         
      } catch (SQLException e) {
         e.printStackTrace();
//      } catch (ClassNotFoundException e) {
//         e.printStackTrace();
      }  finally {
         if (rs != null ) try { rs.close(); } catch(SQLException e ) {}
         if (stmt != null ) try { stmt.close(); } catch(SQLException e ) {}
         if (pstmt1 != null ) try { pstmt1.close(); } catch(SQLException e ) {}
         if (pstmt2 != null ) try { pstmt2.close(); } catch(SQLException e ) {}
         if (conn != null ) try { conn.close(); } catch(SQLException e ) {}
      }
      
      scan.close();
   }
}



