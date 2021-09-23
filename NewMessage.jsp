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
String uid = (String)request.getSession().getAttribute("uid");
%>
<input type = "button" value = "回到主頁" onclick = "window.location='MessageBoard.jsp'">
<form action = "MessageBoardServlet" >
<textarea name = "text" rows = "6" cols="40"></textarea>
<input type = "submit" value = "新增留言">
</form>
</body>
</html>