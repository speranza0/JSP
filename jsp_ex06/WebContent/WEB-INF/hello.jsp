<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${isMan}">
	${name}
	</c:if>
	<c:if test="${!isMan}">
	no man
	</c:if>
	<ul>
	<c:forEach var="name" items="${names}" varStatus="status">
    	<li>${status.count} : <c:out value="${name}" /></li>
	</c:forEach>
	</ul>
</body>
</html>