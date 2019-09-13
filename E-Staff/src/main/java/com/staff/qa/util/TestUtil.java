package com.staff.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.utils.FileUtil;

public class TestUtil {
	
	
	
	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 10;
	
	static HSSFWorkbook wbook;
	static HSSFSheet sheet;

	

	public static Object[][] getData(String sheetName) throws IOException{
		
		try {
			FileInputStream file = new FileInputStream(
					"D:\\Personal Docs\\Eclipse\\E-Staff\\src\\main\\java\\com\\staff\\qa\\testdata\\TestData_EStaff_.xls");
			
			wbook = new HSSFWorkbook(file);
						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		    sheet = wbook.getSheet(sheetName);
			
			HSSFRow row = sheet.getRow(0);
			
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row count is : "+rowcount);
			
			int colcount = row.getPhysicalNumberOfCells();
			System.out.println("Column count is : "+colcount);	
		
		
		Object[][] input = new Object[rowcount][colcount];
		
		for(int i=0 ; i<sheet.getLastRowNum() ; i++) {
			row = sheet.getRow(i + 1);
						
			for(int j=0 ; j<sheet.getRow(0).getLastCellNum() ; j++) {
				HSSFCell cell = row.getCell(j);
				
				String data = cell.getStringCellValue();
				
				System.out.println("Excel data is : "+data);
				
				input[i][j] = data;
				
			}
		}
		
		return input;
		
	}
	
	

	
	

	
}
