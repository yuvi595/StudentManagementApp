package com.StudentManagment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagment.services.impl.StudentViewServiceImpl;

@WebServlet("/studentview")
public class StudentViewController extends HttpServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Call the service implementation to fetch student data
        StudentViewServiceImpl studentViewServiceImpl = new StudentViewServiceImpl();
        studentViewServiceImpl.studentview(req, res);
        
    }
}

