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
				alert("�α׾ƿ��� �����߽��ϴ�.");
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
		out.println("�α�����");
	%>
	
	<input type="button" value="�α׾ƿ�" onclick="logout()">
	
	
	<%
	} else {
	//�α���â �����ֱ�
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