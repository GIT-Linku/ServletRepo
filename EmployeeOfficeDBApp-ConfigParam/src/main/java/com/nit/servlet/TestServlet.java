package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
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
		pw.println("<b>servlet name : "+cg.getServletName()+"</b><br>");
		System.out.println("TestServlet's servlet config obj : "+cg.hashCode());
		
		//read init parameter value
		pw.println("<b><br>DB user init parameter value : "+cg.getInitParameter("dbuser")+"</b");
		pw.println("<br><b>servlet config class  name : "+cg.getClass()+"</b>");
		
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	
}
