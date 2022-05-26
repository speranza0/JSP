<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="regist.do" method="post">
	학생 성적 등록<hr />
		이름 : <input type="text" name="name"><br />
		국어 : <input type="text" name="kor"><br />
		영어 : <input type="text" name="eng"><br />
		수학 : <input type="text" name="math"><br />
		<input type="submit" value="등록">&nbsp;&nbsp;&nbsp;<a href="index.jsp">첫화면</a>&nbsp;&nbsp;&nbsp;<a href="list.do">목록</a>
	</form>
</body>
</html>