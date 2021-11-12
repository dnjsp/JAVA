package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/jsonTestServlet.do")
public class JsonTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JSON 데이터를 만들어서 응답으로 보내주는 서블릿
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		
		//JSON으로 응답할 때의 ContentType 설정 방법
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String choice = request.getParameter("choice");
		
		Gson gson = new Gson();
		String jsonData = null;  // json데이터로 변경된 데이터가 저장될 변수
		
		switch (choice) {
			case "str" :  // 문자열 JSON으로 변환하기
				String str = "안녕하세요.";
				jsonData = gson.toJson(str); 
				break;
			case "array" :  // 배열을 JSON으로 변환하기
				// int[] arr = {100, 200, 300, 400, 500};
				String[] arr = {"한국", "미국", "영국", "중국"};
				jsonData = gson.toJson(arr); 
				break;
			case "obj" :  // 자바객체를 JSON으로 변환하기
				SampleVO vo = new SampleVO(100, "홍길동");
				jsonData = gson.toJson(vo); 
				break;
			case "list" :  // 자바의 List객체를 JSON으로 변환하기
				// [{"num":1,"name":"이순신"},{"num":2,"name":"강감찬"},{"num":3,"name":"변학도"},{"num":4,"name":"성춘향"}]
				ArrayList<SampleVO> samList = new ArrayList<SampleVO>();
				samList.add(new SampleVO(1, "이순신"));
				samList.add(new SampleVO(2, "강감찬"));
				samList.add(new SampleVO(3, "변학도"));
				samList.add(new SampleVO(4, "성춘향"));
				
				jsonData = gson.toJson(samList); 
				break;
			case "map" :  // 자바의 Map객체를 JSON으로 변환하기
				HashMap<String, String> testMap = new HashMap<String, String>();
				testMap.put("name", "이몽룡");
				testMap.put("tel", "010-1234-5678");
				testMap.put("addr", "대전시 중구 대흥동");
				
				jsonData = gson.toJson(testMap); 
				break;
		}
		
		System.out.println(choice + " : " + jsonData);
		
		out.println(jsonData);
		
		response.flushBuffer();  // response한 데이터를 강제로 비움
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
