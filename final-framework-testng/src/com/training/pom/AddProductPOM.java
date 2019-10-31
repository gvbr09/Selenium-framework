package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddProductPOM {
	
private WebDriver driver; 

	public AddProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement catlog; 
		
	@FindBy(xpath="(//a[contains(text(),'Products')])[1]")
	private WebElement products;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addnewicon; 
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement enterproductname; 
		
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement entermegatagtitle; 
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement datatab;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement entermodel;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement enterprice;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement enterqunty;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement linkstab;
	
	@FindBy(id="input-category")
	private WebElement category;
	
	@FindBy(xpath="//div[@id='tab-links']//li[1]")
	private WebElement selectcategory;
	
	@FindBy(xpath="//input[@id='input-category']")
	private WebElement list;
	
	@FindBy(linkText="Attribute")
	private WebElement attribute;
	
	@FindBy(linkText="Option")
	private WebElement option;
	

	@FindBy(linkText="Recurring")
	private WebElement recurring;
	
	@FindBy(linkText="Discount")
	private WebElement discount;
	
	@FindBy(linkText="Special")
	private WebElement special;
	
	@FindBy(linkText="Image")
	private WebElement image;
	
	//@FindBy(xpath="//a[contains(text(),'Reward Points')][2]")
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/div[2]/form/ul/li[10]/a")
	private WebElement rewardpoints;
	
	@FindBy(linkText="Design")
	private WebElement design;
	
	@FindBy(xpath="//div[@class='pull-right']//button[@class='btn btn-primary']")
	private WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement message;
		
	public void selectcatalog() {
		this.catlog.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void products()  {
		this.products.click();
		}
	
	public void addnewicon() {
		this.addnewicon.click();
	}
	
	public void newproduct() {
		this.enterproductname.sendKeys("Finger Ring");
		this.entermegatagtitle.sendKeys("Finger Ring for ladies");
		}
	
	public void datatab() {
		this.datatab.click();
		this.entermodel.sendKeys("SKU-012");
		this.enterprice.sendKeys("500");
		this.enterqunty.sendKeys("50");
		}
	
	public void linktab() {
		this.linkstab.click();
		this.category.click();
		// Test case step says select "EARRINGS" as category.But EARRINGS is not present in the category list.Hence i have opted for Australia after discussion with siva
		this.selectcategory.click();
		}
	
	public void attributetab() {
		this.attribute.click();
	}
	
	public void optiontab() {
		this.option.click();
	}
	
	public void recurringtab() {
		this.recurring.click();
	}
	
	public void discounttab() {
		this.discount.click();
	}
	
	public void specialtab() {
		this.special.click();
	}
	
	public void imagetab() {
		this.image.click();
	}
	
	public void rewardpointstab() {
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(script, args)*/
				this.rewardpoints.click();
		
		
	}
	
	public void designtab() {
		this.design.click();
	}
	
	public void save() {
		this.save.click();
	}
	
	public void message() {
		String MSG=message.getText();
		MSG=MSG.replace("×", "");
		MSG=MSG.trim();
		Assert.assertEquals(MSG, "Success: You have modified products!");
		System.out.println("Successfully Deleted the selected products");	
	}
	
	}
