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
		// �α��� ���� �� �ٷ� �̵��ϴ� JavaScript �ڵ�
		System.out.println("����");
		response.sendRedirect("./Success-page.jsp");

	} else {
		// �α��� ���� ������ �Ǵ� ���� ó���� �����ϴ� �ڵ�
		System.out.println("����");
		response.sendRedirect("./Failure-page.jsp");
	}
	%>
</body>
</html>
