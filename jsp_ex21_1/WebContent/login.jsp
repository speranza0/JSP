<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% if(session.getAttribute("ValidMem") != null) { %>
	<jsp:forward page="main.jsp"></jsp:forward>
<% } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="loginOk.jsp" method="post">
		���̵� : <input type="text" name="id" value="<% if(session.getAttribute("id") != null) out.println(session.getAttribute("id")); %>"> <br />
		��й�ȣ : <input type="password" name="pw"><br />
		<input type="submit" value="�α���"> &nbsp;&nbsp; <input type="button" value="ȸ������" onclick="javascript:window.location='join.jsp'">
	</form>
</body>
</html>