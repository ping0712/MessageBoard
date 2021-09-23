<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="messageboard.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String uid = (String)request.getSession().getAttribute("uid");
ArrayList<MessageBoard> list = (ArrayList<MessageBoard>)request.getAttribute("list");

%>
<body>
<input type = "button" value = "回到主頁" onclick = "window.location='MessageBoard.jsp'">
<table width = "80%" border=1 style="table-layout:fixed;">
<tr>
<th align='center' valign="middle" width="10%" style = "word-wrap:break-word;">uid</th>
<th align='center' valign="middle" style = "word-wrap:break-word;">message</th>
<th align='center' valign="middle" width="10%" style = "word-wrap:break-word;"></th>
</tr>
<%
if (list.size()>=0){
	for(int i = 0;i < list.size();i++){
%>
<tr>
<td align='center' valign="middle" ><%=list.get(i).getUid() %></td>
<td align='center' valign="middle" style = "word-wrap:break-word;"><%=list.get(i).getText() %></td>
<td>
<%
if (list.get(i).getUid().equals(uid)){
	String urld = "MessageBoardServlet?bt=4&index="+i;
	String urlu = "MessageBoardServlet?bt=3&index="+i;
%>
<input type = "button" value = "修改" onclick = "javascript:if(confirm('確實要修改嗎?'))location='<%=urlu%>'"><br/>

<input type = "button" value = "刪除" onclick = "javascript:if(confirm('確實要刪除嗎?'))location='<%=urld%>'">
<%} %>
</td>
</tr>
<%	}
}%>
</table>
</body>
</html>