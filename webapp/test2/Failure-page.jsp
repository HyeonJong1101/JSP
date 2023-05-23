<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="./Login.jsp">에러페이지 다시로그인하세요</a>
	<%
    session.invalidate(); // 세션 무효화
	%>
</body>
</html>