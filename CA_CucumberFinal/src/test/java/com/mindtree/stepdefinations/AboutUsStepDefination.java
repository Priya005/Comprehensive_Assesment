package com.mindtree.stepdefinations;

import org.apache.log4j.LogManager;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class AboutUsStepDefination {
	

	Logger log = LogManager.getLogger(AboutUsStepDefination.class.getName());
	static WebDriver driver = null;
	
	@Given("Get the driver from the WishListSD file")
	public void get_the_driver_from_the_wish_list_sd_file() {
		driver = WishListStepDefination.getDriver();
	}
	@Then("Click on the About Us from he footer section")
	public void click_on_the_about_us_from_he_footer_section() {
		HomePage hp = new HomePage(driver);
		hp.getAboutUs().click();
		log.info("About Us Page");
	}
	@Then("Validate whether About us is opened or not")
	public void validate_whether_about_us_is_opened_or_not() {
		if(driver.getTitle().equals("About us"))
			Assert.assertTrue(true);
		log.info("Verified title of About Us Page");
	}
	public static WebDriver getDriver() {
		return driver;
	}

}
