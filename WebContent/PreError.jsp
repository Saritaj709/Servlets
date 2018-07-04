<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Insert title here</title>
 </head>
 <body>
 <form action="Logout" method="post">
 <table style="background-color:green;margin-left:20px;margin-top:20px;">
 <tr><h3 style="color: red;">Email Or Password is Incorrect</h3></tr>
 <a href='Index.jsp'><input type="button" value="Tryagin"></a>
 <p>Oops</p>
 <div style="display: flex;justify-content:center;">
 <%String email=(String)request.getSession().getAttribute("passEmail");
 out.print("Sorry!! "+email+"please register or try again");%>
 <a href='Index.jsp'></a><img src="opps.png" alt="Error in login" border="4" width="150" height="160" />
  </table>
 </form>
 </body>
 </html>