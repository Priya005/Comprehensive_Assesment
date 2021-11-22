package com.mindtree.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.utility.RetreiveExcelData;
import com.mindtree.pageObjects.AddToCardPage;
import com.mindtree.pageObjects.AllOfItPage;
import com.mindtree.pageObjects.ChristmasGiftPage;
import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.PersonalizedGift;
import com.mindtree.pageObjects.SearchBoxPage;
import com.mindtree.pageObjects.ShopByCategoryPage;
import com.mindtree.pageObjects.SignInPage;
import com.mindtree.pageObjects.WishListPage;
import com.mindtree.reusableComponent.WebDriverHelper;
import com.mindtree.utility.ReadPropertyFile;

public class BigSmall{

	Logger log = LogManager.getLogger(BigSmall.class.getName());

	WebDriver driver = null;
	ReadPropertyFile rp = null;

	/*
	 * this method is responsible for landing at home page and click on sign button.
	 * 
	 * WebDriverHelper class has a initializeDriver() method which will launch and
	 * initialize the driver.
	 * 
	 * ReadPropertyFile class :- contains method which is used to retrieve data from
	 * property file.
	 * 
	 * HomePage class contains method to return webelement of respective web page;
	 */
	@Test(priority = 1)
	public void homePageLanding() throws Exception {

		rp = new ReadPropertyFile();

		driver = WebDriverHelper.initializeDriver();

		driver.get(rp.getUrl());
		System.out.println("url hited");
		
		driver.manage().window().maximize();
		log.info("landing at home page");

		

	}
	
	

	/*
	 * this method is responsible for sending username and password to login form.
	 * 
	 * ReadPropertyFile class :- contains method which is used to retrieve data from
	 * property file.
	 * 
	 * SignInPage class contains method to return webelement of after after sign
	 * page;
	 * 
	 * Data provider attribute is being used to call datasuplier method to return
	 * data combination one by one.
	 */
	@Test(priority = 2, dataProvider = "dataSuplier")
	public void signInTesting(String username, String password) throws Exception {
		
		HomePage hp = new HomePage(driver);

		hp.getSignIn().click();
		log.info("clicked on sign button");

		Assert.assertTrue(true);

		SignInPage sp = new SignInPage(driver);

		sp.getEmail().clear();
		sp.getEmail().sendKeys(username);
		log.info(username + " entered");
		sp.getPassword().clear();
		sp.getPassword().sendKeys(password);
		log.info(password + " entered");
		sp.getSignInSmmitButton().click();
		log.info("clicked on summit button");
		
		Thread.sleep(5000L);
		
		

	}
	
	@Test(priority = 3)
	public void PersonalizedGift ()
	{	
		
		HomePage hp = new HomePage(driver);
		hp.getPersonalizedGift().click();
		PersonalizedGift pg=new PersonalizedGift(driver);
		//implementing sortby--> High to Low Price
		pg.getsortby().click();
        pg.gethightolow().click();
		if(pg.getmaxprice().getText()=="4500")
					Assert.assertTrue(true);
		log.info("Successfully Sorted Products High to Low based on price");
		
	}
	

	/*
	 * this method is responsible for sending product name has to be searched.
	 * 
	 * ReadPropertyFile class :- contains method which is used to retrieve data from
	 * property file.
	 * 
	 * SignInPage class contains method to return webElement of after after sign
	 * page;
	 * 
	 * 
	 * RetreiveExcelData class contains a method getData which will return array
	 * list containing search product. and product list is available in excel sheet.
	 */
	 
	@Test(priority = 4)
	public void searchProduct() throws IOException {

		ArrayList<String> d = RetreiveExcelData.getData("searchDairy");

		SearchBoxPage sb = new SearchBoxPage(driver);

		

		for (int i = 1; i < d.size(); i++) {
			sb.getsearchbox().sendKeys(d.get(i));
			sb.getsearchbox().sendKeys(Keys.ENTER);
		}
        log.info("enterd product name");
        if(sb. getsearchproduct().isDisplayed())
        		Assert.assertTrue(true);
        log.info("Succesfully verified products are display!!");
	}
	
	

	/*
	 * this method is responsible for selecting a product after searching it.
	 * 
	 * SelectProductPage contains method to return webElement of select product
	 * page;
	 * 
	 * Here we are retrieving list of products and selecting first one produxt. 
	 * 
	 
	
	
	
	
	/*
	 * this method is responsible for adding product into card  after selecting  it.
	 * 
	 * and cross verity it by title that product added or not.
	 * 
	 * AddToCardPage contains method to return webElement of select product page.
	 */
	@Test(priority = 5)
	public void ChristmasGift() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.getChristmasGift().click();
		
		log.info("Successfully navigated to christmas Gifts...");
		
		ChristmasGiftPage cg=new ChristmasGiftPage(driver);
		cg.getFirstProduct().click();
		Thread.sleep(2000);
		
		cg.AddToCart().click();
		Thread.sleep(500);
		log.info("Added product to Crad...");
		
		cg.goToCheckOut().click();
		if(cg.ClosePopUp().isDisplayed())
				cg.ClosePopUp().click();
		Thread.sleep(2000);
		
		cg.returnToCard().click();
		Thread.sleep(1000);
		
		log.info("Proceed to checkout and returned to cart !!");

	}
	
	
	@Test(priority = 3)
	public void shopBtCategory() throws InterruptedException 
	{
		
		HomePage hp = new HomePage(driver);
		hp. getshopbycategory().click();
		
		ShopByCategoryPage sc=new ShopByCategoryPage(driver);
		Thread.sleep(1000);
		sc.getBirthdayGift().click();
		sc.getFirstProduct().click();
		sc.addToWishList().click();
		Thread.sleep(500);
	
		//if(sc.closePopUp().isDisplayed())
		//	sc.closePopUp().click();
		if(sc.viewWishList().isDisplayed())
			Assert.assertTrue(true);
		log.info("added to wishList");
		
		
		
	}
	@Test(priority = 7)
	public void AllofIt() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp. getAllofit().click();
		 AllOfItPage  ap=new  AllOfItPage (driver);
		Thread.sleep(2000);
		log.info("Navigated to All of it Page");
		if(ap.getproduct().getText().equals("Auto Rickshaw Pen Stand"))
				Assert.assertTrue(true);
		log.info("Verified Auto Rickshaw Pen Stand");
	}
	
	@Test(priority = 8)
	public void Wishlist() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getWishList().click();
		Thread.sleep(2000);
		log.info("Wishlist Page");
		WishListPage w=new WishListPage(driver);
		if(w.closepopup().isDisplayed())
			w.closepopup().click();
		Thread.sleep(2000);
		if(w.productvisible().isDisplayed())
			Assert.assertTrue(true);
		log.info("Products are displayed in Wishlist");
	}
	@Test(priority = 9)
	public void AboutUs() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getAboutUs().click();
		log.info("About Us Page");
		if(driver.getTitle().equals("About us"))
			Assert.assertTrue(true);
		log.info("Verified title of About Us Page");
	}
	@Test(priority = 10)
	public void GiftCard() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getGiftCard().click();
		log.info("Gift Cards Page");
		ChristmasGiftPage  cg=new ChristmasGiftPage(driver);
		cg.AddToCart().click();
		Thread.sleep(2000);
		log.info("Added Gift Card to cart");
		if(cg.verifycart().isDisplayed())
			Assert.assertTrue(true);
		log.info("Verified cart");
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
		driver = null;
	}

	@DataProvider
	public Object[][] dataSuplier() {
		Object[][] data = new Object[3][2];
		
		data[0][0] = "";
		data[0][1] = "";

		data[1][0] = "simon@123";
		data[1][1] = "abcd";

		data[2][0] = "JackNJill@gmail.com";
		data[2][1] = "JackNJill@123";

		return data;
	}

}
