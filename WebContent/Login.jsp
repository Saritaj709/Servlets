<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="LoginServlet" method="post">
 <table style="background-color:skyblue;margin-left:20px;margin-top:20px;">
 <tr><h3 style="color: red;"><center>Login Page !!</center></h3></tr>
 Enter email:<input type="text" name="email"><br>
 Enter password:<input type="password" name="pass"><br>
 <input type="submit" name="Login" value="Login"><a href="Register.jsp">  SignUp</a><br>
 <a href="Reset.jsp"> Forget password?</a>
 </table>
 </form>
</body>
</html>
