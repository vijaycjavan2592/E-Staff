package com.staff.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.base.Function;
import com.staff.qa.base.BaseClass;

public class TestUtil extends BaseClass {
	
	
	
	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 25;
	
	static HSSFWorkbook wbook;
	static HSSFSheet sheet;
	static HSSFRow row;
	
	
	public static void sendInput(WebElement ele, String text){
			ele.sendKeys(text);
		}
	
	public static void click(WebElement ele){
		ele.click();
	}

	public static Object[][] getData(String sheetName) throws IOException{
		
		try {
			FileInputStream file = new FileInputStream(prop.getProperty("TestDate_ReadExcelSheet"));
			
			wbook = new HSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		    sheet = wbook.getSheet(sheetName);
			
			row = sheet.getRow(0);
			
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row count is : "+rowcount);
			
			int colcount = row.getPhysicalNumberOfCells();
			System.out.println("Column count is : "+colcount);	
		
		
			int rowSize = sheet.getLastRowNum();
			System.out.println("Last Row Number is : "+rowSize);
			int colSize = sheet.getRow(0).getLastCellNum();
			System.out.println("Last Col Number is : "+colSize);
		Object[][] input = new Object[rowSize][colSize];
		
		for(int i=0 ; i<rowSize ; i++) {
			row = sheet.getRow(i + 1);
						
			for(int j=0 ; j<colSize ; j++) {
				//HSSFCell cell = row.getCell(j);
				HSSFCell cell = row.getCell(j, HSSFRow.MissingCellPolicy.CREATE_NULL_AS_BLANK);			
				
				Object data = "";
				
				if (cell.getCellType() == CellType.STRING)
				{
					data = cell.getStringCellValue();
				
				}
				else if(cell.getCellType() == CellType.NUMERIC)
				{
					data = String.valueOf(cell);
					//data = new Integer(cell.getStringCellValue()).toString();
					//data = cell.getNumericCellValue();
					
				}
				else if(cell.getCellType() == CellType.BLANK)
				{
					System.out.print("");
				}				
				
				System.out.println("Excel data is : "+data);
				
				input[i][j] = data;
			
			}
			
		}
			return input;
		
				
			}
	
//_______________DB Connection_____________________________________________
	
	public static String DBConnection_Count(String query) {

		Connection conn = null;
		String obj = "";
		try {

			String dbURL = "jdbc:sqlserver://10.20.14.84:1433";
			String user = "sa";
			String pass = "cbiz123#";
			conn = DriverManager.getConnection(dbURL, user, pass);

			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				System.out.println("Schema is : " + dm.getSchemas());
				System.out.println("Username is : " + dm.getUserName());

				Statement s1 = conn.createStatement();
				ResultSet rs = s1.executeQuery(query);
				System.out.println("Data is ........" + rs);
				// System.out.println(rs.getString(2));

				/*
				 * while(rs.next()) // System.out.println("*************"+rs.getInt(1)+
				 * " "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				 */

				String[] result = new String[2];				

				if (rs != null) {
					while (rs.next()) {
						for (int i = 1; i < result.length; i++) {
							for (int j = 1; j < result.length; j++) {
								result[j] = rs.getString(i);
								obj = result[j];
								System.out.println("MMMMMMMMMMMMM" + result[j]);
							}System.out.println(obj);
						}
					}
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return obj;
	}
}
	
	
	
	
	
	
	
	
	//---------------------------------------------------------------------
			
	/*		public static void wirte(String TCResult1) throws IOException {
				//TestUtil.getData(" ");
			row = sheet.getRow(1);
     	   
        	row.createCell(2).setCellValue(TCResult1);
        	
        	//file.close();
        	
        	   try { 
   	            // this Writes the workbook gfgcontribute 
   	            FileOutputStream out = new FileOutputStream(new File("D:\\Personal Docs\\Eclipse\\E-Staff\\src\\main\\java\\com\\staff\\qa\\testdata\\TestData_EStaff_.xls")); 
   	            wbook.write(out); 
   	            out.close(); 
   	            System.out.println("gfgcontribute.xls written successfully on disk."); 
   	        } 
   	        catch (Exception e) { 
   	            e.printStackTrace(); 
   	        } 
        }

		
		*/

	/*
	
	public static void writeDataInExcel(int p) throws IOException {

		String excelFileName = 
				"D:\\Personal Docs\\Eclipse\\E-Staff\\src\\main\\java\\com\\staff\\qa\\testdata\\TestData_EStaff_.xls";

		FileInputStream file = new FileInputStream(
				"D:\\Personal Docs\\Eclipse\\E-Staff\\src\\main\\java\\com\\staff\\qa\\testdata\\TestData_EStaff_.xls");

		 HSSFWorkbook workbook = new HSSFWorkbook(file); 
		  
	        // Create a blank sheet 
	        HSSFSheet sheet = workbook.getSheet("Result");
	  
	        String TCresult = null;
		     if(p==1) {
		    	 TCresult = "Pass123";
		     }
		     else if(p==2) {
		    	 TCresult = "Fail";
		     }
		     else {
		    	 TCresult = "Skip";
		     }
			  
	        	      
	        // This data needs to be written (Object[]) 
	        Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
	        data.put("2", new Object[]{ TCresult });
	        
	        
	 
	        // Iterate over data and write to sheet 
	        Set<String> keyset = data.keySet(); 
	        int rownum = 1;  
	        for (String key : keyset) { 
	            // this creates a new row in the sheet 
	          //  Row row = sheet.createRow(rownum++); 
	            Object[] objArr = data.get(key); 
	            int cellnum = 2; 
	            for (Object obj : objArr) { 
	                // this line creates a cell in the next column of that row 
	            	if(CellType.STRING.BLANK != null) {
	                Row row = sheet.createRow(rownum++); 
	                Cell cell = row.createCell(cellnum++); 
	                if (obj instanceof String) 
	                    cell.setCellValue((String)obj); 
	                else if (obj instanceof Integer) 
	                    cell.setCellValue((Integer)obj); 
	            } 
	            }
	        } 
	        
	                
	        try { 
	            // this Writes the workbook gfgcontribute 
	            FileOutputStream out = new FileOutputStream(new File(excelFileName)); 
	            workbook.write(out); 
	            out.close(); 
	            System.out.println("gfgcontribute.xlsx written successfully on disk."); 
	        } 
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	    } 
	

	public static void addResult(String TCResult1) throws IOException {
		
		System.out.println("Writimg result ");
		FileInputStream file = new FileInputStream(
				"D:\\Personal Docs\\Eclipse\\E-Staff\\src\\main\\java\\com\\staff\\qa\\testdata\\TestData_EStaff_.xls");

		 HSSFWorkbook workbook = new HSSFWorkbook(file); 
		  
	        // Create a blank sheet 
	        HSSFSheet sheet = workbook.getSheet("Result");
	        
	        int totalRow = sheet.getLastRowNum()+1;
	        
	        for(int i=1 ; i<totalRow ; i++) {
	        	
	        	HSSFRow row = sheet.getRow(i);
	        	   
	        	row.createCell(2).setCellValue(TCResult1);
	        	
	        	file.close();
	        	
	        	   try { 
	   	            // this Writes the workbook gfgcontribute 
	   	            FileOutputStream out = new FileOutputStream(new File("D:\\Personal Docs\\Eclipse\\E-Staff\\src\\main\\java\\com\\staff\\qa\\testdata\\TestData_EStaff_.xls")); 
	   	            workbook.write(out); 
	   	            out.close(); 
	   	            System.out.println("gfgcontribute.xls written successfully on disk."); 
	   	        } 
	   	        catch (Exception e) { 
	   	            e.printStackTrace(); 
	   	        } 
	        }
		
	}
	
	

	public static Object[][] getData1(String sheetName, String TCResult1) throws IOException{
		
		try {
			FileInputStream file = new FileInputStream(
					"D:\\Personal Docs\\Eclipse\\E-Staff\\src\\main\\java\\com\\staff\\qa\\testdata\\TestData_EStaff_.xls");
			
			wbook = new HSSFWorkbook(file);
						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		    sheet = wbook.getSheet(sheetName);
			
			row = sheet.getRow(0);
			
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row count is : "+rowcount);
			
			int colcount = row.getPhysicalNumberOfCells();
			System.out.println("Column count is : "+colcount);	
		
		
			int rowSize = sheet.getLastRowNum();
			System.out.println("Rowsize is : "+rowSize);
			int colSize = sheet.getRow(0).getLastCellNum();
		Object[][] input = new Object[rowcount][colcount];
		
		for(int i=0 ; i<rowSize ; i++) {
			row = sheet.getRow(i + 1);
						
			for(int j=0 ; j<colSize ; j++) {
				//HSSFCell cell = row.getCell(j);
				HSSFCell cell = row.getCell(j, HSSFRow.MissingCellPolicy.CREATE_NULL_AS_BLANK);			
				
				Object data = "";
				
				if (cell.getCellType() == CellType.STRING)
				{
					data = cell.getStringCellValue();
				
				}
				else if(cell.getCellType() == CellType.NUMERIC)
				{
					data = cell.getNumericCellValue();
					
				}
				else if(cell.getCellType() == CellType.BLANK)
				{
					data = cell.getCellType().BLANK;
					System.out.print("");
				}				
				
				System.out.println("Excel data is : "+data);
				
				input[i][j] = data;
				
			}
		}      	
		      
			return input;
		
				
			}
			
//--------------------------------------------------------------
	
	public static void getResults(String abc, int r1) {

		String excelFilePath = "C://Users/VIJAY/Desktop/ExcelWrite.xls";

		String TCresult = "";
	     if(r1==1) {
	    	 TCresult = "Pass";
	     }
	     else if(r1==2) {
	    	 TCresult = "Fail";
	     }
		       
		        try {
		            FileInputStream file = new FileInputStream("D:\\Personal Docs\\Eclipse\\E-Staff\\src\\main\\java\\com\\staff\\qa\\testdata\\TestData_EStaff_.xls");
		            //HSSFWorkbook workbook = HSSFWorkbook.createSheet(inputStream);
		            HSSFWorkbook workbook = new HSSFWorkbook(file);
		            HSSFSheet sheet = workbook.getSheet("LoginData");
		 
		            Object[][] bookData = {
		                    {abc,TCresult},
		                   // {"Software Craftmanship", "Pete McBreen", 26},
//		                    {"The Art of Agile Development", "James Shore", 32},
//		                    {"Continuous Delivery", "Jez Humble", 41},
		            };
		 
		            int rowCount = sheet.getLastRowNum();
		 
		            for (Object[] aBook : bookData) {
		                HSSFRow row = sheet.createRow(++rowCount);
		 
		                int columnCount = 3;
		                 
		                HSSFCell cell = row.createCell(columnCount);
		                cell.setCellValue(rowCount);
		                 
		                for (Object field : aBook) {
		                    cell = row.createCell(++columnCount);
		                    if (field instanceof String) {
		                        cell.setCellValue((String) field);
		                    } else if (field instanceof Integer) {
		                        cell.setCellValue((Integer) field);
		                    }
		                }
		 
		            }
		 
		           // inputStream.close();
		            System.out.println("Writing");
		 
		            FileOutputStream outputStream = new FileOutputStream("D:\\Personal Docs\\Eclipse\\E-Staff\\src\\main\\java\\com\\staff\\qa\\testdata\\TestData_EStaff_.xls");
		            workbook.write(outputStream);
		            workbook.close();
		            outputStream.close();
		             
		        } catch (IOException  ex) {
		            ex.printStackTrace();
		        }
		    }


	*/

	


	        
	

	

