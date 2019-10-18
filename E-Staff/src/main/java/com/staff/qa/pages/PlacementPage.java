package com.staff.qa.pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.staff.qa.base.TestBase;
import com.staff.qa.util.TestUtil;

public class PlacementPage extends TestBase {
	
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
				withTimeout(30, TimeUnit.SECONDS)
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
	
	
	//Filters --> Open Tag - Placement
	@FindBy(xpath = "//div[contains(text(),'Open')]")
	WebElement clickOnOpenTag_Placement;


	public void setClickOnOpenTag_Placement() throws InterruptedException {
		Thread.sleep(2000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(30, TimeUnit.SECONDS)
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
				withTimeout(30, TimeUnit.SECONDS)
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
				withTimeout(30, TimeUnit.SECONDS)
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
				withTimeout(30, TimeUnit.SECONDS)
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
				withTimeout(30, TimeUnit.SECONDS)
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
				withTimeout(30, TimeUnit.SECONDS)
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
				withTimeout(120, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
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
				withTimeout(120, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
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
				withTimeout(120, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
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
	@FindBy(xpath = "//button[@class='plcmnt-edit-submit-btn']")
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
	
	//Click on Cancel button of edit placement form
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement clickOnCancelButton_EditPlacementForm;
	
	public void getClickOnCancelButton() throws InterruptedException {
		Thread.sleep(2000);
		TestUtil.click(clickOnCancelButton_EditPlacementForm);
	}
}


