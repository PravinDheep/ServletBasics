package com.workouts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Registration extends GenericServlet{

	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		//Context param value
		String aquarium = context.getInitParameter("Fish Aquarium");
	
		//Config param value
		String country = config.getInitParameter("Country");
		
		System.out.println(">>>>>>>>>" + aquarium + "::::::::: " + country);
	}
	
	@Override
	public void service(ServletRequest sreq, ServletResponse sres) throws ServletException, IOException {
		String name = sreq.getParameter("name");
		String email = sreq.getParameter("email");
		String addr = sreq.getParameter("address");
		sreq.getParameter("genderMale");
		sreq.getParameter("genderFemale");
		sreq.getParameter("knownLanguageTamil");
		sreq.getParameter("knownLanguageEnglish");
		sreq.getParameter("knownLanguageOthers");
		sreq.getParameter("country");
		sres.setContentType("text/html");
		PrintWriter out = sres.getWriter();
		out.println("name: " + name + "\nemail: " + email + "\nAddr: " + addr);
		System.out.println("name: " + name + "\nemail: " + email + "\nAddr: " + addr);
	}

}
