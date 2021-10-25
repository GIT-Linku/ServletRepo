package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DailyRoutineServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//write bussiness logic for daily routine
		LocalDateTime ldt = LocalDateTime.now();//gives current date and time
		int hour = ldt.getHour();//gives current hour from 0 to 23
		
		//print current date and time
		pw.println("<h1 style='color:red;text-align:center'>"+ldt.toString()+"</h1>");
		
		if(hour==5)
			pw.println("<h1 style=color:yellow;text-align:center>Wake up Time</h1>");
		else if(hour>5.10 && hour<5.40)
			pw.println("<h1 style=color:blue;text-align:center>Exercise</h1>");
		else if(hour>5.40 && hour<6)
			pw.println("<h1 style=color:red;text-align:center>Bath Time</h1>");
		else if(hour>6 && hour<6.15)
			pw.println("<h1 style=color:pink;text-align:center>Puja Time</h1>");
		else if(hour>6.15 && hour<6.30)
			pw.println("<h1 style=color:green;text-align:center>Breakfast Time</h1>");
		else if(hour>6.30 && hour<9.30)
			pw.println("<h1 style=color:black;text-align:center>Home Work,Self Study</h1>");
		else if(hour>9.30 && hour<10)
			pw.println("<h1 style=color:violet;text-align:center>Preapare for College</h1>");
		else if(hour>10 && hour<13)
			pw.println("<h1 style=color:black;text-align:center>College Class</h1>");
		else if(hour>13 && hour<14)
			pw.println("<h1 style=color:pink;text-align:center>Lunch Time</h1>");
		else if(hour>14 && hour<17)
			pw.println("<h1 style=color:red;text-align:center>College Class</h1>");
		else if(hour>17 && hour<18.15)
			pw.println("<h1 style=color:green;text-align:center>Sports Time</h1>");
		else if(hour>18.15 && hour<18.30)
			pw.println("<h1 style=color:blue;text-align:center>Snack Time</h1>");
		else if(hour>18.30 && hour<21)
			pw.println("<h1 style=color:violet;text-align:center>Study Time</h1>");
		else if(hour>21 && hour<22)
			pw.println("<h1 style=color:black;text-align:center>Dinner Time</h1>");
		else
			pw.println("<h1 style=color:yellow;text-align:center>Sleep Time</h1>");
		
		//add home hyperlink
		pw.println("<a href=http://localhost:2020/DailyApp/page.html>home</a>");
		
		//close object
		pw.close();
	}

}
