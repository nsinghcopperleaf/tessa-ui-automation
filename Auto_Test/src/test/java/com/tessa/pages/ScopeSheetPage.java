package com.tessa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tessa.components.*;

public class ScopeSheetPage {
	private WebDriver driver;
    private AttributeGrid attGrid;
    private AssetGrid aGrid;
	    //Locators

	   //cost button 
	   @FindBy(xpath = "//kendo-buttongroup[@class='k-button-group']/button[@class='k-button-icontext k-button k-group-start']")
	   private WebElement costButton;

	   //Generate button
	   @FindBy(xpath = "//kendo-buttongroup[@class='k-button-group']/button[@class='k-button-icontext k-button ng-star-inserted']")
	   private WebElement generateButton;

	  //Delete Asset button
	   @FindBy(xpath ="//kendo-buttongroup[@class='k-button-group']/tooltip-anchor-wrapper[@class='ng-star-inserted'][2]/button[@class='k-button-icontext k-button k-group-end ng-star-inserted']")
	   private WebElement deleteButton;

	   //New Asset button
	   @FindBy(xpath ="//cl-toolbar[@class='cl-c-toolbar cl-c-toolbar__shadow']/button[@class='k-button-icontext k-button']")
	   private WebElement newAssetButton;

	   //asset name link - hardcoded at this moment  
	   @FindBy(xpath = "//span[@class='cl-color__grey--black-color'][contains(text(),'Calcium Nitrate')]")
	   private WebElement assetNameLink;

	   
	   //Constructor
	   public ScopeSheetPage(WebDriver driver, String scopeSheetURL){
	       this.driver=driver;
	       
	       
	       driver.get(scopeSheetURL);
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }

	  	   
	   public AttributeGrid getAttGrid()
	   {
		   attGrid = new AttributeGrid(driver);
		   return this.attGrid;
	   }
	   
	   
	  public AssetGrid getAssetGrid()
	  {
		   aGrid = new AssetGrid(driver);
		   return this.aGrid;
	   }  
	   public void clickOnCostButton(){

	       costButton.click();

	   }
	   
	   public void clickOnGenerateButton(){

	       generateButton.click();

	   }
	   
	   public void clickOnDeleteButton(){

	       deleteButton.click();

	   }
	   
	   public void clickOnNewAssetButton(){

	       newAssetButton.click();

	   }
	   
	   public void clickOnAssetNameLink() {
		   assetNameLink.click();
	   }
	   
	   public void amendAttributeValue(String s){
		   
		   attGrid= this.getAttGrid();   
		   attGrid.clickOnAttributeValueColumn();
		   attGrid.setAttributeField(s);
	   }
	  
	   //We will use this boolean for assertion. To check if page is opened
	   //public boolean isPageOpened(){
	   //    return heading.getText().toString().contains("Developer portal");
	   //}

}
