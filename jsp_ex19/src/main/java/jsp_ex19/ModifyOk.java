package jsp_ex19;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyOk
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Connection connection;
	private Statement stmt;
	
	private String name, id, pw, phone1, phone2, phone3, gender;
	
	HttpSession httpSession;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		httpSession = request.getSession();
		
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		
		if(pwConfirm()) {
			System.out.println("OK");
			
			String query = "update member set name ='" + name + "',phone1 = '" + phone1 + "', phone2 = '" + phone2 + "', phone3 = '" + phone3 + "', gender = '" + gender + "'";
			
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/hello_world", "root", "1234");
				stmt = connection.createStatement();
				int i = stmt.executeUpdate(query);
				if(i == 1) {
					System.out.println("update success");
					httpSession.setAttribute("name", name);
					response.sendRedirect("modifyResult.jsp");
				} else {
					System.out.println("update fail");
					response.sendRedirect("modify.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(stmt != null) stmt.close();
					if(connection != null) connection.close();
				} catch (Exception e) {}
			}
		} else {
			System.out.println("NG");
		}
	}

	private boolean pwConfirm() {
		// TODO Auto-generated method stub
		boolean rs = false;
		
		String sessionPw = (String)httpSession.getAttribute("pw");
		
		if(sessionPw.equals(pw)) {
			rs = true;
		} else {
			rs = false;
		}
		return rs;
	}
}
