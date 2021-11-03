package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uistore.LandingPageUI;


public class LandingPage {
	
	public WebDriver driver;
	
	
	
	public LandingPage(WebDriver driver2) {
		this.driver=driver2;
	}

	public WebElement getLogin() {
		return driver.findElement(LandingPageUI.sign_in);
	}
}
