package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadpropertyFile {
	 public static WebDriver driver;
	   public Properties prop=	new Properties();
	
	public WebDriver initializeDriver() throws IOException 
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe"); 
		//WebDriver driver=new ChromeDriver();
		
		//IE Property file
	
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL-PC\\eclipse-workspace\\PractFramework\\src\\main\\java\\com\\utility\\Config.properties");
	    prop.load(fis);
	    String browserName=  prop.getProperty("browser");
	    
	 
	    if(browserName.equals("chrome") ){
	    	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe"); 
			 driver=new ChromeDriver();
			
	    }
	    else if(browserName.equals("firefox") ){
	    }
	    else if(browserName.equals("IE") ){
	    	
	    }
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
}
