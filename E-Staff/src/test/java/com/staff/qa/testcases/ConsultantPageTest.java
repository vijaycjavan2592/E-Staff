package com.staff.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.staff.qa.base.TestBase;
import com.staff.qa.pages.CompaniesPage;
import com.staff.qa.pages.ConsultantPage;
import com.staff.qa.pages.HomePage;
import com.staff.qa.pages.LoginPage;
import com.staff.qa.util.TestUtil;

public class ConsultantPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ConsultantPage consultantPage;

	public ConsultantPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		consultantPage = new ConsultantPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		consultantPage = homePage.clickOnConsultantOption();
	}

	// @Test
	public void verifyUserNavigateToConsultantPage() throws InterruptedException {

		String TestCaseName = "Verify that user can navigate to the Consultant Page";
		test = extent.createTest(TestCaseName);

		Thread.sleep(2000);
		try {
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("consultant_page_url"));
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");

			testresultdata.put("11",
					new Object[] { 11d, TestCaseName, "User Should be navigate to the Consultant Page", "Pass" });
		} catch (Exception e) {
			testresultdata.put("11",
					new Object[] { 11d, TestCaseName, "User Should be navigate to the Consultant Page", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

//	@Test
	public void verifyAddNewConsulatantFormDisplayed() throws InterruptedException {
		String TestCaseName = "Verify Add New Button is Clickable and it Shows the Add New Consultant Form";
		test = extent.createTest(TestCaseName);
		// Thread.sleep(5000);
		try {
			// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,
			// TimeUnit.SECONDS);
			consultantPage.setClickAddNewMenu();
			Thread.sleep(1000);
			consultantPage.setClickAddManuallyOption();
			Thread.sleep(1000);
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("AddNew_Consultant_page_url"));
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");

			testresultdata.put("12", new Object[] { 12d, TestCaseName,
					"Add New Button Should be Clickable and It Should display the Add New Consultant Form", "Pass" });

		} catch (Exception e) {

			testresultdata.put("12", new Object[] { 12d, TestCaseName,
					"Add New Button Should be Clickable and It Should display the Add New Consultant Form", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test
	public void verifyFunctionalityofContinueButton() throws InterruptedException {
		String TestCaseName = "To Check the Continue Button By Entering the Information and Clicking on 'Continue' button";
		test = extent.createTest(TestCaseName);
		
		consultantPage.setClickAddNewMenu();
		Thread.sleep(1000);
		consultantPage.setClickAddManuallyOption();
		Thread.sleep(1000);
		consultantPage.fillAddNewConsultantForm("Vijay", "chavan", "vijay@gmail.com", "9373867668");
		consultantPage.setselectUOMRate("Monthly");
	
		Thread.sleep(1000);
		consultantPage.clickDateBox();
		consultantPage.selectAvailabilityDate("2019");
		Thread.sleep(2000);
		consultantPage.selectMonth("Oct");
		Thread.sleep(2000);
		consultantPage.setSelectDate("21");
		
		Thread.sleep(1000);
		consultantPage.setselectAvailabilityNotice("1-2 Weeks");
		
		Thread.sleep(1000);
		consultantPage.setselectCanRelocateTo("Bay Area Or North");
		
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		
		
	}
	
	
	
	

}
