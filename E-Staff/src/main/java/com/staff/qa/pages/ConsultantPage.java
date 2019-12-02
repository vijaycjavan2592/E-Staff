package com.staff.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.staff.qa.base.BaseClass;
import com.staff.qa.util.TestUtil;

public class ConsultantPage extends BaseClass {

	public ConsultantPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()='Add New']")
	WebElement clickAddNewMenu;

	public void setClickAddNewMenu() throws InterruptedException {
		Thread.sleep(5000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(ElementClickInterceptedException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("Loading>>>>>>>>>>>>>>>>>>>>>>>>");
				// clickAddNewMenu.click();
				if (clickAddNewMenu.isEnabled()) {
					clickAddNewMenu.click();
				} else {
					System.out.println("Add New option is not available");
				}

				return clickAddNewMenu;
			}
		});

	}

	// Click on Add Manually option
	@FindBy(xpath = "//span[contains(text(),'Add Manually')]")
	WebElement clickAddManuallyOption;

	public void setClickAddManuallyOption() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(clickAddManuallyOption));
		if (clickAddManuallyOption.isEnabled()) {
			clickAddManuallyOption.click();
			;
		} else {
			System.out.println("Add Manually option is not available");
		}
	}
	
	// Click on Upload Resume option
	@FindBy(xpath = "//label[contains(text(),'Upload Resume(s)')]")
	WebElement clickOnUploadResume;

	public void setClickOnUploadResume() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(clickOnUploadResume));
		if (clickOnUploadResume.isEnabled()) {
			clickOnUploadResume.click();
			;
		} else {
			System.out.println("Upload Resume option is not available");
		}
	}

	//Consultant First Name Test Box
	@FindBy(xpath = "//input[@name='consultantFnm']")
	WebElement enterconsultantFirstName;
	
	//Consultant Last Name Text Box
	@FindBy(xpath = "//input[@name='consultantLnm']")
	WebElement enterconsultantLasttName;
	
	//Consultant Email id Text Box
	@FindBy(xpath = "//input[@name='consultantEmail1']")
	WebElement enterconsultantEmailId;
	
	//Consultant Mobile Number Text Box
	@FindBy(xpath = "//input[@name='consultantMobilePhone']")
	WebElement enterconsultantMobileNumber;
	
	//Consultant Work Phone Text Box
	@FindBy(xpath = "//input[@name='consultantWorkPhone']")
	WebElement enterconsultantWorkPhone;
	
	//Consultant Rate
	@FindBy(xpath = "//input[@name='consultantRate']")
	WebElement enterconsultantRate;
	
	public void setRate(String rate) throws InterruptedException {
		Thread.sleep(1000);
		enterconsultantRate.sendKeys(Keys.BACK_SPACE);
		enterconsultantRate.sendKeys(Keys.BACK_SPACE);
		enterconsultantRate.sendKeys(Keys.BACK_SPACE);
		enterconsultantRate.sendKeys(Keys.BACK_SPACE);
		TestUtil.sendInput(enterconsultantRate, rate);
		Thread.sleep(1000);
	}
		
	
	public void fillAddNewConsultantForm(String firstName, String lastName, String emailId, String mobileNo) throws InterruptedException {		
		enterconsultantFirstName.clear();
		TestUtil.sendInput(enterconsultantFirstName, firstName);
		enterconsultantLasttName.clear();
		TestUtil.sendInput(enterconsultantLasttName, lastName);
		enterconsultantEmailId.clear();
		TestUtil.sendInput(enterconsultantEmailId, emailId);
		enterconsultantMobileNumber.clear();
		TestUtil.sendInput(enterconsultantMobileNumber, mobileNo);	
		enterconsultantRate.clear();
		
	//	TestUtil.sendInput(enterconsultantRate, rate);
	}	
	
	//Rate UOM Dropdown
	@FindBy(xpath = "//ng-select[@name='payRateUOM']")
	WebElement clickRateUOMDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectUOMRate;
	
	public void setselectUOMRate(String UOM) throws InterruptedException {
		//clickRateUOMDropdown.clear();
		TestUtil.click(clickRateUOMDropdown);
		Thread.sleep(2000);
		String AllUOM = selectUOMRate.getText();
		System.out.println("++++++++++++++++"+AllUOM);
		if(!UOM.isEmpty()) {
		driver.findElement(By.xpath("//span[contains(text(),'"+UOM+"')]")).click();				
		}else {
			System.out.println("???????????????????? UOM is not available");
		}
	}
	
	//Availability Notice Dropdown
	@FindBy(xpath = "//ng-select[@name='consultantAvailNotice']")
	WebElement clickAvailabilityNoticeDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectAvailabilityNotice;
	
	public void setselectAvailabilityNotice(String availability) throws InterruptedException {
		TestUtil.click(clickAvailabilityNoticeDropdown);
		Thread.sleep(2000);
		String AvailabilityNotice = selectAvailabilityNotice.getText();
		System.out.println("++++++++++++++++"+AvailabilityNotice);
		if(!availability.isEmpty()) {
		driver.findElement(By.xpath("//span[contains(text(),'"+availability+"')]")).click();	
		}else {
			System.out.println("???????????????????? availability is not available");
		}
	}	
		
	//Can Relocate To Dropdown
	@FindBy(xpath = "//ng-select[@name='consultantCanRelocateTo']")
	WebElement clickCanRelocateToDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectCanRelocateTo;
	
	public void setselectCanRelocateTo(String relocateOption) throws InterruptedException {
		TestUtil.click(clickCanRelocateToDropdown);
		Thread.sleep(2000);
		String relocateOptions = selectCanRelocateTo.getText();
		System.out.println("++++++++++++++++"+relocateOptions);
		driver.findElement(By.xpath("//span[contains(text(),'"+relocateOption+"')]")).click();		
	}	
	
	
	//Employment Type Dropdown
	@FindBy(xpath = "//ng-select[@name='consultantEmploymentType']")
	WebElement clickEmploymentTypeDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectEmploymentType;
	
	public void setselectEmploymentType(String EmploymentType) throws InterruptedException {
		TestUtil.click(clickEmploymentTypeDropdown);
		Thread.sleep(2000);
		String EmploymentTypeOption = selectEmploymentType.getText();
		System.out.println("++++++++++++++++"+EmploymentTypeOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+EmploymentType+"')]")).click();		
	}
	
	
	//Candidate Source Dropdown
	@FindBy(xpath = "//ng-select[@name='consultantCandidateSource']")
	WebElement clickCandidateSourceDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectCandidateSource;
	
	public void setselectCandidateSource(String CandidateSource) throws InterruptedException {
		TestUtil.click(clickCandidateSourceDropdown);
		Thread.sleep(2000);
		String CandidateSourceOption = selectCandidateSource.getText();
		System.out.println("++++++++++++++++"+CandidateSourceOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+CandidateSource+"')]")).click();		
	}
	
	
	//Visa Status Dropdown
	@FindBy(xpath = "//ng-select[@name='consultantVisaStatus']")
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
	
	
	//Country Dropdown
	@FindBy(xpath = "//ng-select[@name='consultantCountries']")
	WebElement clickCountryDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectCountry;
	
	public void setselectCountry(String Country) throws InterruptedException {
		TestUtil.click(clickCountryDropdown);
		Thread.sleep(2000);
		String CountryOption = selectCountry.getText();
		System.out.println("++++++++++++++++"+CountryOption);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][text()='"+Country+"']")).click();		
	}
	
	
	//State Dropdown
	@FindBy(xpath = "//ng-select[@name='consultantState']")
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
	@FindBy(xpath = "//ng-select[@name='consultantCity']")
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
	
	//Click on Continue button(General)
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement clickOnContinueButton;
	
	public void setClickOnContinueButton() {
		TestUtil.click(clickOnContinueButton);
	}
	
	//Click on Cancel button(General)
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement clickOnCancelButton;
	
	public void setClickOnCancelButton() {
		TestUtil.click(clickOnCancelButton);
	}
	
	//Availability Date
	@FindBy(xpath = "//input[@name='consultantAvailDate']")
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
		
	public void selectAvailabilityDate(String year) throws InterruptedException {		
		Thread.sleep(1000);
		Iterator<WebElement> it = selectYear.iterator();
		while(it.hasNext()) {
			WebElement year1 = it.next();
			System.out.println(year1.getText());
			
			Thread.sleep(1000);
			String backyear = "2016";
			int yb = Integer.parseInt(backyear);
			int y = Integer.parseInt(year);
			
		/*	String date = driver.findElement(By.xpath("//input[@name='estimatedStartDate']")).getAttribute("ng-reflect-model");
			
			String[] startDate = date.split("\\s");
			System.out.println("Day is : "+startDate[0]);
			System.out.println("Month is : "+startDate[1]);
			System.out.println("Date is : "+startDate[2]);
			System.out.println("Year is : "+startDate[3]);*/
			
			if(y<yb) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@class='owl-dt-control-button owl-dt-control-arrow-button']")).click();
				Thread.sleep(2000);
				WebElement we = driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content'][contains(text(),'\"+year+\"')]"));
				we.click();
			}
			/*else if(y>yb && year.equals(startDate[3])) {
				driver.findElement(By.xpath("//span[contains(@class,'owl-dt-calendar-cell-content owl-dt-calendar-cell-selected')]")).click();
			}*/
			else if(y>yb && year.equals("2019") ) {
				driver.findElement(By.xpath("//span[starts-with(@class,'owl-dt-calendar-cell-content owl-dt-calendar-cell-today')]")).click();
			}			
			else 
			{							
			WebElement we = driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content'][contains(text(),'"+year+"')]"));
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
		
		if(month.equals("Sep")) {
			driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']")).click();
		}
		
		else
		{
		WebElement we = driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content'][contains(text(),'"+month+"')]"));
		we.click();
		}
	
		}
	}
	
	public void setSelectDate(String date) throws InterruptedException {
		
		Iterator<WebElement> it_date = selectDate.iterator();
		while(it_date.hasNext()) {
			WebElement alldate = it_date.next();
		
		System.out.println("Date is ::-" + alldate.getText());
		
		WebElement we = driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content'][contains(text(),'"+date+"')]"));
		
		we.click();				
		}		
	}
	
	//Primary Skills textbox
	@FindBy(xpath = "//input[@name='consultantPrimarySkills']")
	WebElement enterconsultantPrimarySkills;
	
	public void setEnterConsultantPrimarySkills(String consultantPrimarySkills) {
		enterconsultantPrimarySkills.clear();
		TestUtil.sendInput(enterconsultantPrimarySkills, consultantPrimarySkills);
	}
	
	//Secondary Skills textbox
	@FindBy(xpath = "//input[@name='consultantSecondarySkills']")
	WebElement enterconsultantSecondarySkills;
	
	public void setEnterConsultantSecondarySkills(String consultantSecondarySkills) {
		enterconsultantSecondarySkills.clear();
		TestUtil.sendInput(enterconsultantSecondarySkills, consultantSecondarySkills);
	}	
	
	//Other Skills textbox
	@FindBy(xpath = "//input[@name='consultantOtherSkills']")
	WebElement enterconsultantOtherSkills;
	
	public void setEnterConsultantOtherSkills(String consultantOtherSkills) {
		enterconsultantOtherSkills.clear();
		TestUtil.sendInput(enterconsultantOtherSkills, consultantOtherSkills);
	}
	
	//Summary textbox
	@FindBy(xpath = "//textarea[@name='consultantSummary']")
	WebElement enterSummary;
	
	public void setEnterSummary(String Summary) {
		TestUtil.sendInput(enterSummary, Summary);
	}
		
	//Click on Continue button(Skills)
	@FindBy(xpath = "//div[@id='skills-tab-section']//button[contains(text(),'Continue')]")
	WebElement clickOnContinueButton_Skill;
	
	public void setClickOnContinueButton_Skill() {
		TestUtil.click(clickOnContinueButton_Skill);
	}	
	
	//Upload Resume
	@FindBy(xpath = "//button[contains(text(),'Upload Resume')]")
	WebElement uploadResume;
	
	public void setUploadResume(String path) throws InterruptedException, AWTException {
			
		 // Specify the file location with extension
		 StringSelection sel = new StringSelection(path);
		 
		 // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection is : " +sel);
		
		 //click on Upload button
		uploadResume.click();
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
		 
		/*driver.switchTo()
	       .activeElement()
	       .sendKeys("C:\\Users\\chavan_v\\code3.txt");
		System.out.println("Attribute is : "+uploadResume.getAttribute("type"));
		System.out.println("File Uploaded sucessfully");*/
	}

	//click on Add Consultant button
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement clickOnAddConsultantButton;
	
	public void setClickOnAddConsultantButton() throws InterruptedException {
		if(clickOnAddConsultantButton.isEnabled()) {
		TestUtil.click(clickOnAddConsultantButton);
		}
		else {
			Thread.sleep(5000);
			TestUtil.click(clickOnAddConsultantButton);
		}
	}
	
	//Consultant Id (when edit mode)
	@FindBy(xpath = "//input[@name='consultantId']")
	WebElement consultantID;
	
	public String setConsultantId() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Consultant id is ::: "+consultantID.getAttribute("ng-reflect-model"));	
		return consultantID.getAttribute("ng-reflect-model");
	}
	
	//Consultant Id (when edit mode)
	@FindBy(xpath = "//input[@name='consultantID']")
	WebElement consultantID_Edit;
	
	public String setConsultantId_Edit() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Consultant id is ::: "+consultantID_Edit.getAttribute("ng-reflect-model"));	
		return consultantID_Edit.getAttribute("ng-reflect-model");
	}
	
	
	//Confirmation message 
	@FindBy(xpath = "//div[@class='col-md-10 msg-content']")
	WebElement consultantConfirmationMessage;
	
	public String setconsultantConfirmationMessage() throws InterruptedException {
		Thread.sleep(2000);
		return consultantConfirmationMessage.getText();
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
	
	//Filters --> Qualified Tag
	@FindBy(xpath = "//div[contains(text(),'Qualified')]")
	WebElement clickOnQualifiedTag;


	public void setClickOnQualifiedTag() {	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
		TestUtil.click(clickOnQualifiedTag);
		return clickOnQualifiedTag;
	}		
		});
	}
	
	//Grid 1st Row data
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[3]")
	WebElement gridsection;
	
	public void setClickOnFirstRowConsultant() throws InterruptedException {
		Thread.sleep(6000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    	TestUtil.click(gridsection);	    	
		return gridsection;
	}		
		});		
	}
	
	public void setClickOnRow(int i) throws InterruptedException {
		WebElement clickOnRow = driver.findElement(By.xpath("//div[@class='ag-body-container ag-layout-normal']/div["+i+"]/div[3]"));
		Thread.sleep(6000);
		clickOnRow.click();
	}
	
	public String setConsultantOnGrid_GetText() {		
		System.out.println("Grid data Is : "+gridsection.getText());
		return gridsection.getText();
	}
	
	//Count of Consultant in grid section  
	@FindBy(xpath = "//div[@class='consultant-list-container col-md-10']//ats-data-table")
	WebElement allConsultant;
	
	public String setAllConsultantCountInGrid() {
		System.out.println("Size-count is : "+allConsultant.getAttribute("ng-reflect-total-records"));
		return allConsultant.getAttribute("ng-reflect-total-records");
	}
	
	//Total Consultant count - Label
	@FindBy(xpath = "//div[@class='content-heading col-md-4']")
	WebElement totalConsultantcount;
	
	public String setTotalConsultantcountLabel() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
	//wait.until(ExpectedConditions.visibilityOf(totalConsultantcount));
	
	TestUtil.getText(totalConsultantcount, 30);
	
	System.out.println("Count in grid is : "+totalConsultantcount.getText());
	return totalConsultantcount.getText();
	}		
	
	//Search Textbox
	@FindBy(xpath = "//input[@name='searchValue']")
	WebElement searchTextBox;
	
	public void setSearchTextBox(String search) throws InterruptedException {	
		TestUtil.sendInput(searchTextBox, search);				
	}
	
	//-------------Edit Consultant--------------------------------------------
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
	
	//Click on canacel button to remove the uploaded Resume
	@FindBy(xpath = "//span[@class='span-close ng-star-inserted']")
	WebElement clickCancelButtonToRemoveResume;
	
	public void setClickCancelButtonToRemoveResume(){
		if(clickCancelButtonToRemoveResume.isDisplayed()) {
		TestUtil.click(clickCancelButtonToRemoveResume);
		}
		else {
			System.out.println("Resume is not uploaded yet.");
		}
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
	
	//------------------Link Requirement-----------------------
	//Click on Requirement option
	@FindBy(xpath = "//div[contains(text(),'Requirements')]")
    WebElement clickRequirementOption;
	
	public void setClickOnRequirementOption() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickRequirementOption);
	} 
	
	//Click on Link Requirement link
	@FindBy(xpath = "//label[contains(text(),'Link Requirement')]")
	WebElement clickOnLinkRequirementLink;
		
	public void setClickOnLinkRequirementLink() {
		TestUtil.click(clickOnLinkRequirementLink);
	}
	
	//Get text of Requirement Id
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]")
	WebElement alreadyLinkedRequirementId;
		
	public String setAlreadyLinkedRequirementId() {	
		System.out.println("Reuirement is : "+alreadyLinkedRequirementId.getText());
		return alreadyLinkedRequirementId.getText();		
	}
	
	//Select the Requirement
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[1]")
	WebElement selectRequirement;
	
	public void setSelectRequirement() throws InterruptedException {
		Thread.sleep(2000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				
				TestUtil.click(selectRequirement);

				return selectRequirement;
			}
		});			
	}
	
	//Select the Requirement from 2nd row
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[2]/div[1]")
	WebElement selectRequirement_2ndRow;
	
	public void setSelectRequirement_2ndRow() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				
				TestUtil.click(selectRequirement_2ndRow);

				return selectRequirement_2ndRow;
			}
		});
		
	}
	
	//Click on Link Requirement Button
	@FindBy(xpath = "//button[contains(text(),'Link Requirement')]")
	WebElement clickOnLinkRequirementButton;
	
	public void setClickOnLinkRequirementButton() throws InterruptedException {		
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		Thread.sleep(1000);
		ac.moveToElement(clickOnLinkRequirementButton).click().build().perform();
		
	/*	if(clickOnLinkRequirementButton.isEnabled()) {
		TestUtil.click(clickOnLinkRequirementButton);
		}
		else {
			System.out.println("Link Requirement is not clickable");
		}*/
	}
	
	//click on Cancel button from Link Requirement page
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement clickOnCancelButtonFromLinkRequirementPage;
	
	public void setClickOnCancelButtonFromLinkRequirementPage() throws InterruptedException {
		Thread.sleep(2000);
		if(clickOnCancelButtonFromLinkRequirementPage.isEnabled()) {
		TestUtil.click(clickOnCancelButtonFromLinkRequirementPage);
		}
		else {
			System.out.println("Cancel button is not available");
		}
	}
	
	//---------------Resume ---------------------
	//Click on Resume option
	@FindBy(xpath = "//div[contains(text(),'Resume')]")
    WebElement clickResumeOption;
	
	public void setClickOnResumeOption() {
		TestUtil.click(clickResumeOption);
	} 
	
	//Click on Download Resume link
	@FindBy(xpath = "//span[@class='download-resume']")
    WebElement clickDownloadResumeLink;
	
	public void setClickOnDownloadResumeLink() {
		TestUtil.click(clickDownloadResumeLink);
	} 
	
	//------------------Email-------------------------
	//Click on Email-link
	@FindBy(xpath = "//label[contains(text(),'Email')]")
	WebElement clickOnConsultantEmailLink;
	
	public void setClickOnConsultantEmailLink() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnConsultantEmailLink);
	}
	
	//Enter Text in Subject
	@FindBy(xpath = "//input[@name='subject']")
	WebElement enterEmailSubject;
	
	public void setEnterEmailSubject(String subject) {
		TestUtil.sendInput(enterEmailSubject, subject);
	}
	
	//Enter email body
	@FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	WebElement enterEmailBody;
	
	public void setEnterEmailBody(String subject) {
		enterEmailBody.clear();
		TestUtil.sendInput(enterEmailBody, subject);
	}
	
	//Click on Send Button of Email
	@FindBy(xpath = "//span[@class='button btn btn-primary']")
	WebElement clickOnSendButton;
	
	public void setClickOnSendButtonOfEmail() {
		TestUtil.click(clickOnSendButton);
	}
	
	//Click on Cancel Button of Email
	@FindBy(xpath = "//a[@class='btn btn-link']")
	WebElement clickOnCancelButtonOfEmail;
	
	public void setClickOnCancelButtonOfEmail() {
		TestUtil.click(clickOnCancelButtonOfEmail);
	}
	
	//Validation message of Email-Subject
	@FindBy(xpath = "//p[@class='text-danger validation-error ng-star-inserted']")
	WebElement subjectValidationMessage;
	
	public String setSubjectValidationMessage() {
		return subjectValidationMessage.getText();
	}
	
	
	//-------------------------------Archive Consultant-----------------------
	//Select the Consultant from Grid_CheckBox
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[1]")
	WebElement selectConsultant;
	
	public void setSelectConsultantFromGrid_CheckBox() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				
				TestUtil.click(selectConsultant);

				return selectConsultant;
			}
		});		
	}
	
	//Get Email id of Consultant from grid
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[6]")
	WebElement consultantEmailId;
	
	public String setConsultantEmailId() {
		return consultantEmailId.getText();			
	}
	
	//Click on Archive-link
	@FindBy(xpath = "//label[contains(text(),'Archive')]")
	WebElement clickOnArchiveLink;
	
	public void setClickOnArchiveLink() throws InterruptedException {
		Thread.sleep(2000);
		if(clickOnArchiveLink.isDisplayed()) {
		TestUtil.click(clickOnArchiveLink);
		}else {
			System.out.println("Archive button is not available");
		}
	}
	
	//Click on Archive Button (From Pop up) 
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement clickOnArchiveButton;
	
	public void setClickOnArchiveButton() {
		TestUtil.click(clickOnArchiveButton);
	}
	
	
	//Click on Un-Archive link
	@FindBy(xpath = "//label[contains(text(),'Un-Archive')]")
	WebElement clickOnUnArchiveLink;
	
	public void setClickOnUnArchiveLink() throws InterruptedException {
		Thread.sleep(2000);
		if(clickOnUnArchiveLink.isDisplayed()) {
		TestUtil.click(clickOnUnArchiveLink);
		}else {
			System.out.println("Un-Archive button is not available");
		}
	}

	//Click on Un-Archive Button (From Pop up) 
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement clickOnUnArchiveButton;
	
	public void setClickOnUnArchiveButton() {
		TestUtil.click(clickOnUnArchiveButton);	
	}
	
	//Requirement Grid 1st Row data (forRequirement Name)
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[3]")
	WebElement requirementName;
	
	public String setRequirementName() {
		return requirementName.getText();
	}
	
	//----------------------Add Note----------------------
	//Click on Add Note link
	@FindBy(xpath = "//span[@class='add-notes-heading']")
	WebElement clickOnAddNoteLink;

	public void setClickOnAddNoteLink() {
		TestUtil.click(clickOnAddNoteLink);
	}
	
	//Enter note into textbox
	@FindBy(xpath = "//textarea[@class='ng-untouched ng-pristine ng-valid']")
	WebElement enterNoteInTextBox;

	public void setEnterNoteInTextBox(String note) {
		TestUtil.sendInput(enterNoteInTextBox, note);
	}

	// Click on Add Note Button
	@FindBy(xpath = "//button[contains(text(),'Add Note')]")
	WebElement clickOnAddNoteButton;

	public void setClickOnAddNoteButton() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnAddNoteButton);
	}
	
	// Click on Cancel button of Add Note pop up
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement clickOnCancelBtnOfAddNote;

	public void setClickOnCancelBtnOfAddNote() {
		TestUtil.click(clickOnCancelBtnOfAddNote);
	}
	
	//----------------------Schedule Meeting---------------------
	// Click on Schedule Meeting Button
	@FindBy(xpath = "//button[@class='blueButton' or contains(text(),'Schedule Meeting')]")
	WebElement clickOnScheduleMeetingButton;

	public void setClickOnScheduleMeetingButton() {
		TestUtil.click(clickOnScheduleMeetingButton);
	}
	
	//Schedule Meeting pop up name
	@FindBy(xpath = "//div[contains(text(),'Schedule Meeting')]")
	WebElement scheduleMeetingPopupName;
	
	public String setScheduleMeetingPopUpName() {
		return scheduleMeetingPopupName.getText();
	}
	
	//Enter Email id
	@FindBy(xpath = "//input[@name='meetingSentTo']")
	WebElement enterEmailId;
	
	public void setEnterEmailId(String emailid) {
		enterEmailId.clear();
		TestUtil.sendInput(enterEmailId, emailid);
	}
	
	//Appointment-Type Dropdown
	@FindBy(xpath = "//ng-select[@name='appointmentType']")
	WebElement clickAppointmentTypeDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectAppointmentType;
	
	public void setSelectAppointmentType(String appointmentType) throws InterruptedException {
		TestUtil.click(clickAppointmentTypeDropdown);
		Thread.sleep(2000);
		String AppointmentType = selectAppointmentType.getText();
		System.out.println("++++++++++++++++"+selectAppointmentType);
		driver.findElement(By.xpath("//span[contains(text(),'"+appointmentType+"')]")).click();		
	}	
		
	//Sub-Type Dropdown
	@FindBy(xpath = "//ng-select[@name='appointmentSubType']")
	WebElement clickSubTypeDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectSubType;
	
	public void setSelectSubType(String subType) throws InterruptedException {
		TestUtil.click(clickSubTypeDropdown);
		Thread.sleep(2000);
		String SubType = selectAppointmentType.getText();
		System.out.println("++++++++++++++++"+ SubType);
		driver.findElement(By.xpath("//span[contains(text(),'"+subType+"')]")).click();		
	}	
	
	//Start Date _ Schedule Meeting
	@FindBy(xpath = "//input[@name='startDate']")
	WebElement clickOnStartDateBox;
	
	@FindBy(xpath = "//span[@class='owl-dt-control-button-arrow']")
	WebElement clickOnDropButton_ScheduleMeeting;

	@FindBy(xpath = "//tbody[@class='owl-dt-calendar-body']")
	List<WebElement> selectYear_ScheduleMeeting;
	
	//Select Month
    @FindBy(xpath = "//tbody[@class='owl-dt-calendar-body']")
	List<WebElement> selectMonth_ScheduleMeeting;
    
	//Select Date
	@FindBy(xpath = "//tbody[@class='owl-dt-calendar-body']")
	List<WebElement> selectDate_ScheduleMeeting;
	
	//End Date _ Schedule Meeting
	@FindBy(xpath = "//input[@name='endDate']")
	WebElement clickOnEndDateBox;
		
	public void clickOnStartDateBox() throws InterruptedException {
		TestUtil.click(clickOnStartDateBox);
		Thread.sleep(1000);
		TestUtil.click(clickOnDropButton_ScheduleMeeting);
	}
	
	public void selectYear_ScheduleMeeting(String year) throws InterruptedException {		
		Thread.sleep(2000);
		Iterator<WebElement> it = selectYear.iterator();
		while(it.hasNext()) {
			WebElement year1 = it.next();
			System.out.println(year1.getText());
	
			if(year.equals("2019")) {
				driver.findElement(By.xpath("//span[contains(@class,'owl-dt-calendar-cell-content owl-dt-calendar-cell-today')]")).click();
			}
			else 
			{							
			WebElement we = driver.findElement(By.xpath(" //span[@class='owl-dt-calendar-cell-content'][contains(text(),'" +year+ "')]"));
			we.click();
			}		
		}
	}
	
	public void selectMonth_ScheduleMeeting(String month) throws InterruptedException {
		Thread.sleep(2000);
		Iterator<WebElement> it_month = selectMonth.iterator();
		while(it_month.hasNext()) {
			WebElement months = it_month.next();
		
		System.out.println("Start month is : "+months.getText());
		
		if(month.equals("Sep")) {
			driver.findElement(By.xpath("//span[@class='owl-dt-calendar-cell-content owl-dt-calendar-cell-today']")).click();
		}
		else
		{
		WebElement we = driver.findElement(By.xpath(" //span[@class='owl-dt-calendar-cell-content'][contains(text(),'" +month+ "')]"));
		we.click();
		}
	
		}
	}
	
	public void setSelectDate_ScheduleMeeting(String date) throws InterruptedException {
		Thread.sleep(2000);
		Iterator<WebElement> it_date = selectDate.iterator();
		while(it_date.hasNext()) {
			WebElement alldate = it_date.next();
		
		System.out.println("Date is ::-" + alldate.getText());
		
		WebElement we = driver.findElement(By.xpath(" //span[@class='owl-dt-calendar-cell-content'][contains(text(),'" +date+ "')]"));
		
		we.click();				
		}		
	}

		
	//Select End Date
	public void clickOnEndDateBox() throws InterruptedException {
		TestUtil.click(clickOnEndDateBox);
		Thread.sleep(1000);
		TestUtil.click(clickOnDropButton_ScheduleMeeting);
	}
	
	//Enter Start Time
	@FindBy(xpath = "//input[@name='startTime']")
	WebElement enterStartTime;
	
	public void setEnterStartTime(String statTime) {
		TestUtil.sendInput(enterStartTime, statTime);
	}
	
	//Enter End Time
	@FindBy(xpath = "//input[@name='endTime']")
	WebElement enterEndTime;
	
	public void setEnterEndTime(String statTime) {
		TestUtil.sendInput(enterEndTime, statTime);
	}
	
	//Remainder Dropdown
	@FindBy(xpath = "//ng-select[@name='reminderInterval']")
	WebElement clickRemainderDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectRemainder;
	
	public void setSelectRemainder(String remainder) throws InterruptedException {
		TestUtil.click(clickRemainderDropdown);
		Thread.sleep(2000);
		String RemainderOptions = selectRemainder.getText();
		System.out.println("++++++++++++++++"+ RemainderOptions);
		driver.findElement(By.xpath("//span[contains(text(),'"+remainder+"')]")).click();		
	}	
	
	//Auto Follow Up Dropdown
	@FindBy(xpath = "//ng-select[@name='autoFollowUpValue']")
	WebElement clickAutoFollowUpDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectAutoFollowUp;
	
	public void setSelectAutoFollowUp(String autoFollowUp) throws InterruptedException {
		TestUtil.click(clickAutoFollowUpDropdown);
		Thread.sleep(2000);
		String RemainderOptions = selectAutoFollowUp.getText();
		System.out.println("++++++++++++++++"+ RemainderOptions);
		driver.findElement(By.xpath("//span[contains(text(),'"+autoFollowUp+"')]")).click();		
	}	
	
	//Enter Subject
	@FindBy(xpath = "//input[@name='meetingSubject']")
	WebElement enterSubject;
	
	public void setEnterSubject(String subject) {
		TestUtil.sendInput(enterSubject, subject);
	}

	//Click on Schedule button
	@FindBy(xpath = "//div[@class='text-right col-md-6']//button")
	WebElement clickOnScheduleButton;
	
	public void setClickOnScheduleButton() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnScheduleButton);
	}
	
	//Get Consultant Name
	@FindBy(xpath = "//input[@name='consultantname']")
	WebElement consultantName;
	
	public String setConsultantName() {
		return consultantName.getAttribute("ng-reflect-model");
	}
	
	// Click on Cancel button of Schedule Meeting pop up
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement clickOnCancelButtonOfScheduleMeetingPopup;

	public void setClickOnCancelButtonOfScheduleMeetingPopup() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnCancelButtonOfScheduleMeetingPopup);
	}
	
	//-----------------Status-------------------
	//Status pop up title
	@FindBy(xpath = "//div[@class='col-md-10']//span[contains(text(),'Set Status')]")
	WebElement statusPopUpTitle;
	
	public String setStatusPopUpTitle() {
		return statusPopUpTitle.getText();
	}
	
	// Select the Radio button of Requirement
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[1]")
	WebElement selectRadioButtonOfRequirement;

	public void setSelectRadioButtonOfRequirement() throws InterruptedException {
		Thread.sleep(3000);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(StaleElementReferenceException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {

				TestUtil.click(selectRadioButtonOfRequirement);

				return selectRadioButtonOfRequirement;
			}
		});
	}
	
	//Click on Status link
	@FindBy(xpath = "//label[contains(text(),'Status')]")
	WebElement clickOnStatusLink;
	
	public void setClickOnStatusLink_ConsultantPage() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnStatusLink);
	}
	
	//Select Status
	@FindBy(xpath = "//div[@class='ng-select-container']")
	WebElement clickStatusDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectStatus;
	
	public void setselectStatus(String status) throws InterruptedException {
		TestUtil.click(clickStatusDropdown);
		Thread.sleep(2000);
		String StatusOption = selectStatus.getText();
		System.out.println("++++++++++++++++"+StatusOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+status+"')]")).click();		
	}
	
	//Enter Notes
	@FindBy(xpath = "//textarea[@placeholder='Enter Notes here']")
	WebElement enterNotes;
	
	public void setEnterNotes(String note) {
		TestUtil.sendInput(enterNotes, note);
	}
	
	//Click on Set Status button
	@FindBy(xpath = "//div[@class='status-footer-inner-wrapper']//span[contains(text(),'Set Status')]")
	WebElement clickOnSetStatus;
	
	public void setClickOnSetStatus() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnSetStatus);
	}
	
	//Click on Cancel button of Set Status pop up
	@FindBy(xpath = "//div[@class='status-footer-inner-wrapper']//a[contains(text(),'Cancel')]")
	WebElement clickOnCancelButtonOfSetStatusPopup;
	
	public void setClickOnCancelButtonOfSetStatusPopup() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnCancelButtonOfSetStatusPopup);
	}
	
	//Get Requirement Id
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[3]")
	WebElement requirementId;
	
	public String getRequirementId() throws InterruptedException {
		Thread.sleep(3000);
		return requirementId.getText();
	}
	
	//Consultant name in Requirement (Consultant tab) Grid 1st Row data 
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]")
	WebElement requirementId_InConsultant;

	public String setRequirementId_InConsultant() {
		return requirementId_InConsultant.getText();
	}
	
	public void setClickOnRequirementId() {
		TestUtil.click(requirementId_InConsultant);
	}
	
	//Click on Delete Recent Status button
	@FindBy(xpath = "//span[contains(text(),'Delete Recent Status')]")
	WebElement clickOnDeleteRecentStatus;
	
	public void setClickOnDeleteRecentStatus() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnDeleteRecentStatus);
	}
	
	//Click on Delete Button 
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement clickOnDeleteButton;
	
	public void setClickOnDeleteButton() throws InterruptedException {
		Thread.sleep(3000);
		TestUtil.click(clickOnDeleteButton);
	}
	
	//Click on View Job Description link
	@FindBy(xpath = "//span[contains(text(),'View Job Description')]")
	WebElement clickOnJobDescriptionLink;
	
	public void setClickOnJobDescriptionLink() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnJobDescriptionLink);
	}
	
	//View Job Description pop up title
	@FindBy(xpath = "//div[@class='col-md-11']/label")
	WebElement jobDescriptionpopuptitle;
	
	public String getTextOfJobDescriptionpopuptitle() {
		return jobDescriptionpopuptitle.getText();
	}
	
	public void setUploadConsultantResume(String path1) throws InterruptedException, AWTException {
		
		 // Specify the file location with extension
		 StringSelection sel1 = new StringSelection(path1);
		 
		 
		 // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel1,null);
		
		 System.out.println("selection is : " +sel1);
		
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
		        
		 //Press Enter 		
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 	
		 Thread.sleep(1000);
		//----------------------------------------- 
		 
		 Dimension i = driver.manage().window().getSize(); 
			
			System.out.println("Size is : "+i.getWidth()+" "+i.getHeight());
			
			int x = (i.getWidth()/4);
			int y = (i.getHeight()/3);
			
			robot.mouseMove(x,y);
			
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); 
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			
			Thread.sleep(2000);
		 
		/*
		 
		 robot.keyPress(KeyEvent.VK_TAB);
		 robot.keyRelease(KeyEvent.VK_TAB);
		 
		 robot.keyPress(KeyEvent.VK_TAB);
		 robot.keyRelease(KeyEvent.VK_TAB);
		 
		 robot.keyPress(KeyEvent.VK_TAB);
		 robot.keyRelease(KeyEvent.VK_TAB);
		 
		 robot.keyPress(KeyEvent.VK_TAB);
		 robot.keyRelease(KeyEvent.VK_TAB);
		 
		 robot.keyPress(KeyEvent.VK_TAB);
		 robot.keyRelease(KeyEvent.VK_TAB);
		 
		 robot.keyPress(KeyEvent.VK_TAB);
		 robot.keyRelease(KeyEvent.VK_TAB);
		 
		 */
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_A);
		 		
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_A);
		 
		 Thread.sleep(2000);
		 
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 
		 System.out.println("Enter Releases");
		 
		/*driver.switchTo()
	       .activeElement()
	       .sendKeys("C:\\Users\\chavan_v\\code3.txt");
		System.out.println("Attribute is : "+uploadResume.getAttribute("type"));
		System.out.println("File Uploaded sucessfully");*/
	}

	//Click on AI Sreach radio button
	@FindBy(xpath = "//label[contains(text(),'AI')]")
	WebElement clickOnAIRadioButton;
	
	public void setClickOnAIRadioButton() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(StaleElementReferenceException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {

				TestUtil.click(clickOnAIRadioButton);

				return clickOnAIRadioButton;
			}
		});
	}
	
	//Click on Apply button
	@FindBy(xpath = "//a[contains(text(),'Apply')]")
	WebElement clickOnApplyButton;
	
	public void setClickOnApplyButton() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnApplyButton);
	}

	//Consultant count_Headng- Label
	@FindBy(xpath = "//div[@class='content-heading col-md-4']//span")
	WebElement consultantCount_Heading;
	
	public String setConsultantCount_Heading() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
	//wait.until(ExpectedConditions.visibilityOf(totalConsultantcount));
	
	TestUtil.getText(consultantCount_Heading, 30);
	
	System.out.println("Count in grid is : "+consultantCount_Heading.getText());
	return consultantCount_Heading.getText();
	}	
	
	// Rank column
	@FindBy(xpath = "//div[contains(text(),'Rank')]")
	WebElement checkRankColumnIsDisplayed;

	public void setCheckRankColumnIsDisplayed() throws InterruptedException {
		Thread.sleep(2000);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(50, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(ElementClickInterceptedException.class)
				.ignoring(StaleElementReferenceException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {

				checkRankColumnIsDisplayed.isDisplayed();

				return checkRankColumnIsDisplayed;
			}
		});
	}

	// Relevance column
	@FindBy(xpath = "//div[contains(text(),'Rank')]")
	WebElement clickOnRelevanceColumnForSorting;

	public void setClickOnRelevanceColumnForSorting() throws InterruptedException {
		Thread.sleep(2000);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(50, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(StaleElementReferenceException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {

				clickOnRelevanceColumnForSorting.click();

				return clickOnRelevanceColumnForSorting;
			}
		});
	}

	
}
