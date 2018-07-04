package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class RegistrationFilter
 */
@WebFilter("/RegistrationFilter")
public class RegistrationFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public RegistrationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		String firstname = request.getParameter("uname");
		String lastname = request.getParameter("uname1");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobile");
		String password = request.getParameter("pass");

		PrintWriter out = response.getWriter();

		if (firstname.equals("") || lastname.equals("") || email.equals("") || mobileNo.equals("")
				|| password.equals("")) {
			out.print("field values cannot be empty,pls enter values for all fields");
		} else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
