package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		//read form2/req2 data
		String f2val1=req.getParameter("f2t1");
		String f2val2=req.getParameter("f2t2");
		
		//get asses to HttpSession object
		HttpSession ses=req.getSession(false);
		//read form1/req1 data from session attribute 
		String name = (String)ses.getAttribute("name");
		String fname = (String)ses.getAttribute("fname");
		String addrs = (String)ses.getAttribute("addrs");
		String ms = (String)ses.getAttribute("ms");
		//display data
		pw.println("<br><b>form1/req1 data : "+name+"  "+fname+"  "+addrs+"  "+ms);
		pw.println("<br><b>form2/req2 data : "+f2val1+"  "+f2val2);
		
		//invalidate the session
		ses.invalidate();

		//add home hyperlink
		pw.println("<br><br><h1 style='text-align:center'><a href='person_details.html'>home</a></h1>");
		
		pw.println("<br>Session Id : "+ses.getId());

	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
