package com.mindtree.stepdefinations;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;

import com.mindtree.reusableComponent.WebDriverHelper;
import com.mindtree.runner.BigSmall;
import com.mindtree.utility.ReadPropertyFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class HomePageStepDefination {
	
	Logger log = LogManager.getLogger( HomePageStepDefination.class.getName());

	static WebDriver driver = null;
	ReadPropertyFile rp = null;
	
	@Given("Open the Browser")
	public void open_the_browser() throws Exception {
		rp = new ReadPropertyFile();

		driver = WebDriverHelper.initializeDriver();
	   
	}

	@Then("Hit the url")
	public void hit_the_url() throws Exception {

		driver = WebDriverHelper.getDriver();

		driver.get(rp.getUrl());
		System.out.println("url hited");
		
		driver.manage().window().maximize();
		log.info("landing at home page");
	}
	
	public static WebDriver getDriver() {
		return driver;
		
	}
	
	
	
	

	
}
