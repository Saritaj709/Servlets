<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Welcome" method="post"></form>
<table style="background-color:green;margin-left:20px;margin-top:20px;">
 <tr><h3 style="color: red;">Welcome To The Page !!</h3></tr>
 <% 
if(session.getAttribute("username")==null)
{
	response.sendRedirect("Login.jsp");
}
%>
 Welcome ${username}
 </table>
</body>
</html>