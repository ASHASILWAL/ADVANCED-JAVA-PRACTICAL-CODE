package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedStatementEg {

	public static void main(String[] args)	throws Exception{

		String url = "jdbc:mysql://localhost:3306/students";
		String uname = "root";
		String pass = "@rootpassword123";
		String query = "INSERT INTO STUDENT(name) values(?) ";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		PreparedStatement st = con.prepareStatement(query);
		
		st.setString(1, "Hari");
		
		int result = st.executeUpdate();
		
		if(result>0)
		{
			System.out.println("successfully inserted");
		}
		else{
			System.out.println("Insertion Failed");
		}
		
		st.close();
		con.close();
	}
	
}
