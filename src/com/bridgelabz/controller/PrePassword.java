package com.bridgelabz.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrePassword
 */
//@WebServlet("/PrePassword")
public class PrePassword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 RequestDispatcher dispatcher=request.getRequestDispatcher("Password.jsp");
	 dispatcher.forward(request,response);
	}

}
