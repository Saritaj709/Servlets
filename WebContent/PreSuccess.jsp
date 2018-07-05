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
 <tr><h3 style="color: red;">Welcome to the servlet world</h3></tr>
 <a href='Index.jsp'><input type="button" value="Signout" name="Signout"></a>
 <%String email=(String)request.getSession().getAttribute("passEmail");
 out.print("welcome !! "+email+" exists");%>
 <p>Success</p>
 <div style="display: flex; justify-content:center;">
 <img src="success.png" alt="login success" border="4" width="150px" height="160px" />
  </table>
  </table>
  </form>
</body>
</html>