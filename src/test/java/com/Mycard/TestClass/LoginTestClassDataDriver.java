package com.Mycard.TestClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Mycard.PageObject.LoginPage;
import com.Mycard.PageObject.RecruitmentPage;
import com.Mycard.Utilities.ReadExcelFile;

public class LoginTestClassDataDriver extends BaseClass
{
	LoginPage lip;
	RecruitmentPage rp;

	@Test  (dataProvider = "LoginDataProvider", priority = 1 )
	public void login(String username, String password) throws InterruptedException 
	{
		// open Url
		driver.get(projecturl);
		
		lip = new LoginPage(driver);
		System.out.println(" Browse lauch successfully");
		lip.enterdata(lip.username, username);
		System.out.println(" user name entered Successfully");
		lip.enterdata(lip.password, password);
		System.out.println(" password entered Successfully");
		lip.clickonbtn(lip.loginbtn);
		System.out.println(" user Login entered Successfully");
		//Thread.sleep(3000);
		
	//	rp.ClickonLogout(rp.profiledrpdwn, rp.Logoutbtn);
	}
	
	@Test ( priority = 2 )
	public void clickonRecruitment() throws InterruptedException, IOException
	{
		//Thread.sleep(3000);
		rp = new RecruitmentPage(driver);
		rp.clickonelement(rp.recruitment);
		System.out.println(" Recruitment Page open Successfully");
		try {
		rp.textvisibility();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		CaptureScreenShot(driver, "textvisibility");
		
		rp.ClickonLogout(rp.profiledrpdwn, rp.Logoutbtn);
	}
	
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		String filename = System.getProperty("user.dir")+"\\Test Data\\MyCardTestData.xlsx";
		int totalRows = ReadExcelFile.getRowCount(filename, "LoginPage");
		int totalColumns = ReadExcelFile.getCellCount(filename, "LoginPage");
		
		String data[][]= new String[totalRows-1][totalColumns];
		
		for(int i =1; i<totalRows; i++) 
		{
			for(int j=0; j<totalColumns; j++)
			{
				data[i-1][j] = ReadExcelFile.getCellValue(filename, "LoginPage", i, j);
			}
		}
			
		return data;	
	}
	
	
	
}
