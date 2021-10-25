package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FoodTimingServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set responce content type
		res.setContentType("text/html");
		//write bussiness logic to generate the food timing
		LocalDateTime ldt = LocalDateTime.now();//gives current date and time
		int hour = ldt.getHour(); //gives current hours from 0 to 23
		
		//print the current date and time
		pw.println("<h1 style='color:red;text-align:center'>"+ldt.toString()+"</h1>");
		
		if(hour>7 && hour<9)
			pw.println("<h1 style='color:blue;text-align:center'>Breakfast Time</h1>");
		else if(hour>12 && hour<14)
			pw.println("<h1 style='color:green;text-align:center'>Lunch Time</h1>");
		else if(hour>17 && hour<19)
			pw.println("<h1 style='color:black;text-align:center'>Snack Time</h1>");
		else if(hour>21 && hour<23)
			pw.println("<h1 style='color:red;text-align:center'>Dinner Time</h1>");
		else
			pw.println("<h1 style='color:pink;text-align:center'>wait for the time</h1>");
		
		//add home hyperlink
		pw.println("<a href=http://localhost:2020/FoodApp/page.html>home</a>");
		
		//close PrintWriter object
		pw.close();
	}

}
