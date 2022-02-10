package com.workouts.interservletcommunications;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidationServlet
 */
//@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			PrintWriter out = res.getWriter();
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			boolean result = true;
			if(name.equalsIgnoreCase("")) {
				out.println("<html><body>Please enter a valid name</body></html>");
				result = false;
			}
			
			if(email.equalsIgnoreCase("")) {
				out.println("<html><body>Please enter a valid email</body></html>");
				result = false;			
			}

			if(address.equalsIgnoreCase("")) {
				out.println("<html><body>Please enter a valid address</body></html>");
				result = false;
			}
			
			if(result == true) {
				//RegistrationServlet registerServlet = (RegistrationServlet) getServletContext().getServlet("/next");
				//RequestDispatcher registerServlet = req.getRequestDispatcher("/next");
					//or
				RequestDispatcher registerServlet =	getServletContext().getNamedDispatcher("RegistrationServlet");
				//registerServlet.doGet(req, res);
				registerServlet.forward(req, res);
			}
	}	
}
