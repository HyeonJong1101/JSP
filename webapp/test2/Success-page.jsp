<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	function logout() {
		$.ajax({
			url : "./Logout.jsp",
			type : "POST",
			success : function() {
				location.reload();
			},
			error : function() {
				alert("�α׾ƿ��� �����߽��ϴ�.");
			}
		});
	}
</script>
</head>
<body>
	<%
	System.out.println("aa");
	String sessionID = (String) session.getAttribute("id");
	%>
	�����<%=sessionID%>�� �������Դϴ�.
	<br>
	<a href="./Login.jsp">ó��ȭ�� ���ư���</a>
	<input type="button" value="�α׾ƿ�" onclick="logout()">
</body>
</html>