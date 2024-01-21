package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class InsertEg {
	
	public static void main(String[] args)	throws Exception{

		String url = "jdbc:mysql://localhost:3306/students";
		String uname = "root";
		String pass = "@rootpassword123";
		String query = "INSERT INTO STUDENT(id,name) values(3,'Hari') ";
		String query1 = "SELECT * FROM STUDENT";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		
		int  result = st.executeUpdate(query);
		
		if(result>0)
		{
			System.out.println("successfully inserted");
		}
		else{
			System.out.println("Insertion Failed");
		}
		Statement st1 = con.createStatement();
	ResultSet rs = st1.executeQuery(query1);
	rs.next();
int id = rs.getInt("id");
String name = rs.getString("name");
	
	System.out.println(id+" "+name);
		
		st.close();
		con.close();
	}

}
