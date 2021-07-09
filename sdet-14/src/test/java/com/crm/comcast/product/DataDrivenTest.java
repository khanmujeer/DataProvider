package com.crm.comcast.product;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	static WebDriver driver = new ChromeDriver();
	@BeforeClass
	public static void LaunchBrowser()
	{
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="testDataFeed")
	public void test_1(String user,String pass)
	{
		
		WebElement logIn = driver.findElement(By.id("submitButton"));
		logIn.click();
	WebElement userN = driver.findElement(By.name("user_name"));
	userN.clear();
	userN.sendKeys(user);
	
	
	WebElement passW = driver.findElement(By.name("user_password"));
	passW.clear();
	passW.sendKeys(pass);
	
	
	WebElement submit = driver.findElement(By.id("submitButton"));
	submit.click();


		
	}
	
 

@DataProvider(name="testDataFeed")
public Object[][] testDataFeed(){

	Object[][] vitigerData = new Object[2][2];
	
	vitigerData[0][0] = "admin";
	vitigerData[0][1] = "admin";
	
	
	vitigerData[1][0] = "taj";
	vitigerData[1][1] = "mahal";
	
	return vitigerData;
}
@AfterClass
public void closeApp()
{
 driver.close();
 driver.quit();
}
	
	
}
	
 
