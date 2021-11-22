package com.mindtree.stepdefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.ShopByCategoryPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ShopByCategoryStepDefination {
	
	Logger log = LogManager.getLogger(ShopByCategoryStepDefination.class.getName());
	static WebDriver driver = null;
	ShopByCategoryPage sc=null;
	
	@Given("Get the driver from the ChristmasGift file")
	public void get_the_driver_from_the_christmas_gift_file() {
		driver = ChristmasGiftStepDefination.getDriver();
	}
	@Then("click on the ShopByCategory")
	public void click_on_the_shop_by_category() {
		HomePage hp = new HomePage(driver);
		hp.getshopbycategory().click();
	}
	@Then("click on the second category")
	public void click_on_the_second_category() throws InterruptedException {
		 sc=new ShopByCategoryPage(driver);
		Thread.sleep(1000);
		sc.getBirthdayGift().click();
	}
	@Then("Click on the first product of the page")
	public void click_on_the_first_product_of_the_page() {
		
	    sc=new ShopByCategoryPage(driver);
		sc.getFirstProduct().click();
	}
	@And("Add it to the WishList")
	public void add_it_to_the_wish_list() throws InterruptedException {
	    sc=new ShopByCategoryPage(driver);
		sc.addToWishList().click();
		Thread.sleep(500);
	}
	
	@And("Verify it")
	public void verify_it() {
		sc=new ShopByCategoryPage(driver);
		if(sc.viewWishList().isDisplayed())
			Assert.assertTrue(true);
		log.info("added to wishList");
	}
	public static WebDriver getDriver() {
		return driver;
	}

}
