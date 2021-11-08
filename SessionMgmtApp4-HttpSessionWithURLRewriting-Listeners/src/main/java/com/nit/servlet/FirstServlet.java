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

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String name=req.getParameter("pname");
		String fname=req.getParameter("fname");
		String addrs=req.getParameter("address");
		String ms=req.getParameter("ms");
		//create session opbject for current request
		HttpSession ses=req.getSession();
		//keep form1/req1 data in Session object as session attribute value
		 ses.setAttribute("name", name);
		 ses.setAttribute("fname", fname);
		 ses.setAttribute("addrs", addrs);
		 ses.setAttribute("ms", ms);
		
		
		//generate form2 data as per marrital status
		if (ms.equalsIgnoreCase("married")) {
			pw.println("<h1 style='color:red;text-align:center'>Person Details - page2(URL Rewritting)</h1>");
			pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
			pw.println("<table bgcolor='pink' align='center'>");
			pw.println("<tr><td>Spous name : </td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>No of kids : </td><td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td><input type='submit' value='register'></td><td><input type='reset' value='cancel'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}//if 
		else {
			pw.println("<h1 style='color:red;text-align:center'>Person Details - page2(URL Rewritting)</h1>");
			pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
			pw.println("<table bgcolor='pink' align='center'>");
			pw.println("<tr><td>Why u want to marry : </td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>When do u want to marry : </td><td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td><input type='submit' value='register'></td><td><input type='reset' value='cancel'></td></tr>");
			pw.println("</table>");
			
			pw.println("</form>");

		}//else
		
		pw.println("<br>Session Id : "+ses.getId());

	}//doGet(-,-)

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class