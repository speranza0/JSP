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
    	
    	String name, id, pw, phone1, phone2, phone3, gender;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<%
		id = (String)session.getAttribute("id");
		
		String query = "select * from member where id = '" + id + "'";
		
		Class.forName("org.mariadb.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/hello_world", "root", "1234");
		statement = connection.createStatement();
		resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			name = resultSet.getString("name");
			id = resultSet.getString("id");
			pw = resultSet.getString("pw");
			phone1 = resultSet.getString("phone1");
			phone2 = resultSet.getString("phone2");
			phone3 = resultSet.getString("phone3");
			gender = resultSet.getString("gender");
		}
	%>
	
	<form action="ModifyOk" method="post">
		�̸� : <input type="text" name="name" size="10" value=<%= name %>><br />
		���̵� : <%= id %><br />
		��й�ȣ : <input type="text" name="pw" size="10"><br />
		��ȭ��ȣ : <select name="phone1">
			<option value="010">010</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="018">018</option>
			<option value="019">019</option>
			<option value="011">011</option>
		</select> -
		<input type="text" name="phone2" size="5" value=<%= phone2 %>> - <input type="text" name="phone3" size="5" value=<%= phone3 %>><br />
		<%
			if(gender.equals("man")){
		%>
				�������� : <input type="radio" name="gender" value="man" checked="checked">�� &nbsp;<input type="radio" name="gender" value="woman">�� <br />
		<%
			} else {
		%>
		�������� : <input type="radio" name="gender" value="man">�� &nbsp;<input type="radio" name="gender" value="woman" checked="checked">�� <br />
		<%
			}
		%>
		<input type="submit" value="��������"><input type="reset" value="���">
	</form>
</body>
</html>