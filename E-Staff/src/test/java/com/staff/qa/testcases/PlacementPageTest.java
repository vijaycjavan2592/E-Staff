package com.staff.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.staff.qa.base.TestBase;
import com.staff.qa.pages.ConsultantPage;
import com.staff.qa.pages.HomePage;
import com.staff.qa.pages.LoginPage;
import com.staff.qa.pages.PlacementPage;
import com.staff.qa.pages.RequirementPage;

public class PlacementPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PlacementPage placementPage;
	RequirementPage requirementPage;

	public PlacementPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		placementPage = new PlacementPage();
		requirementPage = new RequirementPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		placementPage = homePage.clickOnPlacementOption();
	}

//	@Test(priority = 1)
	public void verifyUserNavigateToConsultantPage() throws InterruptedException {

		String TestCaseName = "Verify that user can navigate to the Palcement Page";
		test = extent.createTest(TestCaseName);

		Thread.sleep(2000);
		try {
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("placement_page_url"));
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");

			testresultdata.put("1",
					new Object[] { 1d, TestCaseName, "User Should be navigate to the Placement Page", "Pass" });
		} catch (Exception e) {
			testresultdata.put("1",
					new Object[] { 1d, TestCaseName, "User Should be navigate to the Placement Page", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

//	@Test(priority = 2)
	public void VerifyAllPlacementCountInHeaderAndGrid() throws InterruptedException {

		String TestCaseName = "Verify the Open Placement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			Thread.sleep(10000);
			placementPage.setTotalPlacementLabel();
			Assert.assertEquals(placementPage.setTotalPlacementLabel(),
					"All Placements (" + placementPage.setAllPlacementCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("2", new Object[] { 2d, TestCaseName,
					" Open Placement count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("2", new Object[] { 2d, TestCaseName,
					" Open Placement count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test(priority = 3)
	public void VerifyOpenPlacementCountInHeaderAndGrid() throws InterruptedException {

		String TestCaseName = "Verify the Open Placement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			placementPage.setClickOnOpenTag_Placement();
			Thread.sleep(10000);
			placementPage.setTotalPlacementLabel();
			Assert.assertEquals(placementPage.setTotalPlacementLabel(),
					"Open Placements (" + placementPage.setAllPlacementCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("3", new Object[] { 3d, TestCaseName,
					" Open Placement count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("3", new Object[] { 3d, TestCaseName,
					" Open Placement count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test(priority = 4)
	public void VerifyPendingApprovalPlacementCountInHeaderAndGrid() throws InterruptedException {

		String TestCaseName = "Verify the Pending Approved Placement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			Thread.sleep(10000);
			placementPage.setClickOnPendingApprovedTag_Placement();
			Thread.sleep(10000);
			placementPage.setTotalPlacementLabel();
			Assert.assertEquals(placementPage.setTotalPlacementLabel(),
					"Pending Approval Placements (" + placementPage.setAllPlacementCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("4", new Object[] { 4d, TestCaseName,
					" Pending Approved Placement count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("4", new Object[] { 4d, TestCaseName,
					" Pending Approved Placement count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test(priority = 5)
	public void VerifyApprovedPlacementCountInHeaderAndGrid() throws InterruptedException {

		String TestCaseName = "Verify the Approved Placement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			Thread.sleep(10000);
			placementPage.setClickOnApprovedTag_Placement();
			Thread.sleep(10000);
			placementPage.setTotalPlacementLabel();
			Assert.assertEquals(placementPage.setTotalPlacementLabel(),
					"Approved Placements (" + placementPage.setAllPlacementCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("5", new Object[] { 5d, TestCaseName,
					" Approved Placement count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("5", new Object[] { 5d, TestCaseName,
					" Approved Placement count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test(priority = 6)
	public void VerifyCandidateOnBillingPlacementCountInHeaderAndGrid() throws InterruptedException {

		String TestCaseName = "Verify the Candidate On Billing Placement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			Thread.sleep(10000);
			placementPage.setClickOnCandidateOnBillingTag_Placement();
			Thread.sleep(10000);
			placementPage.setTotalPlacementLabel();
			Assert.assertEquals(placementPage.setTotalPlacementLabel(),
					"Candidate On Billing Placements (" + placementPage.setAllPlacementCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("6", new Object[] { 6d, TestCaseName,
					" Candidate On Billing Placement count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("6", new Object[] { 6d, TestCaseName,
					" Candidate On Billing Placement count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	
//	@Test(priority = 7)
	public void VerifyBackedOutPlacementCountInHeaderAndGrid() throws InterruptedException {

		String TestCaseName = "Verify the Backed Out Placement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			Thread.sleep(10000);
			placementPage.setClickOnBackedOutTag_Placement();
			Thread.sleep(10000);
			placementPage.setTotalPlacementLabel();
			Assert.assertEquals(placementPage.setTotalPlacementLabel(),
					"Backed Out Placements (" + placementPage.setAllPlacementCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("7", new Object[] { 7d, TestCaseName,
					" BackedOut Placement count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("7", new Object[] { 7d, TestCaseName,
					" BackedOut Placement count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

//	@Test(priority = 8)
	public void VerifyCandidateEndedPlacementCountInHeaderAndGrid() throws InterruptedException {

		String TestCaseName = "Verify the Candidate Ended Placement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			Thread.sleep(10000);
			//Click on Candidate Ended Tag
			placementPage.setClickOnCandidateEndedTag_Placement();
			Thread.sleep(10000);
			placementPage.setTotalPlacementLabel();
			Assert.assertEquals(placementPage.setTotalPlacementLabel(),
					"Candidate Ended Placements (" + placementPage.setAllPlacementCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("8", new Object[] { 8d, TestCaseName,
					" CandidateEnded Placement count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("8", new Object[] { 8d, TestCaseName,
					" CandidateEnded Placement count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void verifyPlacedConsultantAppearInPlacement_FromRequirement() throws InterruptedException {
		
		String testCaseName = "Verify";
		test = extent.createTest(testCaseName);
		
		String searchRequirement = "Req-264609-6";     //RequirementPageTest.requirementId;
		
		try {	
		homePage.clickOnRequirementOption();
		Thread.sleep(5000);
		requirementPage.setSearchTextBox(searchRequirement);
		
		Thread.sleep(5000);
		try {
			requirementPage.setClickOnFirstRowRequirement_id();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}
		
		String requirement_ID = requirementPage.setRequirementId();
		System.out.println("Requirement id is : "+requirement_ID);
		// Click on Consultant option
		requirementPage.setClickOnConsultantOption();
		Thread.sleep(2000);
		String consultantName = requirementPage.setConsultantName_InRequirement();
		// Select the consultant
		Thread.sleep(2000);
		requirementPage.setSelectConsultant();

		requirementPage.setClickOnStatusLink();

		Assert.assertEquals(requirementPage.setStatusPopUpTitle(), "Set Status");

		requirementPage.setselectStatus("Coding Test");
		Thread.sleep(2000);
		requirementPage.setEnterNotes("Test");

		requirementPage.setClickOnSetStatus();

		//Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
		//		"Status has been updated successfully for Consultant " + "" + consultantName + "");
		
		Thread.sleep(3000);
		homePage.clickOnPlacementOption();
		
		System.out.println(placementPage.setRequirementID_PlacementGrid());
		
		Assert.assertEquals(placementPage.setRequirementID_PlacementGrid(), requirement_ID);
	} catch (Exception e) {
		testresultdata.put("8", new Object[] { 8d, testCaseName,
				" CandidateEnded Placement count in header and grid section should be same", "Fail" });
		e.printStackTrace();
		Assert.fail();
	}
		
	}

	
	
	
}
