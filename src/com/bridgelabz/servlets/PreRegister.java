package com.bridgelabz.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreRegister
 */
//@WebServlet("/PreRegister")
public class PreRegister extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 RequestDispatcher dispatcher=request.getRequestDispatcher("Register.jsp");
	dispatcher.forward(request,response);
	}
}
