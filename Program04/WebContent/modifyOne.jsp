<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="modify.do" method="post">
		학생 성적 정보 수정
		<hr />
		<input type="hidden" name="idx" value="${selectOne.idx}">
		학번 : ${selectOne.idx}<br />
		이름 : ${selectOne.name}<br />
		국어 : <input type="text" name="kor" value="${selectOne.kor}"><br />
		영어 : <input type="text" name="eng" value="${selectOne.eng}"><br />
		수학 : <input type="text" name="math" value="${selectOne.math}"><br />
		<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="index.jsp">첫화면</a>&nbsp;&nbsp;&nbsp;<a href="list.do">목록</a>&nbsp;&nbsp;&nbsp;<a href="delete.do?idx=${selectOne.idx}">삭제</a>
	</form>
</body>
</html>