package com.Mycard.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{

	Properties properties; 
	
	String path ="C:\\Users\\LENOVO\\OneDrive\\Desktop\\Project\\Demo Project\\Mycard\\Configuration\\Config.properties";
	
	public ReadConfig() 
	{
		try 
		{
		    properties = new Properties();
		    FileInputStream fis;
		
			fis = new FileInputStream(path);
			properties.load(fis);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
	public String getUrl() 
	{
		String browserUrl = properties.getProperty("url");
		if(browserUrl!= null)
			return browserUrl;
		else
			throw new RuntimeException("URL is not Specified in Config File");
			
	}
	
	public String getBrowser() 
	{
		String browservalue = properties.getProperty("browser");
		if(browservalue!=null)
			return browservalue;
		else
			throw new RuntimeException("Browser Value is not Specified in Config File");
	}
}
