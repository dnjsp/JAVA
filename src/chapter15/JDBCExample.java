package chapter15;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement;

//import oracle.jdbc.driver.OracleDriver;

public class JDBCExample {
	public static void main(String[] args) throws Exception {
	//	OracleDriver -- import만 가져오고 사용은 X
		
		// 1. JDBC 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 임포트랑 같은 이름
		
		// 2. 로딩된 드라이버를 통해 DBMS 접속 준비
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JWH97", "java");
															// orcle jdbc url 검색해서 복사, 서비스 아이디, 비밀번호
		
		// 3. Query 문장을 전송할 객체(sql developer에서 쿼리 작성 화면 보여주) 생성
		Statement statement = connection.createStatement();
		
		// 4. SQL문장을 Statement 객체를 이용하여 실행
		ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT"); // 괄호 안에 ; 붙이면 안 됨
		while (resultSet.next()) { // next가 있으면 커서가 있는 곳에서 다음 데이터를 읽음..?
			String id = resultSet.getString("id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			String mobile_number = resultSet.getString("mobile_number");
			System.out.println(String.format("%s\t%s\t%s\t%s", id,  name, email, mobile_number));
		}
		
		// 6. 사용된 자원 반납
		resultSet.close();
		statement.close();
		connection.close();
	}
}
