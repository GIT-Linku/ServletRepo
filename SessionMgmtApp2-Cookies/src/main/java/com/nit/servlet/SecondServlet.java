package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form1/req1 data from cookies of request2
		Cookie cookies[]=req.getCookies();
		String name=null,fname=null,addrs=null,ms=null;
		if (cookies!=null) {
			name=cookies[0].getValue();
			fname=cookies[1].getValue();
			addrs=cookies[2].getValue();
			ms=cookies[3].getValue();
		}

		//read form2/req2 data
		String f2val1=req.getParameter("f2t1");
		String f2val2=req.getParameter("f2t2");

		//display data
		pw.println("<br><b>form1/req1 data : "+name+"  "+fname+"  "+addrs+"  "+ms);
		pw.println("<br><b>form2/req2 data : "+f2val1+"  "+f2val2);

		//add home hyperlink
		pw.println("<br><br><h1 style='text-align:center'><a href='person_details.html'>home</a></h1>");

	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
