<%@page import="java.sql.Timestamp" %>
<%@page import="jsp_ex25_2.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="dto" class="jsp_ex25_2.MemberDTO"/>
<jsp:setProperty name="dto" property="*"/>
<%
	dto.setrDate(new Timestamp(System.currentTimeMillis()));
	MemberDAO dao = MemberDAO.getInstance();
	if(dao.confirmId(dto.getId()) == MemberDAO.MEMBER_EXISTENT) {
%>
	<script language="javascript">
		alert("���̵� �̹� ���� �մϴ�.");
		history.back();
	</script>
<%
	} else {
		int ri = dao.insertMember(dto);
		if(ri == MemberDAO.MEMBER_JOIN_SUCCESS) {
			session.setAttribute("id", dto.getId());
%>
	<script language="javascript">
		alert("ȸ�������� ���� �մϴ�.");
		document.location.href="login.jsp";
	</script>
<%
		} else {
%>
		<script language="javascript">
			alert("ȸ�����Կ� �����߽��ϴ�.");
			document.location.href="login.jsp";
		</script>
<%
		}
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