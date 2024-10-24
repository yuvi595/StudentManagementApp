package com.StudentManagment.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManagment.services.impl.DeleteStudentServiceImpl;

@WebServlet("/delete")
public class DeleteStudentController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		String idp = req.getParameter("Sid");
		System.out.println(idp);
		DeleteStudentServiceImpl service = new DeleteStudentServiceImpl();
		service.delete(req, res);

		
	}
	

}
