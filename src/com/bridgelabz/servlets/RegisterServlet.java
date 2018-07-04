package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.model.User;
import com.bridgelabz.service.Connect;
import com.bridgelabz.service.ServiceLogic;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	MysqlDataSource dataSource = null;
	List<User> list = new LinkedList<>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String firstname = request.getParameter("uname");
		String lastname = request.getParameter("uname1");

		String email = request.getParameter("email");

		String mobileNo = request.getParameter("mobile");
		String password = request.getParameter("pass");

		PrintWriter out = response.getWriter();
		out.print("<html><body bgcolor='red'>" + " WELCOME ,your details are : " + firstname + " " + lastname + " "
				+ email + " " + mobileNo + " " + password);
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setMobileNo(mobileNo);
		user.setPassword(password);
		list.add(user);
		dataSource=Connect.getConnection();
		int flag = ServiceLogic.saveObject(user);
		if (flag!= 0) {
			out.print("succesfully registered");
			out.print("<h2 align='center'>Firstname : " + firstname + "</h2>");
			try {
				RequestDispatcher dispatcher=request.getRequestDispatcher("PreSuccessServlet");
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			out.print("invalid user details,pls enter different email");
			try {
				RequestDispatcher dispatcher=request.getRequestDispatcher("PreErrorServlet");
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
