package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteEg {

	public static void main(String[] args)	throws Exception{

		String url = "jdbc:mysql://localhost:3306/students";
		String uname = "root";
		String pass = "@rootpassword123";
		String query = "DELETE  FROM STUDENT where name='Rita'";
//		String query1 = "SELECT * FROM STUDENT";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		int  result = st.executeUpdate(query);
		
		if(result>0)
		{
			System.out.println("successfully deleted");
		}
		else{
			System.out.println("Deletion Failed");
		}
//		Statement st1 = con.createStatement();
//	ResultSet rs = st1.executeQuery(query1);
//	rs.next();
//String name = rs.getString("name");
//	
//	System.out.println(name);
		
		st.close();
		con.close();
	}
	
}
