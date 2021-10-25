package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get access to servlet config obj
		ServletConfig cg = getServletConfig();
		//get access to servlet context obj
		ServletContext sc = getServletContext();
		System.out.println("TestServlet's servlet context obj : "+sc.hashCode());
		//read init parameter value
		pw.println("<b><br>DB user servletcontext parameter value : "+sc.getInitParameter("dbuser")+"</b<br>");
		pw.println("<b><br>DB pwd init parameter value : "+cg.getInitParameter("dbpwd")+"</b<br>");
		pw.println("<br><b>servlet config class  name : "+sc.getClass()+"</b>");
		
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	
}
