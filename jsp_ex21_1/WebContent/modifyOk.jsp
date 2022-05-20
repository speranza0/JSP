<%@page import="jsp_ex21_1.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>

<jsp:useBean id="dto" class="jsp_ex21_1.MemberDTO" scope="page" />
<jsp:setProperty name="dto" property="*" />

<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);
	
	MemberDAO dao = MemberDAO.getInstance();
	int ri = dao.updateMember(dto);
	
	if(ri == 1) {
%>
	<script language="javascript">
		alert("회원정보가 수정되었습니다.");
		document.location.href="main.jsp";
	</script>
<%
	} else {
%>
	<script language="javascript">
		alert("회원정보를 확인해주세요.");
		history.go(-1);
	</script>
<%
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>