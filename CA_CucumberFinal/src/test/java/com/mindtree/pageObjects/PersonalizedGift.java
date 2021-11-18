package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.mindtree.appUIStrore.PersonalizedGiftUI;
import com.mindtree.appUIStrore.SignInPageLocators;

public class PersonalizedGift {
	
	
	public WebDriver driver;
	
	public PersonalizedGift(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getsortby() {
		return driver.findElement(PersonalizedGiftUI.sortby);
	}
	
	public WebElement gethightolow() {
		return driver.findElement(PersonalizedGiftUI.hightolow);
	}
	
	public WebElement getmaxprice() {
		return driver.findElement(PersonalizedGiftUI.maxprice);
	}

}