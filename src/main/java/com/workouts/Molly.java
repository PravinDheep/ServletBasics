package com.workouts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Molly implements Servlet{

	String fishName = null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig sc) throws ServletException {
		String fishName = sc.getInitParameter("name");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String numberOfFishes = req.getParameter("m1");
		PrintWriter out = res.getWriter();
		out.println("No of Fishes requested: "+ numberOfFishes + ">>" + fishName);
	}
	
}
