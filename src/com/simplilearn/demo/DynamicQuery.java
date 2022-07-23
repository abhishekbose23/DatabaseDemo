package com.simplilearn.demo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DynamicQuery {
	public static void main (String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/ecommerce";
		String username="root";
		String password="Abhishek@23997";
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter the Laptop name");
		String name=sc.nextLine();
		System.out.print("Enter price");
		BigDecimal price=sc.nextBigDecimal();
		
		//load the driver
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, username, password);
			if(conn!=null) 
			{
				System.out.println("Connection established in database");
				String query= "insert into eproduct(name,price)values(?,?)";
				PreparedStatement st=conn.prepareStatement(query);
				st.setString(1, name);
				st.setBigDecimal(2, price);
				int x=st.executeUpdate();
				
				if(x>0) {
					System.out.println("Data is updated in the query");
				}
				else 
				{
					System.out.println("Data not updated in the query");
				}
			}
			else {
				System.out.println("Connection not estsblished in database");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}
