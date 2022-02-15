package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver lpdriver;
	public LoginPage(WebDriver driver) {
		this.lpdriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="email")
	private WebElement uname;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//button")
	private WebElement Loginbtn;
	
//	public WebElement getUname() {
//	return	lpdriver.findElement(By.id("email"));	
//	}
//	
//	public WebElement getPassword() {
//	
//	return lpdriver.findElement(By.id("password"));
//	}
//	public WebElement getLoginbtn() {
//	return lpdriver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
//	}


public void LoginApplication(String username, String pass) {
	uname.sendKeys(username);
	password.sendKeys(pass);
	Loginbtn.click();
}
public DashboardPage validLogin() {
	uname.sendKeys("kiran@gmail.com");
	password.sendKeys("123456");
	Loginbtn.click();
	return new DashboardPage(lpdriver);
}

}