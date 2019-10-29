package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailRemovePOM {
	
	private static final String link = null;
	private WebDriver driver; 
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement mousehover;
		
	public RetailRemovePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);		
	}

	
			
	@FindBy(xpath="//input[@id='filter_keyword']")
	private WebElement search;
	
	@FindBy(xpath="//a[@id='search_button']")
	private WebElement clicksearch;
	
	@FindBy(xpath="//div[@class='clear2 clear3 clear4 clear5 clear6 clear7 clear8 clear9 clear10 clear11 clear12 tb_size_4_last tb_size_5_last tb_size_6_last tb_size_7_last tb_size_8_last tb_size_9_last tb_size_10_last tb_size_11_last tb_size_12_last']//div[@class='product-thumb product-thumb_style1']//div//a[contains(text(),'NewProduct1')]")
	private WebElement selectproduct;
	
	
	@FindBy(id="button-cart")
	private WebElement clickaddtocart; 
	
	
	@FindBy(linkText="View Cart")
	private WebElement clickviewcart;
	
	@FindBy(xpath="//i[@class='fa fa-times-circle']")
	private WebElement clickremoveicon;
	
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement clickoncart;
	
	public void search(String search) {
		this.search.clear();
		this.search.sendKeys(search);
	}
	
	public void clicksearch() {
		this.clicksearch.click();
	}
	
	public void selectproduct() {
		this.selectproduct.click();
	}
	
	public void clickaddtocart() throws Exception  {
		this.clickaddtocart.click();
		Thread.sleep(3000);
	}
	
	public void mousehovercart()
	{
		Actions act=new Actions(driver);
		act.moveToElement(mousehover).build().perform();
	}
		public void clickviewcart() throws Exception {
		this.clickviewcart.click(); 
		Thread.sleep(3000);
	}
	
	public void clickremoveicon() {
		this.clickremoveicon.click(); 
	}
	
	public void clickoncart() {
		this.clickoncart.click();
	}
	
}
