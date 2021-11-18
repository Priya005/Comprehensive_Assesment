package com.mindtree.stepdefinations;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.SignInPage;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class SignInStepDefination {

	Logger log = LogManager.getLogger(SignInStepDefination.class.getName());
	static WebDriver driver = null;
	SignInPage sp =null;

    @Given("^Getting driver from the HomePageSD file$")
    public void getting_driver_from_the_homepagesd_file() throws Throwable {
          driver = HomePageStepDefination.getDriver();
    }

    @Then("^click on SignIn button$")
    public void click_on_signin_button() throws Throwable {
    	HomePage hp = new HomePage(driver);

		hp.getSignIn().click();
		log.info("clicked on sign button");   	
    }
    
    @Then("giving the email as {string} and Password as {string}")
    public void giving_the_email_as_and_password_as(String email, String password) {
    	SignInPage sp = new SignInPage(driver);

		sp.getEmail().clear();
		sp.getEmail().sendKeys(email);
		log.info(email + " entered");
		sp.getPassword().clear();
		sp.getPassword().sendKeys(password);
		log.info(password + " entered");
    }

  @And("^Clicking on the submit button$")
    public void clicking_on_the_submit_button() throws Throwable {
	   sp = new SignInPage(driver);
	   sp.getSignInSmmitButton().click();
		log.info("clicked on summit button");

    }

    public static WebDriver getDriver() {
		return driver;
	}

	
	
}
