package com.mindtree.appUIStrore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PersonalizedGiftUI {
	public static By sortby=By.id("sortBy");
	
	public static By hightolow=By.xpath("//*[@id=\'sortBy\']/option[7]");

	public static By maxprice=By.xpath("//*[@class='money']");
}