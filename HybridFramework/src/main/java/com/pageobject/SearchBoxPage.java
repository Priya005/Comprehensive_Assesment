package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uistore.SearchBoxPageUI;

public class SearchBoxPage {
	
	public WebDriver driver;
	
	//By searchbox=By.cssSelector("[id='searchbox']");
	
	public SearchBoxPage(WebDriver driver2) {
	this.driver=driver2;
	}

	public WebElement getSearchBox() {
		return driver.findElement(SearchBoxPageUI.searchbox);
	}

}
