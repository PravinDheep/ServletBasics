package com.workouts.interservletcommunications;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Registration
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/workouts","root","welcome");
			PreparedStatement ps = con.prepareStatement("insert into stud values(?,?,?,?)");
			ps.setInt(1, 233);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, address);
			int rows = ps.executeUpdate();
			PrintWriter out = res.getWriter();
			if(rows != -1 && rows != 0) {
				RequestDispatcher rd = req.getRequestDispatcher("/color");
				rd.include(req, res);
			} else {
				 out.println("<html><body><font color='blue'>Insertion Failed</font>");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
