package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import vo.MemberVO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rdp = request.getRequestDispatcher("/login.jsp");
		rdp.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVO member = loginService.findMemberById(id);
		String errorMessage = null;
		String url = "/marble.jsp";
		
		if(member == null) {
			errorMessage = "아이디를 입력해주세요.";
			url = "/login.jsp";
		} else {
			if(password != null && !password.equals(member.getPassword())) {
				errorMessage = "비밀번호를 확인해주세요.";
				url = "/login.jsp";
			} else {
				// 회원이 있고 비밀번호도 맞고
				// 이 경우 세션에 사용자 정보를 저장한다.
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
			}
		}
		
		request.setAttribute("errorMessage", errorMessage);
		
		RequestDispatcher rdp = request.getRequestDispatcher(url);
		rdp.forward(request, response);
	}
	
}
