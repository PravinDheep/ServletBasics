package com.workouts.servletlisteners;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession hs = req.getSession();
    	String username = req.getParameter("user");
    	String password = req.getParameter("password");
    	
    	hs.setAttribute("username", username);
    	hs.setAttribute("password", password);
    	
    	out.println("Login Success");
    	resp.setContentType("text/html");
        out.println("<html><body><a href='./logout'>Logout</a></body></html>");
	}
	
}
