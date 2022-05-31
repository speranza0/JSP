<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="${contextPath}/login" method="post">
		아이디 : <input type="text" name="id"><br />
		비밀번호 : <input type="password" name="password"><br />
		<button type="submit">로그인</button>
	</form>
	<c:if test="${not empty errorMessage}">
		로그인오류 : ${errorMessage}
	</c:if>
</body>
</html>