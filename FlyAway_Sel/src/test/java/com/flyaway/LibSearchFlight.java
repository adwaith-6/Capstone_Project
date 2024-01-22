package com.flyaway;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LibSearchFlight {
	
	WebDriver driver;
	
	public LibSearchFlight(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SearchFlight() {
		
//		String status = "PASS";
		String URL = "http://localhost:8080/FlyAway/home";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get(URL);
		
		WebElement source = driver.findElement(By.xpath("//select[@name='source']"));
		Select selectSource = new Select(source);
		
		selectSource.selectByValue("1");
		
		WebElement destination = driver.findElement(By.xpath("//select[@name='destination']"));
		Select selectDestination = new Select(destination);
		
		selectDestination.selectByValue("4");
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}

}
