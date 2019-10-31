package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterProductDetailsPOM {
	
private WebDriver driver; 

	public FilterProductDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement catlog; 
	
	@FindBy(xpath="(//a[contains(text(),'Products')])[1]")
	private WebElement products;

	@FindBy(xpath="//input[@id='input-name']")
	private WebElement ProductName; 
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filter; 
	
	@FindBy(name="filter_price")
	private WebElement price; 
	
	@FindBy(name="filter_status")
	private WebElement status;
	
	@FindBy(name="filter_model")
	private WebElement model;
	
	@FindBy(name="filter_quantity")
	private WebElement quantity;
	
	@FindBy(name="filter_image")
	private WebElement image;
	
	public void selectcatalog() {
		this.catlog.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void products() throws Exception {
		this.products.click();
		}
	
	public void productname() throws Exception {
		this.ProductName.sendKeys("Integer vitae iaculis massa");
		}
	
	public void selectfilter() throws Exception {
		this.filter.click();
		}

	public void enterprice() throws Exception {
		this.price.sendKeys("515");
		}
		
	public void selectstatus() throws Exception {
	Select selstatus=new Select(status);
	selstatus.selectByVisibleText("Enabled");	
	}
	
	public void selectmodel() {
		
		this.model.sendKeys("SKU-003");
	}
	
	public void enterquantity() {
		
		this.quantity.sendKeys("49");
	}
	
	public void selectimage() throws Exception {
		Select selimage=new Select(image);
		selimage.selectByVisibleText("Enabled");	
		}
	
	}