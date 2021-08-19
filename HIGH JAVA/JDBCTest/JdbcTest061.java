package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
   회원을 관리하는 프로그램을 작성하시오.
   (오라클의 MYMEMBER 테이블 이용)
   
   아래 메뉴의 기능을 모두 구현하시오. (CRUD 기능 구현하기)

   메뉴 예시)
   =======================
       -- 작업 선택 --
       1. 자료 추가
       2. 자료 삭제
       3. 자료 수정
       4. 전체 자료 출력
       0. 작업 끝.
   =======================

   처리 조건)
   1) 자료 추가에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력받는다.)
   2) 자료 삭제는 '회원ID를 입력받아 처리한다.
 */

public class JdbcTest061 {
   Scanner scan = new Scanner(System.in);

   Connection conn = DBUtil.getConnection();
   Statement stmt = null;
   PreparedStatement pstmt = null;
   PreparedStatement pstmt2 = null;
   ResultSet rs = null;

   public static void main(String[] args) throws SQLException {
      new JdbcTest061().menu();
   }

   private void menu() throws SQLException {

      menu: while (true) {
         System.out.println("\n=======================");
         System.out.println("    -- 작업 선택 --");
         System.out.println("    1. 자료 추가");
         System.out.println("    2. 자료 삭제");
         System.out.println("    3. 자료 수정");
         System.out.println("    4. 전체 자료 출력");
         System.out.println("    5. 자료 수정 2");
         System.out.println("    0. 작업 끝");
         System.out.println("=======================");

         System.out.print("\n메뉴를 선택하세요 >> ");
         int menu = scan.nextInt();

         switch (menu) {
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
            select();
            break;
         case 5:
            update2();
            break;
         case 0:
            System.out.println("\n작업을 종료합니다.");
            close();
            break menu;
         default:
            System.out.print("\n없는 번호입니다. 다시 선택하세요 >> ");
            break;
         }
      }
   }

   private void close() {
      if (rs != null)
         try {
            rs.close();
         } catch (SQLException e) {
         }
      if (pstmt != null)
         try {
            pstmt.close();
         } catch (SQLException e) {
         }
      if (pstmt2 != null)
         try {
            pstmt2.close();
         } catch (SQLException e) {
         }
      if (stmt != null)
         try {
            stmt.close();
         } catch (SQLException e) {
         }
      if (conn != null)
         try {
            conn.close();
         } catch (SQLException e) {
         }
   }

   private void select() {
      try {
         String sql = "SELECT MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR FROM MYMEMBER";

         stmt = conn.createStatement();

         rs = stmt.executeQuery(sql);

         System.out.println("\n=== 쿼리문 처리 결과 ===\n");

         if (rs.next()) {
            do {
               System.out.println("아이디 : " + rs.getString(1));
               System.out.println("비밀번호 : " + rs.getString(2));
               System.out.println("이름 : " + rs.getString(3));
               System.out.println("전화번호 : " + rs.getString(4));
               System.out.println("주소 : " + rs.getString(5));
               System.out.println("\n-----------------------\n");
            } while (rs.next());

         } else {
            System.out.println("등록된 정보가 없습니다.");
         }

//      if(!rs.next()) {
//         System.out.println("등록된 정보가 없습니다.");
//      } else {
//         
//      }

      } catch (SQLException e) {
      }
   }

   private void update() {
      try {
         System.out.print("\n수정할 아이디 입력 : ");
         String id = scan.next();

         System.out.print("\n비밀번호 변경 : ");
         String pass = scan.next();

         System.out.print("\n이름 변경 : ");
         String name = scan.next();

         System.out.print("\n전화번호 변경 : ");
         String tel = scan.next();

         System.out.print("\n주소 변경 : ");
         String addr = scan.next();

         String sql = "UPDATE MYMEMBER SET MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? WHERE MEM_ID = ?";
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, pass);
         pstmt.setString(2, name);
         pstmt.setString(3, tel);
         pstmt.setString(4, addr);
         pstmt.setString(5, id);

         int count = pstmt.executeUpdate();

         if (count > 0) {
            System.out.println("\n수정 성공");
         } else {
            System.out.println("\n수정 실패");
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   // 회원 정보를 수정하는 메소드 => 원하는 항목만 하나만 수정
   // 항목을 선택하는 메뉴가 필요함
   private void update2() throws SQLException {
      String sql = null;
      int count = 0;

      System.out.print("\n수정할 아이디를 입력하세요 >> ");
      String id = scan.next();

      // id가 있는지 검사
      int cnt = getMemberCount(id);

      if (cnt == 0) {
         System.out.println("해당 회원은 존재하지 않습니다.");
         System.out.println("수정 작업을 종료합니다.");
         return;
      }

      System.out.println("\n1. 비밀번호 수정");
      System.out.println("2. 이름 수정");
      System.out.println("3. 전화번호 수정");
      System.out.println("4. 주소 수정");
      System.out.print("\n수정할 항목을 선택하세요 >> ");
      int menu = scan.nextInt();

      switch (menu) {
      case 1:
         System.out.print("새 비밀번호 >> ");
         String newPass = scan.next();

         sql = "UPDATE MYMEMBER SET MEM_PASS = ? WHERE MEM_ID = ?";

         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, newPass);
         pstmt.setString(2, id);
         break;
      case 2:
         System.out.print("새 이름 >> ");
         String newName = scan.next();

         sql = "UPDATE MYMEMBER SET MEM_NAME = ? WHERE MEM_ID = ?";

         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, newName);
         pstmt.setString(2, id);
         break;
      case 3:
         System.out.print("새 전화번호 >> ");
         String newTel = scan.next();
         sql = "UPDATE MYMEMBER SET MEM_TEL = ? WHERE MEM_ID = ?";

         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, newTel);
         pstmt.setString(2, id);
         break;
      case 4:
         System.out.print("새 주소 >> ");
         String newAddr = scan.next();
         sql = "UPDATE MYMEMBER SET MEM_ADDR = ? WHERE MEM_ID = ?";

         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, newAddr);
         pstmt.setString(2, id);
         break;
      default:
         System.out.println("잘못 입력하셨습니다.");
         System.out.println("다시 입력해 주세요.");
         break;
      }

      count = pstmt.executeUpdate();

      if (count > 0) {
         System.out.println("\n수정 성공");
      } else {
         System.out.println("\n수정 실패");
      }
   }

   private int getMemberCount(String id) {
      int count = 0;

      try {
         String sql = "SELECT COUNT(*) AS cnt FROM MYMEMBER WHERE MEM_ID = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, id);

         rs = pstmt.executeQuery();

         if (rs.next()) {
            count = rs.getInt("cnt");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return count;
   }

   private void delete() {
      try {
         System.out.print("\n삭제할 아이디 입력 : ");
         String id = scan.next();

         String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, id);

         int count = pstmt.executeUpdate();

         if (count > 0) {
            System.out.println("\n삭제 성공");
         } else {
            System.out.println("\n삭제 실패");
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   private void insert() {
      try {
//         conn = DBUtil.getConnection();

         String id;
         int count = 0;

         // id 중복 확인
         String sql = "SELECT COUNT(*) AS cnt FROM MYMEMBER WHERE MEM_ID = ?";
         pstmt = conn.prepareStatement(sql);

         do {
            System.out.print("\n아이디(MEM_ID) 입력 : ");
            id = scan.next();

            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
               count = rs.getInt("cnt");
            }

            if (count > 0) {
               System.out.println("\n입력한 아이디 " + id + "는 이미 등록된 아이디입니다.");
               System.out.println("다시 입력해 주세요.");
            }

         } while (count > 0);

         System.out.print("\n비밀번호(MEM_PASS) 입력 : ");
         String pass = scan.next();

         System.out.print("\n이름(MEM_NAME) 입력 : ");
         String name = scan.next();

         System.out.print("\n전화번호(MEM_TEL) 입력 : ");
         String tel = scan.next();

         System.out.print("\n주소(MEM_ADDR) 입력 : ");
         String addr = scan.next();

         String sql2 = "INSERT INTO MYMEMBER(MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR)"
               + " VALUES(?, ?, ?, ?, ?)";

         pstmt2 = conn.prepareStatement(sql2);

         pstmt2.setString(1, id);
         pstmt2.setString(2, pass);
         pstmt2.setString(3, name);
         pstmt2.setString(4, tel);
         pstmt2.setString(5, addr);

         int cnt = pstmt2.executeUpdate();

         if (cnt > 0) {
            System.out.println("\n등록 성공");
         } else {
            System.out.println("\n등록 실패");
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}