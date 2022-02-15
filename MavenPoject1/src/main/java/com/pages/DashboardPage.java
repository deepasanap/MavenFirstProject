package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	WebDriver Dpdriver;
	public UserPage up=null;
	public DashboardPage(WebDriver driver) {
	this.Dpdriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(tagName="h1")
	private WebElement header;
	
	@FindBy(xpath = "/html/body/div[1]/aside/section/ul/li[3]/a/span")
	private WebElement userBtn;
	
	
	public boolean verifyheader() {
		boolean b=header.isDisplayed();
		return b;
	}
	public UserPage clickUser() {
		userBtn.click();
		return new UserPage(Dpdriver);
		
	}

}