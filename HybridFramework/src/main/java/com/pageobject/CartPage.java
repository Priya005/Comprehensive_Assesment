package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uistore.CartPageUI;

public class CartPage {
	public WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public WebElement addToCart() {
		return driver.findElement(CartPageUI.addToCart);
	}
	
	public WebElement viewCart() {
		return driver.findElement(CartPageUI.viewCart);
	}
	
}
