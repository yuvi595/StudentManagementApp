package com.StudentManagment.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagment.services.impl.SignupServiceImpl;
import com.StudentManagment.utils.CJdbc;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
	

			SignupServiceImpl signupServiceImpl = new SignupServiceImpl();
			signupServiceImpl.signup(req, res);

	};
}
