package com.flyaway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LibBookFlight {

	WebDriver driver;
	
	public LibBookFlight(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	
	public void BookFlight(String source, String destination) {
		
		driver.findElement(By.linkText("Book Flight")).click();
		driver.findElement(By.linkText("Click to complete booking")).click();
		//System.out.println("Booking Done!");	
	}
	

	
}
