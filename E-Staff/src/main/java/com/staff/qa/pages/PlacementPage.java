package com.staff.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.staff.qa.base.BaseClass;
import com.staff.qa.util.TestUtil;

public class PlacementPage extends BaseClass {
	
	String[] startDate = null;
	
	public PlacementPage() {
		PageFactory.initElements(this.driver, this);
	}
	
	//Total Placement count - Label
	@FindBy(xpath = "//div[@class='content-heading col-md-4']")
	WebElement totalPlacement;
	
	public String setTotalPlacementLabel() {
		System.out.println("Count in grid is : "+totalPlacement.getText());
		return totalPlacement.getText();		
	}
	
	//Count of All-Placement in grid section  
	@FindBy(xpath = "//div[@class='placements-list-container col-md-10']//ats-data-table")
	WebElement allPlacement;
	
	public String setAllPlacementCountInGrid() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    	System.out.println("------------------Waiting ----------------");
	    	allPlacement.getAttribute("ng-reflect-total-records");
		return allPlacement;
	}		
		});
		return allPlacement.getAttribute("ng-reflect-total-records");
	}
	
	//Filters --> All Tag - Placement
	@FindBy(xpath = "//div[@class='filter-tags filter-block']//div[2]")
	WebElement clickOnAllTag_Placement;


	public void setClickOnAllTag_Placement() throws InterruptedException {
		Thread.sleep(2000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
		TestUtil.click(clickOnAllTag_Placement);
		return clickOnAllTag_Placement;
	}		
		});
	}

	
	//Filters --> Open Tag - Placement
	@FindBy(xpath = "//div[contains(text(),'Open')]")
	WebElement clickOnOpenTag_Placement;


	public void setClickOnOpenTag_Placement() throws InterruptedException {
		Thread.sleep(2000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
		TestUtil.click(clickOnOpenTag_Placement);
		return clickOnOpenTag_Placement;
	}		
		});
	}

	//Filters --> Pending Approved Tag - Placement
	@FindBy(xpath = "//div[@class='filter-tags filter-block']//div[4]")
	WebElement clickOnPendingApprovedTag_Placement;


	public void setClickOnPendingApprovedTag_Placement() {	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
		TestUtil.click(clickOnPendingApprovedTag_Placement);
		return clickOnPendingApprovedTag_Placement;
	}		
		});
	}

	//Filters --> Approved Tag - Placement
	@FindBy(xpath = "//div[@class='filter-tags filter-block']//div[5]")
	WebElement clickOnApprovedTag_Placement;


	public void setClickOnApprovedTag_Placement() {	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
		TestUtil.click(clickOnApprovedTag_Placement);
		return clickOnApprovedTag_Placement;
	}		
		});
	}

	//Filters --> Candidate On Billing Tag - Placement
	@FindBy(xpath = "//div[@class='filter-tags filter-block']//div[6]")
	WebElement clickOnCandidateOnBillingTag_Placement;


	public void setClickOnCandidateOnBillingTag_Placement() {	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
		TestUtil.click(clickOnCandidateOnBillingTag_Placement);
		return clickOnCandidateOnBillingTag_Placement;
	}		
		});
	}
	
	//Filters --> Backed Out Tag - Placement
	@FindBy(xpath = "//div[@class='filter-tags filter-block']//div[7]")
	WebElement clickOnBackedOutTag_Placement;


	public void setClickOnBackedOutTag_Placement() {	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
		TestUtil.click(clickOnBackedOutTag_Placement);
		return clickOnBackedOutTag_Placement;
	}		
		});
	}

	//Filters --> Candidate Ended Tag - Placement
	@FindBy(xpath = "//div[@class='filter-tags filter-block']//div[8]")
	WebElement clickOnCandidateEndedTag_Placement;


	public void setClickOnCandidateEndedTag_Placement() {	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(90, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(ElementClickInterceptedException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
		TestUtil.click(clickOnCandidateEndedTag_Placement);
		return clickOnCandidateEndedTag_Placement;
	}		
		});
	}

	
	//Requirement Id in grid
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]")
	WebElement requirementId;
	
	public String setRequirementID_PlacementGrid() throws InterruptedException {
		Thread.sleep(5000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    requirementId.getText();
		return requirementId;
	    }   
	});
		return requirementId.getText();
		}
	
	//Search Textbox - Consultant
	@FindBy(xpath = "//input[@name='searchValue']")
	WebElement allPlacementsearchTextBox;
	
	public void setAllPlacementsearchTextBox(String search) throws InterruptedException {	
		TestUtil.sendInput(allPlacementsearchTextBox, search);				
	}
	
	//Click On Requirement Id in grid
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']/div[1]/div[2]")
	WebElement clickOnRequirementId;
	
	public void setClickOnRequirementID_PlacementGrid() throws InterruptedException {
		Thread.sleep(5000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    TestUtil.click(clickOnRequirementId);
		return clickOnRequirementId;
	    }   
	});
		
		}
	
	//Click on Edit button
	@FindBy(xpath = "//button[@class='ng-tns-c9-9' or contains(text(),'Edit')]")
	WebElement clickOnEditButton;
	
	public void setClickOnEditButton() throws InterruptedException {
		Thread.sleep(5000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    TestUtil.click(clickOnEditButton);
		return clickOnEditButton;
	    }   
	});		
		}
	
	//Select the 'Did Not Start Reason' Radio Button
	@FindBy(xpath = "//label[@class='radio-container'][contains(text(),'Did Not Start Reason')]")
	WebElement selectDiDNotStartRadioBtn;
	
	
	public void setSelectDiDNotStartRadioBtn() {		
		TestUtil.click(selectDiDNotStartRadioBtn);		
	}
	
	//Select 'Did Not Start Reason' option from dropdown
	@FindBy(xpath = "//ng-select[@name='didNotStartReason']")
	WebElement clickDidNotStartDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]")	
	WebElement selectDidNotStart;
	
	public void setselectRecruiter(String DidNotStart) throws InterruptedException {
		TestUtil.click(clickDidNotStartDropdown);
		Thread.sleep(2000);
		String DidNotStartrOption = selectDidNotStart.getText();
		System.out.println("++++++++++++++++"+DidNotStartrOption);
		driver.findElement(By.xpath("//span[contains(text(),'"+DidNotStart+"')]")).click();		
	}	
	
	//click on Save Button 
	@FindBy(xpath = "//button[@class='plcmnt-edit-submit-btn'][contains(text(),'Save')]")
	WebElement clickOnSaveButton;
	
	public void setClickOnSaveButton() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnSaveButton);
	}
	
	//Get Consultant Name
	@FindBy(xpath = "//div[@class='content-heading col-md-4']//span")
	WebElement consultantName;
	
	public String getConsultantName() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Name is :???? "+consultantName.getAttribute("title"));
		return consultantName.getAttribute("title");
	}
	
	//Confirmation message
	@FindBy(xpath = "//div[@class='col-md-10 msg-content']")
	WebElement placementConfirmationMessage;

	public String setPlacementConfirmationMessage() {
		System.out.println(placementConfirmationMessage.getText());
		return placementConfirmationMessage.getText();
	}
	
	public void setWaitUntilConfirmationMessageAppear() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    	WebElement el = driver.findElement(By.xpath("//div[@class='col-md-10 msg-content']"));
		return el;
	    }   
	});		
	}
	
	//Click on Cancel button of edit placement form
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement clickOnCancelButton_EditPlacementForm;
	
	public void getClickOnCancelButton() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnCancelButton_EditPlacementForm);
	}
	
	//Select Sales Person from dropdown
	@FindBy(xpath = "//ng-select[@name='salesPerson']")
	WebElement clickOnSalesPersonDropDown;
	
	public void setSelectSalesPerson(String SalesPerson) throws InterruptedException {  		
		TestUtil.click(clickOnSalesPersonDropDown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+SalesPerson+"')]")).click();				
	}
	
	//Select Recruiter from dropdown
	@FindBy(xpath = "//ng-select[@name='recruiter']")
	WebElement clickOnRecruiterDropDown;
	
	public void setSelectRecruiter(String Recruiter) throws InterruptedException {  		
		TestUtil.click(clickOnRecruiterDropDown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+Recruiter+"')]")).click();				
	}
	
	//Enter the Manager Email
	@FindBy(xpath = "//input[@name='managerEmail']")
	WebElement enterManagerEmail;
	
	public void setEnterManagerEmail(String ManagerEmail) {
		enterManagerEmail.clear();
		TestUtil.sendInput(enterManagerEmail, ManagerEmail);
	}
	
	
	//Click on Status column filter
	@FindBy(xpath = "//div[@class='customHeaderLabel ng-star-inserted'][contains(text(),'Status')]")
	WebElement clickOnStatusColumnFilter;
	
	public void setClickOnStatusColumnFilter() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    	TestUtil.click(clickOnStatusColumnFilter);
		return clickOnStatusColumnFilter;
	    }   
	});		
	}
	
	//Status rows 
	@FindBy(xpath = "//div[@class='ag-body-container ag-layout-normal']//div[9]")
	WebElement statusCloumn;
	
	public String verifyStatus() throws InterruptedException {		
	
		/*Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//div[@class='placements-list-container col-md-10']//ats-data-table")));
		ac.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);*/
		
		//get the count
		int size = driver.findElements(By.xpath("//div[@class='ag-body-container ag-layout-normal']//div[9]")).size();
		System.out.println("<<<<<<<<<"+size);	
		
		WebElement actualStatus = null ;
		
		for(int i=1 ; i<size ; i++) {
			actualStatus = driver.findElement(By.xpath("//div[@class='ag-body-container ag-layout-normal']/div["+i+"]/div[9]"));			
		/*	if(s12.getText().equalsIgnoreCase(expectedStatus)) {
				System.out.println("Found other status : "+s12.getText());*/			
			
			}
		return actualStatus.getText();
		}			
	
	//Click on Download in Ms-Word link
	@FindBy(xpath = "//label[contains(text(),'Download in Ms-Word')]")
    WebElement clickDownloadInMsWordLink;
	
	public void setClickDownloadInMsWordLink() {
		TestUtil.click(clickDownloadInMsWordLink);
	} 
	
	
	//Select Business Unit from dropdown
	@FindBy(xpath = "//ng-select[@name='buisnessUnit']")
	WebElement clickOnBusinessUnitDropDown;

	public void setSelectBusinessUnit(String BusinessUnit) throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnBusinessUnitDropDown);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'" + BusinessUnit + "')]")).click();
	}
	
	//Enter Xoriant-Client
	@FindBy(xpath = "//ng-select[@name='xoriantClient']")
    WebElement enterXoriantClient;
	
	public void setEnterXoriantClient(String XoriantClient) throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(enterXoriantClient);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ng-dropdown-panel[contains(@class,'ng-dropdown-panel ng-star-inserted ng-select')]//div[contains(text(),'"+XoriantClient+"')]")).click();
	} 
	
	//Enter End Client Name
	@FindBy(xpath = "//input[@name='endClientName']")
    WebElement enterEndClientName;
	
	public void setEnterEndClientName(String EndClientName) {
		enterEndClientName.clear();
		TestUtil.sendInput(enterEndClientName, EndClientName);
	} 
	
	//Enter Client Name in Offer Letter
	@FindBy(xpath = "//input[@name='clientNameInOffer']")
    WebElement enterClientNameInOfferLetter;
	
	public void setEnterClientNameInOfferLetter(String ClientNameInOfferLetter) {
		enterClientNameInOfferLetter.clear();
		TestUtil.sendInput(enterClientNameInOfferLetter, ClientNameInOfferLetter);
	} 
	
	//Enter Manager Name
	@FindBy(xpath = "//input[@name='managerName']")
    WebElement enterManagerName;
	
	public void setEnterManagerName(String ManagerName) {
		enterManagerName.clear();
		TestUtil.sendInput(enterManagerName, ManagerName);
	} 
	
	//Enter Manager Phone
	@FindBy(xpath = "//input[@name='managerPhone']")
    WebElement enterManagerPhone;
	
	public void setEnterManagerPhone(String ManagerPhone) {
		enterManagerPhone.clear();
		TestUtil.sendInput(enterManagerPhone, ManagerPhone);
	} 
	
	//Select Nature Of Assignment from dropdown
	@FindBy(xpath = "//ng-select[@name='natureOfAssignment']")
	WebElement clickOnNatureOfAssignmentDropDown;

	public void setSelectNatureOfAssignment(String NatureOfAssignment) throws InterruptedException {
		TestUtil.click(clickOnNatureOfAssignmentDropDown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'" + NatureOfAssignment + "')]")).click();
	}

	//Enter Bill Rate
	@FindBy(xpath = "//input[@name='billRate']")
    WebElement enterBillRate;
	
	public void setEnterBillRate(String BillRate) {
		enterBillRate.sendKeys(Keys.BACK_SPACE);
		enterBillRate.sendKeys(Keys.BACK_SPACE);
		enterBillRate.sendKeys(Keys.BACK_SPACE);
		enterBillRate.sendKeys(Keys.BACK_SPACE);
		TestUtil.sendInput(enterBillRate, BillRate);
	} 
	
	//Select Bill Rate UOM from dropdown
	@FindBy(xpath = "//ng-select[@name='billRateUOM']")
	WebElement clickOnBillRateUOMDropDown;

	public void setSelectBillRateUOM(String BillRateUOM) throws InterruptedException {
		TestUtil.click(clickOnBillRateUOMDropDown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'" + BillRateUOM + "')]")).click();
	}
	
	//Select Billing Frequency from dropdown
	@FindBy(xpath = "//ng-select[@name='billingFrequency']")
	WebElement clickOnBillingFrequencyDropDown;

	public void setSelectBillingFrequency(String BillingFrequency) throws InterruptedException {
		TestUtil.click(clickOnBillingFrequencyDropDown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'" + BillingFrequency + "')]")).click();
	}
	

	//Click on Estimated Start Date Box
	@FindBy(xpath = "//input[@name='estimatedStartDate']")
	WebElement clickOnEstimatedStartDate;
	
	@FindBy(xpath = "//span[@class='owl-dt-control-button-arrow']")
	WebElement clickOnDropButton;
	
	public void clickOnEstimatedStartDateBox() throws InterruptedException {
		TestUtil.click(clickOnEstimatedStartDate);
		Thread.sleep(1000);
		TestUtil.click(clickOnDropButton);
	}
	
	// Click on Estimated End Date Box
	@FindBy(xpath = "//input[@name='estimatedEndDate']")
	WebElement clickOnEstimatedEndDate;

	public void clickOnEstimatedEndDateBox() throws InterruptedException {
		TestUtil.click(clickOnEstimatedEndDate);
		Thread.sleep(1000);
		TestUtil.click(clickOnDropButton);
	}

	//Enter Billing Contact Name 
	@FindBy(xpath = "//input[@name='billingContactName']")
	WebElement enterBillingContactName;

	public void setEnterBillingContactName(String BillingContactName) {
		enterBillingContactName.clear();
		TestUtil.sendInput(enterBillingContactName, BillingContactName);
	}

	//Country Dropdown
	@FindBy(xpath = "//ng-select[@name='assignmentCountry']")
	WebElement clickCountryDropdown;
	
	public void setselectCountry(String Country) throws InterruptedException {
		TestUtil.click(clickCountryDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][text()='"+Country+"']")).click();		
	}
	
	//State Dropdown
	@FindBy(xpath = "//ng-select[@name='assignmentState']")
	WebElement clickStateDropdown;
	
	public void setselectState(String State) throws InterruptedException {
		TestUtil.click(clickStateDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+State+"')]")).click();		
	}	
	
	//City Dropdown
	@FindBy(xpath = "//ng-select[@name='assignmentCity']")
	WebElement clickCityDropdown;
	
	public void setselectCity(String City) throws InterruptedException {
		TestUtil.click(clickCityDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+City+"')]")).click();		
	}
	
	//----------------------------Edit the Consultant Details fields
	//Click on Consultant Details link
	@FindBy(xpath = "//div[contains(text(),'Consultant Details')]")
    WebElement clickConsultantDetailsLink;
	
	public void setClickConsultantDetailsLink() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickConsultantDetailsLink);
	} 
	
	// Click on Client & Assignment link
	@FindBy(xpath = "//div[contains(text(),'Client & Assignment')]")
	WebElement clickClientAndAssignmentLink;

	public void setClickClientAndAssignmentLink() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickClientAndAssignmentLink);
	}

	// Enter the First Name
	@FindBy(xpath = "//input[@name='ConsultantFName']")
	WebElement enterConsultantFName;

	public void setEnterConsultantFName(String ConsultantFName) {
		enterConsultantFName.clear();
		TestUtil.sendInput(enterConsultantFName, ConsultantFName);
	}

	// Enter the Last name
	@FindBy(xpath = "//input[@name='ConsultantLName']")
	WebElement enterConsultantLName;

	public void setEnterConsultantLastName(String ConsultantLName) {
		enterConsultantLName.clear();
		TestUtil.sendInput(enterConsultantLName, ConsultantLName);
	}
	
	//Select Gender from Dropdown
	@FindBy(xpath = "//ng-select[@name='consultantGender']")
	WebElement clickConsultantGenderDropdown;
	
	public void setselectConsultantGender(String Gender) throws InterruptedException {
		TestUtil.click(clickConsultantGenderDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+Gender+"')]")).click();		
	}
	
	//Enter the Email id
	@FindBy(xpath = "//input[@name='consultantEmail1']")
	WebElement enterConsultantEmail1;

	public void setEnterConsultantEmail1(String ConsultantEmail1) {
		enterConsultantEmail1.clear();
		TestUtil.sendInput(enterConsultantEmail1, ConsultantEmail1);
	}
	
	//Enter the Email2 id
	@FindBy(xpath = "//input[@name='consultantEmail2']")
	WebElement enterConsultantEmail2;

	public void setEnterConsultantEmail2(String ConsultantEmail2) {
		enterConsultantEmail2.clear();
		TestUtil.sendInput(enterConsultantEmail2, ConsultantEmail2);
	}
	//Enter the Mobile Number
	@FindBy(xpath = "//input[@name='consultantMobile']")
	WebElement enterConsultantMobile;

	public void setEnterConsultantMobile(String consultantMobile) {
		enterConsultantMobile.clear();
		TestUtil.sendInput(enterConsultantMobile, consultantMobile);
	}
	
	//Enter Address Line 1
	@FindBy(xpath = "//input[@name='consultantAddressLine1']")
	WebElement enterConsultantAddressLine1;

	public void setEnterConsultantAddressLine1(String consultantAddressLine1) {
		enterConsultantAddressLine1.clear();
		TestUtil.sendInput(enterConsultantAddressLine1, consultantAddressLine1);
	}
	

	//Select Country from Dropdown
	@FindBy(xpath = "//ng-select[@name='consultantCountries']")
	WebElement clickConsultantCountriesDropdown;
	
	public void setselectConsultantCountries(String consultantCountries) throws InterruptedException {
		TestUtil.click(clickConsultantCountriesDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][text()='"+consultantCountries+"']")).click();		
	}
	
	//Select State from Dropdown
	@FindBy(xpath = "//ng-select[@name='consultantState']")
	WebElement clickConsultantStateDropdown;
	
	public void setselectConsultantState(String consultantState) throws InterruptedException {
		TestUtil.click(clickConsultantStateDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+consultantState+"')]")).click();		
	}	
	
	//Select City from Dropdown
	@FindBy(xpath = "//ng-select[@name='consultantCity']")
	WebElement clickConsultantCityDropdown;
	
	public void setselectConsultantCity(String consultantCity) throws InterruptedException {
		TestUtil.click(clickConsultantCityDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+consultantCity+"')]")).click();		
	}

	//Enter Zip
	@FindBy(xpath = "//input[@name='consultantZipCode']")
	WebElement enterConsultantZipCode;

	public void setEnterConsultantZipCode(String consultantZipCode) {
		enterConsultantZipCode.clear();
		TestUtil.sendInput(enterConsultantZipCode, consultantZipCode);
	}
	
	//Enter Job Title
	@FindBy(xpath = "//input[@name='jobTitle']")
	WebElement enterJobTitle;

	public void setEnterJobTitle(String jobTitle) {
		enterJobTitle.clear();
		TestUtil.sendInput(enterJobTitle, jobTitle);
	}
	
	//Enter Skills
	@FindBy(xpath = "//textarea[@name='consultantSkills']")
	WebElement enterConsultantSkills;

	public void setEnterConsultantSkills(String consultantSkills) {
		enterConsultantSkills.clear();
		TestUtil.sendInput(enterConsultantSkills, consultantSkills);
	}
	
	//Select Candidate Source from Dropdown
	@FindBy(xpath = "//ng-select[@name='candidateSource']")
	WebElement clickCandidateSourceDropdown;
	
	public void setselectCandidateSource(String candidateSource) throws InterruptedException {
		TestUtil.click(clickCandidateSourceDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+candidateSource+"')]")).click();		
	}
	
	//Select Employment Type from Dropdown
	@FindBy(xpath = "//ng-select[@name='employementType']")
	WebElement clickEmployementTypeDropdown;
	
	public void setselectEmployementType(String employementType) throws InterruptedException {
		TestUtil.click(clickEmployementTypeDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+employementType+"')]")).click();		
	}
	
	//Select Visa Status from Dropdown
	@FindBy(xpath = "//ng-select[@name='visaStatus']")
	WebElement clickVisaStatusDropdown;
	
	public void setselectVisaStatus(String visaStatus) throws InterruptedException {
		TestUtil.click(clickVisaStatusDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+visaStatus+"')]")).click();		
	}	
	
	//Select Pay Rate UOM  from Dropdown
	@FindBy(xpath = "//ng-select[@name='payRateUOM']")
	WebElement clickPayRateUOMDropdown;
	
	public void setselectPayRateUOM(String payRateUOM) throws InterruptedException {
		TestUtil.click(clickPayRateUOMDropdown);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+payRateUOM+"')]")).click();		
	}
	
	// Enter Pay Rate
	@FindBy(xpath = "//input[@name='payRate']")
	WebElement enterPayRate;

	public void setEnterPayRate(String payRate) {
		enterPayRate.sendKeys(Keys.BACK_SPACE);
		enterPayRate.sendKeys(Keys.BACK_SPACE);
		enterPayRate.sendKeys(Keys.BACK_SPACE);
		enterPayRate.sendKeys(Keys.BACK_SPACE);
		TestUtil.sendInput(enterPayRate, payRate);
	}

	// ----------------------------Edit the Gross Margin fields
	// Click on Gross Margin link
	@FindBy(xpath = "//div[contains(text(),'Gross Margin')]")
	WebElement clickGrossMarginLink;

	public void setClickGrossMarginLink() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickGrossMarginLink);
	}
	
	//Get text of Total Loaded Cost
	@FindBy(xpath = "//div[@class='row no-gutters']//label[contains(text(),'Total Loaded Cost')]//following::span[1]")
	WebElement getTextOfTotalLoadedCost;
	
	public String getValueOfTotalLoadedCost() {
			
		String s = getTextOfTotalLoadedCost.getText();
		String ab = s.replaceAll("[$/Hr]", "");
		System.out.println("?????????????????????????"+ab);	
		return s.replaceAll("[$/Hr]", "");		
	}	
	
	//Get text of Bill Rate
	@FindBy(xpath = "//div[@class='row no-gutters']//label[contains(text(),'Bill Rate')]//following::span[1]")
	WebElement getTextOfBillRate;
	
	public String getValueOfBillRate() {				
		String s = getTextOfBillRate.getText();
		String ab = s.replaceAll("[$/Hr]", "");
		System.out.println("?????????????????????????"+ab);	
		return s.replaceAll("[$/Hr]", "");
	}

	//Get text of Xoriant Revenue
	@FindBy(xpath = "//div[@class='row no-gutters']//label[contains(text(),'Xoriant Revenue')]//following::span[1]")
	WebElement getTextOfXoriantRevenue;
	
	public String getValueOfXoriantRevenue() {	
		String s = getTextOfXoriantRevenue.getText();
		String ab = s.replaceAll("[$/Hr]", "");
		System.out.println("?????????????????????????"+ab);	
		return s.replaceAll("[$/Hr]", "");
	}
	
	//Enter Discount
	@FindBy(xpath = "//input[@name='gMDiscAdminFeesAmt']")
	WebElement enterDiscount;

	public void setEnterDiscount(String discount) {
		enterDiscount.sendKeys(Keys.BACK_SPACE);
		enterDiscount.sendKeys(Keys.BACK_SPACE);
		enterDiscount.sendKeys(Keys.BACK_SPACE);
		enterDiscount.sendKeys(Keys.BACK_SPACE);
		TestUtil.sendInput(enterDiscount, discount);
	}
	
	//Get text of Gross Margin
	@FindBy(xpath = "//div[@class='row no-gutters']//label[contains(text(),'Bill Rate')]//following::span[4]")
	WebElement getTextOfGrossMargin;
	
	public String getValueOfGrossMargin() {
		getTextOfGrossMargin.click();	
		String s = getTextOfGrossMargin.getText();
		String ab = s.replaceAll("[$/Hr]", "");
		System.out.println("?????????????????????????"+ab);	
		return s.replaceAll("[%]", "");
	}
	
	//Get text of Gross Margin in $/Hr
	@FindBy(xpath = "//div[@class='row no-gutters']//label[contains(text(),'Bill Rate')]//following::span[5]")
	WebElement getTextOfGrossMarginIn$PerHour;
	
	public String getValueOfGrossMarginIn$PerHour() {	
		String s = getTextOfGrossMarginIn$PerHour.getText();
		String ab = s.replaceAll("[$/Hr]", "");
		System.out.println("?????????????????????????"+ab);	
		return s.replaceAll("[$/Hr]", "");
	}
	
	//Click on Cancel button
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement clickCancelButton;

	public void setClickCancelButton() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickCancelButton);
	}
	
	//Companies Filter---------------------------
	//Enter text in search text box of Companies search tag
	@FindBy(xpath = "//input[@placeholder='Companies']")
	WebElement enterTextInCompaniesSearchTag;
	
	public void setEnterTextInCompaniesSearchTag(String companyName) {
		TestUtil.sendInput(enterTextInCompaniesSearchTag, companyName);
	}
	
	//Select Company 
	@FindBy(xpath = "//input[@placeholder='Companies']")
	WebElement selectCompanyCheckBox;
	
	public void setSelectCompanyCheckBox(String companyName) {
		TestUtil.sendInput(enterTextInCompaniesSearchTag, companyName);
	}
	
	// Account Manager Filter---------------------------
	// Enter text in search text box of Companies search tag
	@FindBy(xpath = "//input[@placeholder='Account Manager']")
	WebElement enterTextInAccountManagerSearchTag;

	public void setEnterTextInAccountManagerSearchTag(String accountManager) {
		TestUtil.sendInput(enterTextInAccountManagerSearchTag, accountManager);
	}

	//Placement Date Filter
	//Click on From Date Box
	@FindBy(xpath = "//input[@name='placementFromDt']")
	WebElement clickOnFromDate;
	
/*	@FindBy(xpath = "//span[@class='owl-dt-control-button-arrow']")
	WebElement clickOnDropButton;*/
	
	public void clickOnFromDateBox() throws InterruptedException {
		TestUtil.click(clickOnFromDate);
		Thread.sleep(1000);
		TestUtil.click(clickOnDropButton);
	}

	// Click on To Date Box
	@FindBy(xpath = "//input[@name='placementToDt']")
	WebElement clickOnToDate;
	
	public void clickOnToDateBox() throws InterruptedException {
	//	TestUtil.click(clickOnToDate);
		Thread.sleep(1000);
		TestUtil.click(clickOnDropButton);
	}
	
	// Click on To Initiate Offer Link
	@FindBy(xpath = "//label[contains(text(),'Initiate Offer')]")
	WebElement clickOnOfferLink;
	
	public void clickOnOfferLink() throws InterruptedException {
		Thread.sleep(1000);
		TestUtil.click(clickOnOfferLink);
	}
	
	@FindBy(xpath = "//span[@class='ng-arrow-wrapper']")
	WebElement emailsTextBox;
	
	public void setEmailsTextBox(String emailId) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ng-clear-wrapper ng-star-inserted']")).click();
		emailsTextBox.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+ emailId +"')]")).click();		
	}
	
	public void setEmailsTextBox2(String emailId2) throws InterruptedException {
		emailsTextBox.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'"+ emailId2 +"')]")).click();
	}
	
	
	@FindBy(xpath = "//div[contains(text(),'Initiate Offer')]")
	WebElement initiateOfferPopUpTiltle;
	
	public String setInitiateOfferPopUpTiltle() throws InterruptedException {
		Thread.sleep(1000);
		return initiateOfferPopUpTiltle.getText();
	}
	
	public boolean setInitiateOfferPopUpDisplayed() {
		 return initiateOfferPopUpTiltle.isDisplayed();
	}
	
	//Click On Initiate Offer Button
	@FindBy(xpath = "//span[contains(text(),'Initiate Offer')]")
	WebElement clickOnInitiateOffer;
	
	public void setClickOnInitiateOffer() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    	TestUtil.click(clickOnInitiateOffer);
		return clickOnInitiateOffer;
	    }   
	});		
		
	/*	Thread.sleep(2000);
		TestUtil.click(clickOnInitiateOffer);*/
	}
	
	//Click On Submit For Approval Button
	@FindBy(xpath = "//button[contains(text(),'Submit For Approval')]")
	WebElement clickOnSubmitForApproval;
	
	public void setClickOnSubmitForApproval() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnSubmitForApproval);
	}
	
	//Click On Cancel button for Approval pop up
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement clickOnCancelBtnForInitiateOfferPopUp;
		
	public void setClickOnCancelBtnForInitiateOfferPopUp() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnCancelBtnForInitiateOfferPopUp);
	}
		
	
	//Click On OK button for Submit For Approval Button
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement clickOnOKBtnSubmitForApproval;
	
	public void setClickOnOKBtnSubmitForApproval() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnOKBtnSubmitForApproval);
	}
	
	//Click On OK button for Submit For Initiate Offer button
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement clickOnOKBtnForInitiateOffer;
	
	public void setClickOnOKBtnForInitiateOffer() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnOKBtnForInitiateOffer);
	}
	
	// Click On Approve button 
	@FindBy(xpath = "//button[contains(text(),'Approve')]")
	WebElement clickOnApproveBtn;

	public void setClickOnApproveBtn() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnApproveBtn);
	}
		
	// Click On OK button for Approve pop up
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement clickOnOKBtnForApprovePopUp;

	public void setClickOnOKBtnForApprovePopUp() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnOKBtnForApprovePopUp);
	}

	// Click On Reject button 
	@FindBy(xpath = "//button[contains(text(),'Reject')]")
	WebElement clickOnRejectBtn;

	public void setClickOnRejectBtn() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnRejectBtn);
	}
	
	//Enter the Reason For Rejection 
	@FindBy(xpath = "//input[@name='reasonForRejection']")
	WebElement enterReasonForRejection ;

	public void setEnterReasonForRejection(String reasonForRejection) throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.sendInput(enterReasonForRejection, reasonForRejection);
	}
	
	// Click On Reject button from Reject pop-up
	@FindBy(xpath = "//span[contains(text(),'Reject')]")
	WebElement clickOnRejectBtnFromRejectPopUp;

	public void setClickOnRejectBtnFromRejectPopUp() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnRejectBtnFromRejectPopUp);
	}
}


