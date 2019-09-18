package com.staff.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
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
		test.log(Status.PASS, "Validation of Login page tile suscessfully");

	}	
	
//	@Test
	public void loginTest() throws InterruptedException {
		test = extent.createTest("To Check The Login Functionality with Valid Username and Valid Password");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		test.log(Status.PASS, "Entered username is : "+ prop.getProperty("username") +" and Password is : "+ prop.getProperty("password"));

		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("landing_page_url"));
		test.log(Status.PASS, "Validation of Login functionality for valid Username or Passwords is sucessfully");
	}
	
	
	@DataProvider
	public Object[][] getEStaffData() throws IOException {
		
		Object data[][] = TestUtil.getData(sheetName);
		
		return data;
	}
	
	
//	@Test(dataProvider = "getEStaffData")
	public void validateLoginFunctionality(String username, String password) throws InterruptedException, IOException {
		test = extent.createTest("Verify the Login functionality for incorrect Username or Passwords");
		
		//TestUtil.addResult("Verify the Login functionality for incorrect Username or Passwords"+username+" "+password+" ");
		loginpage.login(username, password);
		test.log(Status.PASS, "Entered username is : "+username +" and Password is : "+password);		
		//TestUtil.writeDataInExcel(username, password);
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("login_page_url"));
		test.log(Status.PASS, "Validation of Login functionality for incorrect Username or Passwords is sucessfully");	
		
	}
	
	
//	@Test
	public void validateUsernameMessageForBalankUsername() throws InterruptedException {
		
		String abc = "To Check The Login Functionality with Blank Username and Valid Password";
		test = extent.createTest("To Check The Login Functionality with Blank Username and Valid Password");
		homepage = loginpage.login(prop.getProperty("username_Blank"), prop.getProperty("password"));
		test.log(Status.PASS, "Entered username is : "+ prop.getProperty("username_Blank") +" and Password is : "+ prop.getProperty("password"));

		Thread.sleep(2000);		
		Assert.assertEquals(loginpage.userNameValidationMessage(),"Username is required.");
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("login_page_url"));
		test.log(Status.PASS, "Validation message appear : "+loginpage.userNameValidationMessage());
		
		//TestUtil.getResults(abc, ITestResult.SUCCESS);
			
	}
	
	
//	@Test
	public void validateUsernameMessageForIncorrectUsername() throws InterruptedException {
		String abc = "fhjjgwejg";
		test = extent.createTest("To Check The Login Functionality with Incorrect Username and Valid Password");
		homepage = loginpage.login(prop.getProperty("username_incorrect"), prop.getProperty("password"));
		test.log(Status.PASS, "Entered username is : "+ prop.getProperty("username_incorrect") +" and Password is : "+ prop.getProperty("password"));

		Thread.sleep(2000);
		Assert.assertEquals(loginpage.userNameValidationMessage(),"Username should be in the format XOR-IND\\ or XOR-US\\ followed by username");
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("login_page_url"));
		test.log(Status.PASS, "Validation message appear : "+loginpage.userNameValidationMessage());
		TestUtil.getResults(abc, ITestResult.SUCCESS);
	}
	
	
	@Test
	public void validatePasswordMessageForBlankPassword() throws InterruptedException {
		test = extent.createTest("To Check The Login Functionality with Valid Username and Blank Password");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password_blank"));
		test.log(Status.PASS, "Entered username is : " + prop.getProperty("username") + " and Password is : "
				+ prop.getProperty("password_blank"));

		Thread.sleep(2000);
		try {
		Assert.assertEquals(loginpage.passwordValidationMessage(), "Password is required.");
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("login_page_url"));
		test.log(Status.PASS, "Validation message appear : " + loginpage.passwordValidationMessage());
		
		testresultdata.put("2", new Object[] { 2d, "Login Functionality with Valid Username and Blank Password",
				"Logout successfull", "Pass" });
	}
	catch(AssertionError  e)
	{
		testresultdata.put("2", new Object[] { 2d, "Login Functionality with Valid Username and Blank Password",
				"Logout successfull", "Fail" });
		e.printStackTrace();
		Assert.fail();
	}
	}

	
	@Test
	public void validatePasswordMessageForIncorrectPassword() throws InterruptedException {
		test = extent.createTest("To Check The Login Functionality with Valid Username and Incorrect Password");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password_incorrect"));
		test.log(Status.PASS, "Entered username is : "+ prop.getProperty("username") +" and Password is : "+ prop.getProperty("password_incorrect"));

		Thread.sleep(2000);
		try {
		//Assert.assertEquals(loginpage.passwordValidationMessage(),"Password is required.");
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("login_page_url"));
		test.log(Status.PASS, "Validation message appear : "+loginpage.passwordValidationMessage());	
		
		testresultdata.put("3", new Object[] {3d, "Login Functionality with Valid Username and Incorrect Password", "Logout successfull","Pass"});
		
	}
	catch(AssertionError  e) {
		testresultdata.put("3", new Object[] {3d, "Login Functionality with Valid Username and Incorrect Password", "Logout successfull","Fail"});
		e.printStackTrace();
	    Assert.fail();
	}
	}

	
	@Test
	public void validateLoginFunctionality() throws InterruptedException {
		test = extent.createTest("To Check The Login Functionality with Incorrect Username and Incorrect Password");
		homepage = loginpage.login(prop.getProperty("username_incorrect"), prop.getProperty("password_incorrect"));
		test.log(Status.PASS, "Entered username is : "+ prop.getProperty("username_incorrect") +" and Password is : "+ prop.getProperty("password_incorrect"));

		Thread.sleep(2000);
		try {		
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("login_page_url"));
		test.log(Status.PASS, "Validation message appear : "+loginpage.userNameValidationMessage()+"   "+loginpage.passwordValidationMessage());
		testresultdata.put("4", new Object[] {4d, "Login Functionality with Incorrect Username and Incorrect Password", "Logout successfull","Pass"});
	
		}
		catch(AssertionError  e) {
			testresultdata.put("4", new Object[] {4d, "Login Functionality with Incorrect Username and Incorrect Password", "Logout successfull","Fail"});
			e.printStackTrace();
		    Assert.fail();
			
		}
		
		}
}
