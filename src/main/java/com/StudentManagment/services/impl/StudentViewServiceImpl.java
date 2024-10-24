package com.StudentManagment.services.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.StudentManagment.service.StudentViewService;
import com.StudentManagment.utils.CJdbc;
import com.model.Student;
import com.model.User;
import com.mysql.cj.xdevapi.PreparableStatement;

public class StudentViewServiceImpl implements StudentViewService {
	@Override
	public void studentview(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	    List<Student> students = new ArrayList<>();
	    try {
	        CJdbc.jdbc();
//	        String query = "SELECT * FROM student_info;";
	        PreparedStatement pre = CJdbc.con.prepareStatement("SELECT * FROM student_info;");
	        ResultSet rs = pre.executeQuery();

	        
	        // Iterate over the result set and populate the list
	        while (rs.next()) {
	            Student student = new Student();
	            student.setId(rs.getInt("Sid"));
	            student.setName(rs.getString("Sname"));
	            student.setDOB(rs.getString("Dob"));
	            student.setPhone(rs.getString("phone"));
	            student.setEmail(rs.getString("email"));
	            student.setAddress(rs.getString("address"));
	            student.setDept(rs.getString("dept"));
	            student.setPassout(rs.getString("passout_year"));
	            student.setCreatorid(rs.getInt("creator_id"));

	            students.add(student);  // Add student to the list
	            System.out.println("Student added: " + student.getName());
	            
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    System.out.println("Total students found: " + students.size());
	    // Set the students list as a request attribute
	    req.setAttribute("students", students);

	    // Forward the request to the JSP page
	    req.getRequestDispatcher("StudentView.jsp").forward(req, res);
	}


}
