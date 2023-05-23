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
				alert("로그아웃에 실패했습니다.");
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
	사용자<%=sessionID%>의 페이지입니다.
	<br>
	<a href="./Login.jsp">처음화면 돌아가기</a>
	<input type="button" value="로그아웃" onclick="logout()">
</body>
</html>