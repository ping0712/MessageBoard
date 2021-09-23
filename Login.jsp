<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){ 
%>
<script type="text/javascript">
alert("<%=message%>");

</script>
<%} %>
<form action = "LoginServlet" method = "POST">
<table border=1>
<tr><td>帳號</td><td><input type = "text" name = "uid"></td></tr>
<tr><td>密碼</td><td><input type = "password" name = "pwd"></td></tr>
<tr><td><input type = "button" name = "register" value="註冊" onclick ="window.location='Register.jsp'"></td><td><input type = "submit"></td></tr>
</table>
</form>

</body>
</html>