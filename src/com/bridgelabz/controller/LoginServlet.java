package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.repository.ConnectionPool;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;
	   MysqlDataSource dataSource=null;
	  ConnectionPool connectionPool=new ConnectionPool();
		 String query = "select * from login_register where email=? and password=?";
		 PrintWriter out=response.getWriter();
		 try {
            dataSource=connectionPool.getConnection();
			con=dataSource.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			if (rs.next()) {
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(7*24*60*60);
					session.setAttribute("passEmail",email);
					String name=session.getAttribute("passEmail").toString();
					out.println("Hello "+name);
					System.out.println(session.isNew());
					RequestDispatcher dispatcher=request.getRequestDispatcher("PreSuccessServlet");
					dispatcher.forward(request, response);;
			}
				
			 else {
				 HttpSession session = request.getSession(true);
						session.setAttribute("passEmail",email);
						System.out.println(session.isNew());
				RequestDispatcher dispatcher=request.getRequestDispatcher("PreErrorServlet");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
