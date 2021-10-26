package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBTestServlet extends HttpServlet {
	
	static {
		System.out.println("DBTestServlet:static block");
	}
	public DBTestServlet() {
		System.out.println("DBTestServlet:0-param constructor");
	}
	
	//Approach-1
	

	/*
	@Override
	public void init() throws ServletException {
		System.out.println("DBTestServlet::init()");
		ServletConfig cg = getServletConfig();
		System.out.println("driver class name :"+cg.getInitParameter("driverclass"));
		System.out.println("jdbc url :"+cg.getInitParameter("url"));
	}
	*/
	
	//Approach-2
	/*
	private ServletConfig cg;
	  @Override 
	  public void init(ServletConfig cg) throws ServletException {
	  System.out.println("DBTestServlet:init(ServletConfig cg)");
	  this.cg = cg;
	  
	  System.out.println("driver class name :"+cg.getInitParameter("driverclass"));
	  System.out.println("jdbc url :"+cg.getInitParameter("url"));
	  System.out.println("db user:"+cg.getInitParameter("dbuser"));
	  System.out.println("db pwd :"+cg.getInitParameter("dbpwd"));
	  
	  }
	 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("DBTestServlet:service(-,-)");
	//	ServletConfig cg = getServletConfig();
		System.out.println("jdbc url :"+cg.getInitParameter("url"));
		System.out.println("db user:"+cg.getInitParameter("dbuser"));
		
		
	*/
	
	//Approach-3
/*	
	@Override 
	  public void init(ServletConfig cg) throws ServletException {
	  System.out.println("DBTestServlet:init(ServletConfig cg)");
	  super.init(cg);
	  
	  
	  System.out.println("driver class name :"+cg.getInitParameter("driverclass"));
	  System.out.println("jdbc url :"+cg.getInitParameter("url"));
	  System.out.println("db user:"+cg.getInitParameter("dbuser"));
	  System.out.println("db pwd :"+cg.getInitParameter("dbpwd"));
	  
	  }
*/
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("DBTestServlet:doGet(-,-)");
		
       	ServletConfig cg = getServletConfig();
		System.out.println("jdbc url :"+cg.getInitParameter("url"));
		System.out.println("db user:"+cg.getInitParameter("dbuser"));
		
		//get printwriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		
		pw.println("<h1 style='color:red;text-align:center'>Date and Time ::"+new java.util.Date()+"</h1>");
		
		pw.close();
	}
	@Override
	public void destroy() {
		System.out.println("DBTestServlet:destroy()");
	}
}
