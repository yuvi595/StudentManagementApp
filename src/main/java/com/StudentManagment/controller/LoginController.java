package com.StudentManagment.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagment.services.impl.LoginServiceImpl;
import com.StudentManagment.services.impl.SignupServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
		loginServiceImpl.login(req, res);
		
		
	};
}
