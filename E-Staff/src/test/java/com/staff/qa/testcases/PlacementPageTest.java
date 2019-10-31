package com.staff.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		Thread.sleep(3000);
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
		Thread.sleep(5000);
		
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
		placementPage.setEnterManagerEmail();		
		
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
		//click on Approved Tag - Placement
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

	
}
