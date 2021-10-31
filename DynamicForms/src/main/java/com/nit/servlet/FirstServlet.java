package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		
		//generate form2 based on marital status
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr><td>Spouse name: </td><td><input type='text' name='f2t1'></td>");
			pw.println("<tr><td>No of kids : </td><td><input type='text' name='f2t2'></td>");
			pw.println("<tr><td><input type='submit' value='register'></td><td><input type='reset' value='cancel'></td>");
			pw.println("</table>");
			pw.println("</form>");
		}//if
		else {
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table align='center' bgcolor='gray'>");
			pw.println("<tr><td>Why u want to marry : </td><td><input type='text' name='f2t1'></td>");
			pw.println("<tr><td>When u want to marry : </td><td><input type='text' name='f2t2'></td>");
			pw.println("<tr><td><input type='submit' value='register'></td><td><input type='reset' value='cancel'></td>");
			pw.println("</table>");
			pw.println("</form>");
		}//else
		
		//close stream
		pw.close();
	}//doGet(-,-)

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class
