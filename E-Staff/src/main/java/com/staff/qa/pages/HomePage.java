package com.staff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.staff.qa.base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='fas fa-caret-down']")
	WebElement clickLogoutDropdown;
	
	@FindBy(xpath = "//div[@class='logout-div dis-block']")
	WebElement clickLogoutMenu;
	
	@FindBy(xpath = "//span[@class='custom-user']")
	WebElement userNameLabel;
	
	//Click on Menu button
	@FindBy(xpath = "//div[@id='hamburgerMenuIcon']")
	WebElement clickOnMenuButton;
	
	//Click on Companies menu
	@FindBy(xpath = "//div[@class='nav-item companies']")
	WebElement clickCompaniesOption;
	
	//Click on Consultant menu
	@FindBy(xpath = "//div[@class='nav-item consultants']")
	WebElement clickConsultantOption;
		
	
	public boolean verifyCorrectUserName() {
		//System.out.println(userNameLabel.getText());
		return userNameLabel.isDisplayed();		
	}
	
	public CompaniesPage clickOnCompaniesOption() {
		clickOnMenuButton.click();
		clickCompaniesOption.click();
		return new CompaniesPage();		
	}
	
	
	public ConsultantPage clickOnConsultantOption() throws InterruptedException {
		clickOnMenuButton.click();
		Thread.sleep(1000);
		clickConsultantOption.click();
		return new ConsultantPage();		
	}
	
	/*public void clickOnMenuButton() {
		clickOnMenuButton.click();
	}
	*/
		
	public LoginPage logout() {
		clickLogoutDropdown.click();
		clickLogoutMenu.click();
		
		return new LoginPage();
	}

}
