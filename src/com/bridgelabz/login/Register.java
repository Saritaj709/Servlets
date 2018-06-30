package com.bridgelabz.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginPage")
public class Register extends HttpServlet {
	static Statement st = null;
	static Connection con = null;
	static ResultSet rs = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String firstname = request.getParameter("uname");
		String lastname = request.getParameter("uname1");
		
		String email = request.getParameter("email");
		
		 /*if(!email.equals(searchUser(email))){
			email = request.getParameter("email");
			System.out.println("email received");
		}
		 else if(email.equals(searchUser(email)))
		{
			System.out.println("email not  received");
			return;
		}*/
		
		String mobileNo = request.getParameter("mobile");
			String password = request.getParameter("pass");
		
			Connection con = null;
			PreparedStatement pst = null;
			PrintWriter writer = response.getWriter();
			/*if(email.equals(searchUser(email)))
			{
			writer.print("<html><body bgcolor='blue'>" +" your details are : " + firstname + " " + lastname
					+ " " + email + " " + mobileNo + " " + password+"email already exists,pls enter different email");
			response.sendRedirect("Register.jsp");
			}*/
			writer.print("<html><body bgcolor='red'>" + " WELCOME ,your details are : " + firstname + " " + lastname
					+ " " + email + " " + mobileNo + " " + password);
			String query1 = "insert into login_register values(?,?,?,?,?)";
			writer.flush();
			writer.close();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("connecting to database");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
				System.out.println("connection established");

				pst = con.prepareStatement(query1);

				pst.setString(1, firstname);
				pst.setString(2, lastname);
				pst.setString(3, email);
				pst.setString(4, mobileNo);
				pst.setString(5, password);

				pst.executeUpdate();
				System.out.println("details received");

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
				}

	public static String searchUser(String email) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		System.out.println("connecting to database");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?user=root&password=root");
		System.out.println("connection established");
		String query = "select email from login_register";

		st = con.createStatement();

		rs = st.executeQuery(query);
		while (rs.next()) {
			if (rs.getString(1).equals(email)) {
				System.out.println("The user with the given email already exists");
	           return email;
			}
		}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return email;
	}
}