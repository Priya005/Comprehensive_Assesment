package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.AllOfItUi;

public class AllOfItPage {
	
public WebDriver driver;
	
	public AllOfItPage (WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getproduct() {
		return driver.findElement( AllOfItUi.firstproduct);
	}
	
}
