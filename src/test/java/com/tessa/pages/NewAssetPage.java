package com.tessa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//New Asset Browser Page
public class NewAssetPage {

	  
	   private WebDriver driver;
	   
	   //Locators

	   //facility name link - hardcoded at this moment  
	   @FindBy(xpath = "//span[contains(text(),'2A - Catchment Pumping (14)')]")
	   private WebElement facilityLink;

	   //add button 
	   @FindBy(xpath = "//button[@title='Add cost model to selected cost models']")
	   private WebElement addButton;

	   //Apply button
	   @FindBy(xpath = "//button[@class='cl-c-dialog__button k-button k-primary ng-star-inserted']")
	   private WebElement applyButton;

	   //Constructor
	   public NewAssetPage(WebDriver driver){
	       this.driver=driver;
	       //driver.get(PAGE_URL);
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }
/*
	   public void setPassword(String password){
		   passwordTxtField.clear();
		   passwordTxtField.sendKeys(password);
	   }
	   
	   public void setUserName(String userName){
		   userNameTxtField.clear();
		   userNameTxtField.sendKeys(userName);
	   }
*/
	   public void clickOnApplyButton(){

	       applyButton.click();

	   }
	   public void clickOnAddButton(){

	       addButton.click();

	   }
	   public void clickOnFacilityLink(){

		   facilityLink.click();

	   }
	  
	   
	   //We will use this boolean for assertion. To check if page is opened
	   //public boolean isPageOpened(){
	   //    return heading.getText().toString().contains("Developer portal");
	   //}

	   
}
