package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String ss = req.getParameter("ss");
		String engine = req.getParameter("engine");
		//send hyperlink to browser having url to complete send rediraction
		if(engine.equalsIgnoreCase("google"))
			pw.println("<h1 style='color:blue;text-align:center'><a href='https://www.google.com/search?q="+ss+"'>click here for google search</a></h1>");
		else if(engine.equalsIgnoreCase("bing"))
			pw.println("<h1 style='color:blue;text-align:center'><a href='https://www.bing.com/search?q="+ss+"'>click here for bing search</a></h1>");
		else
			pw.println("<h1 style='color:blue;text-align:center'><a href='https://in.search.yahoo.com/search?p="+ss+"'>click here for yahoo search</a></h1>");
		//close stream
		pw.close();

	}//goGet
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost
}//class
