package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	WebDriver Updriver;
	
	public UserPage(WebDriver driver) {
		this.Updriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
