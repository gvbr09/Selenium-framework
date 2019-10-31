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
import com.training.pom.FilterProductDetailsPOM;
import com.training.pom.RetailLoginPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterProductDetailsRTTC_41 {
	
	private WebDriver driver;
	private String baseUrl;
	private RetailLoginPOM1 retailloginPOM1;
	private FilterProductDetailsPOM filterproddetailsPOM;
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
		filterproddetailsPOM = new FilterProductDetailsPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@Test
	
	public void deletecategoriestest() throws Exception {
		retailloginPOM1.sendUserName("admin");
		retailloginPOM1.sendPassword("admin@123");
		retailloginPOM1.clickLoginBtn(); 
		filterproddetailsPOM.selectcatalog();
		filterproddetailsPOM.products();
		filterproddetailsPOM.productname();
		filterproddetailsPOM.selectfilter();
		filterproddetailsPOM.enterprice();
		filterproddetailsPOM.selectfilter();
		filterproddetailsPOM.selectstatus();
		filterproddetailsPOM.selectfilter();
		filterproddetailsPOM.selectmodel();
		filterproddetailsPOM.selectfilter();
		filterproddetailsPOM.enterquantity();
		filterproddetailsPOM.selectfilter();
		filterproddetailsPOM.selectimage();
		screenShot.captureScreenShot("Image");
		filterproddetailsPOM.selectfilter();
		screenShot.captureScreenShot("Product List with product details matching filter criteria should get displayed");
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}