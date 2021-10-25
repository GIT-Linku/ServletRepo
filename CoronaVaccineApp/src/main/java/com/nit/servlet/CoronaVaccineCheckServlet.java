package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoronaVaccineCheckServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrtintWritter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		String name = req.getParameter("pname");
		String addrs = req.getParameter("paddrs");
		int age = Integer.parseInt(req.getParameter("page"));
		//write bussiness logic
		if(age<18)
			pw.println("<h1 style='color:red;text-align:center'>Mr/Miss/Mrs "+name+" you are not eligible for Corona Vaccination</h1><br>");
		else
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs "+name+" you are eligible for Corona Vaccination. Take it.</h1><br>");
		
		//add home hyperlink(graphical hyperlink)
		pw.println("<a href='corona_vaccine.html'><img src='images/Home.jpg'></a>");
		
		//close stream
		pw.close();
	}
}
