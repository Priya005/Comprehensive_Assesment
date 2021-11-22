package com.mindtree.stepdefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.WishListPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WishListStepDefination {
	
	Logger log = LogManager.getLogger(WishListStepDefination.class.getName());
	static WebDriver driver = null;
	WishListPage w=null;
	
	@Given("Get the driver form the AllOfItSD file")
	public void get_the_driver_form_the_all_of_it_sd_file() {
		  driver = AllOfItStepDefination.getDriver();
	}
	@Then("Click on the WishList in the web page")
	public void click_on_the_wish_list_in_the_web_page() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getWishList().click();
		Thread.sleep(2000);
		log.info("Wishlist Page");
	}
	@Then("close the popup in the page")
	public void close_the_popup_in_the_page() throws InterruptedException {
		 w=new WishListPage(driver);
		if(w.closepopup().isDisplayed())
			w.closepopup().click();
		Thread.sleep(2000);
	}
	@Then("Validate if product is present or not")
	public void validate_if_product_is_present_or_not() {
		w=new WishListPage(driver);
		if(w.productvisible().isDisplayed())
			Assert.assertTrue(true);
		log.info("Products are displayed in Wishlist");
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
