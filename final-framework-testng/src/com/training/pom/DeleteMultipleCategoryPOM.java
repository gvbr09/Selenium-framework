package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeleteMultipleCategoryPOM {
	
private WebDriver driver; 
	
	public DeleteMultipleCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement catlog; 
	
	@FindBy(linkText="Categories")
	private WebElement categories;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addnewCat;
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement Catname;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement Metatagtitle;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement savecat;
	
	
	@FindBy(linkText=">|")
	private WebElement modify;
	
	@FindBy(xpath="//tr[1]//td[4]//a[1]//i[1]")
	private WebElement edit;
	
	@FindBy(xpath="//a[@class='btn btn-default']")
	private WebElement Cancel;
	
	@FindBy(xpath="//tr[2]//td[1]//input[1]")
	private WebElement selectchkbox1;
	
	@FindBy(xpath="//tr[3]//td[1]//input[1]")
	private WebElement selectchkbox2;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement delete;
	
	@FindBy(xpath="//div[@class='alert alert-success']") 
	private WebElement message;
	
	public void selectcatalog() {
		this.catlog.click();
	}
	
	public void selectcategories()  {
		this.categories.click();
		}
	
	public void selectnewCat1() {
		this.addnewCat.click();
		}
	
	public void entercatname1() {
		this.Catname.sendKeys("Test1Vijay");
		}
	
	public void entermetatag1() {
		this.Metatagtitle.sendKeys("Test1");
		}
	
	public void savecat1() {
		this.savecat.click();
		}
	
	public void selectnewCat2() {
		this.addnewCat.click();
		}
	
	public void entercatname2() {
		this.Catname.sendKeys("Test2Vijay");
		}
	
	public void entermetatag2() {
		this.Metatagtitle.sendKeys("Test2");
		}
	
	public void savecat2() {
		this.savecat.click();
		}
	
	public void modifycategory() throws Exception {
		this.modify.click();
		Thread.sleep(3000);
		this.edit.click();
		Thread.sleep(3000);
		this.Cancel.click();
		}
	public void deletecategory() throws Exception {
		this.selectchkbox1.click();
		this.selectchkbox2.click();
		Thread.sleep(3000);
		this.delete.click();
		Thread.sleep(3000);
				}
	public void alert() throws Exception {
		Alert alert=driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		}
		
	public void message() {
		String MSG=message.getText();
		MSG=MSG.replace("×", "");
		MSG=MSG.trim();
		Assert.assertEquals(MSG, "Success: You have modified categories!");
		System.out.println("Successfully Deleted the selected categories");		
	}
}