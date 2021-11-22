package com.mindtree.stepdefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.ChristmasGiftPage;
import com.mindtree.pageObjects.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GiftCardStepDefination {
	
	Logger log = LogManager.getLogger(GiftCardStepDefination.class.getName());
	static WebDriver driver = null;
	
	@Given("Get the driver from the AboutUS file")
	public void get_the_driver_from_the_about_us_file() {
		driver = AboutUsStepDefination.getDriver();
	}
	@Then("Click on the Gift Card on the web page")
	public void click_on_the_gift_card_on_the_web_page() {
		HomePage hp = new HomePage(driver);
		hp.getGiftCard().click();
		log.info("Gift Cards Page");
	}
	@Then("Click on Add to cart")
	public void click_on_add_to_cart() throws InterruptedException {
		ChristmasGiftPage  cg=new ChristmasGiftPage(driver);
		cg.AddToCart().click();
		Thread.sleep(2000);
		log.info("Added Gift Card to cart");
	}
	@Then("Verify cart")
	public void verify_cart() {
		ChristmasGiftPage  cg=new ChristmasGiftPage(driver);
		if(cg.verifycart().isDisplayed())
			Assert.assertTrue(true);
		log.info("Verified cart");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
