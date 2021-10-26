package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageEligibleCheckServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VaccineEligibilityCheckServlet.doPost(-,-)");
		//get printwriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read data from form
		String name = req.getParameter("cname");
		String tage = req.getParameter("cage");
		String gender = req.getParameter("cgender");

		String cvsStatus = req.getParameter("vflag");

		int age=0;

		
		  if(cvsStatus.equalsIgnoreCase("no")) { //form validation logic(server side )
		  System.out.println("Server side form validation");
		  List<String> errorsList = new ArrayList();
		  if(name==null || name.length()==0 ||name.equalsIgnoreCase("")) 
		  errorsList.add("Candidate name is required");
		  if(tage==null || tage.length()==0 || tage.equalsIgnoreCase(""))
		  errorsList.add("Candidate age is required");
		  else { 
		  try {
		  age=Integer.parseInt(tage); 
		  if(age<1 || age>125)
		  errorsList.add("Candidate age mut be in the range 1-125");
		  
		  }//try 
		  catch (NumberFormatException nfe) {
		  errorsList.add("Candidate age must be numeric value");
		  
		  } 
		  }//else
		   if(gender==null || gender.length()==0 || gender.equalsIgnoreCase("")) 
		   errorsList.add("Candidate gender is required");
		  if(errorsList.size()>0) { 
		  pw.println("<ul style='color:red'>");
		   for(String errMsg:errorsList) 
		   pw.println("<li>"+errMsg+"</li>"); 
		   pw.println("</ul>");
		  return;
		   }//if
		   }//if
		 
		//age=Integer.parseInt(tage);

		//write business logic
		if(gender.equals("male")) {
			if(age>=21)
				pw.println("<h1 style='color:green;text-align:center'>Mr "+name+" u r eligible for Marriage</h1><br>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Mr "+name+" u r not eligible for Marriage</h1><br>");
		}//if
		else {
			if(gender.equals("female") && age>=18)
				pw.println("<h1 style='color:green;text-align:center'>Miss "+name+" u r eligible for Marriage</h1><br>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Miss "+name+" u r not eligible for Marriage</h1><br>");
		}
		// add home hyperlink(graphical hyperlink)
		pw.println("<a href='marriage_validation.html'><img src='images/Home.jpg'></a>");

		// close stream
		pw.close();

	}//post
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

}
