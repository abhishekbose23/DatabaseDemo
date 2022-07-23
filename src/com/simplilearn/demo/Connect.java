package com.simplilearn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
	public static void main (String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/ecommerce";
		String username="root";
		String password="Abhishek@23997";
		
		
		try {
			//load the driver
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, username, password);
			if(conn!=null) 
			{
				System.out.println("Connection established in database");
				Statement st=conn.createStatement();
				int x=st.executeUpdate("insert into eproduct(name, price) values ('LENOVO ThinkPad ABC',67000)");
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
