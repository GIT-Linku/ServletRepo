package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		//create cookies
		Cookie ck1=new Cookie("TS", "hyd");
		Cookie ck2=new Cookie("MH", "mumbai");
		Cookie ck3=new Cookie("Delhi", "NewDelhi");
		Cookie ck4=new Cookie("Odisha", "BBSR");
		
		ck3.setMaxAge(2*60);
		ck4.setMaxAge(1*60);
		
		//set to response
		res.addCookie(ck1); res.addCookie(ck2);
		res.addCookie(ck3); res.addCookie(ck4);
		
		pw.println("<h style='color:red;text-align:center'>Cokkies are added successfully</h1>");
		//close stream
		pw.close();

	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class
