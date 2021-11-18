package com.mindtree.appUIStrore;

import org.openqa.selenium.By;

public class HomePageLocators {

	public static By signIn = By.cssSelector(".site-nav__link.site-nav__link--icon.signinlink");
	
	public static By personalizedgift=By.linkText("Personalized Gifts");
	
	public static By christmasgift=By.linkText("Christmas Gifts");
	
   public static By shopbycategory=By.xpath("//*[@href='/collections']");
	
	public static By allofit=By.linkText("All of it");
	
	public static By wishlist=By.linkText("wish list");
	
	public static By giftcard=By.linkText("gift card");
	
	public static By aboutus=By.linkText("About Us");
	
}
