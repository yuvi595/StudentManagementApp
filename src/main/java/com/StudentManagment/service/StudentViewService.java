package com.StudentManagment.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface StudentViewService {
	public void studentview(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
