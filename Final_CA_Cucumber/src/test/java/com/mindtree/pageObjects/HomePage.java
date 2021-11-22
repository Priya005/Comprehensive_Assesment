package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.HomePageLocators;

public class HomePage {
	
       WebDriver driver = null;
       
       public HomePage(WebDriver driver)
       {
    	   this.driver = driver;
       }
       public WebElement getSignIn()
       {
    	   return driver.findElement(HomePageLocators.signIn);
       }
       
       
       public WebElement getPersonalizedGift()
       {
    	   return driver.findElement(HomePageLocators.personalizedgift);
       }
       
       public WebElement getChristmasGift()
       {
    	   return driver.findElement(HomePageLocators.christmasgift);
       }
       public WebElement getshopbycategory() {
    	   
   		List<WebElement> list=driver.findElements(HomePageLocators.shopbycategory);
   		return list.get(3);
   	}
       public WebElement getAllofit()
       {
    	   return driver.findElement(HomePageLocators.allofit);
       }
       
       public WebElement getWishList()
       {
    	   return driver.findElement(HomePageLocators.wishlist);
       }
       
       public WebElement  getAboutUs() {
    	   return driver.findElement(HomePageLocators.aboutus);
       }
       
       public WebElement  getGiftCard(){
    	   return driver.findElement(HomePageLocators.giftcard); 
       }
}
