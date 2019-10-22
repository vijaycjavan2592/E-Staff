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

public class RequirementPageTest extends TestBase {

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

     @Test(priority = 1)
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

	@Test(priority = 2)
	public void getOpenRequirementCount() throws InterruptedException {

		String TestCaseName = "Verify the Open Requirement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			// Thread.sleep(5000);
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

	@Test(priority = 3)
	public void getAllRequirementCount() throws InterruptedException {

		String TestCaseName = "Verify the All Requirement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			// Click on All tag
			requirementPage.setClickOnAllTag();
			// Thread.sleep(5000);
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

	@Test(priority = 4)
	public void getArchivedRequirementCount() throws InterruptedException {

		String TestCaseName = "Verify the Archived Requirement count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			// Click on Archived tag
			requirementPage.setClickOnArchivedTag();
			// Thread.sleep(5000);
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

	@Test(priority = 5)
	public void verifyAddNewRequirementBtnClickable() {
		String TestCaseName = "Verify Add New Button is Clickable and it Shows the Add New Requirement Form";
		test = extent.createTest(TestCaseName);

		try {
			// Click on Add New link
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

	@Test(priority = 6)
	public void verifyFunctionalityOfCancelButtonOfAddNewForm() {
		String TestCaseName = "Verify that functionality of Cancel button of Add New Requirement window";
		test = extent.createTest(TestCaseName);

		try {
			// Click on Add New link
			Thread.sleep(2000);
			requirementPage.setClickAddNewLink();
			Thread.sleep(1000);
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("AddNew_Requirement_page_url"));

			// Click on Cancel button
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

	@Test(dataProvider = "getRequirementData", priority = 7)
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
			Thread.sleep(3000);
			requirementId = requirementPage.setRequirementId();
			System.out.println("Requirement id is : "+requirementId);
			// Select Recruiter
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

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
					"Requirement '" + requirementId + "' Added Successfully");

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

	@Test(dataProvider = "getRequirementData_edit", priority = 8)
	public void verifyEditRequirementFunctionality(String recruiter, String no_Of_Openings, String contact,
			String accountManger, String jobTitle, String jobType, String year, String month, String date,
			String businessUnit, String visaStatus, String priority, String communicationSkills, String billRateUOM,
			String payRateUOM, String country, String state, String city, String primarySkills, String SecondarySkills,
			String OptionalSkills, String ShortDescription, String Description) throws InterruptedException {
		String TestCaseName = "Verify that user can edit the Requirement";
		test = extent.createTest(TestCaseName);

		String searchRequirement = requirementId;

		try {
			// Click on Add New link
			Thread.sleep(3000);
			requirementPage.setSearchTextBox(searchRequirement);
			Thread.sleep(2000);
			requirementPage.setClickOnFirstRowRequirement_id();
			Thread.sleep(2000);
			requirementPage.setClickOnEditButton();

			Thread.sleep(2000);
			String requirement_id = requirementPage.setRequirementId();
			String requirementId_Edit = requirementPage.setRequirementId();
			System.out.println("Edit Requirement id is : "+requirementId_Edit);
			// Select Recruiter
			requirementPage.setselectRecruiter(recruiter);
			requirementPage.setEnterRequirementNoOfOpenings(no_Of_Openings);
			// requirementPage.setselectContact(contact);
			requirementPage.setselectAccountManager(accountManger);
			requirementPage.setEnterJobTitle(jobTitle);
			requirementPage.setselectJobType(jobType);
			/*
			 * requirementPage.clickDateBox(); Thread.sleep(2000);
			 * requirementPage.selectStartYear(year); Thread.sleep(2000);
			 * requirementPage.selectMonth(month); Thread.sleep(2000);
			 * requirementPage.setSelectDate(date);
			 */ Thread.sleep(1000);

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

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
					"Requirement '" + searchRequirement + "' Updated Successfully");

			Thread.sleep(3000);
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("8", new Object[] { 8d, TestCaseName,
					"User should be able to edit requirement into the system", "Pass" });
		} catch (Exception e) {
			testresultdata.put("8",
					new Object[] { 8d, TestCaseName, "User should be able edit requirement into the system", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 9)
	public void verifyUploadDocumentFunctionality() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that user can upload the document for particular requirement";
		test = extent.createTest(TestCaseName);

		String searchRequirement = requirementId;

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

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
					"Upload Document Record created successfully");

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

	@Test(priority = 10)
	public void verifyUploadDocumentAppearInGrid() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that upload document can appear in grid";
		test = extent.createTest(TestCaseName);

		String searchRequirement = requirementId;

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
			testresultdata.put("10",
					new Object[] { 10d, TestCaseName, "Uploaded document should be appear in grid section", "Pass" });
		} catch (Exception e) {
			testresultdata.put("10",
					new Object[] { 10d, TestCaseName, "Uploaded document should be appear in grid section", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 11)
	public void verifyDownloadUploadedDocument_requirement() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that user can download the uploaded documents";
		test = extent.createTest(TestCaseName);

		String searchRequirement = requirementId;

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

	@Test(priority = 12)
	public void verifyCancelBtnFunOfUploadDocPopUp_requirement() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that cancel button functionality of Upload Document pop-up";
		test = extent.createTest(TestCaseName);

		String searchRequirement = requirementId;

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

	@Test(priority = 13)
	public void verifyEditJobDescriptionFunctionality() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that user can edit the job description of requirement";
		test = extent.createTest(TestCaseName);

		String searchRequirement = requirementId;

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
			String jobDescription = "Must Have Skills - SAP MDG,SAP MDM\r\n" + "Nice to have skills";
			requirementPage.setEnterDescription(jobDescription);

			Thread.sleep(2000);
			requirementPage.setClickUpdateDescriptionButton();

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
					"Job Description Updated Successfully");

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

	@Test(priority = 14)
	public void verifyArchivedRequirementFunctionality() {
		String TestCaseName = "Verify that user can Archive the requirement";
		test = extent.createTest(TestCaseName);

		//String searchRequirement = requirementId;

		try {
			//requirementPage.setClickOnAllTag();
		
		//	requirementPage.setSearchTextBox(searchRequirement);
			Thread.sleep(7000);

			String requirementID = requirementPage.getTextOfRequirement_id();
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
					"Requirement '" + requirementID + "' Archived and Closed Successfully");

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

	@Test(priority = 15)
	public void verifyUnArchivedRequirementFunctionality() {
		String TestCaseName = "Verify that user can Un-Archive the requirement";
		test = extent.createTest(TestCaseName);

	//	String searchRequirement = requirementId;

		try {
			requirementPage.setClickOnArchivedTag();;
	
		//	requirementPage.setSearchTextBox(searchRequirement);
			Thread.sleep(7000);

			String requirementID = requirementPage.getTextOfRequirement_id();
			requirementPage.setClickArchiveOption();
			requirementPage.setselectArchiveOption("No");
			Thread.sleep(2000);
			requirementPage.setClickOnSaveButtonForUnArchived();

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
					"Requirement '" + requirementID + "' UnArchived Successfully");

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

	@Test(priority = 16)
	public void verifyValidationMessageForClosuredate() {
		String TestCaseName = "Verify that user can select closure date select as future date while Archive the requirement";
		test = extent.createTest(TestCaseName);

	//	String searchRequirement = requirementId;

		try {
		//	requirementPage.setClickOnAllTag();
			Thread.sleep(3000);
		//	requirementPage.setSearchTextBox(searchRequirement);
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

	@Test(priority = 17)
	public void verifyValidationMessageForClosureReason() {
		String TestCaseName = "Verify that user can archive the requirement without selecting closure reason";
		test = extent.createTest(TestCaseName);

	//	String searchRequirement = requirementId;

		try {
		//	requirementPage.setClickOnAllTag();
			Thread.sleep(3000);
		//	requirementPage.setSearchTextBox(searchRequirement);
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

			Assert.assertEquals(requirementPage.setClosureReasonValidationMessage(), "Please Select Closure Reason");

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

	@Test(priority = 18)
	public void verifyCancelButtonFunctionalityOfArchiveRequirementPopUp() {
		String TestCaseName = "Verify the Cancel Button Functionality Of Archive Requirement pop up ";
		test = extent.createTest(TestCaseName);

	//	String searchRequirement = requirementId;

		try {
		//	requirementPage.setClickOnAllTag();
			Thread.sleep(3000);
		//	requirementPage.setSearchTextBox(searchRequirement);
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

	@Test(priority = 19)
	public void verifyValidationsForAddNewRequirement() {
		String TestCaseName = "Verify that validation message can appear for mandatory fields";
		test = extent.createTest(TestCaseName);

		try {
			// Click on Add New link
			Thread.sleep(2000);
			requirementPage.setClickAddNewLink();
			Thread.sleep(1000);
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("AddNew_Requirement_page_url"));

			// Click on Cancel button
			requirementPage.setClickContinueButton();

			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'Recruiter is required.')]")).getText(),
					"Recruiter is required.");

			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'No Of openings is required.')]")).getText(),
					"No Of openings is required.");

			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'Contact is required.')]")).getText(),
					"Contact is required.");

			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'Account Manager is required.')]")).getText(),
					"Account Manager is required.");

			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'Job Title is required.')]")).getText(),
					"Job Title is required.");

			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'Job Type is required.')]")).getText(),
					"Job Type is required.");

			Assert.assertEquals(driver
					.findElement(By.xpath("//div[contains(text(),'Start Date is required in format (MM/DD/YYYY).')]"))
					.getText(), "Start Date is required in format (MM/DD/YYYY).");

			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'Business Unit is required.')]")).getText(),
					"Business Unit is required.");

			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'Visa Status is required.')]")).getText(),
					"Visa Status is required.");

			Assert.assertEquals(driver
					.findElement(By.xpath("//div[contains(text(),'Communication Skills is required.')]")).getText(),
					"Communication Skills is required.");

			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'Bill Rate UOM is required.')]")).getText(),
					"Bill Rate UOM is required.");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("19", new Object[] { 19d, TestCaseName,
					"validation message should be appear for mandatory fields", "Pass" });
		} catch (Exception e) {
			testresultdata.put("19", new Object[] { 19d, TestCaseName,
					"validation message should be appear for mandatory fields'", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 20)
	public void verifyConsultantMapToRequirement() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that user can map the consultant to the requirement";
		String TestCaseName1 = "Verify that mapped consultant can appear in Requirement-Consultant grid section";
		test = extent.createTest(TestCaseName);
		test = extent.createTest(TestCaseName1);

		/*String searchRequirement = requirementId;
		String searchConsultant = "42486005";*/

		try {
			Thread.sleep(3000);
		//	requirementPage.setClickOnAllTag();
		//	requirementPage.setSearchTextBox(searchRequirement);
			Thread.sleep(2000);
			try {
				requirementPage.setClickOnFirstRowRequirement_id();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			requirementPage.setClickOnConsultantOption();

			requirementPage.setClickOnSearchConsultantButton();
			Thread.sleep(2000);

		//	requirementPage.setClickOnAllTag_Consultant();
		//	requirementPage.setConsultantSearchTextBox(searchConsultant);
			Thread.sleep(2000);
			String consultantName = requirementPage.setConsultantName();
			requirementPage.setSelectConsultant();

			requirementPage.setClickOnShortlistConsultantOptionButton();

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
					"Consultants shortlisted successfully.");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("20", new Object[] { 20d, TestCaseName,
					"User should be able to map the consultant to the requirement", "Pass" });

			try {
				requirementPage.setClickOnConsultantOption();
				Thread.sleep(3000);
				Assert.assertEquals(requirementPage.setConsultantName_InRequirement(), consultantName);

				test.log(Status.PASS, TestCaseName + " is sucessfully pass");
				testresultdata.put("21", new Object[] { 21d, TestCaseName1,
						"Mapped consultant should be appear in requirement-consultant grid section", "Pass" });

			} catch (Exception e) {
				testresultdata.put("20", new Object[] { 20d, TestCaseName,
						"User should be able to map the consultant to the requirement", "Fail" });
				e.printStackTrace();
				Assert.fail();
			}

		} catch (Exception e) {
			testresultdata.put("21", new Object[] { 21d, TestCaseName1,
					"Mapped consultant should be appear in requirement-consultant grid section", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test(priority = 22)
	public void verifyConsultantMapToRequirement_alreadyExists() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that user can map the consultant to the requirement which is already linked.";
		test = extent.createTest(TestCaseName);

	/*	String searchRequirement = requirementId;
		String searchConsultant = "42486005";*/

		try {
			Thread.sleep(3000);
		/*	requirementPage.setClickOnAllTag();
			requirementPage.setSearchTextBox(searchRequirement);*/
			Thread.sleep(2000);
			try {
				requirementPage.setClickOnFirstRowRequirement_id();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			requirementPage.setClickOnConsultantOption();

			requirementPage.setClickOnSearchConsultantButton();
			Thread.sleep(2000);

		/*	requirementPage.setClickOnAllTag_Consultant();
			requirementPage.setConsultantSearchTextBox(searchConsultant);*/
			Thread.sleep(2000);
			requirementPage.setSelectConsultant();

			requirementPage.setClickOnShortlistConsultantOptionButton();

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
					"Duplicate status can not be set as Shortlisted status already exists.");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("22", new Object[] { 22d, TestCaseName,
					"Message should be appear 'Duplicate status can not be set as Shortlisted status already exists.",
					"Pass" });
		} catch (Exception e) {
			testresultdata.put("22", new Object[] { 22d, TestCaseName,
					"Message should be appear 'Duplicate status can not be set as Shortlisted status already exists.",
					"Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 23)
	public void verifyArchivedConsultantMapToRequirement() {
		String TestCaseName = "Verify that archived consultant can map to the requirement";
		test = extent.createTest(TestCaseName);

		try {
			Thread.sleep(3000);
		//	requirementPage.setClickOnAllTag();
			Thread.sleep(2000);
			try {
				requirementPage.setClickOnFirstRowRequirement_id();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			requirementPage.setClickOnConsultantOption();

			requirementPage.setClickOnSearchConsultantButton();
			Thread.sleep(2000);

			requirementPage.setClickOnArchivedTag_Consultant();
			Thread.sleep(2000);
			String consultantName = requirementPage.setConsultantName();
			requirementPage.setSelectConsultant();

			requirementPage.setClickOnShortlistConsultantOptionButton();

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
					""+consultantName+" - Archived consultant can not be shortlisted.");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("23", new Object[] { 23d, TestCaseName,
					"Message should be appear 'Archived consultant can not be shortlisted.","Pass" });
		} catch (Exception e) {
			testresultdata.put("23", new Object[] { 23d, TestCaseName,
					"Message should be appear 'Archived consultant can not be shortlisted.","Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority = 24)
	public void verifyCancelBtnFunOfMapConsultantWindow() {
		String TestCaseName = "Verify the Cancel button functionality of map consultant to requirement window";
		test = extent.createTest(TestCaseName);

		try {
			Thread.sleep(3000);
		//	requirementPage.setClickOnAllTag();
			Thread.sleep(2000);
			try {
				requirementPage.setClickOnFirstRowRequirement_id();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			requirementPage.setClickOnConsultantOption();

			requirementPage.setClickOnSearchConsultantButton();
			Thread.sleep(2000);

			requirementPage.setClickOnAllTag_Consultant();
			Thread.sleep(2000);
			
			requirementPage.setSelectConsultant();

			requirementPage.setClickOnCancelButtonFromMapConsultantPage();

			Thread.sleep(2000);
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("24", new Object[] { 24d, TestCaseName,
					"Mapping of consultant to Requirement should be cancel after click on Cancel button","Pass" });
		} catch (Exception e) {
			testresultdata.put("24", new Object[] { 24d, TestCaseName,
					"Mapping of consultant to Requirement should be cancel after click on Cancel button","Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority = 25)
	public void verifyAddNoteFunctionality() throws InterruptedException {
		String TestCaseName = "Verify the Add Note functionality";
		test = extent.createTest(TestCaseName);

		try {
	//	requirementPage.setClickOnAllTag();
		
		Thread.sleep(2000);
		try {
			requirementPage.setClickOnFirstRowRequirement_id();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}
		
		requirementPage.setClickOnAddNoteLink();
		Thread.sleep(1000);
		requirementPage.setEnterNoteInTextBox("Test- Test");
		Thread.sleep(2000);
		requirementPage.setClickOnAddNoteButton();
		
		Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(), "Note added Successfully");
		
		Thread.sleep(2000);
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("25", new Object[] { 25d, TestCaseName,
				"User should be able to add note in requirement","Pass" });
	    } catch (Exception e) {
	    	testresultdata.put("25", new Object[] { 25d, TestCaseName,
				"User should be able to add note in requirement","Fail" });
	    	e.printStackTrace();
	    	Assert.fail();
	    	}
	    }
	
	@Test(priority = 26)
	public void verifyCancelBtnFunOfAddNote() throws InterruptedException {
		String TestCaseName = "Verify the Cancel button functionality of Add Note";
		test = extent.createTest(TestCaseName);

		try {
	//	requirementPage.setClickOnAllTag();
		
		Thread.sleep(2000);
		try {
			requirementPage.setClickOnFirstRowRequirement_id();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}
		
		requirementPage.setClickOnAddNoteLink();
		Thread.sleep(1000);
		requirementPage.setEnterNoteInTextBox("Test- Test");
		Thread.sleep(2000);
		requirementPage.setClickOnCancelBtnOfAddNote();
		
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("26", new Object[] { 26d, TestCaseName,
				"Add note window should be disappear once click on Cancel button","Pass" });
	    } catch (Exception e) {
	    	testresultdata.put("26", new Object[] { 26d, TestCaseName,
				"Add note window should be disappear once click on Cancel button","Fail" });
	    	e.printStackTrace();
	    	Assert.fail();
	    	}
	    }
	
//	@Test(priority = 27)
	public void verifyNavigateToStatusPopUp() throws InterruptedException {
		String TestCaseName = "Verify the user can naviagte to the status pop up";
		test = extent.createTest(TestCaseName);
		
		try {
		//	requirementPage.setClickOnAllTag();
			
			Thread.sleep(2000);
			try {
				requirementPage.setClickOnFirstRowRequirement_id();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			//Click on Consultant option
			requirementPage.setClickOnConsultantOption();
			//click on Search Consultant button
			requirementPage.setClickOnSearchConsultantButton();
			Thread.sleep(2000);
			String consultantName = requirementPage.setConsultantName();
			requirementPage.setSelectConsultant();
			Thread.sleep(2000);
			//Click on Shortlist Consultant button
			requirementPage.setClickOnShortlistConsultantOptionButton();
			
			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),"Consultants shortlisted successfully.");
			
			Thread.sleep(3000);
			//Select the consultant
			requirementPage.setSelectConsultant();
			
			requirementPage.setClickOnStatusLink();
			
			Assert.assertEquals(requirementPage.setStatusPopUpTitle(), "Set Status");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("27", new Object[] { 27d, TestCaseName,
					"User should be able to navigate to the status pop up","Pass" });
		    } catch (Exception e) {
		    	testresultdata.put("27", new Object[] { 27d, TestCaseName,
					"User should be able to navigate to the status pop up","Fail" });
		    	e.printStackTrace();
		    	Assert.fail();
		    	}
		    }
			
	@Test(priority = 28)
	public void verifySetTheStatusToConsultant() throws InterruptedException {
		String TestCaseName = "Verify the user can set the status to the consultant";
		test = extent.createTest(TestCaseName);

		try {
			// requirementPage.setClickOnAllTag();

			Thread.sleep(5000);
			try {
				requirementPage.setClickOnFirstRowRequirement_id();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
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

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
					"Status has been updated successfully for Consultant " + "" + consultantName + "");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("28", new Object[] { 28d, TestCaseName,
					"User should be allow to set the status to the consultant", "Pass" });
		} catch (Exception e) {
			testresultdata.put("28", new Object[] { 28d, TestCaseName,
					"User should be allow to set the status to the consultant", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority = 29)
	public void verifyCancelButtonFunOfSetStatusPopUp() throws InterruptedException {
		String TestCaseName = "Verify that functionality of Cancel button functionality of Set-Status pop up";
		test = extent.createTest(TestCaseName);

		try {
			//requirementPage.setClickOnAllTag();
			Thread.sleep(5000);
			try {
				requirementPage.setClickOnFirstRowRequirement_id();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
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

			requirementPage.setClickOnCancelButtonOfSetStatusPopup();

		//	Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),
		//			"Status has been updated successfully for Consultant " + "" + consultantName + "");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("29", new Object[] { 29d, TestCaseName,
					"Set-Status pop up should be disappear after clicking Cancel button", "Pass" });
		} catch (Exception e) {
			testresultdata.put("29", new Object[] { 29d, TestCaseName,
					"Set-Status pop up should be disappear after clicking Cancel button", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(priority = 30)
	public void verifyDeleteRecentStatusFunctionality() throws InterruptedException {
		String TestCaseName = "Verify that user can delete recent status of linked consultant";
		test = extent.createTest(TestCaseName);

		try {
			//requirementPage.setClickOnAllTag();
			Thread.sleep(5000);
			try {
				requirementPage.setClickOnFirstRowRequirement_id();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			// Click on Consultant option
			requirementPage.setClickOnConsultantOption();
			Thread.sleep(2000);
			String consultantName = requirementPage.setConsultantName_InRequirement();
			// Select the consultant
			Thread.sleep(2000);
			requirementPage.setClickOnConsultantName();
			
			//Click on Delete Recent Status link
			requirementPage.setClickOnDeleteRecentStatus();
			
			//Click on Delete button of pop up
			requirementPage.setClickOnDeleteButton();

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),"Status Deleted Successfully");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("30", new Object[] { 30d, TestCaseName,
					"User should be able to delete the recent status of linked consultant", "Pass" });
		} catch (Exception e) {
			testresultdata.put("30", new Object[] { 30d, TestCaseName,
					"User should be able to delete the recent status of linked consultant", "Fail" });
			e.printStackTrace();
		}
	}


	@Test(priority = 31)
	public void verifyViewResumeFunctionality() throws InterruptedException {
		String TestCaseName = "Verify that user can view(download) CV/Resume of linked consultant";
		test = extent.createTest(TestCaseName);

		try {
			//requirementPage.setClickOnAllTag();
			Thread.sleep(5000);
			try {
				requirementPage.setClickOnFirstRowRequirement_id();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			// Click on Consultant option
			requirementPage.setClickOnConsultantOption();
			Thread.sleep(2000);
			String consultantName = requirementPage.setConsultantName_InRequirement();
			// Select the consultant
			Thread.sleep(2000);
			requirementPage.setClickOnConsultantName();
			//click on View CV/Resume link
			requirementPage.setClickOnViewResumeLink();

			Assert.assertEquals(requirementPage.setRequirementConfirmationMessage(),"File downloaded successfully");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("31", new Object[] { 31d, TestCaseName,
					"User should be able to view(download) the CV/Resume of linked consultant", "Pass" });
		} catch (Exception e) {
			testresultdata.put("31", new Object[] { 31d, TestCaseName,
					"User should be able to view(download) the CV/Resume of linked consultant", "Fail" });
			e.printStackTrace();
		}
	}
	
	

}
