package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login2 {
	@Test
		
	public void verifyDashboard() {
	System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("ofile:///F:/OJT/sel%20sftware/selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");	
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	String text=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[3]/label")).getText();
	Assert.assertEquals(text, "Email");
			
			
			
		}
	}
	

