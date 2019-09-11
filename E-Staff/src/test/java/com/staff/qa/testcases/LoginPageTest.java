package com.staff.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.staff.qa.base.TestBase;
import com.staff.qa.pages.HomePage;
import com.staff.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();		
		loginpage = new LoginPage();		
	}
	
	
	@Test
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		//Use assert
		System.out.println(title);
		Assert.assertEquals(title, "Xor E-Staff");
	}	
	
	@Test
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
