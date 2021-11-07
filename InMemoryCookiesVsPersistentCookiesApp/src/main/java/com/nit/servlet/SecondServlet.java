package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

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
		//read Cookies
		Cookie cookies[]=req.getCookies();
		if(cookies!=null) {
			pw.println("<table border='1' align='center' bgcolor='cyan'>");
			for(Cookie ck:cookies) {
				pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");
			}
			pw.println("</table>");
		}else {
			pw.println("<h style='color:red;text-align:center'>No Cokkies present</h1>");
	}
	//close stream
	pw.close();

}//doGet(-,-)

public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req, res);
}//doPost(-,-)

}//class
