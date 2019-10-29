package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RetailLoginPOM1;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RetailLoginTestsRTTC_011 {
	
	private WebDriver driver;
	private String baseUrl;
	private RetailLoginPOM1 retailloginPOM1;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		retailloginPOM1 = new RetailLoginPOM1(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@Test
	public void retailLoginTest() {
		retailloginPOM1.sendUserName("admin");
		retailloginPOM1.sendPassword("admin@123");
		retailloginPOM1.clickLoginBtn(); 
		String title=driver.getTitle();
		Assert.assertEquals(title,"Dashboard");
		System.out.println("Title is matching");
		screenShot.captureScreenShot("Login is successful");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	}
