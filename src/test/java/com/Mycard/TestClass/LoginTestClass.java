package com.Mycard.TestClass;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Mycard.PageObject.LoginPage;
import com.Mycard.PageObject.RecruitmentPage;

public class LoginTestClass extends BaseClass
{
	LoginPage lip;
	RecruitmentPage rp;

	@Test  ( priority = 1 )
	public void login() throws InterruptedException 
	{
		// open Url
		driver.get(projecturl);
		
		lip = new LoginPage(driver);
		System.out.println(" Browse lauch successfully");
		lip.enterdata(lip.username, "Admin");
		System.out.println(" user name entered Successfully");
		lip.enterdata(lip.password, "admin123");
		System.out.println(" password entered Successfully");
		lip.clickonbtn(lip.loginbtn);
		System.out.println(" user Login entered Successfully");
		//Thread.sleep(3000);
		
		
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
		
		
		
	}
}
