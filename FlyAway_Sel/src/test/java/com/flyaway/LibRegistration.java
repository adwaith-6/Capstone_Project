package com.flyaway;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibRegistration {
	
	WebDriver driver;
	
	public LibRegistration(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public void Registration(String email, String pwd, String confirm_pwd, String name, String address, String city) {
		
		String URL = "http://localhost:8080/FlyAway/signup";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@name='email_id']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='pwd2']")).sendKeys(confirm_pwd);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//a[text()='Login to continue checking flights']"));
		

		
	}
	


}
