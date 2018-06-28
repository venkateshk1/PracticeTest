package com.brady.TestCase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.brady.Pages.Page_Elements;


public class Test_Case {
	WebDriver driver;
	Page_Elements practisetest;
	
	@BeforeMethod
	public void startbrowser()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		practisetest = new PageFactory().initElements(driver, Page_Elements.class);
				
	}
	
		
	
	
	@Test
	public void TestCase() throws InterruptedException
	
	{
		
		practisetest.login_brady("vkailasa@gmail.com", "Test_123");
		String actual=driver.getTitle();
		Assert.assertEquals(actual, "My account - My Store");
		practisetest.verifyinfo("Venkat", "K");
		practisetest.verifyCart();
		practisetest.navigatetoWomen_AddPinkdresstoCart();
		practisetest.navigateToAllspecial();
		practisetest.addAllspecials1ToCart();
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.history.go(-1)");
		practisetest.addAllspecials2ToCart();
		practisetest.checkdiscountpcd();
		practisetest.checkdiscountpsd();
		practisetest.navigatetoDresses();
		Assert.assertEquals(driver.getTitle(), "Dresses - My Store");
		practisetest.navigatetoDresses();
		practisetest.selectlowsetfirst();
		practisetest.selecthighestfirst();
			
	
	}
	 @AfterMethod 
	  public void tearDown() {
	      driver.quit();
	  }
}
