package com.StudentManagment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;


public interface EditStudentService {
    Student getStudentById(int studentId);
    void updateStudent(HttpServletRequest req);
}
