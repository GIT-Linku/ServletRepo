package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerRegistrationServlet extends HttpServlet {
	
	private static final String INSERT_CUSTOMER_QUERY = "INSERT INTO SERVLET_CUSTOMER VALUES(CUST_CNO.NEXTVAL,?,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//read form Data
		String name = req.getParameter("cname");
		String addrs = req.getParameter("cadd");
		Float bill = Float.parseFloat(req.getParameter("billAmt"));
		Long mobileNo = Long.parseLong(req.getParameter("mobileNo"));
		
		//get jdbc pooled object
		try(Connection con = getPooledConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_CUSTOMER_QUERY);
				){
			//set value to query param
			ps.setString(1, name);
			ps.setString(2, addrs);
			ps.setFloat(3, bill);
			ps.setLong(4, mobileNo);
			//execute query
			int result = ps.executeUpdate();
			//process the result
			if(result==1)
				pw.println("<h1 style='color:green'>Customer Registerd</h1>");
			else
				pw.println("<h1 style='color:red'>Customer not Registerd</h1>");
			
			//add home hyperlink
			pw.println("<br><br><a href='customer_registration.html'>Home</a>");
			
		}//try
		catch (SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red'>Internal Error"+se.getMessage()+"</h1>");
		}
		catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red'>Internal Error"+e.getMessage()+"</h1>");
		}
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	//helper method
	private Connection getPooledConnection()throws Exception{
		//create initialcontext object
		InitialContext ic = new InitialContext();
		//get DataSource obj ref through lookup operation
		DataSource ds = (DataSource)ic.lookup("DsJndi");
		Connection con = ds.getConnection();
		return con;
	}
}