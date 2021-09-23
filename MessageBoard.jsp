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
	String uid = (String)request.getAttribute("uid");
	if (uid==null)
		uid = (String)request.getSession().getAttribute("uid");
	session.setAttribute("uid", uid);
    if(message!=null && !"".equals(message)){ 
%>
<script type="text/javascript">
alert("<%=message%>");
</script>
<%} %>

<h1>Welcome <%=uid %></h1>
<input type = "button" value = "瀏覽所有留言" onclick = "window.location='MessageBoardServlet?bt=1'">
<input type = "button" value = "新增留言" onclick = "window.location='MessageBoardServlet?bt=2'">

</body>
</html>