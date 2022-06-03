<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>Marble 게시판</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h1>${id}님 회원가입이 완료되었습니다!</h1>
				<p><a class="btn btn-primary btn-pull" href="${contextPath}/login" role="button">로그인</a></p>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>