package com.tessa.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttributeGrid {
	 private WebElement webE;
	   
	   private final WebDriver driver;
	  
	   public AttributeGrid(WebDriver driver) {
	       this.driver = driver;
	       PageFactory.initElements(driver, this);
	   }

	   //attribute value column 
	   @FindBy(xpath = "//tbody/tr[@class='k-alt ng-star-inserted']/td[@class='ng-star-inserted'][3]")
	   private WebElement attributeValueColumn;
	  
	   //attribute value text field
	   @FindBy(xpath = "//input[@class='k-textbox--fill-parent k-textbox ng-untouched ng-pristine ng-valid ng-star-inserted']")
	   private WebElement attributeValueTxtField;
	   
	  
	   

	   public void clickOnAttributeValueColumn(){

		   attributeValueColumn.click();

	   }

	   public void setAttributeField(String s)
	   {
		   attributeValueTxtField.clear();
		   attributeValueTxtField.sendKeys(s);
	   }
	
}
