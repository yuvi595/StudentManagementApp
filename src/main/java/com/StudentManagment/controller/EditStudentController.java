package com.StudentManagment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagment.services.impl.DeleteStudentServiceImpl;
import com.StudentManagment.services.impl.EditStudentServiceImpl;
import com.model.Student;

@WebServlet("/edit")
public class EditStudentController extends HttpServlet {
	private EditStudentServiceImpl editService = new EditStudentServiceImpl();

    // Handle GET request to load student details
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("id"));
   
//        System.out.println("Editing student with ID: " + id);
        Student student = editService.getStudentById(studentId);

        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Studentedit.jsp");
        dispatcher.forward(req, res);
    }

    // Handle POST request to update student details
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        editService.updateStudent(req);
        res.sendRedirect(req.getContextPath() + "/studentview"); // Redirect back to the student list after updating
    }
		
	}


