<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<c:set var="userId" value="${member.id}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>Marble 게시판</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<c:if test="${not empty userId}">
		<div class="container">
			<div class="jumbotron">
				<div class="container">
					<h1>웹 사이트 소개</h1>
					<p>이 웹 사이트는 간단한 Marble을 할 수 있는 JSP 웹 사이트입니다. ${member.id}님은 로그인중이며 Marble 게임을 즐기실 수 있습니다.</p>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${empty userId}">
		<div class="container">
			<div class="jumbotron">
				<div class="container">
					<h1>웹 사이트 소개</h1>
					<p>이 웹 사이트는 간단한 Marble을 할 수 있는 JSP 웹 사이트입니다. 로그인을 하면 Marble 페이지로 넘어갑니다. 비회원은 회원가입을 해주세요.</p>
					<p><a class="btn btn-primary btn-pull" href="login.jsp" role="button">로그인</a></p>
					<p><a class="btn btn-primary btn-pull" href="join.jsp" role="button">회원가입</a></p>
				</div>
			</div>
		</div>
	</c:if>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>