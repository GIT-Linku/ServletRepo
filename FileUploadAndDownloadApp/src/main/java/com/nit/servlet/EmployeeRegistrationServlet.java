package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.MultipartBoundaryInputStream;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;


@WebServlet("/uploadurl")
public class EmployeeRegistrationServlet extends HttpServlet {
	
	private static final String INSERT_EMPLOYEE_QUERY="INSERT INTO UPLOAD_EMPLOYEE VALUES(EMP_SEQ.NEXTVAL,?,?,?,?)";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter obj
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//read special request Object
			MultipartFormDataRequest nreq = new MultipartFormDataRequest(req);
			//read form data
			String name = nreq.getParameter("ename");
			String addrs = nreq.getParameter("eadd");
			//create UploadBean class object
			UploadBean upb = new UploadBean();
			upb.setFolderstore("E:/store");
			upb.setOverwrite(false);
			upb.setFilesizelimit(50*1024);
			//complete file Upload process
			upb.store(nreq);
			pw.println("<b>file are uploaded successfully</b>");
			//get the names of the uploaded files
			Vector<UploadParameters> vector = upb.getHistory();
			ArrayList<String> filesList=new ArrayList();
			vector.forEach(up->{
				filesList.add("E:/store/"+up.getFilename());
			});
			//write JDBC code to form data and files location to db table as record
			
			//Load JDBC Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","IMIT","IMIT");
			
			//create prepared statement
			ps = con.prepareStatement(INSERT_EMPLOYEE_QUERY);
			
			//set values to query param
			ps.setString(1, name);
			ps.setString(2, addrs);
			ps.setString(3, filesList.get(0));
			ps.setString(4, filesList.get(1));
			
			//execute the query
			int count = ps.executeUpdate();
			if(count==1)
				pw.println("<h1 style='color:green;text-align:center'>Employee registered</h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Employee not registered</h1>");
		}
		catch (Exception e) {
			e.printStackTrace();
			pw.println("<b>Problem in file uploading</b>"+e.getMessage());
		}
		finally {
			//close jdbc objs
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		//add home hyperlinks
		pw.println("<a href='employee_register.html'>home</a>");
		//close stream
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
