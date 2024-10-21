package com.StudentManagment.controller;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagment.services.impl.StudentInfoServiceImpl;
import com.StudentManagment.utils.CJdbc;
import com.mysql.cj.xdevapi.PreparableStatement;

@WebServlet("/studentinfo")
public class StudentInfoController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		StudentInfoServiceImpl studentInfoServiceImpl = new StudentInfoServiceImpl();
		studentInfoServiceImpl.studentinfo(req, res);
	

};
}