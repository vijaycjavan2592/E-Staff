package com.staff.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.staff.qa.base.TestBase;
import com.staff.qa.util.TestUtil;

public class ConsultantPage extends TestBase {

	public ConsultantPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()='Add New']")
	WebElement clickAddNewMenu;

	public void setClickAddNewMenu() {

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
	
	//Rate UOM
	@FindBy(xpath = "//ng-select[@name='payRateUOM']")
	WebElement clickRateUOMDropdown;
	
	@FindBy(xpath = "//ng-dropdown-panel[@class='ng-dropdown-panel ng-star-inserted ng-select-top']")	
	WebElement selectUOMRate;
	
	public void setselectUOMRate(String UOM) throws InterruptedException {
		TestUtil.click(clickRateUOMDropdown);
		Thread.sleep(2000);
		String AllUOM = selectUOMRate.getText();
		System.out.println("++++++++++++++++"+AllUOM);
		driver.findElement(By.xpath("//span[contains(text(),'"+UOM+"')]")).click();				
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
		driver.findElement(By.xpath("//span[contains(text(),'"+availability+"')]")).click();		
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
		
		if(month.equals("Sep")) {
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
		
		WebElement we = driver.findElement(By.xpath(" //span[contains(text(),'" +date+ "')]"));
		
		we.click();
		
		
		}
		
	}
	
	
	
		
	public void fillAddNewConsultantForm(String firstName, String lastName, String emailId, String mobileNo) throws InterruptedException {		
		TestUtil.sendInput(enterconsultantFirstName, firstName);
		TestUtil.sendInput(enterconsultantLasttName, lastName);
		TestUtil.sendInput(enterconsultantEmailId, emailId);
		TestUtil.sendInput(enterconsultantMobileNumber, mobileNo);
		
		
		
		
	}
}
