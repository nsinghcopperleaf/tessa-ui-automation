package com.tessa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	  
	   private WebDriver driver;

	   //Page URL
	   private static String PAGE_URL="https://aws-preprod.copperleafgroup.com/AW_COST_QA/Pages/Home/Views/Home.aspx";

	   //Locators

	   //user name input field
	   @FindBy(xpath = "//div[@class='cl-login__form-control'][1]/input[@id='username']")
	   private WebElement userNameTxtField;

	   //password input field
	   @FindBy(xpath = "//div[@class='cl-login__form-control'][2]/input[@id='password']")
	   private WebElement passwordTxtField;

	   @FindBy(xpath = "//div[@id='loginWrapper']/input[@id='btnSubmit']")
	   private WebElement loginButton;

	   //Constructor
	   public LoginPage(WebDriver driver){
	       this.driver=driver;
	       driver.get(PAGE_URL);
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }

	   public void setPassword(String password){
		   passwordTxtField.clear();
		   passwordTxtField.sendKeys(password);
	   }
	   
	   public void setUserName(String userName){
		   userNameTxtField.clear();
		   userNameTxtField.sendKeys(userName);
	   }

	   public void clickOnLoginButton(){

	       loginButton.click();

	   }
	   
	   //We will use this boolean for assertion. To check if page is opened
	   //public boolean isPageOpened(){
	   //    return heading.getText().toString().contains("Developer portal");
	   //}

	   
}
