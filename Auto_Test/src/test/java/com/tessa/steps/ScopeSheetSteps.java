package com.tessa.steps;
import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
//import net.serenity.showcase.pages.ScopeSheetPage;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import junit.framework.Assert;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Test;
import static org.junit.Assert.*;
import org.jbehave.core.steps.Steps;

import com.tessa.util.Util;

import com.tessa.pages.*;



public class ScopeSheetSteps extends Steps{
    WebDriver driver; 
   
    private ScopeSheetPage scopeSheet;
    private NewAssetPage newAsset;
   
	@Given("a user is logged into C55")
	public void LoggedIntoC55() {
		
		//String exePath = "C:\\Users\\eloh\\Driver\\chromedriver.exe";
		//System.setProperty("webdriver.chrome.driver", exePath);


		try {

			//Comment these out -- When selenium grid is in place
			ChromeOptions cap = new ChromeOptions();
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			WebDriver driver = null;

			driver = new RemoteWebDriver(new URL("http://michaelh2018:4444/wd/hub"), cap);



			//Thread.sleep(6000);

			//driver = new ChromeDriver();
			//driver.manage().window().maximize();

			LoginPage currentPage = new LoginPage(driver);

			Util util = new Util();

			String password = util.getPassword();

			String userName = "Automation_admin_user";
			//System.out.println("password" + password);

			currentPage.setUserName(userName);
			currentPage.setPassword(password);
			currentPage.clickOnLoginButton();

			System.out.println("Logged into C55");

			//Thread.sleep(4000);
			//TakesScreenshot ts=(TakesScreenshot)driver;
			//FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("C:\\Users\\eloh\\Desktop\\CaptureScreenshot.png"));
			//System.out.println("Image Captured");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
    
	@When("a user launch Cost Estimation tool $s")
	public void LaunchCETool(String s) {
		try
		{
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("launch cost estimation tool");
		
			String scopeSheetURL = "https://aws-tessa-qa.copperleafgroup.com/scope-sheet/" + s +  "/assets";
			
			System.out.println("Scope sheet is: "  + scopeSheetURL);
			
			scopeSheet = new ScopeSheetPage(driver, scopeSheetURL);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
	}
    
	@When("a user add a new asset")
	public void AddAsset() {
		try
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//click New Asset button
			
			//driver.findElement(By.xpath("//cl-toolbar[@class='cl-c-toolbar cl-c-toolbar__shadow']/button[@class='k-button-icontext k-button']")).click();
			scopeSheet.clickOnNewAssetButton();
		
			NewAssetPage nab = new NewAssetPage(driver);
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			//Click Facility link 
			System.out.println("Getting facility name");
		
			Thread.sleep(4000);
			nab.clickOnFacilityLink();
			
			//driver.findElement(By.xpath("//span[contains(text(),'2A - Catchment Pumping (14)')]")).click();
				
			
		   //Click Add button
			Thread.sleep(4000);
			//driver.findElement(By.xpath("//button[@title='Add cost model to selected cost models']")).click();
			nab.clickOnAddButton();
			
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			
			System.out.println("Click Add Template button");
			Thread.sleep(4000);
			//driver.findElement(By.xpath("//button[@class='cl-c-dialog__button k-button k-primary ng-star-inserted']")).click();
			nab.clickOnApplyButton();
		
			Thread.sleep(4000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
    
	@When("a user delete a new asset")
	public void DeleteAsset() {
		try
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//click Delete Asset button
			scopeSheet.getAssetGrid().clickOnAssetNameLink();
			//driver.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']/table[@class='k-selectable']/tbody/tr/td[3]/div[@class='icon-component cl-color__brand-copper-color']/span[@class='cl-color__grey--black-color']")).click();
			Thread.sleep(1000);
			System.out.println("Click Delete button");
			//driver.findElement(By.xpath("//kendo-buttongroup[@class='k-button-group']/tooltip-anchor-wrapper[@class='ng-star-inserted'][2]/button[@class='k-button-icontext k-button k-group-end ng-star-inserted']")).click();
		    scopeSheet.clickOnDeleteButton();
			Thread.sleep(4000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
    
	@When("a user amend a new attribute $s")
	public void AmendAttribute(String s) {
		try
		{
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1000);

			//Select Asset Calcium Nitrate 
			//driver.findElement(By.xpath("//span[@class='cl-color__grey--black-color'][contains(text(),'Calcium Nitrate')]")).click();
	        scopeSheet.getAssetGrid().clickOnAssetNameLink();
		
			
			System.out.println("selecting the asset Calicum Nitrate");
			
	        Thread.sleep(1000);   
	        scopeSheet.amendAttributeValue("1");
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		   
			//set attribute value to 1 
			System.out.println("Entering the attribute value");
			
			
		    Thread.sleep(1000);
			
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
    
	@When("a user click generate button")
	public void ClickGenerate() {
		try
		{
			Thread.sleep(4000);
			System.out.println("Click Generate & Save button");
			
			//driver.findElement(By.xpath("//kendo-buttongroup[@class='k-button-group']/button[@class='k-button-icontext k-button ng-star-inserted']")).click();
				
			scopeSheet.clickOnGenerateButton();
			
			driver.manage().timeouts().implicitlyWait(110, TimeUnit.SECONDS); 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	
	
	
    @When("a scope sheet is returned with Draft Generated")
	public void GenerateSuccessful() {
		
		System.out.println("Cost successfully");
		try 
		{
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			Thread.sleep(4000);
		
			String status = driver.findElement(By.xpath("//div[@class='cl-c-scope-header__right-links']/ts-estimate-status/div[@class='display-inline-flex']/div[@class='cl-c-pill--status']")).getText();
			System.out.println("status is" + status);
			if (status.trim().startsWith(("Draft Generated")))
			{
			
				System.out.println("Correct! It can be costed successfully");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		
		
				
	}
    
    @When("a user click cost button")
	public void ClickCost() {
		try
		{
			Thread.sleep(4000);
			
			System.out.println("Click cost button");
			driver.findElement(By.xpath("//kendo-buttongroup[@class='k-button-group']/button[@class='k-button-icontext k-button k-group-start']")).click();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
   
	@Then("a scope sheet is returned with Draft Generated")
	public void GenerateWithoutError(String s) {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		
		System.out.println("Generated without error");
		
		List<WebElement> costs = driver.findElements(By.xpath("//div[@class='ts-c-summary-costs__header--currency']/span[2]"));
		System.out.println("webelement");
		for (WebElement cost : costs)
		{
		  System.out.println(cost.getText());
		 
		  System.out.println("CAPEX Cost :" + s);
	      if (cost.getText().trim().equals(s))
	      {
	    	
	    	System.out.println("CAPEX Calculation is correct");
	    	
	      }
		}
		
			}
	
   @Then("verify the cost calculation $s")
	public void VerifyCost(String s) {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		
		System.out.println("Verify Cost Calculation Result");

		String capexCost = "";
		List<WebElement> costs = driver.findElements(By.xpath("//div[@class='ts-c-summary-costs__header--currency']/span[2]"));
		System.out.println("webelement");
		for (WebElement cost : costs)
		{
		  System.out.println(cost.getText());
		 
		  System.out.println("CAPEX Cost :" + s);
		  capexCost = cost.getText().trim();
		  assertEquals(s, capexCost);
		  if (cost.getText().trim().equals(s))
	      {
	    	
	    	System.out.println("CAPEX Calculation is correct");
	    	break;
	    	
	      }
		}
	   assertEquals(s, capexCost);

	   try
		{
		 Thread.sleep(2000);
		 driver.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Then("verify the cost can be generated successfully")
	public void VerifyGenerate() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		try 
		{
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			Thread.sleep(4000);
		
			String status = driver.findElement(By.xpath("//div[@class='cl-c-scope-header__right-links']/ts-estimate-status/div[@class='display-inline-flex']/div[@class='cl-c-pill--status']")).getText();
			System.out.println("status is" + status);

			assertTrue((status.trim().startsWith("Draft Generated")));

			if (status.trim().startsWith(("Draft Generated")))
			{
			
				System.out.println("Correct! It can be costed successfully");
			}

			driver.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		
		
	}
	
    
	@Then("verify the empty state of spend profile will be returned") 
	public void VerifyEmptyStateSP() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		try 
		{
			Thread.sleep(4000);
		
			List<WebElement> spendProfile = driver.findElements(By.xpath("//div[@class='cl-c-spend-profile-card__column--account-type']/span[@class='ng-star-inserted']"));
			
			int size =  spendProfile.size();
			
			if (size == 0) 
			{
				System.out.println("Correct! Empty Spend Profile");
			}
			driver.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		
		
	}
}


