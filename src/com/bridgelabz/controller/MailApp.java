package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.repository.SendMail;

/**
 * Servlet implementation class MailApp
 */
//@WebServlet("/MailApp")
@SuppressWarnings("serial")
public class MailApp extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
	//	PrintWriter out=response.getWriter();
		
		String to=request.getParameter("to");
		String user="shenoy01apr2018@gmail.com";
		String pass="01apr2018";
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("PreLogin");
		dispatcher.forward(request,response);
		SendMail.send(to,user,pass);
	}

}
