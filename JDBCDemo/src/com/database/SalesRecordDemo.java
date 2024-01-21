package com.database;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class SalesRecordDemo {

		public static void main(String[] args) throws Exception{

			String url = "jdbc:mysql://localhost:3306/SalesRecord";
			String uname = "root";
			String pass = "";
			String query = "SELECT * FROM ProductSale where Discount > ?";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			PreparedStatement st = con.prepareStatement(query);
			
			st.setInt(1, 10);
			  
			ResultSet rs = st.executeQuery();
			
		    while (rs.next()) {
		        int productId = rs.getInt("Prod_Id");
		        String productName = rs.getString("Prod_Name");
		        String productCategory = rs.getString("Prod_Cat");
		        double productPrice = rs.getDouble("Prod_Price");
		        double discount = rs.getDouble("Discount");

		        System.out.println("Product ID: " + productId);
		        System.out.println("Product Name: " + productName);
		        System.out.println("Product Category: " + productCategory);
		        System.out.println("Price: " + productPrice);
		        System.out.println("Discount: " + discount);
		        System.out.println();
		    }
			
			st.close();
			con.close();
		}
		
	}
