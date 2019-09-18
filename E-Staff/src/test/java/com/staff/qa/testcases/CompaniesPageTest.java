package com.staff.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.staff.qa.base.TestBase;
import com.staff.qa.pages.CompaniesPage;
import com.staff.qa.pages.HomePage;
import com.staff.qa.pages.LoginPage;
import com.staff.qa.util.TestUtil;

public class CompaniesPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	CompaniesPage companiesPage;
	
	public CompaniesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		companiesPage = new CompaniesPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		companiesPage = homePage.clickOnCompaniesOption();
	}
	
	@Test
	public void CompaniesPageURLTest() throws InterruptedException {
		test = extent.createTest("Verify the URL of Companies-Page");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleIs("Xor E-Staff"));
		
		Thread.sleep(2000);
		String URL = companiesPage.validateCompaniesPageURL();
		//System.out.println("URL is : "+URL);
		Assert.assertEquals(companiesPage.validateCompaniesPageURL(), prop.getProperty("companies_page_url"));		
		test.log(Status.PASS, "Validation of Companies-page URl is successful");
	}
	
	
	

}
