//WordServlet.java

package com.nit.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class WordServlet extends HttpServlet{
	static {
		System.out.println("WordServlet:static block");
	}
	public WordServlet() {
		System.out.println("WordServlet:0-param constructor");
	}
	@Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("WordServlet:init(ServletConfig cg)");
	}

	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("WordServlet:service(-,-)");
		
		//set responce content type
		res.setContentType("application/msword");

		//get PrintWriter Stream
		PrintWriter pw = res.getWriter();
		
		//write output content to browser
		pw.println("<table border='1' align='center'>");
		pw.println("<tr><th>Player Name</th><th>Medal</th><th>Catagory</th></tr>");
		pw.println("<tr><td>Neeraj Chopra</td><td>Gold</td><td>Javelin</td></tr>");
		pw.println("<tr><td>Mirabai Chanu</td><td>Silver</td><td>Weight Lifting</td></tr>");
		pw.println("<tr><td>Ravi Kumar Dahiya</td><td>Silver</td><td>Wrestling</td></tr>");
		pw.println("<tr><td>PV Sindhu</td><td>Bronze</td><td>Badminton</td></tr>");
		pw.println("<tr><td>Lovlina Borgohain</td><td>Bronze</td><td>Boxing</td></tr>");
		pw.println("<tr><td>Bajrang Punia</td><td>Bronze</td><td>Wrestling</td></tr>");
		pw.println("<tr><td>Hockey</td><td>Bronze</td><td>Mens Hockey</td></tr>");
		pw.println("</table>");


		//close stream
		pw.close();
	}//service
}//class