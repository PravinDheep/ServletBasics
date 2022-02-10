package com.workouts.ajax;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxRegistration
 */
public class AjaxRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		
		res.getWriter().print("Name: \t" +  name + "\nEmail: \t" + email + "\nAddress: \t" + address + "\n");
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/color");
		rd.include(req, res);
		 
	}

}
