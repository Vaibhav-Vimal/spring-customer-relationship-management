package com.luv2code.tsestdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setup Connection variable
		
		String user = "springstudent";
		String pass = "springstudent";
		
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		//get Connection to DB
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to DB :" + url);
			
			Class.forName(driver);
			Connection conn =  DriverManager.getConnection(url, user, pass);
			
			out.println("Connection Successfull");
			
			conn.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}

}
