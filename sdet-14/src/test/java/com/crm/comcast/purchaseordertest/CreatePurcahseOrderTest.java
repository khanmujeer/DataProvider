package com.crm.comcast.purchaseordertest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 *
 */
@Listeners(com.crm.comcast.genericutility.ListnersIMP.class)
public class CreatePurcahseOrderTest extends BaseClass{
	
	@Test(groups = "smokeTest")
	public void createPurchaseOrderTest() throws Throwable {

		
		/*read test script data*/
		 String subject = eLib.getExcelData("po", 1, 2);
		 String venDorName = eLib.getExcelData("po", 1, 3);
		 String serachValue = eLib.getExcelData("po", 1, 4);
		 String bAddress = eLib.getExcelData("po", 1, 5);
		 String sAddress = eLib.getExcelData("po", 1, 6);
		 String productName = eLib.getExcelData("po", 1, 7);
		 String qty = eLib.getExcelData("po", 1, 8);

	        
		 
		/*step 2 : navigate to purchase Oder Page*/ 
		 
		   WebElement moreWb = driver.findElement(By.linkText("More"));
		   wLib.mouseOver(driver, moreWb);
		   driver.findElement(By.linkText("Purchase Order")).click();
		  
		/*step 3 : navigate to create purchase Oder Page*/ 
		   driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
		   
		/*step 4 : create new purchase Oder Page*/ 
		   driver.findElement(By.name("subject")).sendKeys(subject);
		   driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img")).click();
		   /*Switch to child browser*/
		  wLib.switchToWindow(driver, "Vendors");

		  WebElement swb =driver.findElement(By.xpath("//select[@name='search_field']")); 
		  wLib.select(swb, serachValue);
		 
		 driver.findElement(By.name("search_text")).sendKeys(venDorName);
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.linkText(venDorName)).click();
		   /*Switch back to parent browser*/
		  wLib.switchToWindow(driver, "Purchase Order");
		   
		   //select product 
		   driver.findElement(By.id("searchIcon1")).click();
		   wLib.switchToWindow(driver, "Product");
		   
   		 driver.findElement(By.name("search_text")).sendKeys(productName);
   		 driver.findElement(By.name("search")).click();
   		 driver.findElement(By.linkText(productName)).click();
		   /*Switch back to parent browser*/
   	      wLib.switchToWindow(driver, "Purchase Order");
		  driver.findElement(By.id("qty1")).sendKeys(qty);
		  
		  driver.findElement(By.name("bill_street")).sendKeys(bAddress);
		  driver.findElement(By.name("ship_street")).sendKeys(sAddress);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   
		/*step 5: verify*/
		  String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		  if(actSuccessFullMsg.contains(subject)) {
			  System.out.println(subject + "==>purchase order created successfully==>PASS");
		  }else {
			  System.out.println(subject + "==>purchase order not created ==>Fail");

		  }
		
		 
	}

}


