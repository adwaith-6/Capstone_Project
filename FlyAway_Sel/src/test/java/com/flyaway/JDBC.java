package com.flyaway;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;




public class JDBC {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String URL = "jdbc:mysql://localhost:3306/flyaway";
		String UN  = "root";
		String PWD = "";
		
		String qry = "select * from f_user";
		
		
		try {
			java.sql.Connection conn = DriverManager.getConnection(URL, UN, PWD);
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(qry);
			while (rs.next()) {
				
				System.out.println(rs.getString(1));
				
			}
			
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
