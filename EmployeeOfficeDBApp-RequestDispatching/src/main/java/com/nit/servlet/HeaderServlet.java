package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/headurl")
public class HeaderServlet extends HttpServlet {
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWritter
		PrintWriter pw = res.getWriter();
		//set xontent type
		res.setContentType("text/html");
		
		//write header content
		pw.println("<marquee><h1 style='color:red;align:center'>N A R E S H Technology</h1></marquee>");
		
		//close stream
		//do not close stream
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
