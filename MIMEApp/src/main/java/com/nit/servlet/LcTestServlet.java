package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet {
	
	static {
		System.out.println("LcTestServlet:static block");
	}
	public LcTestServlet() {
		System.out.println("LcTestServlet:0-param constructor");
	}
	@Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("LcTestServlet:init(ServletConfig cg)");
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LcTestServlet:service(-,-)");
		
		//get printwriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		
		pw.println("<h1 style='color:red;text-align:center'>Date and Time ::"+new java.util.Date()+"</h1>");
		
		pw.close();
	}
	@Override
	public void destroy() {
		System.out.println("LcTestServlet:destroy()");
	}
}
