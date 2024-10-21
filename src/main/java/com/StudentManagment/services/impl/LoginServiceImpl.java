package com.StudentManagment.services.impl;

import java.io.PrintWriter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;

import com.StudentManagment.service.LoginService;
import com.StudentManagment.utils.CJdbc;

public class LoginServiceImpl implements LoginService {

	@Override
	public void login(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		System.out.println("Service code");
		System.out.println("Username");
		System.out.println(req.getParameter("password"));

		try {
			CJdbc.jdbc(); // Ensure the connection is established
			String insertQuery = "select * from user_info where userName = ? and password= ?;";
			PreparedStatement pre = CJdbc.con.prepareStatement(insertQuery);
			PrintWriter out = res.getWriter();
			
			String userName = req.getParameter("userName");
			String password = req.getParameter("password");
			
			System.out.println(userName);
			System.out.println(password);
			
			pre.setString(1, userName);
			pre.setString(2, password);
			
			ResultSet resultSet = pre.executeQuery();
			if (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
//				System.out.println(user.getId());
				user.setUser(resultSet.getString("userName"));
				
				res.sendRedirect("dashboard.html");
				out.println("logged in success");
			} else {
				out.println("logged in failed");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
