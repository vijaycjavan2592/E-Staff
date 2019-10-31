package com.staff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.staff.qa.base.BaseClass;

public class HomePage extends BaseClass{
	
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
	
	//Click on Requirement menu
	@FindBy(xpath = "//div[@class='nav-item requirements']")
	WebElement clickRequirementOption;
		
	//Click on Placement menu
	@FindBy(xpath = "//label[contains(text(),'Placements')]")
	WebElement clickPlacementOption;
	
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
	
	public RequirementPage clickOnRequirementOption() throws InterruptedException {
		clickOnMenuButton.click();
		Thread.sleep(1000);
		clickRequirementOption.click();
		return new RequirementPage();		
	}
	
	
	public PlacementPage clickOnPlacementOption() throws InterruptedException {
		clickOnMenuButton.click();
		Thread.sleep(1000);
		clickPlacementOption.click();
		return new PlacementPage();		
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
