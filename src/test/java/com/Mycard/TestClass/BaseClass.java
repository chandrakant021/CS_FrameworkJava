package com.Mycard.TestClass;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.Mycard.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
 
	ReadConfig readconfig = new ReadConfig();
	
    String projecturl = readconfig.getUrl();
    String projectbrowser = readconfig.getBrowser();
	
    public static WebDriver driver;
    
    @BeforeClass
    public void setup() 
    {
    	
       switch(projectbrowser.toLowerCase())
        {
    	 case "chrome" : 
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    		break;
    		
    	 case "msedge" :
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    		break;
    		
    	 case "firefox" :
    		WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
    		break;
    		
    	 default :
    		driver = null;
    		break;
    	
       }
       
       // implicit Wait added for 10 sec
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       driver.manage().window().maximize();
       
       // for Logging
       // logger = LogManager.getLogger("myCard");
       
    }
    
    public void CaptureScreenShot(WebDriver driver, String testName) throws IOException 
    {
    	// Step 1: Convert WebDriver object to TakesScreenShots Interface
    	TakesScreenshot ts = ( TakesScreenshot )driver;
    	
    	// Step 2: Call getScreenshotAs method to create Image File
     	File src =ts.getScreenshotAs(OutputType.FILE);
    	
    	File destn = new File(System.getProperty("user.dir")+"\\ScreenShots\\"+ testName +".png");
    	
    	// Step 3: Copy Image File to Destination
    	FileUtils.copyFile(src, destn);
    	
    }
    
    // Browser Close
    @AfterClass
    public void tearDown() 
    {
 	   driver.close();
 	   driver.quit();
    }
    
    
}
