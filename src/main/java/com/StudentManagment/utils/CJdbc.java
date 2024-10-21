package com.StudentManagment.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CJdbc {
	
	
	public static Connection con;
	public static void jdbc() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagement","root","yuvi@2003");
	}

}
