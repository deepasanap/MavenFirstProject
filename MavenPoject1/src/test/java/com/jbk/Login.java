package com.jbk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.UserPage;

public class Login {
	public WebDriver driver;
	public LoginPage lp=null;
	public DashboardPage dp=null;
	public UserPage up=null;
	@BeforeSuite
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.get("file:///F:/OJT/sel%20software/selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	}
	@Test
		
	public void verifyDPHeader() {
	
	 lp=new LoginPage(driver);
	 dp=lp.validLogin();
	 boolean b=dp.verifyheader();
	 Assert.assertTrue(b);
	 System.out.println("pass");
	}
	
	@Test
	
	public void verifyUserPage() {
	
		 lp=new LoginPage(driver);
		up= dp.clickUser();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
		
	}
}
	
	
	
//	lp.LoginApplication("kiran@gmail.com","123456");
//	
//	String actual=driver.getTitle();
//	Assert.assertEquals(actual, "JavaByKiran | Dashboard");
			
			
			
		
	
	

