package com.staff.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.staff.qa.base.TestBase;

public class LoginPage extends TestBase {
	

	public LoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='btn btn-primary login-button']")
	WebElement loginBtn;
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public HomePage login(String un , String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
