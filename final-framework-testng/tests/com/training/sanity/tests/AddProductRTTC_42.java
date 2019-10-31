package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddProductPOM;
import com.training.pom.RetailLoginPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProductRTTC_42 {
	
	private WebDriver driver;
	private String baseUrl;
	private RetailLoginPOM1 retailloginPOM1;
	private AddProductPOM addproductPOM;
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
		retailloginPOM1=new RetailLoginPOM1(driver);
		addproductPOM = new AddProductPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@Test	
	public void addproducttest() throws Exception {
		retailloginPOM1.sendUserName("admin");
		retailloginPOM1.sendPassword("admin@123");
		retailloginPOM1.clickLoginBtn(); 
		addproductPOM.selectcatalog();
		addproductPOM.products();
		addproductPOM.addnewicon();
		addproductPOM.newproduct();
		screenShot.captureScreenShot("new product");
		addproductPOM.datatab();
		screenShot.captureScreenShot("data tab");
		addproductPOM.linktab();
		screenShot.captureScreenShot("links tab");
		addproductPOM.attributetab();
		screenShot.captureScreenShot("attribute tab");
		addproductPOM.optiontab();
		screenShot.captureScreenShot("options tab");
		addproductPOM.recurringtab();
		screenShot.captureScreenShot("recurring tab");
		addproductPOM.discounttab();
		screenShot.captureScreenShot("discount tab");
		addproductPOM.specialtab();
		screenShot.captureScreenShot("special tab");
		addproductPOM.imagetab();
		screenShot.captureScreenShot("image tab");
		addproductPOM.rewardpointstab();
		screenShot.captureScreenShot("rewardpoints tab");
		addproductPOM.designtab();
		screenShot.captureScreenShot("design tab");
		addproductPOM.save();
		addproductPOM.message();
		screenShot.captureScreenShot("Success Message");
			
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}