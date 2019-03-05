package com.tessa.components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class AssetGrid {
	
	//asset name link - hardcoded at this moment  
   //@FindBy(xpath = "//span[@class='cl-color__grey--black-color'][contains(text(),'Calcium Nitrate')]")
   @FindBy(xpath="//td[@class='ng-star-inserted'][2]/span[@class='ng-star-inserted']")
   private WebElement assetNameLink;
   
   private final WebDriver driver;
  
   public AssetGrid(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
       
   }

 	public void clickOnAssetNameLink(){
      

		   assetNameLink.click();

	   }
	
	
}
