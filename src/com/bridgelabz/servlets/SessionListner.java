package com.bridgelabz.servlets;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListner
 *
 */
//@WebListener
public class SessionListner implements HttpSessionListener {

    /**
     * Default constructor. 
     */
	private static int count=0;
    public SessionListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	count++;
    	System.out.println(arg0.getSession().getId());
    	System.out.println("On session Created !! "+count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	count--;
    	System.out.println("On session destroyed !! ");
    }
	
}
