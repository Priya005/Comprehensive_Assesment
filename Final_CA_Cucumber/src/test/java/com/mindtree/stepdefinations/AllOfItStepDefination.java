package com.mindtree.stepdefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.AllOfItPage;
import com.mindtree.pageObjects.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AllOfItStepDefination {
	Logger log = LogManager.getLogger(AllOfItStepDefination.class.getName());
	static WebDriver driver = null;
	
	@Given("Get the driver from the ShopByCategorySD file")
	public void get_the_driver_from_the_shop_by_category_sd_file() {
	    driver = ShopByCategoryStepDefination.getDriver();
	}
	@Then("Click on the AllOfIt option from the menu bar")
	public void click_on_the_all_of_it_option_from_the_menu_bar() {
	    HomePage hp = new HomePage(driver);
		hp. getAllofit().click();
		log.info("Navigated to All of it Page");
	}
	
	@Then("Validate its title")
	public void validate_its_title() throws InterruptedException {
		AllOfItPage  ap=new  AllOfItPage (driver);
		Thread.sleep(2000);
		if(ap.getproduct().getText().equals("Auto Rickshaw Pen Stand"))
				Assert.assertTrue(true);
		log.info("Verified Auto Rickshaw Pen Stand");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
