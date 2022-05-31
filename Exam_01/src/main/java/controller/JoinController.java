package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.JoinService;
import vo.JoinParam;

@WebServlet("/join")
public class JoinController extends HttpServlet {
	
	JoinService joinService = new JoinService();
	
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
		String name = request.getParameter("name");
		
		JoinParam param = new JoinParam(id, password, name);
		
		joinService.joinProcess(param);
		
		request.setAttribute("name", name);
		RequestDispatcher rdp = request.getRequestDispatcher("/welcome.jsp");
		rdp.forward(request, response);
	}
}
