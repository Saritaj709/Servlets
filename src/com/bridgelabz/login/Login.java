package com.bridgelabz.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection con = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		String query = "select firstname from login_register where email=? and password=?";
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
				String user = rs.getString(1);
				System.out.println("valid user : " + user);
				System.out.println("login successful");
				HttpSession session = request.getSession();
				session.setAttribute("username",user);
				response.sendRedirect("Welcome.jsp");
			} else {
				System.out.println("given details are invalid,pls try again or click on SignUp page to register");
				response.sendRedirect("Login.jsp");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
