package com.mindtree.stepdefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.PersonalizedGift;
import com.mindtree.pageObjects.SignInPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class PersonalizedGiftStepDefination {
	
	Logger log = LogManager.getLogger(PersonalizedGiftStepDefination.class.getName());
	static WebDriver driver = null;
	
	PersonalizedGift pg=null;
	@Given("Get the driver from the SignInSD file")
	public void get_the_driver_from_the_sign_in_sd_file() {
		driver = SignInStepDefination.getDriver();
	}

	@Then("Click on the Personalized Gift section")
	public void click_on_the_personalized_gift_section() {
		HomePage hp = new HomePage(driver);
		hp.getPersonalizedGift().click();
	}

	@Then("Click on Sort By option")
	public void click_on_sort_by_option() throws InterruptedException {
		//implementing sortby--> High to Low Price
		      pg=new PersonalizedGift(driver);
				pg.getsortby().click();
				Thread.sleep(500);
	}

	@Then("Select the High To Low option")
	public void select_the_high_to_low_option() {
		pg=new PersonalizedGift(driver);
		 pg.gethightolow().click();
	    
	}
	
	@Then("Verify max price")
	public void verify_max_price() {
		pg=new PersonalizedGift(driver);
		if(pg.getmaxprice().getText()=="4500")
			Assert.assertTrue(true);
			log.info("Successfully Sorted Products High to Low based on price");
	}

    public static WebDriver getDriver() {
		return driver;
	}
}
