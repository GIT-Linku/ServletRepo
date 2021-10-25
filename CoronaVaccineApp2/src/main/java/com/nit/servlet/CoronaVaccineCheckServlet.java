package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoronaVaccineCheckServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrtintWritter
				PrintWriter pw = res.getWriter();
				//set content type
				res.setContentType("text/html");
				//read form data
				String name = req.getParameter("pname");
				String addrs = req.getParameter("paddrs");
				String tage = req.getParameter("page");
				
				//form validation logic(server side )
				List<String> errorsList = new ArrayList();
				if(name==null || name.length()==0 || name.equalsIgnoreCase(""))
					errorsList.add("Person name is requird");
				if(addrs==null || addrs.length()==0 || addrs.equalsIgnoreCase(""))
					errorsList.add("Person address is required");
				else if(addrs.length()<10)
					errorsList.add("Person address must have min 10 charecter");
				int age = 0;
				if(tage==null || tage.length()==0 || tage.equalsIgnoreCase(" "))
					errorsList.add("Person age is required");
				else {
					try {
						age = Integer.parseInt(tage);
						if(age<=0 || age>125)
							errorsList.add("Person age mut be in the range 1-125");
						
					} catch (NumberFormatException nfe) {
						errorsList.add("Person age must be numeric value");
						
					}//catch
				}//else
				
				if(errorsList.size()>0) {
					pw.println("<ul style='color:red'>");
					for(String errMsg:errorsList)
						pw.println("<li>"+errMsg+"</li>");
					pw.println("</ul>");
					return;						
				}
				
				
				
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
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
