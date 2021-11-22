package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.SearchBoxPageLocators;

public class SearchBoxPage {
		
	       WebDriver driver = null;
	       
	       public SearchBoxPage(WebDriver driver)
	       {
	    	   this.driver = driver;
	       }
	       
	       public WebElement getsearchbox() {
	   		return driver.findElement(SearchBoxPageLocators.searchbox);
	   	}
	   	
	   	public WebElement getsearchproduct() {
	   		List<WebElement> list=driver.findElements(SearchBoxPageLocators.searchproduct);
	   		return list.get(0);
	   	}
}
