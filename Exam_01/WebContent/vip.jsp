<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>VIP 회원</h1>
	<c:if test="${member.vip == true}">
		${member.name} VIP 회원님 환영합니다!
	</c:if>
	<c:if test="${member.vip == false}">
		${member.name}님은 VIP가 아닙니다!
	</c:if>
</body>
</html>