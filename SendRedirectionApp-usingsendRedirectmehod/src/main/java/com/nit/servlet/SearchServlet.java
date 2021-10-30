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
		String url=null;
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+ss;
		else
			url="https://in.search.yahoo.com/search?p="+ss;
		
		//perform sendRedirection
		System.out.println("Before res.sendRedirect(-)");
		pw.println("<b>hello</b>");
		res.sendRedirect(url);
		System.out.println("After res.sendRedirect(-)");
		pw.println("<b>hii</b>");
		
		//close stream
		pw.close();

	}//goGet
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost
}//class
