<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="list.do" method="post">
		전체 성적 조회 &nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">첫화면</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="regist.jsp">등록</a>
		<hr />
		<table width="500">
			<tr>
				<td>학번</td>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>총점</td>
				<td>평균</td>
			</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.idx}</td>
					<td>${dto.name}</td>
					<td>${dto.kor}</td>
					<td>${dto.eng}</td>
					<td>${dto.math}</td>
					<td>${dto.sum}</td>
					<td><fmt:formatNumber value="${dto.avg}" pattern=".00" /></td>
					<td><a href="selectOne.do?idx=${dto.idx}">수정</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>