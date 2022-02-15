package com.Exel;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class ExelWithDp {
	WebDriver driver=null;
  @Test(dataProvider = "getLoginData")
  public void test01(String username, String password) {
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///F:/OJT/sel%20software/selenium/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button")).click();
		
	  
  }

  @DataProvider
  public Object[][] getLoginData() throws Exception {
	  ReadEx2forDPEx r=new ReadEx2forDPEx();
	    return  r.Read("Demo1.xlsx", "login");
  }
}
