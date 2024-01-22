package com.flyaway;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFlyAway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String email = "peter1@email.com";
		String name = "Peter1";
		String address = "Queens";
		String city = "New York";
		String pwd = "peter";
		String confirm_pwd = "peter";
		
		WebDriver driver = new ChromeDriver();

		LibRegistration reg = new LibRegistration(driver);
		reg.Registration(email, pwd, confirm_pwd, name, address, city);
		LibLogin log = new LibLogin(driver);
		log.Login(email, pwd);
		
		LibSearchFlight search = new LibSearchFlight(driver);
		search.SearchFlight();
		
		LibBookFlight book = new LibBookFlight(driver);
		book.BookFlight("Banglore", "Chennai");
		
		String URL = "jdbc:mysql://localhost:3306/flyaway";
		String UN  = "root";
		String PWD = "";
		
		String qry = "select * from f_user where email=\"" + email + "\"";
		
		
		try {
			java.sql.Connection conn = DriverManager.getConnection(URL, UN, PWD);
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(qry);
			while (rs.next()) {
				if(rs.getString(2).equals(name)) {
					System.out.println("Name in database is same as User input");
				}
				if(rs.getString(3).equals(email)) {
					System.out.println("Email in database is same as User input");
				}
				if(rs.getString(5).equals(address)) {
					System.out.println("Address in database is same as User input");
				}
				if(rs.getString(6).equals(city)) {
					System.out.println("City in database is same as User input");
				}
				if(rs.getString(7).equals(pwd)) {
					System.out.println("Password in database is same as User input");
				}
			}
			
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
