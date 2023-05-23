<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	function logout(){
		$.ajax({
			url: "./Logout.jsp",
			type: "POST",
			success: function() {
				location.reload();
			},
			error: function() {
				alert("로그아웃에 실패했습니다.");
			}
		});
	}
</script>
</head>
<body>
	<%
	String sessionID = (String) session.getAttribute("id");
	%>

	<%
	if (sessionID != null) {
		out.println("로그인중");
	%>
	
	<input type="button" value="로그아웃" onclick="logout()">
	
	
	<%
	} else {
	//로그인창 보여주기
	%>
	<form method="post" action="./Loginprocess.jsp">
		ID:<input type=text name="id"><br> PW:<input type=text
			name="pw"><br> <input type=submit>
	</form>
	<%
	}
	%>
</body>
</html>