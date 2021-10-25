package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formurl")
public class FormCompsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		String name = req.getParameter("pname");
		int age = Integer.parseInt(req.getParameter("page"));
		String addrs = req.getParameter("paddrs");
		String gender = req.getParameter("gender");
		String ms = req.getParameter("ms");
		String qlfy = req.getParameter("qlfy");
		String language[] = req.getParameterValues("language");
		String hobies[] = req.getParameterValues("hb");
		String dob = req.getParameter("dob");
		String tob = req.getParameter("tob");
		String month = req.getParameter("mob");
		String week = req.getParameter("wdb");
		int favNumber = Integer.parseInt(req.getParameter("favNumber"));
		long mobileno = Long.parseLong(req.getParameter("mobileNo"));
		String mail = req.getParameter("mail");
		String favColor = req.getParameter("favColor");
		int income = Integer.parseInt(req.getParameter("income"));
		String url = req.getParameter("fburl");
		String search = req.getParameter("favSearch");
		
		//write bussiness logic
		if(gender.equalsIgnoreCase("M")) {
			if(age<5)
				pw.println("<h1 style='color:blue;text-align:center'>Master "+name+" u r a baby boy</h1>");
			else if(age<13)
				pw.println("<h1 style='color:blue;text-align:center'>Master "+name+" u r a small boy</h1>");
			else if(age<19)
				pw.println("<h1 style='color:blue;text-align:center'>Mr "+name+" u r a teenager boy</h1>");
			else if(age<35)
				pw.println("<h1 style='color:blue;text-align:center'>Mr "+name+" u r a young man</h1>");
			else if(age<50)
				pw.println("<h1 style='color:blue;text-align:center'>Mr "+name+" u r a middle-aged man</h1>");
			else
				pw.println("<h1 style='color:blue;text-align:center'>Mr "+name+" u r a old man</h1>");	
		}//if
		else {
			if(age<5)
				pw.println("<h1 style='color:blue;text-align:center'>Master "+name+" u r a baby girl</h1>");
			else if(age<13)
				pw.println("<h1 style='color:blue;text-align:center'>Master "+name+" u r a small girl</h1>");
			else if(age<19) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center'>Mrs "+name+" u r a teenager married girl</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center'>Miss "+name+" u r a teenager girl</h1>");
			}
			else if(age<35) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center'>Mrs "+name+" u r a young married girl</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center'>Miss "+name+" u r a young girl</h1>");
			}
			else if(age<50) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center'>Mrs "+name+" u r a middle-aged married women</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center'>Miss "+name+" u r a middle-aged women</h1>");
			}
			else {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center'>Mrs "+name+" u r a old married women</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center'>Miss "+name+" u r a old women</h1>");
			}
		}
		
		//display form data
		pw.println("<br><br><b>Form Data ::</b><br>");
		pw.println("<br><b>Name ::</b>"+name);
		pw.println("<br><b>Age ::</b>"+age);
		pw.println("<br><b>Address ::</b>"+addrs);
		pw.println("<br><b>Gender ::</b>"+gender);
		pw.println("<br><b>Marital Status ::</b>"+ms);
		pw.println("<br><b>Qualification ::</b>"+qlfy);
		pw.println("<br><b>Known Language ::</b>"+language);
		pw.println("<br><b>Hobies ::</b>"+hobies);
		pw.println("<br><b>DOB ::</b>"+dob);
		pw.println("<br><b>TOB ::</b>"+tob);
		pw.println("<br><b>Month of Birth ::</b>"+month);
		pw.println("<br><b>Week of birth ::</b>"+week);
		pw.println("<br><b>Fav Number ::</b>"+favNumber);
		pw.println("<br><b>Mobile No. ::</b>"+mobileno);
		pw.println("<br><b>Email ::</b>"+mail);
		pw.println("<br><b>Fav Color ::</b>"+favColor);
		pw.println("<br><b>Income ::</b>"+income);
		pw.println("<br><b>Fb url ::</b>"+url);
		pw.println("<br><b>Search string ::</b>"+search);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
