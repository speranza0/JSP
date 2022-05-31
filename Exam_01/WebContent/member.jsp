<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>접속한 회원정보</h1>
	<p>아이디 : ${member.id}</p>
	<p>이름 : ${member.name}</p>
	<a href="${contextPath}/vip.jsp">VIP 접속</a>
</body>
</html>