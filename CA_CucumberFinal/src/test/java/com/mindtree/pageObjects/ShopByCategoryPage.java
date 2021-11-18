package com.mindtree.pageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.HomePageLocators;
import com.mindtree.appUIStrore.ShopByCategoryUI;



public class ShopByCategoryPage {
		
	       WebDriver driver = null;
	       
	       public ShopByCategoryPage(WebDriver driver)
	       {
	    	   this.driver = driver;
	       }
	       
	       public WebElement getBirthdayGift()
	       {
	    	   return driver.findElement(ShopByCategoryUI.birthdaygift);
	       }
	       
	       public WebElement getFirstProduct()
	       {
	    	   return driver.findElement(ShopByCategoryUI.firstproduct);
	       }
	       public WebElement addToWishList()
	       {
	    	   return driver.findElement(ShopByCategoryUI.addtowishlist);
	       }
	       public WebElement viewWishList()
	       {
	    	   return driver.findElement(ShopByCategoryUI.viewwishlist);
	       }
	       
	       public WebElement closePopUp()
	       {
	    	   List<WebElement> list=driver.findElements(ShopByCategoryUI.popup);
	      		return list.get(2);
	       }
	       
}
