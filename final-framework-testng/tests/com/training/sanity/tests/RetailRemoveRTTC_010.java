package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RetailLoginPOM1;
import com.training.pom.RetailRemovePOM;
import com.training.pom.listofCategoriesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.training.generics.ScreenShot;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class RetailRemoveRTTC_010 {
	private WebDriver driver;
	private String baseUrl1;
	private static Properties properties;
	private RetailRemovePOM retailPOM;
	private ScreenShot screenShot;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		retailPOM = new RetailRemovePOM(driver); 
		baseUrl1 = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver); 
		
		// open the browser 
		driver.get(baseUrl1);
		
		}
	
	@Test
	public void removefromcart() throws Exception {
		retailPOM.search("products");
		screenShot.captureScreenShot("Prodcuts search");
		retailPOM.clicksearch();
		screenShot.captureScreenShot("products list");
		retailPOM.selectproduct();
		screenShot.captureScreenShot("selection of product");
		retailPOM.clickaddtocart();
		screenShot.captureScreenShot("product in cart");
		retailPOM.mousehovercart();
		screenShot.captureScreenShot("hovering cart");
		retailPOM.clickviewcart();
		screenShot.captureScreenShot("cart view");
		retailPOM.clickremoveicon();
		screenShot.captureScreenShot("removal from cart");
		retailPOM.clickoncart();
		String title=driver.getTitle();
		Assert.assertEquals(title,"Shopping Cart");
		System.out.println("Title is matching");
		screenShot.captureScreenShot("emprt cart");
		}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
