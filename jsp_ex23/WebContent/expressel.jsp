<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="member" class="jsp_ex23.MemberInfo" scope="page" />
<jsp:setProperty name="member" property="name" value="ȫ�浿" />
<jsp:setProperty name="member" property="id" value="abc" />
<jsp:setProperty name="member" property="pw" value="123" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	�̸� : <jsp:getProperty name="member" property="name" /><br />
	���̵� : <jsp:getProperty name="member" property="id" /><br />
	��й�ȣ : <jsp:getProperty name="member" property="pw" /><br />
	
	<hr />
	
	�̸� : ${member.name}<br />
	���̵� : ${member.id}<br />
	��й�ȣ : ${member.pw}<br />
</body>
</html>