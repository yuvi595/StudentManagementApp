package com.StudentManagment.services.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagment.service.EditStudentService;
import com.StudentManagment.utils.CJdbc;
import com.model.Student;



public class EditStudentServiceImpl implements EditStudentService {

    // Retrieve student details by ID
    public Student getStudentById(int studentId) {
        Student student = null;
        try {
            CJdbc.jdbc();
            String sql = "SELECT * FROM student_info WHERE Sid = ?";
            PreparedStatement ps = CJdbc.con.prepareStatement(sql);
            ps.setInt(1, studentId);
            System.out.println(studentId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("Sid"));
	            student.setName(rs.getString("Sname"));
	            student.setDOB(rs.getString("Dob"));
	            student.setPhone(rs.getString("phone"));
	            student.setEmail(rs.getString("email"));
	            student.setAddress(rs.getString("address"));
	            student.setDept(rs.getString("dept"));
	            student.setPassout(rs.getString("passout_year"));
//	            student.setCreatorid(rs.getInt("creator_id"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    // Update student details
    public void updateStudent(HttpServletRequest req) {
    	try {
            CJdbc.jdbc();
            String sql = "UPDATE student_info SET Sname = ?, Dob = ?, phone = ?, email = ?, address = ?, dept = ?, passout_year = ? WHERE Sid = ?";
            PreparedStatement ps = CJdbc.con.prepareStatement(sql);

            // Set parameters and log each one for debugging
            ps.setString(1, req.getParameter("name"));
//            ps.setString(1, Student.);
            ps.setString(2, req.getParameter("dob"));
            ps.setString(3, req.getParameter("phone"));
            ps.setString(4, req.getParameter("email"));
            ps.setString(5, req.getParameter("address"));
            ps.setString(6, req.getParameter("dept"));
            ps.setString(7, req.getParameter("passout"));
            ps.setInt(8, Integer.parseInt(req.getParameter("id")));

            System.out.println("Updating student with ID: " + req.getParameter("id"));
            System.out.println("Name: " + req.getParameter("name"));
            System.out.println("DOB: " + req.getParameter("dob"));
            // Print the other parameters similarly

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student record updated successfully.");
            } else {
                System.out.println("No student record found with the provided ID.");
            }

            // Commit the changes if auto-commit is disabled
            CJdbc.con.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
