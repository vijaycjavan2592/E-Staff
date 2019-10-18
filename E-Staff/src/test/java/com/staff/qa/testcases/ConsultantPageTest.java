package com.staff.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.staff.qa.base.TestBase;
import com.staff.qa.pages.ConsultantPage;
import com.staff.qa.pages.HomePage;
import com.staff.qa.pages.LoginPage;
import com.staff.qa.util.TestUtil;



public class ConsultantPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ConsultantPage consultantPage;
	
	String sheetName = "Consultant";
	String sheetName_EditConsultant = "Edit_Consultant";
	
	static String consultantID;

	public ConsultantPageTest() {
		super();		
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp() throws InterruptedException {
		initialization();
		consultantPage = new ConsultantPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		consultantPage = homePage.clickOnConsultantOption();
	}

	@Test(priority = 1,groups = {"regression"})
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

	@Test(priority = 2,groups = {"regression"})
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
	
	@DataProvider
	public Object[][] getEStaffData() throws IOException {

		Object data[][] = TestUtil.getData(sheetName);

		return data;
	}
	
	@Test(dataProvider = "getEStaffData",priority = 3,groups = {"regression"})
	public void verifyAddNewConsultant(String Firstname, String Lastname, String emailId, String mobileno,String rate,
			String UOMRate, String Year, String Month, String date, String Availability_Notice, String Can_Relocate_To,
			String EmploymentType, String CandidateSource, String VisaStatus, String Country, String State, String City,
			String PrimarySkills, String SecondarySkills, String OtherSkills, String Summary)
			throws InterruptedException, AWTException {
		
		String TestCaseName = "Verify that user can add new consultant into the system";
		test = extent.createTest(TestCaseName);
		
		String TestCaseName2 = "To Check the new added consultant can appear in Gird section";
		test = extent.createTest(TestCaseName2);

		try {
		consultantPage.setClickAddNewMenu();
		Thread.sleep(1000);
		consultantPage.setClickAddManuallyOption();
		Thread.sleep(1000);
		consultantID = consultantPage.setConsultantId();
		consultantPage.fillAddNewConsultantForm(Firstname, Lastname, emailId, mobileno);
		consultantPage.setselectUOMRate(UOMRate);

		Thread.sleep(1000);
		consultantPage.clickDateBox();
		consultantPage.selectAvailabilityDate(Year);
		Thread.sleep(2000);
		consultantPage.selectMonth(Month);
		Thread.sleep(2000);
		consultantPage.setSelectDate(date);

		Thread.sleep(1000);
		consultantPage.setselectAvailabilityNotice(Availability_Notice);

		Thread.sleep(1000);
		consultantPage.setselectCanRelocateTo(Can_Relocate_To);		

		consultantPage.setselectEmploymentType(EmploymentType);

		consultantPage.setselectCandidateSource(CandidateSource);

		consultantPage.setselectVisaStatus(VisaStatus);

		consultantPage.setselectCountry(Country);
		Thread.sleep(1000);
		consultantPage.setselectState(State);
		Thread.sleep(1000);
		consultantPage.setselectCity(City);

		consultantPage.setClickOnContinueButton();

		Thread.sleep(1000);
		consultantPage.setEnterConsultantPrimarySkills(PrimarySkills);

		consultantPage.setEnterConsultantSecondarySkills(SecondarySkills);

		consultantPage.setEnterConsultantOtherSkills(OtherSkills);

		consultantPage.setEnterSummary(Summary);
		Thread.sleep(1000);
		consultantPage.setClickOnContinueButton_Skill();

		Thread.sleep(2000);
		consultantPage.setUploadResume("C:\\Users\\chavan_v\\Downloads\\Danish_Araquei_-_Resume.doc");

		consultantPage.setClickOnAddConsultantButton();
		Thread.sleep(2000);		
		
		Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "Consultant (ID:-"+consultantID+") Added Successfully");

		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("13",
				new Object[] { 13d, TestCaseName,"System should should be allow to add new consultant", "Pass" });
		}
		catch(Exception e) {
			testresultdata.put("13",
					new Object[] { 13d, TestCaseName,"System should should be allow to add new consultant", "Fail" });
			e.printStackTrace();
			Assert.fail();			
		}
		
		try {
		consultantPage.setClickOnAllTag();
		Thread.sleep(5000);
		Assert.assertEquals(consultantPage.setConsultantOnGrid_GetText(), Firstname +" "+ Lastname);

		test.log(Status.PASS, TestCaseName2 + " is sucessfully pass");
		testresultdata.put("14",
				new Object[] { 14d, TestCaseName2,"New added consultant should appear in grid section", "Pass" });
		}
		catch(Exception e) {
			testresultdata.put("14",
					new Object[] { 14d, TestCaseName2,"New added consultant should appear in grid section", "Fail" });
			e.printStackTrace();
			Assert.fail();			
		}
	}	
		
	
	@Test(dataProvider = "getEStaffData",priority = 5,groups = {"regression"})
	public void verifyDuplicateConsultant(String Firstname, String Lastname, String emailId, String mobileno,String rate, 
			String UOMRate, String Year, String Month, String date, String Availability_Notice, String Can_Relocate_To,
			String EmploymentType, String CandidateSource, String VisaStatus, String Country, String State, String City,
			String PrimarySkills, String SecondarySkills, String OtherSkills, String Summary)
			throws InterruptedException, AWTException {
		String TestCaseName = "Verify that user can create duplicate consultant into the system";
		test = extent.createTest(TestCaseName);

		try {
		consultantPage.setClickAddNewMenu();
		Thread.sleep(1000);
		consultantPage.setClickAddManuallyOption();
		Thread.sleep(1000);
		String consultantID = consultantPage.setConsultantId();
		consultantPage.fillAddNewConsultantForm(Firstname, Lastname, emailId, mobileno);
		consultantPage.setselectUOMRate(UOMRate);

		Thread.sleep(1000);
		consultantPage.clickDateBox();
		consultantPage.selectAvailabilityDate(Year);
		Thread.sleep(2000);
		consultantPage.selectMonth(Month);
		Thread.sleep(2000);
		consultantPage.setSelectDate(date);

		Thread.sleep(1000);
		consultantPage.setselectAvailabilityNotice(Availability_Notice);

		Thread.sleep(1000);
		consultantPage.setselectCanRelocateTo(Can_Relocate_To);
		

		consultantPage.setselectEmploymentType(EmploymentType);

		consultantPage.setselectCandidateSource(CandidateSource);

		consultantPage.setselectVisaStatus(VisaStatus);

		consultantPage.setselectCountry(Country);
		Thread.sleep(1000);
		consultantPage.setselectState(State);
		Thread.sleep(1000);
		consultantPage.setselectCity(City);

		consultantPage.setClickOnContinueButton();

		Thread.sleep(1000);
		consultantPage.setEnterConsultantPrimarySkills(PrimarySkills);

		consultantPage.setEnterConsultantSecondarySkills(SecondarySkills);

		consultantPage.setEnterConsultantOtherSkills(OtherSkills);

		consultantPage.setEnterSummary(Summary);
		Thread.sleep(1000);
		consultantPage.setClickOnContinueButton_Skill();

		Thread.sleep(2000);
		consultantPage.setUploadResume("C:\\Users\\chavan_v\\Downloads\\Danish_Araquei_-_Resume.doc");

		consultantPage.setClickOnAddConsultantButton();
		Thread.sleep(2000);		
		
		Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "Consultant is already exists with same email-id. Duplicate Consultant can not be created.");

		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("15",
				new Object[] { 15d, TestCaseName,"System should not be allow to add duplicate consultant", "Pass" });
		}
		catch(Exception e) {
			testresultdata.put("15",
					new Object[] { 15d, TestCaseName,"System should not be allow to add duplicate consultant", "Fail" });
			e.printStackTrace();
			Assert.fail();			
		}
	}	

	
	@Test(priority = 6,groups = {"regression"})
	public void verifyFunctionalityOfCancelButton()
			throws InterruptedException, AWTException {
		String TestCaseName = "Verify that functionality of Cancel button of Add New Consultant window";
		test = extent.createTest(TestCaseName);

		try {
		consultantPage.setClickAddNewMenu();
		Thread.sleep(1000);
		consultantPage.setClickAddManuallyOption();
		Thread.sleep(1000);
		consultantPage.setClickOnCancelButton();

		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("consultant_page_url"));

		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("16",
				new Object[] { 16d, TestCaseName,"Add new consultant window should be disappear after clicking Cancel button", "Pass" });
		}
		catch(Exception e) {
			testresultdata.put("16",
					new Object[] { 16d, TestCaseName,"Add new consultant window should be disappear after clicking Cancel button", "Fail" });
			e.printStackTrace();
			Assert.fail();			
		}
	}	

	
	@Test(priority = 7,groups = {"regression"})
	public void getAvailableCount() throws InterruptedException {

		String TestCaseName = "Verify the Available consultants count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {
			Thread.sleep(5000);
			consultantPage.setTotalConsultantcountLabel();
			Assert.assertEquals(consultantPage.setTotalConsultantcountLabel(),
					"Available Consultants (" + consultantPage.setAllConsultantCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("17", new Object[] { 17d, TestCaseName,
					" Available consultants count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("17", new Object[] { 17d, TestCaseName,
					" Available consultants count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority = 8,groups = {"regression"})
	public void getAllCount() throws InterruptedException {

		String TestCaseName = "Verify the All consultants count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {			
			consultantPage.setClickOnAllTag();
			Thread.sleep(6000);
			consultantPage.setTotalConsultantcountLabel();
			Assert.assertEquals(consultantPage.setTotalConsultantcountLabel(),
					"All Consultants (" + consultantPage.setAllConsultantCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("18", new Object[] { 18d, TestCaseName,
					" All consultants count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("18", new Object[] { 18d, TestCaseName,
					" All consultants count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(priority = 9,groups = {"regression"})
	public void getArchivedCount() throws InterruptedException {

		String TestCaseName = "Verify the Archived consultants count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {			
			consultantPage.setClickOnArchivedTag();
			Thread.sleep(6000);
			consultantPage.setTotalConsultantcountLabel();
			Assert.assertEquals(consultantPage.setTotalConsultantcountLabel(),
					"Archived Consultants (" + consultantPage.setAllConsultantCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("19", new Object[] { 19d, TestCaseName,
					" Archived consultants count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("19", new Object[] { 19d, TestCaseName,
					" Archived consultants count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	
	@Test(priority = 10,groups = {"regression"})
	public void getQualifiedCount() throws InterruptedException {

		String TestCaseName = "Verify the Qualified consultants count in header and grid section";
		test = extent.createTest(TestCaseName);
		try {			
			consultantPage.setClickOnQualifiedTag();
			Thread.sleep(6000);
			consultantPage.setTotalConsultantcountLabel();
			Assert.assertEquals(consultantPage.setTotalConsultantcountLabel(),
					"Qualified Consultants (" + consultantPage.setAllConsultantCountInGrid() + ")");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("20", new Object[] { 20d, TestCaseName,
					" Qualified consultants count in header and grid section should be same", "Pass" });
		} catch (Exception e) {
			testresultdata.put("20", new Object[] { 20d, TestCaseName,
					" Qualified consultants count in header and grid section should be same", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	@DataProvider
	public Object[][] getEStaffData_EditConsultant() throws IOException {

		Object data[][] = TestUtil.getData(sheetName_EditConsultant);

		return data;
	}
	
	@Test(dataProvider = "getEStaffData_EditConsultant",priority = 11,groups = {"regression"},dependsOnMethods = { "verifyAddNewConsultant" })
	public void verifyEditConsultantFunctionality(String Firstname, String Lastname, String emailId, String mobileno,String rate,
			String UOMRate, String Year, String Month, String date, String Availability_Notice, String Can_Relocate_To,
			String EmploymentType, String CandidateSource, String VisaStatus, String Country, String State, String City, 
			String PrimarySkills, String SecondarySkills, String OtherSkills, String Summary) 
					throws InterruptedException, AWTException {
		String TestCaseName = "Verify that user edit the consultant into the system";
		test = extent.createTest(TestCaseName);
		
		String searchConsultant = consultantID;
		
		try {
		//Navigate to All Tag filter	
		consultantPage.setClickOnAllTag();
		consultantPage.setSearchTextBox(searchConsultant);
		
		Thread.sleep(2000);
		consultantPage.setClickOnFirstRowConsultant();
		
		try {
		Assert.assertEquals(consultantPage.setConsultantId(), searchConsultant);
		}
		catch(Exception e) {
			
		}	
		Thread.sleep(2000);
		consultantPage.setClickOnEditButton();
		
		consultantPage.fillAddNewConsultantForm(Firstname, Lastname, emailId, mobileno);
		consultantPage.setselectUOMRate(UOMRate);

	/*	Thread.sleep(1000);
		consultantPage.clickDateBox();
		consultantPage.selectAvailabilityDate(Year);
		Thread.sleep(2000);
		consultantPage.selectMonth(Month);
		Thread.sleep(2000);
		consultantPage.setSelectDate(date);*/

		Thread.sleep(1000);
		consultantPage.setselectAvailabilityNotice(Availability_Notice);

		Thread.sleep(1000);
		consultantPage.setselectCanRelocateTo(Can_Relocate_To);		

		consultantPage.setselectEmploymentType(EmploymentType);

		consultantPage.setselectCandidateSource(CandidateSource);

		consultantPage.setselectVisaStatus(VisaStatus);

		consultantPage.setselectCountry(Country);
		Thread.sleep(1000);
		consultantPage.setselectState(State);
		Thread.sleep(1000);
		consultantPage.setselectCity(City);

		consultantPage.setClickOnContinueButton();

		Thread.sleep(1000);
		consultantPage.setEnterConsultantPrimarySkills(PrimarySkills);

		consultantPage.setEnterConsultantSecondarySkills(SecondarySkills);

		consultantPage.setEnterConsultantOtherSkills(OtherSkills);

		consultantPage.setEnterSummary(Summary);
		Thread.sleep(1000);
		consultantPage.setClickOnContinueButton_Skill();

		Thread.sleep(1000);
		consultantPage.setClickCancelButtonToRemoveResume();
		Thread.sleep(2000);
		consultantPage.setUploadResume("C:\\Users\\chavan_v\\Downloads\\Danish_Araquei_-_Resume.doc");

		consultantPage.setClickOnAddConsultantButton();
		Thread.sleep(2000);		

			Thread.sleep(2000);		
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "Consultant (ID:-"+searchConsultant+") Updated Successfully");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("21",
					new Object[] {21d, TestCaseName,"System should should be allow to update consultant", "Pass" });
			}
			catch(Exception e) {
				testresultdata.put("21",
						new Object[] {21d, TestCaseName,"System should should be allow to update consultant", "Fail" });
				e.printStackTrace();
				Assert.fail();			
			}		
	}
	
	
	@Test(priority = 12,groups = {"regression"})
	public void verifyUploadDocumentFunctionality() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that user can upload the document in to system";
		test = extent.createTest(TestCaseName);
		
		//String searchConsultant = prop.getProperty("Consultant_id");
		
		try {
		/*consultantPage.setClickOnAllTag();
		consultantPage.setSearchTextBox(searchConsultant);*/
		
		Thread.sleep(2000);
		try {
		consultantPage.setClickOnFirstRowConsultant();
		}
    	catch(Exception e) {
    		WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
    		System.out.println(noData.getText());
    	}
		consultantPage.setClickOnDocumentOption();
		
		consultantPage.setClickOnUploadDocumentLink();
		
		consultantPage.setEnterDocumentName("resume");
		
		consultantPage.setSelectDocumentType("Resume");
		
		consultantPage.setUploadDocument(prop.getProperty("document_upload_path"));
		
		Thread.sleep(3000);	
		consultantPage.setClickOnUploadButton();	
		
		
			Thread.sleep(2000);		
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "Upload Document Record created successfully");
			
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("22",
					new Object[] {22d, TestCaseName,"System should be allow to upload document", "Pass" });
			}
			catch(Exception e) {
				testresultdata.put("22",
						new Object[] {22d, TestCaseName,"System should be allow to upload document", "Fail" });
				e.printStackTrace();
				Assert.fail();			
			}		
		}

	@Test(priority = 13,groups = {"regression"})
	public void verifyUploadDocumentAppearInGrid() throws InterruptedException, AWTException {
		String TestCaseName = "Verify that upload document can appear in grid";
		test = extent.createTest(TestCaseName);

		//String searchConsultant = prop.getProperty("Consultant_id");
		try {
			/*consultantPage.setClickOnAllTag();
			consultantPage.setSearchTextBox(searchConsultant);*/

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			consultantPage.setClickOnDocumentOption();

			consultantPage.setClickOnUploadDocumentLink();

			String document_Name = "Resume";
			consultantPage.setEnterDocumentName(document_Name);

			consultantPage.setSelectDocumentType("Resume");

			consultantPage.setUploadDocument(prop.getProperty("document_upload_path"));

			Thread.sleep(3000);
			consultantPage.setClickOnUploadButton();

			Thread.sleep(2000);
			Assert.assertEquals(consultantPage.setDocumentNameInGrid(), document_Name);

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("23",
					new Object[] { 23d, TestCaseName, "Uploaded document should be appear in grid section", "Pass" });
		} catch (Exception e) {
			testresultdata.put("23",
					new Object[] { 23d, TestCaseName, "Uploaded document should be appear in grid section", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 14,groups = {"regression"})
	public void verifyDownloadUploadedDocument() throws InterruptedException {
		String TestCaseName = "Verify that user can download the uploaded documents";
		test = extent.createTest(TestCaseName);

		//String searchConsultant = prop.getProperty("Consultant_id");
		
		try {
		/*consultantPage.setClickOnAllTag();
		consultantPage.setSearchTextBox(searchConsultant);*/

		Thread.sleep(2000);
		try {
			consultantPage.setClickOnFirstRowConsultant();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}
		consultantPage.setClickOnDocumentOption();

		consultantPage.setDownloadUploadedDocument();

			Thread.sleep(2000);
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "File downloaded successfully");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("24", new Object[] { 24d, TestCaseName,
					"User should be able to download the uploaded documents", "Pass" });
		} catch (Exception e) {
			testresultdata.put("24", new Object[] { 24d, TestCaseName,
					"User should be able to download the uploaded documents", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority = 15,groups = {"regression"})
	public void verifyLinkRequirementToConsultant() throws InterruptedException {
		String TestCaseName = "Verify that user can link the requirement to the consultant";
		//String TestCaseName_duplicate = "Verify that user can link the requirement which is already linked. ";
		test = extent.createTest(TestCaseName);
		
		//String searchConsultant = prop.getProperty("Consultant_id");
		//String searchRequirement = prop.getProperty("Requirement_id");
		
		try {
	/*	consultantPage.setClickOnAllTag();
		consultantPage.setSearchTextBox(searchConsultant);*/
		Thread.sleep(2000);
		try {
			consultantPage.setClickOnFirstRowConsultant();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}				
		consultantPage.setClickOnRequirementOption();
		
		consultantPage.setClickOnLinkRequirementLink();
		
		//consultantPage.setSearchTextBox(searchRequirement);
		
		Thread.sleep(3000);
		consultantPage.setSelectRequirement();	
		
		Thread.sleep(2000);
		consultantPage.setClickOnLinkRequirementButton();
		
			Thread.sleep(1000);
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "Requirements are linked successfully.");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("25", new Object[] { 25d, TestCaseName,
					"User should be able to link the requirement to the consultant", "Pass" });
		}
	
		catch (Exception e) {
			testresultdata.put("25", new Object[] { 25d, TestCaseName,
					"User should be able to link the requirement to the consultant", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}		
	}

	
	@Test(priority = 16,groups = {"regression"})
	public void verifyLinkRequirementToConsultant_alreadyExists() throws InterruptedException {
		String TestCaseName = "Verify that user can link the requirement which is already linked. ";
		test = extent.createTest(TestCaseName);
		
		/*String searchConsultant = prop.getProperty("Consultant_id");
		String searchRequirement = prop.getProperty("Requirement_id");*/

		try {
		consultantPage.setClickOnAllTag();
		//consultantPage.setSearchTextBox(searchConsultant);

		Thread.sleep(2000);
		try {
			consultantPage.setClickOnFirstRowConsultant();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}				
		consultantPage.setClickOnRequirementOption();
		
		consultantPage.setClickOnLinkRequirementLink();
		Thread.sleep(2000);
	//	consultantPage.setSearchTextBox(searchRequirement);
		
		Thread.sleep(3000);
		consultantPage.setSelectRequirement();		
		
		consultantPage.setClickOnLinkRequirementButton();		
		
			Thread.sleep(2000);
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "Duplicate status can not be set as Shortlisted status already exists.");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("26", new Object[] { 26d, TestCaseName,
					"Message should be appear 'Duplicate status can not be set as Shortlisted status already exists.'", "Pass" });
		} 	
			
		catch (Exception e) {
			testresultdata.put("26", new Object[] { 26d, TestCaseName,
					"Message should be appear 'Duplicate status can not be set as Shortlisted status already exists.'", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}		
	}
	
	@Test(priority = 17,groups = {"regression"})
	public void verifyDownloadResumeFunctionality() throws InterruptedException {
		String TestCaseName = "Verify that user can download the consultant resume";
		test = extent.createTest(TestCaseName);
		
	//	String searchConsultant = prop.getProperty("Consultant_id");

		try {
		/*consultantPage.setClickOnAllTag();
		consultantPage.setSearchTextBox(searchConsultant);*/

		Thread.sleep(2000);
		try {
			consultantPage.setClickOnFirstRowConsultant();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}				
		consultantPage.setClickOnResumeOption();
		
		consultantPage.setClickOnDownloadResumeLink();
		
			Thread.sleep(2000);
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "File downloaded successfully");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("27", new Object[] { 27d, TestCaseName,
					"User should be able to download the consultant resume.", "Pass" });
		} 	
			
		catch (Exception e) {
			testresultdata.put("27", new Object[] { 27d, TestCaseName,
					"User should be able to download the consultant resume.", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}		
	}
		
	@Test(priority = 18,groups = {"regression"})
	public void verifyCancelFunctionalityOfLinkRequirement() {
		String TestCaseName = "Verify the Cancel button functionality of LinkRequirement to the consultant";
		test = extent.createTest(TestCaseName);
		
		/*String searchConsultant = prop.getProperty("Consultant_id");
		String searchRequirement = prop.getProperty("Requirement_id");*/

		try {
		/*consultantPage.setClickOnAllTag();
		consultantPage.setSearchTextBox(searchConsultant);*/

		Thread.sleep(2000);
		try {
			consultantPage.setClickOnFirstRowConsultant();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}				
		consultantPage.setClickOnRequirementOption();
		
		consultantPage.setClickOnLinkRequirementLink();
		Thread.sleep(2000);
		//consultantPage.setSearchTextBox(searchRequirement);
		
		Thread.sleep(2000);
		//consultantPage.setSelectRequirement();		
		
		consultantPage.setClickOnCancelButtonFromLinkRequirementPage();;		
		Thread.sleep(2000);
		
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("28", new Object[] { 28d, TestCaseName,
					"Link Requirement to consultant should be cancel after click on Cancel button", "Pass" });
		} 	
			
		catch (Exception e) {
			testresultdata.put("28", new Object[] { 28d, TestCaseName,
					"Link Requirement to consultant should be cancel after click on Cancel button", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}		
	}

	
	@Test(priority = 19,groups = {"regression"})
	public void verifyEmailFunctionality() {
		String TestCaseName = "Verify that user can send the Email to the Consultant";
		test = extent.createTest(TestCaseName);
		
		String searchConsultant = prop.getProperty("Consultant_id");
		
		try {
			consultantPage.setClickOnAllTag();
			consultantPage.setSearchTextBox(searchConsultant);

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}				

			consultantPage.setClickOnConsultantEmailLink();
			
			consultantPage.setEnterEmailSubject("Test");
			
			consultantPage.setEnterEmailBody("Test for email functionality");
			
			consultantPage.setClickOnSendButtonOfEmail();
			
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "Message sent successfully");
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("29", new Object[] { 29d, TestCaseName,
					"User should be able to send the Email to the consultant", "Pass" });
		} 	
			
		catch (Exception e) {
			testresultdata.put("29", new Object[] { 29d, TestCaseName,
					"User should be able to send the Email to the consultant", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}		
	}
	

	@Test(priority = 20,groups = {"regression"})
	public void verifyCancelButtonFunctionalityOfEmail() {
		String TestCaseName = "Verify that user can cancel the composed Email";
		test = extent.createTest(TestCaseName);
		
		//String searchConsultant = prop.getProperty("Consultant_id");
		
		try {
			/*consultantPage.setClickOnAllTag();
			consultantPage.setSearchTextBox(searchConsultant);*/

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}				

			consultantPage.setClickOnConsultantEmailLink();
			
			consultantPage.setEnterEmailSubject("Test");
			
			consultantPage.setEnterEmailBody("Test");
			
			consultantPage.setClickOnCancelButtonOfEmail();
			
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("30", new Object[] { 30d, TestCaseName,
					"User should be able to cancel the composed Email", "Pass" });
		} 	
			
		catch (Exception e) {
			testresultdata.put("30", new Object[] { 30d, TestCaseName,
					"User should be able to cancel the composed Email", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}		
	}
	
	@Test(priority = 21)
	public void verifyValidationForEmailSubject() {
		String TestCaseName = "Verify that validation message can appear for email-Subject";
		test = extent.createTest(TestCaseName);
		
		String searchConsultant = prop.getProperty("Consultant_id");
		
		try {
			consultantPage.setClickOnAllTag();
			consultantPage.setSearchTextBox(searchConsultant);

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}				

			consultantPage.setClickOnConsultantEmailLink();		
			
			consultantPage.setClickOnSendButtonOfEmail();			
			
			Assert.assertEquals(consultantPage.setSubjectValidationMessage(), "Subject is required");
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("31", new Object[] { 31d, TestCaseName,
					"Validation message should be appear that 'Subject is required'", "Pass" });
		} 				
		catch (Exception e) {
			testresultdata.put("31", new Object[] { 31d, TestCaseName,
					"Validation message should be appear that 'Subject is required'", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}		
	}
	

	@Test(priority = 22,groups = {"regression"})
	public void verifyArchiveFunctionality() {
		String TestCaseName = "Verify that user can archive the consultant";
		test = extent.createTest(TestCaseName);
		
		//String searchConsultant = prop.getProperty("Consultant_id");
		
		try {
			//consultantPage.setClickOnAllTag();
			//consultantPage.setSearchTextBox(searchConsultant);

			Thread.sleep(2000);
			try {
				consultantPage.setSelectConsultantFromGrid_CheckBox();	
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}		
						
			consultantPage.setClickOnArchiveLink();	
			
			consultantPage.setClickOnArchiveButton();			
			
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "1 Consultants archived successfully.");
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("32", new Object[] { 32d, TestCaseName,
					"User should be able to archive the consultant", "Pass" });
		} 				
		catch (Exception e) {
			testresultdata.put("32", new Object[] { 32d, TestCaseName,
					"User should be able to archive the consultant", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}		
	}

	
	@Test(priority = 23,groups = {"regression"})
	public void verifyUn_ArchiveFunctionality() {
		String TestCaseName = "Verify that user can un-archive the consultant";
		test = extent.createTest(TestCaseName);
		
		//String searchConsultant = prop.getProperty("Consultant_id");
		
		try {
			consultantPage.setClickOnArchivedTag();
			//consultantPage.setSearchTextBox(searchConsultant);

			Thread.sleep(2000);
			try {
				consultantPage.setSelectConsultantFromGrid_CheckBox();	
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}		
						
			consultantPage.setClickOnUnArchiveLink();	
			
			consultantPage.setClickOnUnArchiveButton();			
			
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(), "1 Consultants Un-Archived successfully.");
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("33", new Object[] { 33d, TestCaseName,
					"User should be able to un-archive the consultant", "Pass" });
		} 				
		catch (Exception e) {
			testresultdata.put("33", new Object[] { 33d, TestCaseName,
					"User should be able to un-archive the consultant", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}		
	}

	@Test(priority = 24,groups = {"regression"})
	public void verifyPageLable() {
		String TestCaseName = "Verify that Available Consultant lable can displayed on Consultant page";
		test = extent.createTest(TestCaseName);
		try {
			WebElement el = driver.findElement(By.xpath("//span[contains(text(),'Available Consultants')]"));

			String xyz = el.getText();
			boolean actual = xyz.contains("Available Consultants");

			Thread.sleep(2000);
			Assert.assertTrue(actual, "Available consultant lable is available");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("34", new Object[] { 34d, TestCaseName,
					"Available Consultant lable should be displayed on Consultant page", "Pass" });
		}

		catch (Exception e) {
			testresultdata.put("34", new Object[] { 34d, TestCaseName,
					"Available Consultant lable should be displayed on Consultant page", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}	
	
	@Test(priority = 25,groups = {"regression"})
	public void verifyArchivedConsultantMapToRequirement() {
		String TestCaseName = "Verify that consultant can map/shorlist the archived requirement";
		test = extent.createTest(TestCaseName);		

		try {
	//	consultantPage.setClickOnAllTag();
		Thread.sleep(2000);
		try {
			consultantPage.setClickOnFirstRowConsultant();
		} catch (Exception e) {
			WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
			System.out.println(noData.getText());
		}				
		consultantPage.setClickOnRequirementOption();
		
		consultantPage.setClickOnLinkRequirementLink();
		consultantPage.setClickOnArchivedTag();
		Thread.sleep(3000);
		String requirementName = consultantPage.setRequirementName();
		consultantPage.setSelectRequirement();	
		
		Thread.sleep(2000);
		consultantPage.setClickOnLinkRequirementButton();
	
		
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(),
					""+requirementName+"- Archived or Closed requirement can not be linked.");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("35", new Object[] { 35d, TestCaseName,
					"Message should be appear 'Archived consultant can not be shortlisted.","Pass" });
		} catch (Exception e) {
			testresultdata.put("35", new Object[] { 35d, TestCaseName,
					"Message should be appear 'Archived consultant can not be shortlisted.","Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority = 26,groups = {"regression"})
	public void verifyAddNoteFunctionality() throws InterruptedException {
		String TestCaseName = "Verify the Add Note functionality";
		test = extent.createTest(TestCaseName);

		try {
		//	consultantPage.setClickOnAllTag();
		
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
		testresultdata.put("36", new Object[] { 36d, TestCaseName,
				"User should be able to add note in Consultant","Pass" });
	    } catch (Exception e) {
	    	testresultdata.put("36", new Object[] { 36d, TestCaseName,
				"User should be able to add note in Consultant","Fail" });
	    	e.printStackTrace();
	    	Assert.fail();
	    	}
	    }

	@Test(priority = 27,groups = {"regression"})
	public void verifyCancelBtnFunOfAddNote() throws InterruptedException {
		String TestCaseName = "Verify the Cancel button functionality of Add Note";
		test = extent.createTest(TestCaseName);

		try {
		//	consultantPage.setClickOnAllTag();
		
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
		testresultdata.put("37", new Object[] { 37d, TestCaseName,
				"Add note window should be disappear once click on Cancel button","Pass" });
	    } catch (Exception e) {
	    	testresultdata.put("37", new Object[] { 37d, TestCaseName,
				"Add note window should be disappear once click on Cancel button","Fail" });
	    	e.printStackTrace();
	    	Assert.fail();
	    	}
	    }
	
	@Test(priority = 28,groups = {"regression"})
	public void verifyNavigateToScheduleMeetingPopUp() throws InterruptedException {
		String TestCaseName = "Verify the user can navigate to the Schedule Meeting pop up";
		test = extent.createTest(TestCaseName);

		try {
		//	consultantPage.setClickOnAllTag();

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			String consultantName = consultantPage.setConsultantName();

			consultantPage.setClickOnScheduleMeetingButton();
			
			Thread.sleep(3000);
			Assert.assertEquals(consultantPage.setScheduleMeetingPopUpName(), "Schedule Meeting");
			
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("38", new Object[] { 38d, TestCaseName,
					"User should be click on Schedule Meeting button and navigate to the Schedule Meeting pop up","Pass" });
		    } catch (Exception e) {
		    	testresultdata.put("38", new Object[] { 38d, TestCaseName,
					"User should be click on Schedule Meeting button and navigate to the Schedule Meeting pop up","Fail" });
		    	e.printStackTrace();
		    	Assert.fail();
		    	}
		    }		
	
	@Test(priority = 29,groups = {"regression"})
	public void verifyScheduleMeetingFunctionality() throws InterruptedException {
		String TestCaseName = "Verify the Schedule Meeting functionality";
		test = extent.createTest(TestCaseName);

		try {
		//	consultantPage.setClickOnAllTag();

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			Thread.sleep(3000);
			String consultantName = consultantPage.setConsultantName();

			System.out.println("------------------------"+consultantName +"*****************");
			consultantPage.setClickOnScheduleMeetingButton();
			
			consultantPage.setEnterEmailId("vijay.chavan@xoriant.com");

			consultantPage.setSelectAppointmentType("Event");

			consultantPage.setSelectSubType("Job Fair");

			// Select Start Date
			consultantPage.clickOnStartDateBox();
			consultantPage.selectYear_ScheduleMeeting("2019");
			consultantPage.selectMonth_ScheduleMeeting("Nov");
			consultantPage.setSelectDate_ScheduleMeeting("25");

			// Enter Start Time
			consultantPage.setEnterStartTime("1020");

			// Select End Date
			consultantPage.clickOnEndDateBox();
			consultantPage.selectYear_ScheduleMeeting("2020");
			consultantPage.selectMonth_ScheduleMeeting("Nov");
			consultantPage.setSelectDate_ScheduleMeeting("25");

			// Enter End Time
			consultantPage.setEnterEndTime("1130");
			// Select Remainder
			consultantPage.setSelectRemainder("30 minutes");
			// Selct Auto Follow Up
			consultantPage.setSelectAutoFollowUp("2 Weeks");
			// Enter Subject
			consultantPage.setEnterSubject("Test");
			// click on Schedule button
			consultantPage.setClickOnScheduleButton();
			Thread.sleep(2000);
			//Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(),
			//		"Meeting has been scheduled successfully for Consultant "+""+consultantName+"");

			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("39",
					new Object[] { 39d, TestCaseName, "User should be able to creatre schedule meeting", "Pass" });
		} catch (Exception e) {
			testresultdata.put("39",
					new Object[] { 39d, TestCaseName, "User should be able to creatre schedule meeting", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(priority = 30,groups = {"regression"})
	public void verifyCancelBtnFunOfScheduleMeetingPopUp() throws InterruptedException {
		String TestCaseName = "Verify the Cancel button functionality of Schedule Meeting popup";
		test = extent.createTest(TestCaseName);

		try {
			//consultantPage.setClickOnAllTag();

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			consultantPage.setClickOnScheduleMeetingButton();
			
			consultantPage.setClickOnCancelButtonOfScheduleMeetingPopup();
			
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("40",
					new Object[] { 40d, TestCaseName, "Schedule Meeting pop up should be disappear once click on Cancel button", "Pass" });
		} catch (Exception e) {
			testresultdata.put("40",
					new Object[] { 40d, TestCaseName, "Schedule Meeting pop up should be disappear once click on Cancel button", "Fail" });
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(priority = 31,groups = {"regression"})
	public void verifyValidationsInScheduleMeetingPopUp() {
		String TestCaseName = "Verify that validation message can appear for mandatory fields in Schedule Meeting pop up";
		test = extent.createTest(TestCaseName);

		try {
		//	consultantPage.setClickOnAllTag();

			Thread.sleep(2000);
			try {
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			consultantPage.setClickOnScheduleMeetingButton();
			// click on Schedule button
			consultantPage.setClickOnScheduleButton();
			
			Assert.assertEquals(
					driver.findElement(By.xpath("//p[contains(text(),'Please Select Sub-Type')]")).getText(),
					"Please Select Sub-Type");

			Assert.assertEquals(
					driver.findElement(By.xpath("//p[contains(text(),'Please enter start time')]")).getText(),
					"Please enter start time");

			Assert.assertEquals(
					driver.findElement(By.xpath("//p[contains(text(),'Please enter end time')]")).getText(),
					"Please enter end time");
			
			test.log(Status.PASS, TestCaseName + " is sucessfully pass");
			testresultdata.put("41", new Object[] { 41d, TestCaseName,
					"validation message should be appear for mandatory fields", "Pass" });
		} catch (Exception e) {
			testresultdata.put("41", new Object[] { 41d, TestCaseName,
					"validation message should be appear for mandatory fields'", "Fail" });
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
				consultantPage.setClickOnFirstRowConsultant();
			} catch (Exception e) {
				WebElement noData = driver.findElement(By.xpath("//span[@class='ag-overlay-no-rows-center']"));
				System.out.println(noData.getText());
			}
			// Click on Requiement option
			consultantPage.setClickOnRequirementOption();
			Thread.sleep(2000);
			
			//Click on Link Requirement link
			consultantPage.setClickOnLinkRequirementLink();
			
			String requirementId = consultantPage.getRequirementId();
			
			//Select the Requirement
			Thread.sleep(2000);
			consultantPage.setSelectRequirement();
			
			//Click on Link Requirement Button
			consultantPage.setClickOnLinkRequirementButton();
		
			//click on Requirement option
			consultantPage.setClickOnRequirementOption();
		
			Thread.sleep(2000);
			driver.navigate().refresh();
			
			//click on Requirement option
			consultantPage.setClickOnRequirementOption();
			
			//Select the radio button of Requirement
			consultantPage.setSelectRadioButtonOfRequirement();
			
			//Click on Status link 
			consultantPage.setClickOnStatusLink_ConsultantPage();
			
			Assert.assertEquals(consultantPage.setStatusPopUpTitle(), "Set Status");
			
			//Select the option from Status dropdown
			consultantPage.setselectStatus("Coding Test");
			
			//Enter the Note
			consultantPage.setEnterNotes("Test");
			
			//Click on Set Status button
			consultantPage.setClickOnSetStatus();
			
			Assert.assertEquals(consultantPage.setconsultantConfirmationMessage(),
					"Status has been updated successfully for Consultant " + "" + requirementId + "");

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
	
	
	

	
	

}
