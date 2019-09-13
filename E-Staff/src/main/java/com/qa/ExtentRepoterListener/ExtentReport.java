package com.qa.ExtentRepoterListener;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.xml.XmlSuite;
/*
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ExtentReport implements IReporter {
	

	 public static ExtentReports extent;
	 public static ExtentTest test;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		// specify location of the report
		  extent = new ExtentReports(System.getProperty("user.dir") + "//test-output//extentReport1.html", true);

		  
		  for(ISuite suite : suites) {
			  Map<String, ISuiteResult> result = suite.getResults();
			  
			  for(ISuiteResult r : result.values()) {
				  ITestContext context = r.getTestContext();
				  
				  buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				  buildTestNodes(context.getPassedTests(), LogStatus.FAIL);
			  }
		  }
		  System.out.println("We are closing");
		  
		  
		  
		 
	}
	
	
	
	public void buildTestNodes(IResultMap tests, LogStatus status) {
		 
		if(tests.size()>0) {
			for(ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());  
				
				
				for(String group : result.getMethod().getGroups()) {
					test.assignCategory(group);
					
					if(result.getThrowable() != null) {
						test.log(status, result.getThrowable());
					}
					else {
						test.log(status, "Test" + status.toString().toLowerCase());
					}
					
					
				}
				
				
			}
			
		}
	}

}*/