package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원ID를 파라미터로 받아서 해당 회원 정보를 구해서 Update Form으로 보낸다.
		request.setCharacterEncoding("utf-8");
		
		String mem_id = request.getParameter("mem_id");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemberVO memVO = service.getMember(mem_id);
		
		request.setAttribute("memberVO", memVO);
		
		request.getRequestDispatcher("/WEB-INF/view/memberUpdateForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정할 회원 정보를 파라미터로 받아서 DB의 회원정보를 수정한 후 List로 이동한다.
		request.setCharacterEncoding("utf-8");
		
		// 요청할 때 파라미터로 온 데이터 구하기
		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_pass = request.getParameter("mem_pass");
		String mem_tel = request.getParameter("mem_tel");
		String mem_addr = request.getParameter("mem_addr");
		
		// 데이터를 VO객체에 저장하기
		MemberVO memVO = new MemberVO();
		memVO.setMem_id(mem_id);
		memVO.setMem_name(mem_name);
		memVO.setMem_pass(mem_pass);
		memVO.setMem_tel(mem_tel);
		memVO.setMem_addr(mem_addr);
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int cnt = service.updateMember(memVO);
	}

}
