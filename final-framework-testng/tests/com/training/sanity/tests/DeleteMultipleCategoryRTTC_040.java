package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

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
import com.training.pom.DeleteMultipleCategoryPOM;
import com.training.pom.RetailLoginPOM1;
import com.training.pom.listofCategoriesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteMultipleCategoryRTTC_040 {
	
	private WebDriver driver;
	private String baseUrl;
	private RetailLoginPOM1 retailloginPOM1;
	private DeleteMultipleCategoryPOM deletelistcat;
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
		deletelistcat=new DeleteMultipleCategoryPOM(driver);
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
		deletelistcat.selectcatalog();
		deletelistcat.selectcategories();
		deletelistcat.selectnewCat1();
		deletelistcat.entercatname1();
		deletelistcat.entermetatag1();
		deletelistcat.savecat1();
		deletelistcat.selectnewCat2();
		deletelistcat.entercatname2();
		deletelistcat.entermetatag2();		
		deletelistcat.savecat2();
		deletelistcat.modifycategory();
		deletelistcat.deletecategory();
		screenShot.captureScreenShot("popup");
		deletelistcat.alert();	
		deletelistcat.message();
		screenShot.captureScreenShot("Success Message");
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}