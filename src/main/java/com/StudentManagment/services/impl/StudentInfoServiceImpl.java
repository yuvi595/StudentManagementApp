package com.StudentManagment.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.StudentManagment.service.StudentInfoService;
import com.StudentManagment.utils.CJdbc;
import com.model.Student;
import com.model.User;

public class StudentInfoServiceImpl implements StudentInfoService {
	@Override
	public void studentinfo(HttpServletRequest req, HttpServletResponse res) {
		
	

	try {
		CJdbc.jdbc();
		String insertQuery = ("insert into student_info (Sname,Dob,phone,email,address,dept,passout_year,creator_id) values(? ,?, ?, ?, ?, ?, ?,?);");
		PreparedStatement pre = CJdbc.con.prepareStatement(insertQuery);
		
		PrintWriter out = res.getWriter();
		
		Student student = new Student();
		student.setName(req.getParameter("Sname"));
		student.setDOB(req.getParameter("DOB"));
		student.setPhone(req.getParameter("PhoneNo"));
		student.setEmail(req.getParameter("email"));
		student.setAddress(req.getParameter("address"));
		student.setDept(req.getParameter("deptment"));
		student.setPassout(req.getParameter("passout_year"));
		
		HttpSession session = req.getSession();
		int id= (int) session.getAttribute("userid");
		System.out.println(id);
//		
//		String Sname = req.getParameter("Sname");
//		String DOB = req.getParameter("DOB");
//		String PhoneNo = req.getParameter("PhoneNo");
//		String Email = req.getParameter("email");
//		String Address = req.getParameter("address");
//		String Deptment = req.getParameter("deptment");
//		String Passout_year = req.getParameter("passout_year");
//		
//		
//		System.out.println(Sname);
//		System.out.println(DOB);
//		System.out.println(PhoneNo);
//		System.out.println(Email);
//		System.out.println(Address);
//		System.out.println(Deptment);
//		System.out.println(Passout_year);
		
		pre.setString(1, student.getName());
		pre.setString(2, student.getDOB());
		pre.setString(3, student.getPhone());
		pre.setString(4, student.getEmail());
		pre.setString(5, student.getAddress());
		pre.setString(6, student.getDept());
		pre.setString(7, student.getPassout());
		pre.setInt(8, id);
		
		int rowsAffected = pre.executeUpdate();
		if (rowsAffected > 0) {
//			res.sendRedirect("dashboard.html");
			out.println("Success: Data successfully inserted into the database.");
			System.out.println("Successfully inserted the student data");
		} else {
			out.println("Error: No rows inserted.");
			System.out.println("Failed to insert the students data");
		}
	}catch (Exception e) {
		System.out.println(e);
	}

}

}
