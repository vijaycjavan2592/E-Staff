package com.staff.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.staff.qa.base.TestBase;
import com.staff.qa.pages.HomePage;
import com.staff.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();	
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void logoutTest() {
		test = extent.createTest("Verify the application logout functionality Test");
		
		homePage.logout();		
	}
	
	@Test
	public void verifyUserNameLableTest() {
		test = extent.createTest("verify the User-Name Lable once logged-in");
		homePage.verifyCorrectUserName();
	}
	
	


}
