package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.ContactUsUI;


public class ContactUsPage {
	  WebDriver driver = null;

	public ContactUsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	   public WebElement getContactUs()
       {
    	   return driver.findElement(ContactUsUI.contactUS);
       }
	   
	   public WebElement getMessage()
       {
    	   return driver.findElement(ContactUsUI.message);
       }
	   
	   public WebElement getName()
       {
    	   return driver.findElement(ContactUsUI.name);
       }
	   public WebElement getEmail()
       {
    	   return driver.findElement(ContactUsUI.email);
       }
	   public WebElement toSend()
       {
    	   return driver.findElement(ContactUsUI.send);
       }
	   public WebElement getTitle()
       {
    	   return driver.findElement(ContactUsUI.title);
       }
	   
		public WebElement getContinueShopping() {
			return driver.findElement(ContactUsUI.continueshopping);
		}


}
