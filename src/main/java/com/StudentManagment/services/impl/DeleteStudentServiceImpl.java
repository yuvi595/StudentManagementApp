package com.StudentManagment.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagment.service.DeleteStudentService;
import com.StudentManagment.utils.CJdbc;
import com.mysql.cj.xdevapi.PreparableStatement;

public class DeleteStudentServiceImpl implements DeleteStudentService {
		
	
		public void delete(HttpServletRequest req, HttpServletResponse res) {
			System.out.println(req.getParameter("id"));


			try {
				CJdbc.jdbc(); // Ensure the connection is established
				String insertQuery = "DELETE FROM student_info WHERE Sid=?;";
				PreparedStatement pre =  CJdbc.con.prepareStatement(insertQuery);
				PrintWriter out = res.getWriter();
				int id = Integer.parseInt(req.getParameter("id"));
				pre.setInt(1, id);
				int rowsAffected = pre.executeUpdate();
				if (rowsAffected > 0) {
					res.sendRedirect("dashboard.html");
				} else {
					out.println("<h2>Error: No rows deleted. The record might not exist.</h2>");
				}
				pre.close();
				
			} catch (Exception e) {
				System.out.println(e);
			}


		}


	}







