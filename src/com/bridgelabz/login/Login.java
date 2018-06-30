package com.bridgelabz.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection con = null;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		 PrintWriter out=response.getWriter();
		String query = "select * from login_register where email=? and password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connecting to database");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
			System.out.println("connection established");

			pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			if (rs.next()) {
				RequestDispatcher dispatcher=request.getRequestDispatcher("PreSuccess");
				dispatcher.forward(request, response);
				/*String user = rs.getString(1);
				HttpSession session = request.getSession();
				session.setAttribute("username",user);
				response.sendRedirect("Welcome.jsp");*/
			} else {
				//out.println("given details are invalid,pls try again or click on SignUp page to register");
				//response.sendRedirect("Login.jsp");
				RequestDispatcher dispatcher=request.getRequestDispatcher("PreError");
				out.println("<html><body><h1>Invalid email or password</h1><a href='Index.jsp'>Back</a></body></html>");
			   // response.sendRedirect("Index.jsp");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
