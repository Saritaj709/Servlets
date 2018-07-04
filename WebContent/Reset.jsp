<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="PassWordReset" method="post">
 <table style="background-color:blue;margin-left:20px;margin-top:20px;">
 <tr><h3 style="color:violet;">Reset Password !!</h3></tr>
  Email:<input type="text" name="email"><br>
  NewPassword:<input type="password" name="pass1"><br>
  RetypePassWord:<input type="password" name="pass2">
   <h4 style="color:indigo;">click on reset to reset the password</h4>
 <input type="submit" name="Reset" value="Reset"><a href="Register.jsp">SignUp</a> 
 </table>
 </form>
 </body>
 </html>