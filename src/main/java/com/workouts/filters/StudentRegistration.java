package com.workouts.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		int marks1 = Integer.parseInt(req.getParameter("marks1"));
		int marks2 = Integer.parseInt(req.getParameter("marks2"));
		int total = marks1 + marks2;
		
		PrintWriter out = res.getWriter();
		 
		out.println("<pre>");
		out.println("ID: " + id);
		out.println("Name: " + name);
		out.println("Marks1: " + marks1);
		out.println("Marks2: " + marks2);
		out.println("Total: " + total);
		out.println("</pre>");
	}

	
}
