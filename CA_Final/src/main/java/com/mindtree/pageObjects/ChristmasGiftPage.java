package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.ChristmasGiftUI;



public class ChristmasGiftPage{

	 WebDriver driver = null;
     
     public ChristmasGiftPage(WebDriver driver)
     {
  	   this.driver = driver;
     }
     
     public WebElement getFirstProduct()
     {
  	   return driver.findElement(ChristmasGiftUI. firstproduct);
     }
     public WebElement AddToCart()
     {
  	   return driver.findElement(ChristmasGiftUI.addtocart);
     }
     public WebElement getVerifyProduct()
     {
  	   return driver.findElement(ChristmasGiftUI.verifyproduct);
     }
     public WebElement goToCheckOut()
     {
  	   return driver.findElement(ChristmasGiftUI. checkout);
     }
     public WebElement ClosePopUp()
     {
  	   return driver.findElement(ChristmasGiftUI.closepopup);
     }
     public WebElement returnToCard()
     {
  	   return driver.findElement(ChristmasGiftUI.returntocart);
     
     }
     public WebElement verifycart() {
 		return driver.findElement(ChristmasGiftUI.cartproduct);
 	}

}
