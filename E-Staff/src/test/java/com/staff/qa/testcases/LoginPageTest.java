package com.staff.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.staff.qa.base.TestBase;
import com.staff.qa.pages.HomePage;
import com.staff.qa.pages.LoginPage;
import com.staff.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;

	
	String sheetName = "LoginData";
	
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();		
		loginpage = new LoginPage();		
	}
	
	
//	@Test
	public void loginPageTitleTest() {
		test = extent.createTest("Verify the login Page Title Test");
		String title = loginpage.validateLoginPageTitle();
		//Use assert
		System.out.println(title);
		Assert.assertEquals(title, "Xor E-Staff");
	}	
	
	@Test
	public void loginTest() {
		test = extent.createTest("Verify the Login functionality with correct username and password");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@DataProvider
	public Object[][] getEStaffData() throws IOException {
		
		Object data[][] = TestUtil.getData(sheetName);
		
		return data;
	}
	
	
//	@Test(dataProvider = "getEStaffData")
	public void validateLoginFunctionality(String username, String password) throws InterruptedException {
		test = extent.createTest("Verify the Login functionality with all possibility");
		
		loginpage.login(username, password);
		
		Thread.sleep(2000);
	}
	
	

}
