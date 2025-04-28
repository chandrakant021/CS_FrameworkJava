package com.Mycard.PageObject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mycard.TestClass.BaseClass;

import junit.framework.Assert;

public class RecruitmentPage 
{
	BaseClass bs;
	WebDriver ldriver;
	public RecruitmentPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	////span[text()='Recruitment']
  @FindBy(xpath="//ul[@class='oxd-main-menu']/li[5]") public WebElement recruitmentbtn;
  @FindBy(xpath="//span[text()='Recruitment']") public WebElement recruitment; 
  @FindBy(xpath="//span/h6") public WebElement RecruitmentText;
  

	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']") public WebElement profiledrpdwn;
	
	@FindBy(xpath="(//a[@class='oxd-userdropdown-link'])[4]")public WebElement Logoutbtn;
	
  
  public void clickonelement(WebElement element1) 
  {
	  element1.click();
  }
	
  public void textvisibility() throws IOException 
  {
	  if(RecruitmentText.isDisplayed()) 
	  {
		  Assert.assertTrue(true);
		  System.out.println("Recruitment Text Display..");
	  }
	  else 
	  {
		  Assert.assertTrue(false);
		 // bs.CaptureScreenShot(ldriver, "textvisibility");
		  System.out.println("Recruitment Text not Display..");
	  }
  }
  
  
  public void ClickonLogout(WebElement drpelement , WebElement drpoption) 
	{
		drpelement.click();
		if(drpoption.isDisplayed())
		{
			drpoption.click();
		}
		else
		{
			ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			drpoption.click();
		}
		
	}
  
  
}
