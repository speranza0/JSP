<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write.do" method="post">
			<tr>
				<td> �̸� </td>
				<td> <input type="text" name="bName" size = "50"> </td>
			</tr>
			<tr>
				<td> ���� </td>
				<td> <input type="text" name="bTitle" size = "50"> </td>
			</tr>
			<tr>
				<td> ���� </td>
				<td> <textarea name="bContent" rows="10" ></textarea> </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="���ۼ�"> &nbsp;&nbsp; <a href="list.do">�۸��</a></td>
			</tr>
		</form>
	</table>
</body>
</html>