package com.staff.qa.base;
// A simple Java program to demonstrate the use of reflection 
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.reflect.Field; 
import java.lang.reflect.Constructor; 

// class whose object is to be created 
class Test {

	public static void main(String args[]) throws Exception 
	{ 
		
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
            System.out.println("Schema is : "+dm.getSchemas());
            System.out.println("Username is : "+dm.getUserName());
            
            Statement s1 = conn.createStatement();
            ResultSet rs = s1.executeQuery("SELECT Count(*) FROM [cBizOneexternaldb].[dbo].[NewPlacementDetails]");
            System.out.println("Data is ........"+rs);
          //  System.out.println(rs.getString(2));
      
           /* while(rs.next())
    		//	System.out.println("*************"+rs.getInt(1)+ " "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
            	*/
            
            String[] result = new String[2];
            
            
            if(rs!=null){
                while (rs.next()){
                    for(int i = 1; i <result.length ;i++)
                    {
                        for(int j = 1; j <result.length;j++)
                        {
                            result[j]=rs.getString(i);
                            obj = result[j];
							System.out.println("MMMMMMMMMMMMM" + result[j]);
						}System.out.println(obj);
                    }
                }
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
		  finally {
	            try {
	                if (conn != null && !conn.isClosed()) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
		  
		  }
	
		
	}
}
