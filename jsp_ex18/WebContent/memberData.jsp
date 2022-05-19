<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%!
    	Connection connection;
    	Statement statement;
    	ResultSet resultSet;
    	
    	String driver = "org.mariadb.jdbc.Driver";
    	String url = "jdbc:mariadb://localhost:3306/hello_world";
    	String uid = "root";
    	String upw = "1234";
    	String query = "select * from student";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, uid, upw);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()){
				String number = resultSet.getString("number");
				String name = resultSet.getString("name");
				int level = resultSet.getInt("level");
				String birth = resultSet.getString("birth");
				
				out.println("번호 : " + number + ", 이름 : " + name + ", 학년 : " + level + ", 생일 : " + birth + "<br />");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	%>
</body>
</html>