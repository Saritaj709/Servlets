package com.bridgelabz.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PassWordReset
 */
@WebServlet("/Reset")
public class PassWordReset extends HttpServlet {
	Connection con = null;
	PreparedStatement pst = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String newPassword = request.getParameter("pass1");
		String retypePassword = request.getParameter("pass2");
		request.setAttribute("passEmail", email);
		if (newPassword.equals(retypePassword)) {
			String query = "update login_register set password=? where email=?";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("connecting to database");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
				System.out.println("connection established");

				pst = con.prepareStatement(query);
				pst.setString(1, newPassword);
				pst.setString(2, email);
				pst.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		RequestDispatcher rs = request.getRequestDispatcher("Welcome");
		rs.forward(request, response);
	}

}
