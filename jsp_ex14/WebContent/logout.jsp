<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import = "java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Enumeration enumeration = session.getAttributeNames();
		while(enumeration.hasMoreElements()){
			String sName = enumeration.nextElement().toString();
			String sValue = (String)session.getAttribute(sName);
			
			if(sValue.equals("abcde")) session.removeAttribute(sName);
		}
	%>
	<a href="sessiontest.jsp">sessionTest</a>
</body>
</html>