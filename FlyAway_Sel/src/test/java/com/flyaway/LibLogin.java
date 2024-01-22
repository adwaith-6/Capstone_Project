package com.flyaway;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibLogin {
	
	WebDriver driver;
	
	public LibLogin(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public String Login(String email, String pwd) {
		
		String status = "PASS";
		String URL = "http://localhost:8080/FlyAway/login";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@name='email_id']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button")).click();
		
		try {
			driver.findElement(By.xpath("//a[text()='Logout']"));
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			status = "FAIL";
		}
		
		return status;
	}


}
