package com.StudentManagment.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagment.service.SignupService;
import com.StudentManagment.utils.CJdbc;

public class SignupServiceImpl implements SignupService{
	
		
		@Override
		public void signup(HttpServletRequest req, HttpServletResponse res) {
			// TODO Auto-generated method stub
			System.out.println("Service code");
			System.out.println("Username");
			System.out.println(req.getParameter("email"));
			System.out.println(req.getParameter("password"));
			
		
		
	
		try {
			CJdbc.jdbc(); // Ensure the connection is established
			String insertQuery = ("INSERT INTO StudentManagement.user_info (userName,email,password) VALUES (?,?,?);");
			PreparedStatement pre = CJdbc.con.prepareStatement(insertQuery);
			PrintWriter out = res.getWriter();
			String userName = req.getParameter("userName");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			System.out.println(userName);
			System.out.println(email);
			System.out.println(password);
			pre.setString(1, userName);
			pre.setString(2, email);
			pre.setString(3, password);
			int rowsAffected = pre.executeUpdate();
			if (rowsAffected > 0) {
				res.sendRedirect("login.html");
				out.println("Success: Data successfully inserted into the database.");
			} else {
				out.println("Error: No rows inserted.");
			}

			pre.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		}
		

}
