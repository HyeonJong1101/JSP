<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	session.setAttribute("id", id);
	System.out.println(id);
	System.out.println(pw);
	if (id != null && pw != null && id.equals("test1") && pw.equals("1234")) {
		// 로그인 성공 시 바로 이동하는 JavaScript 코드
		System.out.println("성공");
		response.sendRedirect("./Success-page.jsp");

	} else {
		// 로그인 실패 페이지 또는 실패 처리를 진행하는 코드
		System.out.println("실패");
		response.sendRedirect("./Failure-page.jsp");
	}
	%>
</body>
</html>
