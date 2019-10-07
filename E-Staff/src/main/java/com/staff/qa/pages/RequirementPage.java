package com.staff.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.staff.qa.base.TestBase;
import com.staff.qa.util.TestUtil;

public class RequirementPage extends TestBase {
	
	public RequirementPage() {
		PageFactory.initElements(driver, this);
	}

	
	//Total Consultant count - Label
	@FindBy(xpath = "//div[@class='content-heading col-md-4']")
	WebElement totalRequirement;
	
	public String setTotalRequirementLabel() {
		System.out.println("Count in grid is : "+totalRequirement.getText());
		return totalRequirement.getText();		
	}
	
	//Count of Requirement in grid section  
	@FindBy(xpath = "//div[@class='requirements-list-container col-md-10']//ats-data-table")
	WebElement allRequirement;
	
	/*public String setAllRequirementCountInGrid() {
		System.out.println("Size-count is : "+allRequirement.getAttribute("ng-reflect-total-records"));
		return allRequirement.getAttribute("ng-reflect-total-records");
	}*/
	
	public String setAllRequirementCountInGrid() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    	System.out.println("------------------Waiting ----------------");
	    	allRequirement.getAttribute("ng-reflect-total-records");
		return allRequirement;
	}		
		});
		return allRequirement.getAttribute("ng-reflect-total-records");
	}
	
	//Filters --> All Tag
	@FindBy(xpath = "//div[contains(text(),'All')]")
	WebElement clickOnAllTag;


	public void setClickOnAllTag() {	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
		TestUtil.click(clickOnAllTag);
		return clickOnAllTag;
	}		
		});
	}
	
	//Filters --> Archived Tag
	@FindBy(xpath = "//div[contains(text(),'Archived')]")
	WebElement clickOnArchivedTag;


	public void setClickOnArchivedTag() {	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
		TestUtil.click(clickOnArchivedTag);
		return clickOnArchivedTag;
	}		
		});
	}
	
	//Click on Add new link
	@FindBy(xpath = "//label[text()='Add New']")
	WebElement clickAddNewLink;
	
	public void setClickAddNewLink() {		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("Loading>>>>>>>>>>>>>>>>>>>>>>>>");
				// clickAddNewMenu.click();
				if (clickAddNewLink.isEnabled()) {
					clickAddNewLink.click();
				} else {
					System.out.println("Add New option is not available");
				}
				return clickAddNewLink;
			}
		});
	}
	
	//Click on Cancel button(General)
	@FindBy(xpath = "//div[@id='general-tab-section']//a[contains(text(),'Cancel')]")
	WebElement clickOnCancelButton;
	
	public void setClickOnCancelButton() {
		TestUtil.click(clickOnCancelButton);
	}
	
	//Requirement Id
	@FindBy(xpath = "//input[@name='requirementID']")
	WebElement requirementID;
	
	public String setRequirementId() {
		System.out.println("Requirement id is ::: "+requirementID.getAttribute("ng-reflect-model"));	
		return requirementID.getAttribute("ng-reflect-model");
	}
	
	//Select Recruiter
	@FindBy(xpath = "//ng-select[@name='requirementRecruiter']")
	WebElement clickRecruiterDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectRecruiter;
	
	public void setselectRecruiter(String Recruiter) throws InterruptedException {
		TestUtil.click(clickRecruiterDropdown);
		Thread.sleep(2000);
		String RecruiterOption = selectRecruiter.getText();
		System.out.println("++++++++++++++++"+RecruiterOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+Recruiter+"')]")).click();		
	}	
	
	//Enter No Of Openings
	@FindBy(xpath = "//input[@name='requirementNoOfOpenings']")
	WebElement enterRequirementNoOfOpenings;
		
	public void setEnterRequirementNoOfOpenings(String No_Of_Opening) throws InterruptedException {
	
		TestUtil.sendInput(enterRequirementNoOfOpenings, No_Of_Opening);
	}	
	
	//Select Requirement - Contact
	@FindBy(xpath = "//ng-select[@name='requirementContact']")
	WebElement clickContactDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectContact;
	
	public void setselectContact(String Contact) throws InterruptedException {
		TestUtil.click(clickContactDropdown);
		Thread.sleep(2000);
		String ContactOption = selectContact.getText();
		System.out.println("++++++++++++++++"+ContactOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+Contact+"')]")).click();		
	}	
	
	//Select Account Manager
	@FindBy(xpath = "//ng-select[@name='requirementAccountManager']")
	WebElement clickAccountManagerDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectAccountManager;
	
	public void setselectAccountManager(String AccountManager) throws InterruptedException {
		TestUtil.click(clickAccountManagerDropdown);
		Thread.sleep(2000);
		String AccountManagerOption = selectAccountManager.getText();
		System.out.println("++++++++++++++++"+AccountManagerOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+AccountManager+"')]")).click();		
	}	
	
	//Enter Job Title
	@FindBy(xpath = "//input[@name='requirementJobTitle']")
	WebElement enterJobTitle;
		
	public void setEnterJobTitle(String JobTitle) throws InterruptedException {
	
		TestUtil.sendInput(enterJobTitle, JobTitle);
	}
	
	//Select Job Type
	@FindBy(xpath = "//ng-select[@name='requirementJobType']")
	WebElement clickJobTypeDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectJobType;
	
	public void setselectJobType(String JobType) throws InterruptedException {
		TestUtil.click(clickJobTypeDropdown);
		Thread.sleep(2000);
		String JobTypeOption = selectJobType.getText();
		System.out.println("++++++++++++++++"+JobTypeOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+JobType+"')]")).click();		
	}	
	
	//Select Business Unit
	@FindBy(xpath = "//ng-select[@name='requirementBusinessUnit']")
	WebElement clickBusinessUnitDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectBusinessUnit;
	
	public void setselectBusinessUnit(String BusinessUnit) throws InterruptedException {
		TestUtil.click(clickBusinessUnitDropdown);
		Thread.sleep(2000);
		String BusinessUnitOption = selectBusinessUnit.getText();
		System.out.println("++++++++++++++++"+BusinessUnitOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+BusinessUnit+"')]")).click();		
	}	
	
	//Select Visa Status
	@FindBy(xpath = "//ng-select[@name='requirementVisaStatus']")
	WebElement clickVisaStatusDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectVisaStatus;
	
	public void setselectVisaStatus(String VisaStatus) throws InterruptedException {
		TestUtil.click(clickVisaStatusDropdown);
		Thread.sleep(2000);
		String VisaStatusOption = selectVisaStatus.getText();
		System.out.println("++++++++++++++++"+VisaStatusOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+VisaStatus+"')]")).click();		
	}	
	
	//Select Priority 
	@FindBy(xpath = "//ng-select[@name='requirementStatus']")
	WebElement clickPriorityDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectPriority;
	
	public void setselectPriority(String Priority) throws InterruptedException {
		TestUtil.click(clickPriorityDropdown);
		Thread.sleep(2000);
		String PriorityOption = selectPriority.getText();
		System.out.println("++++++++++++++++"+PriorityOption);
		driver.findElement(By.xpath("//div[contains(text(),'"+Priority+"')]")).click();		
	}	
	
	//Select Communication Skills  
	@FindBy(xpath = "//ng-select[@name='requirementCommSkills']")
	WebElement clickCommunicationSkillsDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectCommunicationSkills;
	
	public void setselectCommunicationSkills(String CommunicationSkills) throws InterruptedException {
		TestUtil.click(clickCommunicationSkillsDropdown);
		Thread.sleep(2000);
		String CommunicationSkillsOption = selectCommunicationSkills.getText();
		System.out.println("++++++++++++++++"+CommunicationSkillsOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+CommunicationSkills+"')]")).click();		
	}	
	
	// Select Bill Rate UOM 
	@FindBy(xpath = "//ng-select[@name='billRateUOM']")
	WebElement clickBillRateUOMDropdown;

	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")
	WebElement selectBillRateUOM;

	public void setselectBillRateUOM(String BillRateUOM) throws InterruptedException {
		TestUtil.click(clickBillRateUOMDropdown);
		Thread.sleep(2000);
		String BillRateUOMOption = selectBillRateUOM.getText();
		System.out.println("++++++++++++++++" + BillRateUOMOption);
		driver.findElement(By.xpath("//span[contains(text(),'" + BillRateUOM + "')]")).click();
	}

	// Select Pay Rate UOM
	@FindBy(xpath = "//ng-select[@name='payRateUOM']")
	WebElement clickPayRateUOMDropdown;

	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")
	WebElement selectPayRateUOM;

	public void setselectPayRateUOM(String PayRateUOM) throws InterruptedException {
		TestUtil.click(clickPayRateUOMDropdown);
		Thread.sleep(2000);
		String PayRateUOMOption = selectPayRateUOM.getText();
		System.out.println("++++++++++++++++" + PayRateUOMOption);
		driver.findElement(By.xpath("//span[contains(text(),'" + PayRateUOM + "')]")).click();
	}
	
	//Country Dropdown
	@FindBy(xpath = "//ng-select[@name='requirementCountries']")
	WebElement clickCountryDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectCountry;
	
	public void setselectCountry(String Country) throws InterruptedException {
		TestUtil.click(clickCountryDropdown);
		Thread.sleep(2000);
		String CountryOption = selectCountry.getText();
		System.out.println("++++++++++++++++"+CountryOption);
		driver.findElement(By.xpath("//span[text()='"+Country+"']")).click();		
	}	
	
	//State Dropdown
	@FindBy(xpath = "//ng-select[@name='requirementState']")
	WebElement clickStateDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectState;
	
	public void setselectState(String State) throws InterruptedException {
		TestUtil.click(clickStateDropdown);
		Thread.sleep(2000);
		String StateOption = selectState.getText();
		System.out.println("++++++++++++++++"+StateOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+State+"')]")).click();		
	}		
	
	//City Dropdown
	@FindBy(xpath = "//ng-select[@name='requirementCity']")
	WebElement clickCityDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectCity;
	
	public void setselectCity(String City) throws InterruptedException {
		TestUtil.click(clickCityDropdown);
		Thread.sleep(2000);
		String CityOption = selectCity.getText();
		System.out.println("++++++++++++++++"+CityOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+City+"')]")).click();		
	}
	
	
	//Start Date
	@FindBy(xpath = "//input[@name='requirementStartDate']")
	WebElement clickOnCalen;
	
	@FindBy(xpath = "//span[@class='owl-dt-control-button-arrow']")
	WebElement clickOnDropButton;

	@FindBy(xpath = "//tbody[@class='owl-dt-calendar-body']")
	List<WebElement> selectYear;
	
	//Select Month
    @FindBy(xpath = "//tbody[@class='owl-dt-calendar-body']")
	List<WebElement> selectMonth;
    
	//Select Date
	@FindBy(xpath = "//tbody[@class='owl-dt-calendar-body']")
	List<WebElement> selectDate;
		
	public void clickDateBox() throws InterruptedException {
		TestUtil.click(clickOnCalen);
		Thread.sleep(1000);
		TestUtil.click(clickOnDropButton);
	}
	
	public void selectStartYear(String year) throws InterruptedException {		
		
		Iterator<WebElement> it = selectYear.iterator();
		while(it.hasNext()) {
			WebElement year1 = it.next();
			System.out.println(year1.getText());
	
			if(year.equals("2019")) {
				driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']")).click();
			}
			else 
			{							
			WebElement we = driver.findElement(By.xpath(" //span[contains(text(),'" +year+ "')]"));
			we.click();
			}
		
		}
	}
	
	public void selectMonth(String month) throws InterruptedException {
		Thread.sleep(2000);
		Iterator<WebElement> it_month = selectMonth.iterator();
		while(it_month.hasNext()) {
			WebElement months = it_month.next();
		
		System.out.println("Start month is : "+months.getText());
		
		if(month.equals("Oct")) {
			driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']")).click();
		}
		else
		{
		WebElement we = driver.findElement(By.xpath(" //span[contains(text(),'" +month+ "')]"));
		we.click();
		}
	
		}
	}
	
	public void setSelectDate(String date) throws InterruptedException {
		
		Iterator<WebElement> it_date = selectDate.iterator();
		while(it_date.hasNext()) {
			WebElement alldate = it_date.next();
		
		System.out.println("Date is ::-" + alldate.getText());
		
		Date date1 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		String strDate= formatter.format(date1);
		System.out.println(strDate);
		
		if(date.equals(strDate)) {
			driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']")).click();
		}
		else {
		WebElement we = driver.findElement(By.xpath(" //span[contains(text(),'" +date+ "')]"));		
		we.click();				
		}		
		}
	}
	
	//Click on Continue Button(General)
	@FindBy(xpath = "//div[@id='general-tab-section']//button[contains(text(),'Continue')]")
	WebElement clickContinueButton;

	public void setClickContinueButton() {
		TestUtil.click(clickContinueButton);
	}
	
	//Enter primary Skills
	@FindBy(xpath = "//input[@name='requirementPrimarySkills']")
	WebElement enterPrimarySkills;

	public void setEnterPrimarySkills(String primarySkills) {
		enterPrimarySkills.clear();
		TestUtil.sendInput(enterPrimarySkills, primarySkills);
	}
	
	//Enter Secondary Skills
	@FindBy(xpath = "//input[@name='requirementSecondarySkills']")
	WebElement enterSecondarySkills;

	public void setEnterSecondarySkills(String SecondarySkills) {
		enterSecondarySkills.clear();
		TestUtil.sendInput(enterSecondarySkills, SecondarySkills);
	}

	//Enter Optional Skills
	@FindBy(xpath = "//input[@name='requirementOptionalSkills']")
	WebElement enterOptionalSkills;

	public void setEnterOptionalSkills(String OptionalSkills) {
		enterOptionalSkills.clear();
		TestUtil.sendInput(enterOptionalSkills, OptionalSkills);
	}
	
	//Enter ShortDescription
	@FindBy(xpath = "//input[@name='requirementShortDescription']")
	WebElement enterShortDescription;

	public void setEnterShortDescription(String ShortDescription) {
		enterShortDescription.clear();
		TestUtil.sendInput(enterShortDescription, ShortDescription);
	}
	
	//Click on Continue button(Skills)
	@FindBy(xpath = "//div[@id='skills-tab-section']//button[contains(text(),'Continue')]")
	WebElement clickOnContinueButton_Skill;
	
	public void setClickOnContinueButton_Skill() {
		TestUtil.click(clickOnContinueButton_Skill);
	}	
	
	//Enter Description
	@FindBy(xpath = "//div[@id='cke_1_contents']//div[1]")
	WebElement enterDescription;

	public void setEnterDescription(String Description) {
		enterDescription.clear();
		TestUtil.sendInput(enterDescription, Description);
	}
	
	// Click on Continue button(JobDescription)
	@FindBy(xpath = "//div[@id='jobDescription-tab-section']//button[contains(text(),'Continue')]")
	WebElement clickOnContinueButton_JobDescription;

	public void setClickOnContinueButton_JobDescription() throws InterruptedException {
		Thread.sleep(1000);
		TestUtil.click(clickOnContinueButton_JobDescription);
	}

	// Click on Add Requirement button
	@FindBy(xpath = "//button[contains(text(),'Add Requirement')]")
	WebElement clickOnAddRequirementButton;

	public void setClickOnAddRequirementButton() {
		TestUtil.click(clickOnAddRequirementButton);
	}
	
	// Click on Update Requirement button
	@FindBy(xpath = "//button[contains(text(),'Update Requirement')]")
	WebElement clickOnUpdateRequirementButton;

	public void setClickOnUpdateRequirementButton() {
		TestUtil.click(clickOnUpdateRequirementButton);
	}
	
	//Confirmation message 
	@FindBy(xpath = "//div[@class='col-md-10 msg-content']")
	WebElement requirementConfirmationMessage;
	
	public String setRequirementConfirmationMessage() {
		System.out.println(requirementConfirmationMessage.getText());
		return requirementConfirmationMessage.getText();
	}
		
	//Search Textbox
	@FindBy(xpath = "//input[@name='searchValue']")
	WebElement searchTextBox;
	
	public void setSearchTextBox(String search) throws InterruptedException {	
		TestUtil.sendInput(searchTextBox, search);				
	}
	
	//Grid 1st Row data
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[3]")
	WebElement requirementId_gridsection;
	
	public void setClickOnFirstRowRequirement_id() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    	TestUtil.click(requirementId_gridsection);	    	
		return requirementId_gridsection;
	}		
		});		
	}
	
	//Click on Edit button
	@FindBy(xpath = "//button[text()='Edit']")
	WebElement clickOnEditButton;
	
	public void setClickOnEditButton() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    	TestUtil.click(clickOnEditButton);
		return clickOnEditButton;
	}		
		});		
		
	}
	
	//----------------Document Upload---------------------
	//Click on Document option
	@FindBy(xpath = "//div[contains(text(),'Documents')]")
	WebElement clickDocumentOption;
	
	public void setClickOnDocumentOption() {
		TestUtil.click(clickDocumentOption);
	}
	
	//Click on Upload Document link
	@FindBy(xpath = "//label[contains(text(),'Upload Document')]")
	WebElement clickOnUploadDocumentLink;
	
	public void setClickOnUploadDocumentLink() {
		TestUtil.click(clickOnUploadDocumentLink);
	}
	
	//Enter Document Name
	@FindBy(xpath = "//input[@name='documentText']")
	WebElement enterDocumentName;
	
	public void setEnterDocumentName(String documentName) {
		TestUtil.sendInput(enterDocumentName, documentName);
	}
	
	//Select Document Type
	@FindBy(xpath = "//div[@class='ng-select-container']")
	WebElement clickOnDocumentTypeDropDown;
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectDocumentType;
	
	public void setSelectDocumentType(String DocumentType) throws InterruptedException {  
		
		TestUtil.click(clickOnDocumentTypeDropDown);
		Thread.sleep(2000);
		String AllUOM = selectDocumentType.getText();
		System.out.println("++++++++++++++++"+AllUOM);
		driver.findElement(By.xpath("//span[contains(text(),'"+DocumentType+"')]")).click();				
	}
	
	//Click on Browse Button
	@FindBy(xpath = "//button[contains(text(),'Browse')]")
	WebElement clickOnBrowseButton;
	
	public void setUploadDocument(String path) throws InterruptedException, AWTException {	
		
		 // Specify the file location with extension
		 StringSelection sel = new StringSelection(path);
		 
		 // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection is : " +sel);
		
		 //click on Upload button
		 TestUtil.click(clickOnBrowseButton);
		Thread.sleep(1000);
		
		// Create object of Robot class
		 Robot robot = new Robot();
		 Thread.sleep(1000);
		      
		  // Press Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 
		// Release Enter
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		  // Press CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 
		// Release CTRL+V
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(1000);
		        
		 //Press Enter 
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 System.out.println("Enter Releases");
	}
	
	//Click on Upload button
	@FindBy(xpath = "//button[contains(text(),'Upload')]")
	WebElement clickOnUploadButton;
	
	public void setClickOnUploadButton() {
		TestUtil.click(clickOnUploadButton);
	}
	
	//Document Name
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[1]")
	WebElement documentNameInGrid;
	
	public String setDocumentNameInGrid() {
		return documentNameInGrid.getText();
	}
	
	//Download uploaded document
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]")
	WebElement downloadUploadedDocument;
	
	public void setDownloadUploadedDocument() {
		TestUtil.click(downloadUploadedDocument);
	}

	//Click on Cancel button of Upload Document pop up
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement clickOnCancelButtonOfUploadDocumentPopUp;
	
	public void setClickOnCancelButtonOfUploadDocumentPopUp() {
		TestUtil.click(clickOnCancelButtonOfUploadDocumentPopUp);
	}

	// ----------------Job Description---------------------
	// Click on Job Description option
	@FindBy(xpath = "//div[contains(text(),' Job Description')]")
	WebElement clickJobDescriptionOption;

	public void setClickOnJobDescriptionOption() {
		TestUtil.click(clickJobDescriptionOption);
	}

	// Click on Update Description button
	@FindBy(xpath = "//button[contains(text(),'Update Description')]")
	WebElement clickUpdateDescriptionButton;

	public void setClickUpdateDescriptionButton() {
		TestUtil.click(clickUpdateDescriptionButton);
	}
	
	//---------------------Archive Requirement----------------
	//Click on Archive column
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[10]")
	WebElement clickOnArchiveOption;

	public void setClickArchiveOption() throws InterruptedException {
		TestUtil.click(clickOnArchiveOption);
		Thread.sleep(2000);
	}
	
	//Select archive option  
	@FindBy(xpath = "//div[@class='ng-select-container ng-has-value']//span[@class='ng-arrow-wrapper']")
	WebElement clickOnArchiveOptionDropdown;
	
	public void setselectArchiveOption(String archiveOption) throws InterruptedException {
		TestUtil.click(clickOnArchiveOptionDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'"+archiveOption+"')]")).click();		
	}	
	
	//Click on Closure Date
	@FindBy(xpath = "//div[@class='date-row']//input[@name='requirementReqDueDate']")
	WebElement clickOnClosureDate;

	public void setClickClosureDate() throws InterruptedException {
		TestUtil.click(clickOnClosureDate);
		Thread.sleep(1000);
		TestUtil.click(clickOnDropButton);
	}
	

	@FindBy(xpath = "//span[@class='owl-dt-control-button-arrow']")
	WebElement clickOnDropButton_ClosureDate;

	@FindBy(xpath = "//tbody[@class='owl-dt-calendar-body']")
	List<WebElement> selectYear_ClosureDate;
	
	//Select Month
    @FindBy(xpath = "//tbody[@class='owl-dt-calendar-body']")
	List<WebElement> selectMonth_ClosureDate;
    
	//Select Date
	@FindBy(xpath = "//tbody[@class='owl-dt-calendar-body']")
	List<WebElement> selectDate_ClosureDate;
		
	
	public void selectStartYear_ClosureDate(String year) throws InterruptedException {		
		
		Iterator<WebElement> it = selectYear.iterator();
		while(it.hasNext()) {
			WebElement year1 = it.next();
			System.out.println(year1.getText());		
			
	
			if(year.equals("2019")) {
				driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today owl-dt-calendar-cell-selected']")).click();
			}
			else 
			{							
			WebElement we = driver.findElement(By.xpath(" //span[contains(text(),'" +year+ "')]"));
			we.click();
			}
		
		}
	}
	
	public void selectMonth_ClosureDate(String month) throws InterruptedException {
		
		Iterator<WebElement> it_month = selectMonth.iterator();
		while(it_month.hasNext()) {
			WebElement months = it_month.next();
		
		System.out.println("Start month is : "+months.getText());
		
		Date date1 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		String stryear= formatter.format(date1);
		System.out.println(stryear);
		
		if(month.equals("Oct") & stryear.equals("2019")) {
			driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today owl-dt-calendar-cell-selected']")).click();
		}
		else
		{
		WebElement we = driver.findElement(By.xpath(" //span[contains(text(),'" +month+ "')]"));
		we.click();
		}
	
		}
	}
	
	public void setSelectDate_ClosureDate(String date) throws InterruptedException {
		
		Iterator<WebElement> it_date = selectDate.iterator();
		while(it_date.hasNext()) {
			WebElement alldate = it_date.next();
		
		System.out.println("Date is ::-" + alldate.getText());
		
		Date date1 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		String strDate= formatter.format(date1);
		System.out.println(strDate);
		
		if(date.equals(strDate)) {
			driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today owl-dt-calendar-cell-selected']")).click();
		}
		else {
		WebElement we = driver.findElement(By.xpath("//tbody[@class='owl-dt-calendar-body']//span[text()='"+date+"']"));		
		we.click();				
		}		
		}
	}
	
	//Select Closure Reason
	@FindBy(xpath= "//div[@class='col-md-9']//ng-select[@name='requirementClosureReason']")
	WebElement selectClosureReason;
	
	public void setSelectClosureReason(String ClosureReason) throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(selectClosureReason);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'"+ClosureReason+"')]")).click();
	}
	
	//Click on Close and Archive button
	@FindBy(xpath = "//span[contains(text(),'Close and Archive')]")
	WebElement clickOnArchiveButton;
	
	public void setClickOnArchiveButton() throws InterruptedException {
		Thread.sleep(1000);
		TestUtil.click(clickOnArchiveButton);
	}
	
	//click on Save button for un-archived requirement
	@FindBy(xpath = "//div[@class='action']/span[1]")
	WebElement clickSaveButton;
	
	public void setClickOnSaveButtonForUnArchived() {
		TestUtil.click(clickSaveButton);
	}
	
	//Validation message for closure date while Archive the requirement
	@FindBy(xpath = "//div[contains(text(),'Closure date cannot be a date in the future')]")
	WebElement closureDateValidationMessage;
	
	public String setClosureDateValidationMessage() {
		return closureDateValidationMessage.getText();
	}
	
	//Validation message for closure reason while Archive the requirement
	@FindBy(xpath = "//p[contains(text(),'Please Select Closure Reason')]")
	WebElement closureReasonValidationMessage;
	
	public String setClosureReasonValidationMessage() {
		return closureReasonValidationMessage.getText();
	}
	
	//click on Cancel button of archived requirement pop up
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement clickCancelButton;
	
	public void setClickOnCancelButtonFromArchivedPopUp() {
		TestUtil.click(clickCancelButton);
	}
	
	
	
	
	
}
