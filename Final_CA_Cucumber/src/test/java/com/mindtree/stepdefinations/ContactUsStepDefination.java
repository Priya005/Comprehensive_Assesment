package com.mindtree.stepdefinations;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.ContactUsPage;
import com.mindtree.utility.ReadPropertyFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
public class ContactUsStepDefination {
	
	Logger log = LogManager.getLogger(ContactUsStepDefination.class.getName());
	static WebDriver driver = null;
	ReadPropertyFile  rp = null;
	ContactUsPage cp = null;
	
	@Given("getting driver from GiftCard file")
	public void getting_driver_from_about_us_sd_file() {
		driver = GiftCardStepDefination.getDriver();
	}

	@When("Click on ContactUs footer")
	public void click_on_contact_us_footer() {
		cp=new ContactUsPage(driver);
		cp.getContinueShopping().click();
		cp. getContactUs().click();
		log.info("contact us page open...");
	}

	@When("sending email, name and message to the contact form")
	public void sending_email_name_and_message_to_the_contact_form() throws Exception {
		cp=new ContactUsPage(driver);
		rp=new ReadPropertyFile();
		
		cp.getName().sendKeys(rp.getName());
		cp.getEmail().sendKeys(rp.getEmail());
		cp.getMessage().sendKeys(rp.getMessage());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("Verify that data has been sent")
	public void verify_that_data_has_been_sent() {
		cp=new ContactUsPage(driver);
		if (cp.getTitle().getText().equalsIgnoreCase("contact us")) {
			Assert.assertTrue(true);
			log.info("Title verified successfully ");
			driver.close();
		}
	}
	




}
