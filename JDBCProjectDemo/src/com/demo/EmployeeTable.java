package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class EmployeeTable {
	
	public static void main(String[] args)	throws Exception{

	String url = "jdbc:mysql://localhost:3306/employee";
	String uname = "root";
	String pass = "@rootpassword123";
	String query = "SELECT name FROM EMPLOYEE where id=1 ";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,uname,pass);
	
	Statement st = con.createStatement();
	
	ResultSet rs = st.executeQuery(query);
	
	rs.next();
	
	
	String name = rs.getString("name");
	
	System.out.println(name);
	
	st.close();
	con.close();
}
	
}
