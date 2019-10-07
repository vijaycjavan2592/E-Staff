package com.staff.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.staff.qa.base.TestBase;
import com.staff.qa.pages.ConsultantPage;
import com.staff.qa.pages.HomePage;
import com.staff.qa.pages.LoginPage;
import com.staff.qa.pages.RequirementPage;
import com.staff.qa.util.TestUtil;

public class RequirementPageTest extends TestBase{

	RequirementPage requirementPage;
	LoginPage loginPage;
	HomePage homePage;
	
	String sheetName = "Add_Requirement";
	
	String sheetname_edit = "Edit_Requirement";
	
	static String requirementId;
	
	public RequirementPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		requirementPage = new RequirementPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		requirementPage = homePage.clickOnRequirementOption();
	}
	
//	@Test
	public void verifyUserNavigateToConsultantPage() throws InterruptedException {

		String TestCaseName = "Verify that user can navigate to the Requirement Page";
		test = extent.createTest(TestCaseName);

		Thread.sleep(2000);
		try {
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("requirement_page_url"));
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");

			testresultdata.put("1",
					new Object[] { 1d, TestCaseName, "User Should be navigate to the Requirement Page", "Pass" });
		} catch (Exception e) {
			testresultdata.put("1",
					new Object[] { 1d, TestCaseName, "User Should be navigate to the Requirement Page", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	
//	@Test
	public void getOpenRequirementCount() throws InterruptedException {

		String TestCaseName = "Verify the Open Requirement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			//Thread.sleep(5000);
			requirementPage.setTotalRequirementLabel();
			Assert.assertEquals(requirementPage.setTotalRequirementLabel(),
					"Open Requirements (" + requirementPage.setAllRequirementCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("2", new Object[] { 2d, TestCaseName,
					" Open Requirements count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("2", new Object[] { 2d, TestCaseName,
					" Open Requirements count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

//	@Test
	public void getAllRequirementCount() throws InterruptedException {

		String TestCaseName = "Verify the All Requirement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			//Click on All tag	
			requirementPage.setClickOnAllTag();
			//Thread.sleep(5000);
			requirementPage.setTotalRequirementLabel();
			Assert.assertEquals(requirementPage.setTotalRequirementLabel(),
					"All Requirements (" + requirementPage.setAllRequirementCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("3", new Object[] { 3d, TestCaseName,
					" All Requirements count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("3", new Object[] { 3d, TestCaseName,
					" All Requirements count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	
//	@Test
	public void getArchivedRequirementCount() throws InterruptedException {

		String TestCaseName = "Verify the Archived Requirement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			//Click on Archived tag	
			requirementPage.setClickOnArchivedTag();
			//Thread.sleep(5000);
			requirementPage.setTotalRequirementLabel();
			Assert.assertEquals(requirementPage.setTotalRequirementLabel(),
					"Archived Requirements (" + requirementPage.setAllRequirementCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("4", new Object[] { 4d, TestCaseName,
					" Archived Requirements count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("4", new Object[] { 4d, TestCaseName,
					" Archived Requirements count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	
//	@Test
	public void verifyAddNewRequirementBtnClickable() {
		String TestCaseName = "Verify Add New Button is Clickable and it Shows the Add New Requirement Form";
		test = extent.createTest(TestCaseName);
		
		try {
		//Click on Add New link	
		Thread.sleep(2000);
		requirementPage.setClickAddNewLink();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("AddNew_Requirement_page_url"));
		
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("5", new Object[] { 5d, TestCaseName,
				"Add New Button Should be Clickable and It Should display the Add New Requirement Form", "Pass" });
		} catch (Exception e) {
			testresultdata.put("5", new Object[] { 5d, TestCaseName,
					"Add New Button Should be Clickable and It Should display the Add New Requirement Form", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test
	public void verifyFunctionalityOfCancelButtonOfAddNewForm() {
		String TestCaseName = "Verify that functionality of Cancel button of Add New Requirement window";
		test = extent.createTest(TestCaseName);

		try {
		//Click on Add New link	
		Thread.sleep(2000);
		requirementPage.setClickAddNewLink();		
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("AddNew_Requirement_page_url"));
		
		//Click on Cancel button
		requirementPage.setClickOnCancelButton();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("requirement_page_url"));
		
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("6", new Object[] { 6d, TestCaseName,
				"Add new Requirement window should be disappear after clicking Cancel button", "Pass" });
		} catch (Exception e) {
			testresultdata.put("6", new Object[] { 6d, TestCaseName,
					"Add new Requirement window should be disappear after clicking Cancel button", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@DataProvider
	public Object[][] getRequirementData() throws IOException {

		Object data[][] = TestUtil.getData(sheetName);

		return data;
	}
	
//	@Test(dataProvider = "getRequirementData")
	public void verifyAddRequirementFunctionality(String recruiter, String no_Of_Openings, String contact,
			String accountManger, String jobTitle, String jobType, String year, String month, String date,
			String businessUnit, String visaStatus, String priority, String communicationSkills, String billRateUOM,
			String payRateUOM, String country, String state, String city, String primarySkills, String SecondarySkills, 
			String OptionalSkills, String ShortDescription, String Description) throws InterruptedException {
		String TestCaseName = "Verify that user can add new requirement into the system";
		test = extent.createTest(TestCaseName);
		
		try {
		// Click on Add New link
		Thread.sleep(3000);
		requirementPage.setClickAddNewLink();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("AddNew_Requirement_page_url"));
		
		requirementId = requirementPage.setRequirementId();
		//Select Recruiter
		requirementPage.setselectRecruiter(recruiter);		
		requirementPage.setEnterRequirementNoOfOpenings(no_Of_Openings);		
		requirementPage.setselectContact(contact);		
		requirementPage.setselectAccountManager(accountManger);		
		requirementPage.setEnterJobTitle(jobTitle);		
		requirementPage.setselectJobType(jobType);		
		requirementPage.clickDateBox();
		Thread.sleep(2000);
		requirementPage.selectStartYear(year);
		Thread.sleep(2000);
		requirementPage.selectMonth(month);
		Thread.sleep(2000);
		requirementPage.setSelectDate(date);	
		Thread.sleep(1000);
		
		requirementPage.setselectBusinessUnit(businessUnit);		
		requirementPage.setselectVisaStatus(visaStatus);		
		requirementPage.setselectPriority(priority);		
		requirementPage.setselectCommunicationSkills(communicationSkills); 		
		requirementPage.setselectBillRateUOM(billRateUOM);		
		requirementPage.setselectPayRateUOM(payRateUOM);		
		requirementPage.setselectCountry(country);		
		requirementPage.setselectState(state);		
		requirementPage.setselectCity(city);		
		
		requirementPage.setClickContinueButton();
		
		requirementPage.setEnterPrimarySkills(primarySkills);  		
		requirementPage.setEnterSecondarySkills(SecondarySkills);		
		requirementPage.setEnterOptionalSkills(OptionalSkills);		
		requirementPage.setEnterShortDescription(ShortDescription);
		
		requirementPage.setClickOnContinueButton_Skill();
		
		requirementPage.setEnterDescription(Description);
		
		requirementPage.setClickOnContinueButton_JobDescription();
		
		requirementPage.setClickOnAddRequirementButton();
		
		Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(), "Requirement '"+requirementId+"' Added Successfully");
		
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("7", new Object[] { 7d, TestCaseName,
				"User should be able to add new requirement into the system", "Pass" });
		} catch (Exception e) {
			testresultdata.put("7", new Object[] { 7d, TestCaseName,
					"User should be able add new requirement into the system", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@DataProvider
	public Object[][] getRequirementData_edit() throws IOException {

		Object data[][] = TestUtil.getData(sheetname_edit);

		return data;
	}

//	@Test(dataProvider = "getRequirementData_edit")
	public void verifyEditRequirementFunctionality(String recruiter, String no_Of_Openings, String contact,
			String accountManger, String jobTitle, String jobType, String year, String month, String date,
			String businessUnit, String visaStatus, String priority, String communicationSkills, String billRateUOM,
			String payRateUOM, String country, String state, String city, String primarySkills, String SecondarySkills, 
			String OptionalSkills, String ShortDescription, String Description) throws InterruptedException {
		String TestCaseName = "Verify that user can edit the Requirement";
		test = extent.createTest(TestCaseName);
		
		String searchRequirement =requirementId;
		
		try {
		// Click on Add New link
		Thread.sleep(3000);
		requirementPage.setSearchTextBox(searchRequirement);
		Thread.sleep(2000);
		requirementPage.setClickOnFirstRowRequirement_id();
		Thread.sleep(2000);		
		requirementPage.setClickOnEditButton();
		
		String requirement_id = requirementPage.setRequirementId();
		//Select Recruiter
		requirementPage.setselectRecruiter(recruiter);		
		requirementPage.setEnterRequirementNoOfOpenings(no_Of_Openings);		
	//	requirementPage.setselectContact(contact);		
		requirementPage.setselectAccountManager(accountManger);		
		requirementPage.setEnterJobTitle(jobTitle);		
		requirementPage.setselectJobType(jobType);		
		/*requirementPage.clickDateBox();
		Thread.sleep(2000);
		requirementPage.selectStartYear(year);
		Thread.sleep(2000);
		requirementPage.selectMonth(month);
		Thread.sleep(2000);
		requirementPage.setSelectDate(date);	
*/		Thread.sleep(1000);
		
		requirementPage.setselectBusinessUnit(businessUnit);		
		requirementPage.setselectVisaStatus(visaStatus);		
		requirementPage.setselectPriority(priority);		
		requirementPage.setselectCommunicationSkills(communicationSkills); 		
		requirementPage.setselectBillRateUOM(billRateUOM);		
		requirementPage.setselectPayRateUOM(payRateUOM);		
		requirementPage.setselectCountry(country);		
		requirementPage.setselectState(state);		
		requirementPage.setselectCity(city);		
		
		requirementPage.setClickContinueButton();
		
		requirementPage.setEnterPrimarySkills(primarySkills);  		
		requirementPage.setEnterSecondarySkills(SecondarySkills);		
		requirementPage.setEnterOptionalSkills(OptionalSkills);		
		requirementPage.setEnterShortDescription(ShortDescription);
		
		requirementPage.setClickOnContinueButton_Skill();
		
		requirementPage.setEnterDescription(Description);
		
		requirementPage.setClickOnContinueButton_JobDescription();
		
		requirementPage.setClickOnUpdateRequirementButton();
		
		Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(), "Requirement '"+searchRequirement+"' Updated Successfully");
		
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("8", new Object[] { 8d, TestCaseName,
				"User should be able to edit requirement into the system", "Pass" });
		} catch (Exception e) {
			testresultdata.put("8", new Object[] { 8d, TestCaseName,
					"User should be able edit requirement into the system", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

//	@Test
	public void verifyUploadDocumentFunctionality() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that user can upload the document for particular requirement";
		test = extent.createTest(TestCaseName);
		
        String searchRequirement = "Req-264587-6";		
		
        try {
		Thread.sleep(3000);
		requirementPage.setSearchTextBox(searchRequirement);
		Thread.sleep(2000);
		try {
			requirementPage.setClickOnFirstRowRequirement_id();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}		
		requirementPage.setClickOnDocumentOption();
		
		requirementPage.setClickOnUploadDocumentLink();
		
		requirementPage.setEnterDocumentName("Job Description");
		
		requirementPage.setSelectDocumentType("Contract Agreement");
		
		requirementPage.setUploadDocument(prop.getProperty("document_upload_path"));
		Thread.sleep(3000);	
		requirementPage.setClickOnUploadButton();
		  
		Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(), "Upload Document Record created successfully");
		
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("9", new Object[] { 9d, TestCaseName,
				"User should be able to upload the document for particular requirement", "Pass" });
		} catch (Exception e) {
			testresultdata.put("9", new Object[] { 9d, TestCaseName,
					"User should be able to upload the document for particular requirement", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test
	public void verifyUploadDocumentAppearInGrid() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that upload document can appear in grid";
		test = extent.createTest(TestCaseName);
		
        String searchRequirement = "Req-264587-6";		
		
        try {
		Thread.sleep(3000);
		requirementPage.setSearchTextBox(searchRequirement);
		Thread.sleep(2000);
		try {
			requirementPage.setClickOnFirstRowRequirement_id();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}		
		requirementPage.setClickOnDocumentOption();
		
		requirementPage.setClickOnUploadDocumentLink();
		
		String documentName = "Job Description";
		requirementPage.setEnterDocumentName(documentName);
		
		requirementPage.setSelectDocumentType("Contract Agreement");
		
		requirementPage.setUploadDocument(prop.getProperty("document_upload_path"));
		Thread.sleep(3000);	
		requirementPage.setClickOnUploadButton();
		  
		Thread.sleep(2000);	
		Assert.assertEquals(requirementPage.setDocumentNameInGrid(), documentName);
		
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("10", new Object[] { 10d, TestCaseName,
				"Uploaded document should be appear in grid section", "Pass" });
		} catch (Exception e) {
			testresultdata.put("10", new Object[] { 10d, TestCaseName,
					"Uploaded document should be appear in grid section", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test
	public void verifyDownloadUploadedDocument_requirement() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that user can download the uploaded documents";
		test = extent.createTest(TestCaseName);
		
        String searchRequirement = "Req-264587-6";		
		
        try {
		Thread.sleep(3000);
		requirementPage.setSearchTextBox(searchRequirement);
		Thread.sleep(2000);
		try {
			requirementPage.setClickOnFirstRowRequirement_id();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}		
		requirementPage.setClickOnDocumentOption();

		requirementPage.setDownloadUploadedDocument();
	
		Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(), "File downloaded successfully");
		
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("11", new Object[] { 11d, TestCaseName,
				"User should be able to download the uploaded documents", "Pass" });
		} catch (Exception e) {
			testresultdata.put("11", new Object[] { 11d, TestCaseName,
					"User should be able to download the uploaded documents", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}	
	}
	
//	@Test
	public void verifyCancelBtnFunOfUploadDocPopUp_requirement() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that cancel button functionality of Upload Document pop-up";
		test = extent.createTest(TestCaseName);
		
        String searchRequirement = "Req-264587-6";		
		
        try {
		Thread.sleep(3000);
		requirementPage.setSearchTextBox(searchRequirement);
		Thread.sleep(2000);
		try {
			requirementPage.setClickOnFirstRowRequirement_id();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}		
		requirementPage.setClickOnDocumentOption();

		requirementPage.setClickOnUploadDocumentLink();
		
		requirementPage.setClickOnCancelButtonOfUploadDocumentPopUp();

		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("12", new Object[] { 12d, TestCaseName,
				"Upload document pop up should be disappear once click on Cancel button", "Pass" });
		} catch (Exception e) {
			testresultdata.put("12", new Object[] { 12d, TestCaseName,
					"Upload document pop up should be disappear once click on Cancel button", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}	
	}	
	
//	@Test
	public void verifyEditJobDescriptionFunctionality() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that user can edit the job description of requirement";
		test = extent.createTest(TestCaseName);
		
        String searchRequirement = "Req-264587-6";		
		
        try {
		Thread.sleep(3000);
		requirementPage.setSearchTextBox(searchRequirement);
		Thread.sleep(2000);
		try {
			requirementPage.setClickOnFirstRowRequirement_id();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}		
		requirementPage.setClickOnJobDescriptionOption();
		
		requirementPage.setClickOnEditButton();
		
		Thread.sleep(2000);
		String jobDescription = "Must Have Skills - SAP MDG,SAP MDM\r\n" + 
				                 "Nice to have skills";
		requirementPage.setEnterDescription(jobDescription);
		
		Thread.sleep(2000);
		requirementPage.setClickUpdateDescriptionButton();
		
		Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(), "Job Description Updated Successfully");
		
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("13", new Object[] { 13d, TestCaseName,
				"User should be able to edit the job description of requirement", "Pass" });
		} catch (Exception e) {
			testresultdata.put("13", new Object[] { 13d, TestCaseName,
					"User should be able to edit the job description of requirement", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}	
	}
	
//	@Test
	public void verifyArchivedRequirementFunctionality() {
		String TestCaseName = "Verify that user can Archive the requirement";
		test = extent.createTest(TestCaseName);

		String searchRequirement = "Req-264587-6";

		try {
			requirementPage.setClickOnAllTag();
			Thread.sleep(3000);
			requirementPage.setSearchTextBox(searchRequirement);
			Thread.sleep(7000);

			requirementPage.setClickArchiveOption();
			requirementPage.setselectArchiveOption("Yes");
			Thread.sleep(2000);
			requirementPage.setClickClosureDate();
			Thread.sleep(2000);
			requirementPage.selectStartYear_ClosureDate("2019");
			Thread.sleep(2000);
			requirementPage.selectMonth_ClosureDate("Oct");
			Thread.sleep(2000);
			requirementPage.setSelectDate_ClosureDate("7");
			requirementPage.setSelectClosureReason("Duplicate");
			requirementPage.setClickOnArchiveButton();

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
					"Requirement '" + searchRequirement + "' Archived and Closed Successfully");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("14",
					new Object[] { 14d, TestCaseName, "User should be able to archive the requirement", "Pass" });
		} catch (Exception e) {
			testresultdata.put("14",
					new Object[] { 14d, TestCaseName, "User should be able to archive the requirement", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test
	public void verifyUnArchivedRequirementFunctionality() {
		String TestCaseName = "Verify that user can Un-Archive the requirement";
		test = extent.createTest(TestCaseName);

		String searchRequirement = "Req-264587-6";

		try {
			requirementPage.setClickOnAllTag();
			Thread.sleep(3000);
			requirementPage.setSearchTextBox(searchRequirement);
			Thread.sleep(7000);

			requirementPage.setClickArchiveOption();
			requirementPage.setselectArchiveOption("No");
			Thread.sleep(2000);
			requirementPage.setClickOnSaveButtonForUnArchived();

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
					"Requirement '" + searchRequirement + "' UnArchived Successfully");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("15",
					new Object[] { 15d, TestCaseName, "User should be able to un-archive the requirement", "Pass" });
		} catch (Exception e) {
			testresultdata.put("15",
					new Object[] { 15d, TestCaseName, "User should be able to un-archive the requirement", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test
	public void verifyValidationMessageForClosuredate() {
		String TestCaseName = "Verify that user can select closure date select as future date while Archive the requirement";
		test = extent.createTest(TestCaseName);

		String searchRequirement = "Req-264587-6";

		try {
			requirementPage.setClickOnAllTag();
			Thread.sleep(3000);
			requirementPage.setSearchTextBox(searchRequirement);
			Thread.sleep(7000);

			requirementPage.setClickArchiveOption();
			requirementPage.setselectArchiveOption("Yes");
			Thread.sleep(2000);
			requirementPage.setClickClosureDate();
			Thread.sleep(2000);
			requirementPage.selectStartYear_ClosureDate("2020");
			Thread.sleep(2000);
			requirementPage.selectMonth_ClosureDate("Mar");
			Thread.sleep(2000);
			requirementPage.setSelectDate_ClosureDate("7");
						
			Assert.assertEquals(requirementPage.setClosureDateValidationMessage(),
					"Closure date cannot be a date in the future");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("16", new Object[] { 16d, TestCaseName,
					"validation message should be appear 'Closure date cannot be a date in the future'", "Pass" });
		} catch (Exception e) {
			testresultdata.put("16", new Object[] { 16d, TestCaseName,
					"validation message should be appear 'Closure date cannot be a date in the future'", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	
//  @Test
	public void verifyValidationMessageForClosureReason() {
		String TestCaseName = "Verify that user can archive the requirement without selecting closure reason";
		test = extent.createTest(TestCaseName);

		String searchRequirement = "Req-264587-6";

		try {
			requirementPage.setClickOnAllTag();
			Thread.sleep(3000);
			requirementPage.setSearchTextBox(searchRequirement);
			Thread.sleep(7000);

			requirementPage.setClickArchiveOption();
			requirementPage.setselectArchiveOption("Yes");
			Thread.sleep(2000);
			requirementPage.setClickClosureDate();
			Thread.sleep(2000);
			requirementPage.selectStartYear_ClosureDate("2019");
			Thread.sleep(2000);
			requirementPage.selectMonth_ClosureDate("Mar");
			Thread.sleep(2000);
			requirementPage.setSelectDate_ClosureDate("7");
			Thread.sleep(2000);
			requirementPage.setClickOnArchiveButton();
			
			Assert.assertEquals(requirementPage.setClosureReasonValidationMessage(),
					"Please Select Closure Reason");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("17", new Object[] { 17d, TestCaseName,
					"validation message should be appear 'Please Select Closure Reason'", "Pass" });
		} catch (Exception e) {
			testresultdata.put("17", new Object[] { 17d, TestCaseName,
					"validation message should be appear 'Please Select Closure Reason'", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void verifyCancelButtonFunctionalityOfArchiveRequirementPopUp() {
		String TestCaseName = "Verify the Cancel Button Functionality Of Archive Requirement pop up ";
		test = extent.createTest(TestCaseName);

		String searchRequirement = "Req-264587-6";

		try {
			requirementPage.setClickOnAllTag();
			Thread.sleep(3000);
			requirementPage.setSearchTextBox(searchRequirement);
			Thread.sleep(7000);

			requirementPage.setClickArchiveOption();
			requirementPage.setselectArchiveOption("Yes");
			Thread.sleep(2000);
			requirementPage.setClickOnCancelButtonFromArchivedPopUp();

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("18", new Object[] { 18d, TestCaseName,
					"Archived pop up should be closed once click on Cancel button", "Pass" });
		} catch (Exception e) {
			testresultdata.put("18", new Object[] { 18d, TestCaseName,
					"Archived pop up should be closed once click on Cancel button'", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}


}
