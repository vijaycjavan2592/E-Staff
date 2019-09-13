package com.staff.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.staff.qa.testcases.LoginPageTest;
import com.staff.qa.util.TestUtil;
import com.staff.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	static Logger log = Logger.getLogger(TestBase.class);
	

	public TestBase() {

		try {
			prop = new Properties();
			InputStream file = new FileInputStream(
					"D:\\Personal Docs\\Eclipse\\E-Staff\\src\\main\\java\\com\\staff\\qa\\config\\config.properties");
			prop.load(file);
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D://JarFile//chromedriver_76.0.3809.126/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Issue in driver");			
		}
		
		log.info("Launching browser");
		
		e_driver = new EventFiringWebDriver(driver);
		
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		
		driver = e_driver;
		

		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		
		log.info("Entering application URL");
		log.warn("Hey this is warning message");
		log.fatal("Hey this is just factal error message");
		log.debug("this is debug message");
		
		
	}
	
	@BeforeTest
	public void setExtentReport() {
		htmlreport = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "//test-output//Reportsreportextent50.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlreport);		
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setDocumentTitle("E-Staff Application Automation Report");
		htmlreport.config().setReportName("Functional Testing");
		
	}
	
	
	@AfterMethod
	public static void getResult(ITestResult result) throws IOException{
		
		System.out.println("TC Name is : "+result.getName());
		//test = extent.createTest(result.getMethod().getMethodName());
		if(result.getStatus() == ITestResult.SUCCESS){
			//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			//MarkupHelper is used to display the output in different colors
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
		}
		
		if(result.getStatus() == ITestResult.FAILURE){
			//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			//MarkupHelper is used to display the output in different colors
			//String screenShotPath = takeScreenShot(driver, "screenShotName");
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			//test.log(Status.FAIL, "Screenshot Below : "+test.addScreenCaptureFromPath(screenShotPath));
			//test.fail("SS below" + test.addScreenCaptureFromPath(screenShotPath));
			
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,  MarkupHelper.createLabel("Test case skiped is "+result.getName(), ExtentColor.ORANGE));
		}
		
		System.out.println("Browser close");
		driver.close();
		
	}
	
	
	@AfterTest
	public void endReport() {
		
		//extent.close();
		extent.flush();		
		
	}
	
	
	public static String takeScreenShot(WebDriver driver , String screenShotName) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		String dest = System.getProperty("user.dir") +" /screenshot/ "+screenShotName+".png";
		System.out.println(dest);
		File destination = new File(dest);
		FileUtils.copyFile(srcFile, destination);
		return dest;		
	}
	
	
	



}
