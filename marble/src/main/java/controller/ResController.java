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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rdp = request.getRequestDispatcher("/marble.jsp");
		rdp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String id = request.getParameter("id");
		String res = request.getParameter("res");
		String count = request.getParameter("clickCount");
		
		UserParam update = new UserParam(id, res, count);
		
		String sql = "update diceresult set dicesum = ?, dicecount = ? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(update.getDicesum() + res));
			pstmt.setInt(2, Integer.parseInt(update.getDicecount() + 1));
			pstmt.setString(3, update.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id", id);
		RequestDispatcher rdp = request.getRequestDispatcher("/list.jsp");
		rdp.forward(request, response);
	}

}
