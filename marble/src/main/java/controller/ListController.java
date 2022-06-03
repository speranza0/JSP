package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.JdbcUtils;
import service.ListUpService;
import vo.UserParam;


/**
 * Servlet implementation class ListController
 */
@WebServlet("/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ListUpService listUpService = new ListUpService();
	Connection conn = JdbcUtils.conn;   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
		
		ArrayList<UserParam> list = listUpService.userList();
		
		request.setAttribute("list", list);
		RequestDispatcher rdp = request.getRequestDispatcher("/list.jsp");
		rdp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
		
		ArrayList<UserParam> list = listUpService.userList();
		
		request.setAttribute("list", list);
		RequestDispatcher rdp = request.getRequestDispatcher("/list.jsp");
		rdp.forward(request, response);
	}

}
