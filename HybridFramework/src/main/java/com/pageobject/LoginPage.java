package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uistore.LoginPageUI;

public class LoginPage {
	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	/*By email=By.cssSelector("[id='email']");
	By password=By.cssSelector("[id='pass']");
	By submit=By.xpath("//*[@id=\"send2\"]");*/
	
	public WebElement getEmail() {
		return driver.findElement(LoginPageUI.email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(LoginPageUI.password);
	}
	
	public WebElement getLogin() {
		return driver.findElement(LoginPageUI.submit);
	}


}
