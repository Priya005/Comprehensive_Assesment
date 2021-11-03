package com.uistore;

import org.openqa.selenium.By;

public class CartPageUI {
	
	public static By  addToCart =By.xpath("//*[@id=\"maincontent\"]/div/div/div/div[1]/div[3]/div[2]/div[2]/ol/li[1]/div/div/div[2]/div[3]/form/button");
	public static By viewCart=By.xpath("//a[contains(text(),'View Cart')]");
}
