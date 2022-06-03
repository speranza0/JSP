package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapper.MemberMapper;
import service.JoinService;
import service.LoginService;
import vo.JoinParam;
import vo.MemberVO;

@WebServlet("/join")
public class JoinController extends HttpServlet {
	
	JoinService joinService = new JoinService();
	LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rdp = request.getRequestDispatcher("/join.jsp");
		rdp.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		JoinParam param = new JoinParam(id, password, email);
		
		String errorMessage = null;
		String url = null;
		
		if(id == "" || password == "" || email == "") {
			errorMessage = "입력되지 않는 가입정보가 있습니다.";
			url = "/join.jsp";
		} else {
			joinService.joinProcess(param);
			request.setAttribute("id", id);
			url = "/welcome.jsp";
		}
		
		request.setAttribute("errorMessage", errorMessage);
		
		RequestDispatcher rdp = request.getRequestDispatcher(url);
		rdp.forward(request, response);
	}
}
