package chapter15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	public List<StudentDTO> selectStudent() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.46.30:1521:xe", "YYJ95", "java");
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT"); 
		List<StudentDTO> list = new ArrayList<StudentDTO>();	
		while (resultSet.next()) { 
			String id = resultSet.getString("id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			String mobile_number = resultSet.getString("mobile_number");
			list.add(new StudentDTO(id, name, email, mobile_number));
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	
	public int insertStudent(StudentDTO dto) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.46.30:1521:xe", "YYJ95", "java");
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO STUDENT (");
		builder.append("	ID,");
		builder.append("	NAME,");
		builder.append("	EMAIL,");
		builder.append("	MOBILE_NUMBER");
		builder.append(") VALUES (");
		builder.append("	'" + dto.getId() + "',");
		builder.append("	'" + dto.getName() + "',");
		builder.append("	'" + dto.getEmail() + "',");
		builder.append("	'" + dto.getMobileNumber() + "'");
		builder.append(")");
		int executeUpdate = statement.executeUpdate(builder.toString());
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	public int updateStudent(StudentDTO dto) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.46.30:1521:xe", "YYJ95", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE STUDENT");
		builder.append("	SET");
		builder.append("		EMAIL = ?,");
		builder.append("		MOBILE_NUMBER = ?");
		builder.append("WHERE");
		builder.append("	ID = ?");
		// 미리 sql 문장을 준비하는 객체 사용
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, dto.getEmail());
		statement.setString(2, dto.getMobileNumber());
		statement.setString(3, dto.getId());
		
		int executeUpdate = statement.executeUpdate();
		
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	public int deleteStudent(String id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.46.30:1521:xe", "YYJ95", "java");
		PreparedStatement statement = connection.prepareStatement("DELETE FROM STUDENT WHERE ID = ?");
		statement.setString(1, id);
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
}