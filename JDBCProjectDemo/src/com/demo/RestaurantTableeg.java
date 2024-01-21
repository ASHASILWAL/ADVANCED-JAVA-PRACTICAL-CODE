package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RestaurantTableeg {
	
	public static void main(String[] args)	throws Exception{

		String url = "jdbc:mysql://localhost:3306/hotel";
		String uname = "root";
		String pass = "@rootpassword123";
		String query = "INSERT INTO RESTAURANT(res_name,res_catagory) values('Sekuwa Corner','Fast Food') ";
		String query1 = "INSERT INTO RESTAURANT(res_name,res_catagory) values(?,?) ";
		String query2 = "SELECT * FROM RESTAURANT";
		
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
		
		
PreparedStatement st1 = con.prepareStatement(query1);
		
		st1.setString(1,"Thakali House");
		st1.setString(2,"Casual");
		int result1 = st1.executeUpdate();
		
		if(result1>0)
		{
			System.out.println("successfully inserted");
		}
		else{
			System.out.println("Insertion Failed");
		}
		
		Statement st2 = con.createStatement();
	ResultSet rs = st2.executeQuery(query2);
	while (rs.next()){
int res_id = rs.getInt("res_id");
String res_name = rs.getString("res_name");
	
	System.out.println(res_id+"  "+res_name);
	}
		st.close();
		con.close();
	}

}
