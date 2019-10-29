package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class listofCategoriesPOM {
	
private WebDriver driver; 
	
	public listofCategoriesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement catlog; 
	
	@FindBy(linkText="Categories")
	private WebElement categories;
	
		public void selectcatalog() {
		this.catlog.click();
	}
	
	public void selectcategories() {
		this.categories.click();
			}
	


}
