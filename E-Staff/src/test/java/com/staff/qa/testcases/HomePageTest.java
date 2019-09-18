package com.staff.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
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
	public void logoutTest() throws InterruptedException {
		test = extent.createTest("Verify the application logout functionality Test");
		
		homePage.logout();	
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("login_page_url"));
		test.log(Status.PASS, "Validation of Logout functionality sucessfully");
	}
	
	@Test
	public void verifyUserNameLableTest() {
		test = extent.createTest("verify the User-Name Lable once logged-in");
		homePage.verifyCorrectUserName();		
	}
	
	


}
