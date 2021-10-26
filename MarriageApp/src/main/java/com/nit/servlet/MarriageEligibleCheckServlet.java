package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageEligibleCheckServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// set content type
		res.setContentType("text/html");

		// read form data
		String name = req.getParameter("cname");
		int age = Integer.parseInt(req.getParameter("cage"));
		String gender = req.getParameter("cgender");

		// write bussiness logic
		 if(gender.equals("M")) {
			 if(age>=21)
				 pw.println("<h1 style='color:green;text-align:center'>Mr "+name+" u r eligble for marriage</h1><br>");
			 else
				 pw.println("<h1 style='color:red;text-align:center'>Mr "+name+" u r not eligble for marriage</h1><br>");
		 }
		 else {
			 if(gender.equals("F") && age>=18)
				 pw.println("<h1 style='color:green;text-align:center'>Miss "+name+" u r eligble for marriage</h1><br>");
			 else
				 pw.println("<h1 style='color:red;text-align:center'>Miss "+name+" u r not eligble for marriage</h1><br>");
		 }
 
		// add home hyperlink(graphical hyperlink)
		pw.println("<a href='marriage_validation.html'><img src='images/Home.jpg'></a>");

		// close stream
		pw.close();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
