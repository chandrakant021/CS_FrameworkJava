package com.Mycard.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// User Name WebElement of Login page
	@FindBy(name="username") public WebElement username;
	
	// Password WebElement of Login page
	@FindBy(name="password") public WebElement password;
	
	// Login Button WebElement of Login page
	@FindBy(xpath="//button[@type='submit']") public WebElement loginbtn;
	
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']") public WebElement profiledrpdwn;
	
	@FindBy(xpath="(//a[@class='oxd-userdropdown-link'])[4]")public WebElement Logoutbtn;
	
	
	public void enterdata(WebElement element, String inputdata) 
	{
		element.sendKeys(inputdata);
	}
	
	public void clickonbtn(WebElement elementbtn) 
	{
		elementbtn.click();
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
