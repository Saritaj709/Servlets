<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>

<center><h3>Welcome !!</h3></center></br>
 
 <!-- <a href="Login.jsp"><input type="button" name="Login" value="Login"></a>

 <a href="Register.jsp"><input type="button" name="SignUp" value="SignUp"></a><br>

 <a href="Reset.jsp"><input type="button" name="ResetPassword" value="ResetPassword"></a> -->
<form action="PreLogin" method="post"><input type="submit" value="Login"></form>
 <form action="PreRegister" method="post"><input type="submit" value="SignUp"></form>
<form action="PreReset" method="post">
<input type="submit" value="ResetPassword">
</form> 
 <!-- <a href="Reset.jsp"><input type="button" name="ResetPassword" value="ResetPassword"></a> -->
</body>
</html>