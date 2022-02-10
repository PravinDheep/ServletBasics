package com.workouts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AadharRegistration
 */
@WebServlet("/AadharRegistration")
public class AadharRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String formValue = req.getParameter("formNo");
		HttpSession session = req.getSession();

		if(("1".equals(formValue))){
			String name = req.getParameter("name");
			String fname = req.getParameter("fname");
			String mname = req.getParameter("mname");
			
			session.setAttribute("name", name);
			session.setAttribute("fname", fname);
			session.setAttribute("mname", mname);
			// request scope not available, session scope available, retrives the
			// static content.
			res.sendRedirect("./AadharRegForm2.html");
			
		} else if(("2".equals(formValue))){
			String contact = req.getParameter("contact");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			
			session.setAttribute("contact", contact);
			session.setAttribute("email", email);
			session.setAttribute("address", address);
			
			res.sendRedirect("./AadharRegForm3.html");
		} else {
			String qual = req.getParameter("qual");
			String per = req.getParameter("per");
			
			String name = session.getAttribute("name").toString();
			String fname = session.getAttribute("fname").toString();
			String mname = session.getAttribute("mname").toString();
			String contact = session.getAttribute("contact").toString();
			String email = session.getAttribute("email").toString();
			String address = session.getAttribute("address").toString();
			
			try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/workouts","root","welcome");
			  PreparedStatement ps = con.prepareStatement("insert into aadharreg values(?,?,?,?,?,?,?,?)");
			  ps.setString(1,name);
			  ps.setString(2,fname);
			  ps.setString(3,mname);
			  ps.setString(4,contact);
			  ps.setString(5,email);
			  ps.setString(6,address);
			  ps.setString(7,qual);
			  ps.setString(8, per);
			  
			  int rows = ps.executeUpdate();
			  
			  PrintWriter out = res.getWriter();
			  if(rows != -1) {
				  RequestDispatcher rd = req.getRequestDispatcher("/color");
				  rd.include(req, res);
				  out.println("<pre>");
				  out.println("Name: " + name);
				  out.println("Father Name: " + fname);
				  out.println("Mother Name: " + mname);
				  out.println("Contact: " + contact);
				  out.println("E-mail: " + email);
				  out.println("Address: " + address);
				  out.println("Qualification: " + qual);
				  out.println("Percentage: " + per);
				  out.println("</pre>");
			  } else {
				  out.println("<html><body><font color='red'>Insertion failed</font></body></html>");
			  }
				
			} catch(Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		
		
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	

}
