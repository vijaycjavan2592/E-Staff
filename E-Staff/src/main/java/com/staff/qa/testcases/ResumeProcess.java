package com.staff.qa.testcases;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.google.common.base.Function;
import com.staff.qa.base.BaseClass;
import com.staff.qa.pages.ConsultantPage;
import com.staff.qa.pages.HomePage;
import com.staff.qa.pages.LoginPage;

public class ResumeProcess extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ConsultantPage consultantPage;
	
	String path = "ConsultantCVPath";
	
	static String consultantID = "Cons-633950";

	public ResumeProcess() {
		super();		
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp() throws InterruptedException {
		//initialization();
		/*consultantPage = new ConsultantPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		consultantPage = homePage.clickOnConsultantOption();*/
	}
	
	@Test
	public void verifyUploadConsultant()
			throws InterruptedException, AWTException {
		
		String TestCaseName = "Verify that user can upload the consultant's resume into the system";
		test = extent.createTest(TestCaseName);
		
		try {
		
		Thread.sleep(2000);
		for(int i=10325 ; i<=10325 ; ) {	
									
		System.out.println("Proccing folder No : "+i);
		
		initialization();
		consultantPage = new ConsultantPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		consultantPage = homePage.clickOnConsultantOption();
		
		consultantPage.setClickAddNewMenu();
		Thread.sleep(1000);
		consultantPage.setClickOnUploadResume();		
			
		consultantPage.setUploadConsultantResume("\\\\10.20.14.84\\Shared\\ResumesToProcess\\"+i+"");	
		
		//consultantPage.setconsultantConfirmationMessage();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(8, TimeUnit.MINUTES)
				.pollingEvery(2, TimeUnit.SECONDS).
				ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    public WebElement apply(WebDriver driver) {
	    	System.out.println("Wait.....");
	    WebElement el = driver.findElement(By.xpath("//div[@class='col-md-10 msg-content']"));
	    el.getText();
		return el;
	}		
		});
				
		Thread.sleep(3000);
		driver.close();
		i = i+25;
		
		}
		test.log(Status.PASS, TestCaseName + " is sucessfully pass");
		testresultdata.put("45", new Object[] { 45d, TestCaseName,
				"User should be able to upload the consultant's resume into the system", "Pass" });
	} catch (Exception e) {
		testresultdata.put("45", new Object[] { 45d, TestCaseName,
				"User should be able to upload the consultant's resume into the system", "Fail" });
				
		e.printStackTrace();
	}
	}
	
	
	
}
