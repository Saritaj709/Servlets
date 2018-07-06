package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.model.User;
import com.bridgelabz.repository.UserRepository;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email= request.getParameter("email");
		String pwd = request.getParameter("pass");
		UserRepository userRepository=new UserRepository();
	
		 try {
			 PrintWriter out=response.getWriter();
			 User user=userRepository.validateUser(email, pwd);
			if ((user.getEmail()!=null)||(user.getPassword()!=null)) {
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(7*24*60*60);
					session.setAttribute("passEmail",email);
					String name=session.getAttribute("passEmail").toString();
					out.println("Hello "+name);
					System.out.println("Session status "+session.isNew());
					RequestDispatcher dispatcher=request.getRequestDispatcher("PreSuccessServlet");
					dispatcher.forward(request, response);;
			}
				
			 else {
				 HttpSession session = request.getSession(true);
						session.setAttribute("passEmail",email);
						System.out.println("Session status "+session.isNew());
				RequestDispatcher dispatcher=request.getRequestDispatcher("PreErrorServlet");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
