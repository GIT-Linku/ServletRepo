package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {

	private static final String GET_EMP_BY_ENO = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		try {
			//get PrintWritter
			pw = res.getWriter();
			//set content type
			res.setContentType("text/html");
			//include header content
			RequestDispatcher rd1 = req.getRequestDispatcher("/headurl");
			rd1.include(req, res);
			//get accessto servlet config obj
			ServletConfig cg = getServletConfig();
			//System.out.println("EmloyeeSearchServlet's servlet config obj : "+cg.hashCode());

			//read init parameter value
			String driver = cg.getInitParameter("driverClass");
			String url = cg.getInitParameter("url");
			String user = cg.getInitParameter("dbuser");
			String pwd = cg.getInitParameter("dbpwd");
			//pw.println("<b>hello</b>");

			//read form data
			int no = Integer.parseInt(req.getParameter("eno"));

			//Load the driver
			try {
				Class.forName(driver);
			}//try
			catch (ClassNotFoundException cnf) {
				cnf.printStackTrace();
			}//catch

			//Create connection
			try (Connection con = DriverManager.getConnection(url,user,pwd)){
				PreparedStatement ps = con.prepareStatement(GET_EMP_BY_ENO);
				if(ps!=null)
					ps.setInt(1, no);
				try(ResultSet rs = ps.executeQuery()){
					if(rs!=null) {
						if(rs.next()){
							pw.println("<h1 style='color:blue;text-align:center'>Employee details are : </h1>");

							pw.println("<p style='color:orange;text-align:center'><b>Employee no : "+rs.getInt(1)+"</b><br>");
							pw.println("<b>Employee name : "+rs.getString(2)+"</b><br>");
							pw.println("<b>Job : "+rs.getString(3)+"</b><br>");
							pw.println("<b>Salary : "+rs.getFloat(4)+"</b><br>");
							pw.println("<b>Dept. No : "+rs.getInt(5)+"</b></p>");
						}//if
						else {
							pw.println("<h1 style='color:red;text-align:center'>Employee Details not found</h1>");
						}//else
					}//if

					pw.println("<p style='text-align:center'><a href='search.html'>home</a></p>");

					
				}//try2
			}//try1
			
			//include footer content
			RequestDispatcher rd2 = req.getRequestDispatcher("/footer.html");
			rd2.include(req, res);
			
			//close stream
			pw.close();
		}//try
		catch (Exception e) {
			e.printStackTrace();
			
			
			pw.println("<b>before rd.forward()</b>");
			System.out.println("MainServlet:before rd.forward()");
			RequestDispatcher rd = req.getRequestDispatcher("errurl");
			rd.forward(req, res);
			
			pw.println("<b>after rd.forward()</b>");
			System.out.println("MainServlet:after rd.forward()");
		}

	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}








