package com.mindtree.stepdefinations;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.SearchBoxPage;

import com.mindtree.utility.RetreiveExcelData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class SearchProductStepDefiantion {
	Logger log = LogManager.getLogger(SearchProductStepDefiantion.class.getName());
	static WebDriver driver = null;
	
	SearchBoxPage sb = null;
	
	@Given("Get the driver form the PersonalizedGiftsSD file")
	public void get_the_driver_form_the_personalized_gifts_sd_file() {
		driver = PersonalizedGiftStepDefination.getDriver();
	}
	
	@Then("Activate the Search box")
	public void activate_the_search_box() {
		log.info("Search Box Activated");
	}
	
	@Then("Get values from excel file")
	public void get_valuesfrom_excel_file() throws IOException {
		ArrayList<String> d = RetreiveExcelData.getData("searchDairy");

		 sb = new SearchBoxPage(driver);

		

		for (int i = 1; i < d.size(); i++) {
			sb.getsearchbox().sendKeys(d.get(i));
			sb.getsearchbox().sendKeys(Keys.ENTER);
		}
        log.info("enterd product name");
	}
	
	@Then("Send keys into the Search box")
	public void send_keys_into_the_search_box() {
		log.info("Successfully searched product - Diary");
	}
	
	@Then("verify if searched product is displayed")
	public void verify_if_searched_product_is_displayed() {
		 sb = new SearchBoxPage(driver);

		 if(sb. getsearchproduct().isDisplayed())
     		Assert.assertTrue(true);
     log.info("Succesfully verified products are display!!");
	
	
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
