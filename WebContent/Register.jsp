<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="RegisterServlet" method="post">
		<table
			style="background-color: green; margin-left: 20px; margin-top: 20px;">
			<tr>
				<h3 style="color: red;">
					<center>SignUp Page !!</center>
				</h3>
			</tr>
			<center>
				Firstname:<input type="text" name="uname">
			</center>
			<center>
				Lastname:<input type="text" name="uname1">
			</center>
			<center>
				Email:<input type="text" name="email"
					pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9-\-\.]+)\.([a-zA-Z]{2,5})$"
					title="Follow abc@domain.com" />
			</center>
			<center>
				MobileNo:<input type="text" name="mobile" />
			</center>
			<center>
				Password:<input type="password" name="pass"
					pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*].{8,})"
					title="Should contain atleast 1 uppercase,1 lowercase,1digit" />
			</center>
			<center>
				<input type="submit" name="Register" value="Register" />
			</center>
			<center>
				<a href='Index.jsp'><input type="button" value="Signout"
					name="Signout">
			</center>
			</a>
		</table>
	</form>
</body>
</html>
