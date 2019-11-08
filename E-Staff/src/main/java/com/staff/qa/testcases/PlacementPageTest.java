package com.staff.qa.testcases;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.staff.qa.base.BaseClass;
import com.staff.qa.pages.ConsultantPage;
import com.staff.qa.pages.HomePage;
import com.staff.qa.pages.LoginPage;
import com.staff.qa.pages.PlacementPage;
import com.staff.qa.pages.RequirementPage;


public class PlacementPageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	PlacementPage placementPage;
	RequirementPage requirementPage;
	ConsultantPage consultantPage;
	
	 private static DecimalFormat df = new DecimalFormat("0.00");

	public PlacementPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		placementPage = new PlacementPage();
		consultantPage = new ConsultantPage();
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

		String TestCaseName = "Verify the 'Candidate Ended' Placement count in header and grid section";
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
	
//	@Test(priority = 9)
	public void verifyPlacedConsultantAppearInPlacement_FromRequirement() throws InterruptedException {
		
		String testCaseName = "To Check the Gridview of Placements after Placing the Consultant from Requirements Module";
		test = extent.createTest(testCaseName);
		
		String searchRequirement = RequirementPageTest.requirementId;
		
		try {	
		//click on Requirement option	
		homePage.clickOnRequirementOption();
		//Thread.sleep(5000);
	//	requirementPage.setSearchTextBox(searchRequirement);
		
		Thread.sleep(5000);
		try {
			requirementPage.setClickOnFirstRowRequirement_id();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}
		//Get the Requirement Id
		String requirement_ID = requirementPage.setRequirementId();
		System.out.println("Requirement id is : "+requirement_ID);	
		
		Thread.sleep(2000);
		//Click on Search Consultant Button
		requirementPage.setClickOnSearchConsultantButton();
		Thread.sleep(2000);
        //Get the Consultant Name
		String consultantName1 = requirementPage.setConsultantName();
		//Select the First consultant (select the checkbox)
		requirementPage.setSelectConsultant();
		//Click on Shortlisted Consultant button
		requirementPage.setClickOnShortlistConsultantOptionButton();
		
		String message = "Duplicate status can not be set as Shortlisted status already exists.";
		if(requirementPage.setRequirementConfirmationMessage().equalsIgnoreCase(message)) {
			driver.navigate().refresh();
			Thread.sleep(3000);
			requirementPage.setSelectConsultant_2ndRow();
			Thread.sleep(2000);
			//Click on Shortlisted Consultant button
			requirementPage.setClickOnShortlistConsultantOptionButton();
		}
		Thread.sleep(6000);
		driver.navigate().refresh();
		//Click on Consultant option
		requirementPage.setClickOnConsultantOption();
		//String consultantName = requirementPage.setConsultantName_InRequirement();
		// Select the consultant
		requirementPage.setSelectConsultant();

		requirementPage.setClickOnStatusLink();

		Assert.assertEquals(requirementPage.setStatusPopUpTitle(), "Set Status");

		requirementPage.setselectStatus("Placed");
		Thread.sleep(2000);
		requirementPage.setEnterNotes("Test");

		requirementPage.setClickOnSetStatus();

		//Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
		//		"Status has been updated successfully for Consultant " + "" + consultantName + "");
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		homePage.clickOnPlacementOption();
		Thread.sleep(5000);
		
		placementPage.setAllPlacementsearchTextBox(requirement_ID);
		
		System.out.println(placementPage.setRequirementID_PlacementGrid());
		
		Thread.sleep(5000);
		String requirementId_InPlacementPage = "";
		try {
			requirementId_InPlacementPage = placementPage.setRequirementID_PlacementGrid();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}
		//Verifying that placed requirement appear in Placement grid
		Assert.assertEquals(requirementId_InPlacementPage, requirement_ID);
		
		test.log(Status.PASS, testCaseName + " is sucessfully pass");
		testresultdata.put("9", new Object[] { 9d, testCaseName,
				"Placed Record Should be displayed In gridview", "Pass" });
		
	} catch (Exception e) {
		testresultdata.put("9", new Object[] { 9d, testCaseName,
				"Placed Record Should be displayed In gridview", "Fail" });
		e.printStackTrace();
		Assert.fail();
	}		
		
	}
	

//	@Test(priority = 10)
	public void verifyPlacedConsultantAppearInPlacement_FromConsultant() throws InterruptedException {
		
		String testCaseName = "To Check the Gridview of Placements after Placing the Consultant from Consultant Module";
		test = extent.createTest(testCaseName);
		
	//	String searchRequirement = RequirementPageTest.requirementId;
		
		try {	
		//click on Consultant option	
		homePage.clickOnConsultantOption();		
		Thread.sleep(5000);
		try {
			consultantPage.setClickOnFirstRowConsultant();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}
		//Get the Consultant Id
		String consultant_ID = consultantPage.setConsultantId();
		System.out.println("Consultant id is : "+consultant_ID);			
		
		//Click on Search Consultant Button
		consultantPage.setClickOnLinkRequirementLink();
		
        //Get the Requirement ID
		String requirementID = consultantPage.setAlreadyLinkedRequirementId();
		
		//Select the First Requirement (select the checkbox)
		consultantPage.setSelectRequirement();
				
		//Click on Link-Requirement button
		consultantPage.setClickOnLinkRequirementButton();
		
		String message = "Duplicate status can not be set as Shortlisted status already exists.";
		if(consultantPage.setconsultantConfirmationMessage().equalsIgnoreCase(message)) {
			driver.navigate().refresh();
			Thread.sleep(3000);
			consultantPage.setSelectRequirement_2ndRow();
			Thread.sleep(2000);
			//Click on Shortlisted Consultant button
			consultantPage.setClickOnLinkRequirementButton();
		}
		Thread.sleep(3000);
		driver.navigate().refresh();
	
		//Click on Consultant option
		consultantPage.setClickOnRequirementOption();
		
		String requirementId = consultantPage.setRequirementId_InConsultant();
	
		// Select the consultant
		requirementPage.setSelectConsultant();

		requirementPage.setClickOnStatusLink();

		Assert.assertEquals(requirementPage.setStatusPopUpTitle(), "Set Status");

		requirementPage.setselectStatus("Placed");
		Thread.sleep(2000);
		requirementPage.setEnterNotes("Test");

		requirementPage.setClickOnSetStatus();

		//Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
		//		"Status has been updated successfully for Consultant " + "" + consultantName + "");
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		homePage.clickOnPlacementOption();
		Thread.sleep(7000);
		
		placementPage.setAllPlacementsearchTextBox(consultant_ID);
		
		System.out.println(placementPage.setRequirementID_PlacementGrid());
		
		Thread.sleep(5000);
		String requirementId_InPlacementPage = "";
		try {
			requirementId_InPlacementPage = placementPage.setRequirementID_PlacementGrid();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}
		//Verifying that placed requirement appear in Placement grid
		Assert.assertEquals(requirementId_InPlacementPage, requirementId);
		
		test.log(Status.PASS, testCaseName + " is sucessfully pass");
		testresultdata.put("10", new Object[] { 10d, testCaseName,
				"Placed Record Should be displayed In gridview", "Pass" });
	
	} catch (Exception e) {
		testresultdata.put("10", new Object[] { 10d, testCaseName,
				"Placed Record Should be displayed In gridview", "Fail" });
		e.printStackTrace();
		Assert.fail();
	}		
		
	}
	
//	@Test(priority = 11)
	public void verifyBackedOutConsultantFunctionality() throws InterruptedException {
		String TestCaseName = "To Check the Gridview of Placements after Backed Out the Consultant";
		test = extent.createTest(TestCaseName);
		
		try {
		//Click on Open Tab
		placementPage.setClickOnOpenTag_Placement();
		
		//Click On Requirement Id in grid
		placementPage.setClickOnRequirementID_PlacementGrid();		
		
		//Click on Edit button
		placementPage.setClickOnEditButton();
		
		//get the consultant name   
		String consultantName = placementPage.getConsultantName();	
		
		//Select Recruiter from dropdown
		placementPage.setSelectRecruiter("Vijay Chavan");
		
		//Select Sales Person from dropdown
		placementPage.setSelectSalesPerson("Vijay Chavan");		
		
		//Enter Manager Email  
		placementPage.setEnterManagerEmail("vijay.chavan@xoriant.com");		
		
		String str = driver.findElement(By.xpath("//label[@class='radio-container'][contains(text(),'Did Not Start Reason')]//input")).getAttribute("ng-reflect-is-disabled");
		System.out.println(":::::::::::"+str);
		if(str.equalsIgnoreCase("true")) {
			System.out.println("'Did Not Start Reason' Radio Button is already selected");
			placementPage.getClickOnCancelButton();
			driver.navigate().back();			
		}else {		
		//Select the 'Did Not Start Reason' Radio Button	
		placementPage.setSelectDiDNotStartRadioBtn();
		
		//Select 'Did Not Start Reason' option from dropdown
		placementPage.setselectRecruiter("Candidate Backed Out");
		
		//click onSave button
		placementPage.setClickOnSaveButton();
		
		Thread.sleep(3000);				
		Assert.assertEquals(placementPage.setPlacementConfirmationMessage(), "Placement Details of Client/Assignment data section for' "+consultantName+"' Updated Successfully");
		}
		
		test.log(Status.PASS,TestCaseName+" is sucessfully pass");
		testresultdata.put("11",new Object[]{11d,TestCaseName,"Backed out consultant should be disappear from Open filter Tag","Pass"});

		}
		catch(Exception e)
		{
			testresultdata.put("11",
				new Object[] { 11d, TestCaseName, "Backed out consultant should be disappear from Open filter Tag", "Fail" });
			e.printStackTrace();
			Assert.fail();
			}
		}
	
//	@Test(priority = 12)
	public void verifyBackedOutFilterData() throws InterruptedException {
		String TestCaseName = "To Check the Filter by Tags by Clicking on Backed Out";
		test = extent.createTest(TestCaseName);
		
		try {
		//click on Backed Out Tag - Placement
		placementPage.setClickOnBackedOutTag_Placement();
		Thread.sleep(3000);
		
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		//Compare the status with given status
		Assert.assertEquals(placementPage.verifyStatus(), "Candidate Backed Out");
		
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		Assert.assertEquals(placementPage.verifyStatus(), "Candidate Backed Out");
		
		test.log(Status.PASS,TestCaseName+" is sucessfully pass");
		testresultdata.put("12",new Object[]{12d,TestCaseName,"It Should Filter and Show the Backed Out Records In Grid View","Pass"});

		}
		catch(Exception e)
		{
			testresultdata.put("12",
				new Object[] { 12d, TestCaseName, "It Should Filter and Show the Backed Out Records In Grid View", "Fail" });
			e.printStackTrace();
			Assert.fail();
			}
		}
	
	
	
//	@Test(priority = 13)
	public void verifyOpenFilterData() throws InterruptedException {
		String TestCaseName = "To Check the Filter by Tags by Clicking on Open";
		test = extent.createTest(TestCaseName);
		
		try {
		//click on Open Tag - Placement
		placementPage.setClickOnOpenTag_Placement();
		Thread.sleep(3000);
		
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		//Compare the status with given status
		Assert.assertEquals(placementPage.verifyStatus(), "Open");
		
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		Assert.assertEquals(placementPage.verifyStatus(), "Open");
		
		test.log(Status.PASS,TestCaseName+" is sucessfully pass");
		testresultdata.put("13",new Object[]{13d,TestCaseName,"It Should Filter and Show the Open Records In Grid View","Pass"});

		}
		catch(Exception e)
		{
			testresultdata.put("13",
				new Object[] { 13d, TestCaseName, "It Should Filter and Show the Open Records In Grid View", "Fail" });
			e.printStackTrace();
			Assert.fail();
			}
		}

//	@Test(priority = 14)
	public void verifyPendingApprovalFilterData() throws InterruptedException {
		String TestCaseName = "To Check the Filter by Tags by Clicking on Pending Approval";
		test = extent.createTest(TestCaseName);
		
		try {
		//click on Pending Approval Tag - Placement
		placementPage.setClickOnPendingApprovedTag_Placement();
		Thread.sleep(3000);
		
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		//Compare the status with given status
		Assert.assertEquals(placementPage.verifyStatus(), "Pending Approval");	
		
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		Assert.assertEquals(placementPage.verifyStatus(), "Pending Approval");
		
		test.log(Status.PASS,TestCaseName+" is sucessfully pass");
		testresultdata.put("14",new Object[]{14d,TestCaseName,"It Should Filter and Show the Pending Approval Records In Grid View","Pass"});

		}
		catch(Exception e)
		{
			testresultdata.put("14",
				new Object[] { 14d, TestCaseName, "It Should Filter and Show the Pending Approval Records In Grid View", "Fail" });
			e.printStackTrace();
			Assert.fail();
			}
		}
	
//	@Test(priority = 15)
	public void verifyApprovedFilterData() throws InterruptedException {
		String TestCaseName = "To Check the Filter by Tags by Clicking on Approved";
		test = extent.createTest(TestCaseName);
		
		try {
		//click on Approved Tag - Placement
		placementPage.setClickOnApprovedTag_Placement();
		Thread.sleep(3000);
		
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		//Compare the status with given status		
		Assert.assertEquals(placementPage.verifyStatus(), "Approved");
				
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		Assert.assertEquals(placementPage.verifyStatus(), "Approved");
		
		test.log(Status.PASS,TestCaseName+" is sucessfully pass");
		testresultdata.put("15",new Object[]{15d,TestCaseName,"It Should Filter and Show the Approved Records In Grid View","Pass"});

		}
		catch(Exception e)
		{
			testresultdata.put("15",
				new Object[] { 15d, TestCaseName, "It Should Filter and Show the Approved Records In Grid View", "Fail" });
			e.printStackTrace();
			Assert.fail();
			}
		}


//	@Test(priority = 16)
	public void verifyCandidateOnBillingFilterData() throws InterruptedException {
		String TestCaseName = "To Check the Filter by Tags by Clicking on Candidate On Billing";
		test = extent.createTest(TestCaseName);
		
		try {
		//click on Approved Tag - Placement
		placementPage.setClickOnCandidateOnBillingTag_Placement();
		Thread.sleep(3000);
		
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		//Compare the status with given status		
		Assert.assertEquals(placementPage.verifyStatus(), "Candidate On Billing");
				
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		Assert.assertEquals(placementPage.verifyStatus(), "Candidate On Billing");
		
		test.log(Status.PASS,TestCaseName+" is sucessfully pass");
		testresultdata.put("16",new Object[]{16d,TestCaseName,"It Should Filter and Show the Candidate On Billing Records In Grid View","Pass"});

		}
		catch(Exception e)
		{
			testresultdata.put("16",
				new Object[] { 16d, TestCaseName, "It Should Filter and Show the Candidate On Billing Records In Grid View", "Fail" });
			e.printStackTrace();
			Assert.fail();
			}
		}


//	@Test(priority = 17)
	public void verifyCandidateEndedFilterData() throws InterruptedException {
		String TestCaseName = "To Check the Filter by Tags by Clicking on Candidate Ended";
		test = extent.createTest(TestCaseName);
		
		try {
		//click on Candidate Ended Tag - Placement
		placementPage.setClickOnCandidateEndedTag_Placement();
		Thread.sleep(3000);
		
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		//Compare the status with given status		
		Assert.assertEquals(placementPage.verifyStatus(), "Candidate Ended");
				
		//Click on Status column filter icon  
		placementPage.setClickOnStatusColumnFilter();
		
		Assert.assertEquals(placementPage.verifyStatus(), "Candidate Ended");
		
		test.log(Status.PASS,TestCaseName+" is sucessfully pass");
		testresultdata.put("17",new Object[]{17d,TestCaseName,"It Should Filter and Show the Candidate Ended Records In Grid View","Pass"});

		}
		catch(Exception e)
		{
			testresultdata.put("17",
				new Object[] { 17d, TestCaseName, "It Should Filter and Show the Candidate Ended Records In Grid View", "Fail" });
			e.printStackTrace();
			Assert.fail();
			}
		}
	
	
//	@Test(priority = 18)
	public void verifyAddNoteFunctionality() throws InterruptedException {
		String TestCaseName = "Verify the Add Note functionality";
		test = extent.createTest(TestCaseName);

		try {
			placementPage.setClickOnOpenTag_Placement();

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}

			consultantPage.setClickOnAddNoteLink();
			Thread.sleep(1000);
			consultantPage.setEnterNoteInTextBox("Test- Test");
			Thread.sleep(2000);
			consultantPage.setClickOnAddNoteButton();

			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "Note added Successfully");

			Thread.sleep(2000);
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("18",
					new Object[] { 18d, TestCaseName, "User should be able to add note in Consultant", "Pass" });
			
		} catch (Exception e) {
			testresultdata.put("18",
					new Object[] { 18d, TestCaseName, "User should be able to add note in Consultant", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test(priority = 19)
	public void verifyCancelBtnFunOfAddNote() throws InterruptedException {
		String TestCaseName = "Verify the Cancel button functionality of Add Note";
		test = extent.createTest(TestCaseName);

		try {
			placementPage.setClickOnOpenTag_Placement();

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}

			consultantPage.setClickOnAddNoteLink();
			Thread.sleep(1000);
			consultantPage.setEnterNoteInTextBox("Test- Test");
			Thread.sleep(2000);
			consultantPage.setClickOnCancelBtnOfAddNote();

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("19", new Object[] { 19d, TestCaseName,"Add note window should be disappear once click on Cancel button", "Pass" });
		} catch (Exception e) {
			testresultdata.put("19", new Object[] { 19d, TestCaseName,"Add note window should be disappear once click on Cancel button", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test(priority = 20)
	public void verifyDownloadPlacementFormFunctionality() throws InterruptedException {
		String TestCaseName = "Verify that user can download the Placement Form";
		test = extent.createTest(TestCaseName);

		try {
			placementPage.setClickOnOpenTag_Placement();

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}

			// Click on Download in Ms-Word link
			placementPage.setClickDownloadInMsWordLink();

			Thread.sleep(2000);
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "Document downloaded successfully");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("20",
					new Object[] { 20d, TestCaseName, "User should be able to download the Placement Form.", "Pass" });
		}

		catch (Exception e) {
			testresultdata.put("20",
					new Object[] { 20d, TestCaseName, "User should be able to download the Placement Form.", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

//	@Test(priority = 21)
	public void verifyEditClientAssignmentFieldsOfPlacementFormFunctionality() throws InterruptedException {
		String TestCaseName = "Verify that user can edit the Client & Assignment fields of Placement Form";
		test = extent.createTest(TestCaseName);

		try {
			placementPage.setClickOnBackedOutTag_Placement();

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			// Click on Edit button
			placementPage.setClickOnEditButton();

			// Get the consultant Name
			String consutlatName = placementPage.getConsultantName();

			// Select Business Unit from dropdown
			placementPage.setSelectBusinessUnit("55 - House");

			// Select Recruiter from dropdown
			placementPage.setSelectRecruiter("Sawan Muttha");

			// Select Sales Person from dropdown
			placementPage.setSelectSalesPerson("Sawan Muttha");

			// Enter Xoriant-Client
			placementPage.setEnterXoriantClient("Demo");

			// Enter End Client Name
			placementPage.setEnterEndClientName("Xoriant");

			// Enter Client Name in Offer Letter
			placementPage.setEnterClientNameInOfferLetter("Xoriant Solutions");

			// Enter Manager Name
			placementPage.setEnterManagerName("Manger");

			// Enter Manager Phone
			placementPage.setEnterManagerPhone("9988776655");

			// Enter Manager Email
			placementPage.setEnterManagerEmail("vijay.chavan@xoriant.com");

			// Select Nature Of Assignment from dropdown
			placementPage.setSelectNatureOfAssignment("Staffing Placement");

			// Enter Bill Rate
			placementPage.setEnterBillRate("100");

			// Select Bill Rate UOM from dropdown
			placementPage.setSelectBillRateUOM("Hourly");

			// Select Billing Frequency from dropdown
			placementPage.setSelectBillingFrequency("MONTHLY");

			// Select Estimated Start Date
			placementPage.clickOnEstimatedStartDateBox();
			consultantPage.selectAvailabilityDate("2020");
			consultantPage.selectMonth("May");
			consultantPage.setSelectDate("20");

			// Select Estimated End Date
			placementPage.clickOnEstimatedEndDateBox();
			consultantPage.selectAvailabilityDate("2021");
			consultantPage.selectMonth("May");
			consultantPage.setSelectDate("20");

			// Enter Billing Contact Name
			placementPage.setEnterBillingContactName("Xoriant Solutions");

			// Select Country
			placementPage.setselectCountry("United States");

			// Select State
			placementPage.setselectState("California");

			// Select City
			placementPage.setselectCity("Actis");

			// Click on Save Button
			placementPage.setClickOnSaveButton();

			Assert.assertEquals(placementPage.setPlacementConfirmationMessage(),
					"Placement Details of Client/Assignment data section for' " + consutlatName
							+ "' Updated Successfully");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("21", new Object[] { 21d, TestCaseName,
					"User should be able to edit the Client & Assignment fields of Placement Form", "Pass" });
		} catch (Exception e) {
			testresultdata.put("21", new Object[] { 21d, TestCaseName,
					"User should be able to edit the Client & Assignment fields of Placement Form", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}	
	
//	@Test(priority = 22)
	public void verifyEditConsultantDetailsOfPlacementFormFunctionality() throws InterruptedException {
		String TestCaseName = "Verify that user can edit the  Consultant Details fields of Placement Form";
		test = extent.createTest(TestCaseName);
		
		try {
			placementPage.setClickOnBackedOutTag_Placement();

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			//Click on Consultant Details link
			placementPage.setClickConsultantDetailsLink();
			
			// Click on Edit button
			placementPage.setClickOnEditButton();

			// Get the consultant Name
			String consutlatName = placementPage.getConsultantName();
			
			//Enter First Name
			placementPage.setEnterConsultantFName("John");
			
			//Enter Last Name
			placementPage.setEnterConsultantLastName("John");
			
			//Select Gender from Dropdown
			placementPage.setselectConsultantGender("Male");
			
			//Enter the Email id
			placementPage.setEnterConsultantEmail1("vijay.chavan@xoriant.com");

			//Enter the Mobile Number
			placementPage.setEnterConsultantMobile("9988776655");
		
			//Enter Address Line 1
			placementPage.setEnterConsultantAddressLine1("United state");
			
			//Select Country from Dropdown
			placementPage.setselectConsultantCountries("Australia");
			//Select State from Dropdown
			placementPage.setselectConsultantState("South Australia");
			//Select City from Dropdown
			placementPage.setselectConsultantCity("Belton");
			
			//Enter Zip
			placementPage.setEnterConsultantZipCode("11045");
			
			//Enter Job Title
			placementPage.setEnterJobTitle("Software Engg");
			
			//Select Candidate Source from Dropdown
			placementPage.setselectCandidateSource("EMPLOYEE");
			
			//Enter Skills
			placementPage.setEnterConsultantSkills("Java SQL");
			
			//Select Employment Type from Dropdown
			placementPage.setselectEmployementType("Hourly W2");
			
			//Select Visa Status from Dropdown
			placementPage.setselectVisaStatus("CITIZEN");
			
			//Enter Pay Rate
			placementPage.setEnterPayRate("100");
			
			//Select Pay Rate UOM  from Dropdown
			placementPage.setselectPayRateUOM("Hourly");
			
			//click on Save Button 
			placementPage.setClickOnSaveButton();
			
			Assert.assertEquals(placementPage.setPlacementConfirmationMessage(),
					"Placement Details of Consultant Details section for '" + consutlatName
							+ "' Updated Successfully");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("22", new Object[] { 22d, TestCaseName,
					"User should be able to edit the Consultant Details fields of Placement Form", "Pass" });
		} catch (Exception e) {
			testresultdata.put("22", new Object[] { 22d, TestCaseName,
					"User should be able to edit the Consultant Details fields of Placement Form", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}	
		
//	@Test(priority = 23)
	public void verifyEditGrossMarginOfPlacementFormFunctionality() throws InterruptedException {
		String TestCaseName = "Verify that user can edit the Gross Margin fields of Placement Form";
		test = extent.createTest(TestCaseName);
		
	      try {
			placementPage.setClickOnBackedOutTag_Placement();

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			//Click on Gross Margin link
			placementPage.setClickGrossMarginLink();
			
			// Click on Edit button
			placementPage.setClickOnEditButton();

			// Get the consultant Name
			String consutlatName = placementPage.getConsultantName();
			
			//Get text of Total Loaded Cost
			String TotalLoadedCost =placementPage.getValueOfTotalLoadedCost().trim();
			double totalLoadedCostNumber = Double.parseDouble(TotalLoadedCost);
			
			//Get text of Bill Rate
			placementPage.getValueOfBillRate();			
			
			//Enter Discount
			placementPage.setEnterDiscount("10");
			
			//Get text of Gross Margin
			String GrossMargin =  placementPage.getValueOfGrossMargin();
			double actulGrossMarginInPercentage = Double.parseDouble(GrossMargin);
			
			//Get text of Gross Margin in $/Hr
			String GrossMarginIn$PerHour = placementPage.getValueOfGrossMarginIn$PerHour().trim();
			double actulGrossMarginIn$PerHour = Double.parseDouble(GrossMarginIn$PerHour);
			
			//Get text of Xoriant Revenue
			String XoriantRevenue = placementPage.getValueOfXoriantRevenue().trim();
			double xoriantRevenueNumber = Double.parseDouble(XoriantRevenue);
			
			double expectedGrossMarginIn$PerHour = xoriantRevenueNumber - totalLoadedCostNumber;
			
			//verify Gross Margin Per Hour 
			Assert.assertEquals(df.format(actulGrossMarginIn$PerHour), df.format(expectedGrossMarginIn$PerHour));
			
			
			double expectedGrossMarginInPercentage = ((actulGrossMarginIn$PerHour) * 100)/ xoriantRevenueNumber;
					
			//Verify Gross Margin Percentage
			Assert.assertEquals(df.format(actulGrossMarginInPercentage), df.format(expectedGrossMarginInPercentage));
			
			//click on Save Button 
			placementPage.setClickOnSaveButton();
			
			
			Assert.assertEquals(placementPage.setPlacementConfirmationMessage(),
					"Placement Details of Gross margin section for' " + consutlatName
							+ "' Updated Successfully");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("23", new Object[] { 23d, TestCaseName,
					"User should be able to edit the Consultant Details fields of Placement Form", "Pass" });
		} catch (Exception e) {
			testresultdata.put("23", new Object[] { 23d, TestCaseName,
					"User should be able to edit the Consultant Details fields of Placement Form", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
		
//	@Test(priority = 24)
	public void verifyCancelButtonFunGrossMarginOfPlacementForm() throws InterruptedException {
		String TestCaseName = "Verify cancel button functionality of edit the Gross Margin fields of Placement Form";
		test = extent.createTest(TestCaseName);
		
	    try {
				placementPage.setClickOnBackedOutTag_Placement();

				Thread.sleep(2000);
				try {
					consultantPage.setClickOnFirstRowConsultant();
				} catch (Exception e) {
					WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
					System.out.println(noData.getText());
				}
				//Click on Gross Margin link
				placementPage.setClickGrossMarginLink();
				
				// Click on Edit button
				placementPage.setClickOnEditButton();

				// Get the consultant Name
				String consutlatName = placementPage.getConsultantName();
				
				//Click on Cancel button
				placementPage.setClickCancelButton();
				
				test.log(Status.PASS, TestCaseName + " is sucessfully pass");
				testresultdata.put("24", new Object[] { 24d, TestCaseName,
						"User should be able to click on Cancel button and edit window should be disappear after clicking Cancel button", "Pass" });
			} catch (Exception e) {
				testresultdata.put("24", new Object[] { 24d, TestCaseName,
						"User should be able to click on Cancel button and edit window should be disappear after clicking Cancel button", "Fail" });
				e.printStackTrace();
				Assert.fail();
			}
	}
			
//	@Test(priority = 25)
	public void verifyCancelButtonFunConsultantDetailsOfPlacementForm() throws InterruptedException {
		String TestCaseName = "Verify cancel button functionality of edit the Consultant Details of Placement Form";
		test = extent.createTest(TestCaseName);
		
	    try {
				placementPage.setClickOnBackedOutTag_Placement();

				Thread.sleep(2000);
				try {
					consultantPage.setClickOnFirstRowConsultant();
				} catch (Exception e) {
					WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
					System.out.println(noData.getText());
				}
				//Click on Gross Margin link
				placementPage.setClickConsultantDetailsLink();
				
				// Click on Edit button
				placementPage.setClickOnEditButton();

				// Get the consultant Name
				String consutlatName = placementPage.getConsultantName();
				
				//Click on Cancel button
				placementPage.setClickCancelButton();
				
				test.log(Status.PASS, TestCaseName + " is sucessfully pass");
				testresultdata.put("25", new Object[] { 25d, TestCaseName,
						"User should be able to click on Cancel button and edit window should be disappear after clicking Cancel button", "Pass" });
			} catch (Exception e) {
				testresultdata.put("25", new Object[] { 25d, TestCaseName,
						"User should be able to click on Cancel button and edit window should be disappear after clicking Cancel button", "Fail" });
				e.printStackTrace();
				Assert.fail();
			}
	}
	
//   @Test(priority = 26)
	public void verifyCancelButtonFunClientAssignmentOfPlacementForm() throws InterruptedException {
		String TestCaseName = "Verify cancel button functionality of edit the Client Assignment of Placement Form";
		test = extent.createTest(TestCaseName);

		try {
			placementPage.setClickOnBackedOutTag_Placement();

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}

			// Click on Edit button
			placementPage.setClickOnEditButton();

			// Get the consultant Name
			String consutlatName = placementPage.getConsultantName();

			// Click on Cancel button
			placementPage.setClickCancelButton();

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("26", new Object[] { 26d, TestCaseName,
					"User should be able to click on Cancel button and edit window should be disappear after clicking Cancel button",
					"Pass" });
		} catch (Exception e) {
			testresultdata.put("26", new Object[] { 26d, TestCaseName,
					"User should be able to click on Cancel button and edit window should be disappear after clicking Cancel button",
					"Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

//	@Test(priority = 27, invocationCount = 1)
	public void verifyCompaniesSearchTextBoxFunOfPlacementForm() throws InterruptedException {
		String TestCaseName = "Verify searched company name can appear based on entered text in search textbox of Companies tag of Placement Form";
		test = extent.createTest(TestCaseName);

		try {
			// Wait until page load
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath("//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]"))));
			Thread.sleep(3000);

			// Enter text in search text box of Companies search tag
			String companyName = "Accenture";
			placementPage.setEnterTextInCompaniesSearchTag(companyName);

			List<WebElement> searchCompanyName = driver
					.findElements(By.xpath("//div[@class='filter-companies filter-checkbox-block']//li//label"));
			// List<WebElement> searchCompanyName;

			for (WebElement e : searchCompanyName) {
				String searchedCompany = e.getAttribute("title");

				if (searchedCompany.startsWith(companyName)) {
					// System.out.println("search fun is incorrect");

					test.log(Status.PASS, TestCaseName + " is sucessfully pass");
					testresultdata.put("27", new Object[] { 27d, TestCaseName,
							"Searched company name should be appear based on entered text in search textbox of Companies tag of Placement Form","Pass" });
				}
			}
		} catch (Exception e) {
			testresultdata.put("27", new Object[] { 27d, TestCaseName,
					"Searched company name should be appear based on entered text in search textbox of Companies tag of Placement Form","Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test(priority = 28, invocationCount = 1)
	public void verifyCompaniesFilterFunOfPlacementForm() throws InterruptedException {
		String TestCaseName = "Verify that user can select the company from list of companies of Placement Form";
		test = extent.createTest(TestCaseName);

		try {
		// Wait until page load
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]"))));
		Thread.sleep(3000);

		//Enter text in search text box of Companies search tag
		String companyName = "Accenture";
		placementPage.setEnterTextInCompaniesSearchTag(companyName);
		
	    WebElement searchCompanyName = driver
				.findElement(By.xpath("//div[@class='filter-companies filter-checkbox-block']//li//label"));
		// List<WebElement> searchCompanyName;

		//for (WebElement e : searchCompanyName) {
			String searchedCompany = searchCompanyName.getAttribute("title");

			if (searchedCompany.equalsIgnoreCase(companyName)) {
				driver.findElement(By.xpath("//div[@class='filter-companies filter-checkbox-block']//label[contains(text(),'"+companyName+"')]")).click();
				
				// System.out.println("search fun is incorrect");

				test.log(Status.PASS, TestCaseName + " is sucessfully pass");
				testresultdata.put("28", new Object[] { 28d, TestCaseName,
						"User should be able to select the company from list of companies of Placement Form","Pass" });
			}
		
		} catch (Exception e) {
			testresultdata.put("28", new Object[] { 28d, TestCaseName,
				"User should be able to select the company from list of companies of Placement Form","Fail" });
			e.printStackTrace();
			Assert.fail();
			}
		}
	
//	@Test(priority = 29, invocationCount = 1)
	public void verifyCompaniesFilterFunOfPlacementForm1() throws InterruptedException {
		String TestCaseName = "Verify that searched company data appeard in grid with database ";
		test = extent.createTest(TestCaseName);

		try {
			// Wait until page load
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath("//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]"))));
			Thread.sleep(3000);

			// Enter text in search text box of Companies search tag
			String companyName = "3i Infotech Inc.";
			placementPage.setEnterTextInCompaniesSearchTag(companyName);

			WebElement searchCompanyName = driver
					.findElement(By.xpath("//div[@class='filter-companies filter-checkbox-block']//li//label"));
			// List<WebElement> searchCompanyName;

			// for (WebElement e : searchCompanyName) {
			String searchedCompany = searchCompanyName.getAttribute("title");

			if (searchedCompany.equalsIgnoreCase(companyName)) {
				driver.findElement(By.xpath("//div[@class='filter-companies filter-checkbox-block']//label[contains(text(),'"+ companyName + "')]")).click();

				wait.until(ExpectedConditions.visibilityOf(
						driver.findElement(By.xpath("//div[@class='placements-list-container col-md-10']"))));
				Thread.sleep(5000);
				placementPage.setTotalPlacementLabel();

				test.log(Status.PASS, TestCaseName + " is sucessfully pass");
				testresultdata.put("29", new Object[] { 29d, TestCaseName,
						"Data appeared based on filtered companies should be same in database and UI", "Pass" });
			}

		} catch (Exception e) {
			testresultdata.put("29", new Object[] { 29d, TestCaseName,
					"Data appeared based on filtered companies should be same in database and UI", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}			
	}

//	@Test(priority = 30, invocationCount = 1)
	public void verifyAccountManagerSearchTextBoxFunOfPlacementForm() throws InterruptedException {
		String TestCaseName = "Verify searched Account Manager name can appear based on entered text in search textbox of Account Manager tag of Placement Form";
		test = extent.createTest(TestCaseName);

		try {
			// Wait until page load
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath("//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]"))));
			Thread.sleep(3000);

			// Enter text in search text box of Companies search tag
			String accountManagerName = "Vijay Thosar";
			placementPage.setEnterTextInAccountManagerSearchTag(accountManagerName);

			List<WebElement> searchCompanyName = driver
					.findElements(By.xpath("//div[@class='filter-companies filter-checkbox-block']//li//label"));
			// List<WebElement> searchCompanyName;

			for (WebElement e : searchCompanyName) {
				String searchedCompany = e.getAttribute("title");

				if (searchedCompany.startsWith(accountManagerName)) {
					// System.out.println("search fun is incorrect");

					test.log(Status.PASS, TestCaseName + " is sucessfully pass");
					testresultdata.put("30", new Object[] { 30d, TestCaseName,
							"Searched Account Manager should be appear based on entered text in search textbox of Account Manager tag of Placement Form","Pass" });
				}
			}
		} catch (Exception e) {
			testresultdata.put("30", new Object[] { 30d, TestCaseName,
					"Searched Account Manager name should be appear based on entered text in search textbox of Account Manager tag of Placement Form","Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test(priority = 31, invocationCount = 1)
	public void verifyAccountMangerFilterFunOfPlacementForm() throws InterruptedException {
		String TestCaseName = "Verify that user can select the account manger from list of account manager of Placement Form";
		test = extent.createTest(TestCaseName);

		try {
		// Wait until page load
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]"))));
		Thread.sleep(3000);

		//Enter text in search text box of Companies search tag
		String accountManagerName = "Vijay Thosar";
		placementPage.setEnterTextInAccountManagerSearchTag(accountManagerName);
		
	    WebElement searchAccountManager = driver
				.findElement(By.xpath("//div[@class='filter-accountManager filter-checkbox-block']//li//label"));
		// List<WebElement> searchCompanyName;

		//for (WebElement e : searchCompanyName) {
			String searchedAccountManager = searchAccountManager.getAttribute("title");

			if (searchedAccountManager.equalsIgnoreCase(accountManagerName)) {
				driver.findElement(By.xpath("//div[@class='filter-accountManager filter-checkbox-block']//label[contains(text(),'"+accountManagerName+"')]")).click();
				
				// System.out.println("search fun is incorrect");

				test.log(Status.PASS, TestCaseName + " is sucessfully pass");
				testresultdata.put("31", new Object[] { 31d, TestCaseName,
						"User should be able to select the account manager from list of account manager of Placement Form","Pass" });
			}
		
		} catch (Exception e) {
			testresultdata.put("31", new Object[] { 31d, TestCaseName,
				"User should be able to select the account manager from list of account manager of Placement Form","Fail" });
			e.printStackTrace();
			Assert.fail();
			}
		}
	
//	@Test(priority = 32, invocationCount = 1)
	public void verifyAccountManagerFilterFunOfPlacementForm1() throws InterruptedException {
		String TestCaseName = "Verify that searched Account Manager data appeard in grid with database ";
		test = extent.createTest(TestCaseName);

		try {
			// Wait until page load
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath("//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]"))));
			Thread.sleep(3000);

			// Enter text in search text box of Companies search tag
			String accountManagerName = "Vijay Chavan";
			placementPage.setEnterTextInAccountManagerSearchTag(accountManagerName);			

			WebElement searchAccountManager = driver
					.findElement(By.xpath("//div[@class='filter-accountManager filter-checkbox-block']//li//label"));
			// List<WebElement> searchCompanyName;

			// for (WebElement e : searchCompanyName) {
			String searchedAccountManager = searchAccountManager.getAttribute("title");

			if (searchedAccountManager.equalsIgnoreCase(accountManagerName)) {
				driver.findElement(By.xpath("//div[@class='filter-accountManager filter-checkbox-block']//label[contains(text(),'"+ accountManagerName + "')]")).click();

				wait.until(ExpectedConditions.visibilityOf(
						driver.findElement(By.xpath("//div[@class='placements-list-container col-md-10']"))));
				Thread.sleep(5000);
				placementPage.setTotalPlacementLabel();

				test.log(Status.PASS, TestCaseName + " is sucessfully pass");
				testresultdata.put("32", new Object[] { 32d, TestCaseName,
						"Data appeared based on filtered Account Manager should be same in database and UI", "Pass" });
				}
			} catch (Exception e) {
				testresultdata.put("32", new Object[] { 32d, TestCaseName,
						"Data appeared based on filtered Account Manager should be same in database and UI", "Fail" });
				e.printStackTrace();
				Assert.fail();
				}
		}

	@Test(priority = 31, invocationCount = 2)
	public void verifyPlacementDateFilterFunOfPlacementForm() throws InterruptedException {
		String TestCaseName = "Verify that searched Placement Date data appeard in grid with database";
		test = extent.createTest(TestCaseName);

		try {
			// Wait until page load
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath("//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]"))));
			Thread.sleep(3000);

			// Select From Date
			placementPage.clickOnFromDateBox();
			consultantPage.selectAvailabilityDate("2019");
			consultantPage.selectMonth("May");
			consultantPage.setSelectDate("20");

			// Select To date
			placementPage.clickOnToDateBox();
			consultantPage.selectAvailabilityDate("2019");
			consultantPage.selectMonth("Dec");
			consultantPage.setSelectDate("20");

			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//div[@class='placements-list-container col-md-10']"))));
			Thread.sleep(5000);
			placementPage.setTotalPlacementLabel();

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("32", new Object[] { 32d, TestCaseName,
					"Data appeared based on filtered Placement Date should be same in database and UI", "Pass" });
		} catch (Exception e) {
			testresultdata.put("32", new Object[] { 32d, TestCaseName,
					"Data appeared based on filtered Placement Date should be same in database and UI", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

}