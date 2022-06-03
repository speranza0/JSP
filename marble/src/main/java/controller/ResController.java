package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.JdbcUtils;
import service.JoinService;
import service.ResUpdateService;
import vo.UserParam;

/**
 * Servlet implementation class ResController
 */
@WebServlet("/update")
public class ResController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResUpdateService updateService = new ResUpdateService();
	Connection conn = JdbcUtils.conn;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rdp = request.getRequestDispatcher("/marble.jsp");
		rdp.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String id = request.getParameter("id");
		String res = request.getParameter("res");
		String roundNum = request.getParameter("roundNum");
		
		UserParam update = updateService.userResUpdate(id);
		
		String sql = "update diceresult set dicesum = ?, dicecount = ?, roundnum = ? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, update.getDicesum() + Integer.parseInt(res));
			pstmt.setInt(2, update.getDicecount() + 1);
			pstmt.setInt(3, update.getRoundnum() + Integer.parseInt(roundNum));
			pstmt.setString(4, update.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id", id);
		RequestDispatcher rdp = request.getRequestDispatcher("/list");
		rdp.forward(request, response);
	}

}
