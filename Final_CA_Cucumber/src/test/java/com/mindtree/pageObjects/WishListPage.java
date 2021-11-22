package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.WishListUi;

public class WishListPage {
public WebDriver driver;
	
	public WishListPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement productvisible() {
		return driver.findElement(WishListUi.product);
	}
	
	public WebElement closepopup() {
		List<WebElement> list=driver.findElements(WishListUi.popup);
		return list.get(2);
	}

}
