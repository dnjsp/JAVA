package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// JDBC 드라이버를 로딩하고 Connection객체를 생성하는 메소드로 구성된 class 만들기
public class DBUtil {
   
   // 정적(static) 초기화 블럭
   static {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버 로딩 실패...ㅜ");
         e.printStackTrace();
      }
   }
   
   public static Connection getConnection() {
      try {
         return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JWH97", "java");
      } catch (SQLException e) {
         System.out.println("오라클 연동 실패");
         return null;
      }
   }
}