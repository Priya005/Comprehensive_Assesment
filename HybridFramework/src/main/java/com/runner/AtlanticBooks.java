package com.runner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.pageobject.CartPage;
import com.pageobject.LandingPage;
import com.pageobject.LoginPage;
import com.pageobject.SearchBoxPage;

import com.sun.tools.sjavac.Log;
import com.utility.DataDriven;
import com.utility.ExtentReporterNG;
import com.utility.ReadpropertyFile;



public class  AtlanticBooks  extends ReadpropertyFile{
	ExtentReporterNG er;
	public static Logger log = LogManager.getLogger(ReadpropertyFile.class.getName());
	ReadpropertyFile rp=null;
	@Test(priority=1,dataProvider="getData")
	public void baseNavigation(String username,String password) throws IOException {
	//	er.startTest("Loging to Homepage");
		rp=new ReadpropertyFile();
		driver=initializeDriver();
		log.info("Driver is initialized");
	//	driver.get("https://atlanticbooks.com");
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		
		l.getLogin().click();
		Assert.assertTrue(l.getLogin().isDisplayed());
		LoginPage lp=new LoginPage(driver) ;
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		//er.endTest();
		log.info("Succesfully Login....");
		
		}
	
		
	
	@DataProvider
	private Object[][] getData() 
	{
		   //Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
			Object[][] data=new Object[2][2];
			//0th row
			data[0][0]="mind@com";
			data[0][1]="12344";
			
			data[1][0]="priyabodke07@gmail.com";
			data[1][1]="Priya@99";
		
			
			return data;
			
		
	}
	
	@Test(priority = 2)
	public void searchProductTesting() throws IOException {
	
		DataDriven d = new DataDriven();
		ArrayList<String> data= d.getData("searchproduct");
		SearchBoxPage sb = new SearchBoxPage(driver);
		for(int i=0;i<data.size()-1;i++) {
		sb.getSearchBox().sendKeys(data.get(i+1));

		sb.getSearchBox().sendKeys(Keys.ENTER);
		}
		//log.info("Searched product name");

	}
	@Test(priority=3)
	public void addToCart() throws InterruptedException, IOException {
	
		CartPage c=new CartPage(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		c.addToCart().click();

		//Thread.sleep(000L);
		log.info("Add to Cart..moving to view cart");
	}
	@Test(priority=4)
	public void viewCart() throws InterruptedException, IOException {
		//er.startTest("View Cart");
		CartPage c=new CartPage(driver);
		c.viewCart().click();
		//Thread.sleep(1000L);

		log.info("Succesfully view Cart !!");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
		
	}
