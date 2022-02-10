package com.workouts.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StudRegFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String studFilter = filterConfig.getInitParameter("student");
		System.out.println(studFilter + " from Filter init");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		String identifier = req.getParameter("id");
		String name = req.getParameter("name");
		int marks1 = 0;
		int marks2 = 0;
		int total = 0;
		try {
			marks1 = Integer.parseInt(req.getParameter("marks1"));
			marks2 = Integer.parseInt(req.getParameter("marks2"));
			total = Integer.parseInt(req.getParameter("total"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter out = res.getWriter();
		 
		if(identifier.equals("")) {
			out.println("ID is required.");
		}
		
		 
		if(name.equals("")) {
			out.println("NAME is required.");
		}
		
		 
		if(marks1 == 0) {
			out.println("MARK1 is required.");
		}
		
		 
		if(marks2 == 0) {
			out.println("MARK2 is required.");
		}
		
		 
		if(total == 0) {
			out.println("Total is required.");
		}
		
		//Before invoking Servlet
		
		fc.doFilter(req, res); //Calling StudentRegistration servlet
		
		// After invoking Servlet
		
		RequestDispatcher rd = req.getRequestDispatcher("/color"); rd.include(req,
		res);
		  
	}

	@Override
	public void destroy() {
		System.out.println("Filter destroy");
	}

}
