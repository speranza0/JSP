<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%= session.getAttribute("name") %>���� ȸ������ ������ ���� ó�� �Ǿ����ϴ�.<br />
<a href="logout.jsp">�α׾ƿ�</a> &nbsp;&nbsp; <a href="modify.jsp">��������</a>
</body>
</html>