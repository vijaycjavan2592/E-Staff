package com.staff.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	static Logger log = Logger.getLogger(BaseClass.class);
	
	public Map<String, Object[]> testresultdata;
	
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	

	public BaseClass() {	 

		try {
			prop = new Properties();
			InputStream file = new FileInputStream(
					"D:\\Personal Docs\\Eclipse\\New folder\\E-Staff\\src\\main\\java\\com\\staff\\qa\\config\\config.properties");
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
			System.setProperty("webdriver.chrome.driver", "D://JarFile//ChromeDriver_78/chromedriver.exe");
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
	
	@BeforeTest(alwaysRun = true)
	public void setExtentReport(ITestContext context) {
		htmlreport = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "//test-output//Reportsreportextent50.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlreport);		
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setDocumentTitle("E-Staff Application Automation Report");
		htmlreport.config().setReportName("Functional Testing");
	}
	
	
	@AfterMethod
	public static void getResult(ITestResult result) throws IOException, InterruptedException{
		String sheetName = "LoginData";
		System.out.println("TC Name is : "+result.getName());
		//test = extent.createTest(result.getMethod().getMethodName());
		if(result.getStatus() == ITestResult.SUCCESS){
			//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			//MarkupHelper is used to display the output in different colors
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
			//TestUtil.getResults(result.getStatus());
			//TestUtil.writeDataInExcel(result.getStatus());
		}
		
		else if(result.getStatus() == ITestResult.FAILURE){
			//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			//MarkupHelper is used to display the output in different colors
			String screenShotPath = takeScreenShot(driver, result.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
						
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			test.fail("Screenshot below : " +   test.addScreenCaptureFromPath(screenShotPath));
			//MediaEntityBuilder
			//TestUtil.getData1(sheetName, "Fail1");
			
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,  MarkupHelper.createLabel("Test case skiped is "+result.getName(), ExtentColor.ORANGE));
		}
		
		System.out.println("Browser close");
		Thread.sleep(1000);
		driver.quit();
		
	}
	
	
	public static String takeScreenShot(WebDriver driver, String screenShotName)  {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		
		String path = ("D:\\Personal Docs\\Eclipse\\E-Staff\\screenshots\\E_Staff_Screenshots"+ screenShotName+System.currentTimeMillis() +".png");
		System.out.println(path);
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Capture Failed "+e.getMessage());
		}
		return path;		
	}
	
	
	@BeforeClass(alwaysRun = true)
	  public void setupBeforeSuite(ITestContext context) throws IOException {
		FileInputStream file = new FileInputStream(prop.getProperty("TestCaseResultsInExcelSheet"));
	     //create a new work book
	     workbook = new HSSFWorkbook(file);
	      //create a new work sheet
	      
	      sheet = workbook.createSheet();
	      testresultdata = new TreeMap<String, Object[]>();
	      //add test result excel file column header
	      //write the header in the first row
	      testresultdata.put("0", new Object[] {"Test Case Id", "Teat Case description", "Expected Result","Actual Result"});	
	}
	
	@AfterTest
	public void endReport() {
		
		//extent.close();
		extent.flush();				
	}
	
	@AfterClass
	  public void setupAfterSuite() {
	    //write excel file and file name is TestResult.xls 
	    Set<String> keyset = testresultdata.keySet();
	    int rownum = 0;
	    for (String key : keyset) {
	        Row row = sheet.createRow(rownum++);
	        Object [] objArr = testresultdata.get(key);
	        int cellnum = 0;
	        for (Object obj : objArr) {
	            Cell cell = row.createCell(cellnum++);
	            if(obj instanceof Date) 
	                cell.setCellValue((Date)obj);
	            else if(obj instanceof Boolean)
	                cell.setCellValue((Boolean)obj);
	            else if(obj instanceof String)
	                cell.setCellValue((String)obj);
	            else if(obj instanceof Double)
	                cell.setCellValue((Double)obj);
	        }
	    }
	    try {
	        FileOutputStream out =new FileOutputStream(prop.getProperty("TestCaseResultsInExcelSheet"));
	        workbook.write(out);
	        out.close();
	        System.out.println("Excel written successfully..");
	         
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	



}
