<%@page import="jsp_ex25_2.MemberDAO" %>
<%@page import="jsp_ex25_2.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<%
	String id = (String)session.getAttribute("id");
	MemberDAO dao = MemberDAO.getInstance();
	MemberDTO dto = dao.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script language="JavaScript" src="members.js"></script>
</head>
<body>
	<form action="modifyOk.jsp" method="post" name="reg_frm">
		���̵� : <%= dto.getId() %><br />
		��й�ȣ : <input type="password" name="pw" size="20"><br />
		��й�ȣ Ȯ�� : <input type="password" name="pw_check" size="20"><br />
		�̸� : <%= dto.getName() %><br />
		���� : <input type="text" name="eMail" size="20" value="<%= dto.geteMail() %>"><br />
		�ּ� : <input type="text" name="address" size="20" value="<%= dto.getAddress() %>"><br />
		<input type="button" value="����" onclick="updateInfoConfirm()"> &nbsp;&nbsp;&nbsp; <input type="reset" value="���" onclick="javascript.window.location='login.jsp'">  
	</form>
</body>
</html>